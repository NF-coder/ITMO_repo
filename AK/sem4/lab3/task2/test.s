    .data
    .org 0x00
buff_placeholder:        .byte  '\0_______________________________'

    .data
    .org 0x40
mask:                    .word  0x000000ff
buffer_ptr:              .word  0x00
input_addr:              .word  0x80
output_addr:             .word  0x84


    .text
    .org         0x100
_start:
    @p input_addr b!           \                                                 D: | A: | B: input_addr
    lit 0x01                   \                                                 D: text_start_shift | A: | B:
    @p buffer_ptr + a!         \                                                 D: | A: buffer_ptr | B: input_addr
    lit 0x00                   \ пушим счётчик                                   D: sym_cnt | A: buffer_ptr | B: input_addr
read_sec:
    @b                         \                                                 D: sym_cnt sym | A: buffer_ptr | B: input_addr 
    dup !+                     \                                                 D: sym_cnt sym | A: buffer_ptr_next | B: input_addr
    lit 0x0a xor if save_cnt   \                                                 D: sym_cnt | A: buffer_ptr_next | B: input_addr
    lit 0x01 + dup             \ инкремент счётчика символов                     D: sym_cnt_nxt sym_cnt_nxt | A: buffer_ptr_next | B: input_addr
    lit 0x20 xor if error_out  \ проверка превышения
    read_sec ;

save_cnt:
    @p buffer_ptr a!           \ пушим указатель на старт буфера в a             D: sym_cnt | A: buffer_ptr | B: X
    @ + !+                     \ сохраняем длину строки                          D: | A: buffer_ptr_nxt | B: X
    lit 0x0                    \ пушим счётчик символов на стек                  D: sym_cnt | A: buffer_ptr_nxt | B: X
cycle:
    a b!                       \ копируем указатель на буфер из a в b            D: sym_cnt | A: buffer_ptr | B: buffer_ptr
    @p mask                    \ пушим маску на стек                             D: sym_cnt mask | A: buffer_ptr | B: buffer_ptr

    @+                         \ пушим слово по адресу из a на стек              D: sym_cnt mask buff_word | A: buffer_ptr_nxt | B: buffer_ptr
    and                        \ сбиваем маской лишнее                           D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    dup lit 0x0A xor if finish \ проверяем, является ли символ переносом строки - если да, то В С Ё  D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    dup lit 0x20 xor
    if output_and_set_zero     \ проверяем, является ли символ пробелом если да, то обработка отдельно D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    is_letter ;

is_letter:                    \ high check
    dup lit -90 +             \                                                 D: X curr_char_word (curr_char_word-0x5A)
    -if _is_letter_low_check  \                                                 D: X curr_char_word
    dup lit -65 +             \                                                 D: X curr_char_word (curr_char_word-0x41)
    -if if_is_letter          \ если буква перед диапазоном заглавных -> out    D: X curr_char_word
    output_and_set_zero ;
_is_letter_low_check:         \ low check
    dup lit -97 +             \                                                 D: X curr_char_word (curr_char_word-0x61)
    -if if_is_letter          \
    dup lit -122 +            \                                                 D: X curr_char_word (curr_char_word-0x7A)
    -if if_is_letter          \ 
    output_and_set_zero ;



if_is_letter:
    over dup if is_first      \ проверяем, является ли символ первым в слове. если да, то обрабатываем отдельно D: curr_char_word sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    over                      \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
not_first: 
    dup lit -96 +             \                                                 D: sym_cnt curr_char_word (curr_char_word-0x61) | A: buffer_ptr_nxt | B: buffer_ptr
    -if output_and_count
    is_not_first_high ;
is_not_first_high:
    lit 0x20 +                \                                                 D: sym_cnt (curr_char_word+0x20) | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;




is_first:                     \                                                 D: curr_char_word sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    over dup lit -96 +        \                                                 D: sym_cnt curr_char_word (curr_char_word-0x61) | A: buffer_ptr_nxt | B: buffer_ptr
    -if is_first_low          \ проверяем, является ли символ нижним. если да, то отдельно   D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;
is_first_low:                 \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    lit -32 +                 \                                                 D: sym_cnt (curr_char_word-0x20) | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;




output_and_set_zero:          \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    over drop lit 0x0 over    \ сбрасываем счётчик символов                     D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    output                    \                                                 D: sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    cycle ;
output_and_count:
    output                    \                                                 D: sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    lit 0x01 +                \                                                 D: sym_cnt_nxt | A: buffer_ptr_nxt | B: buffer_ptr
    cycle ;                   \ замыкаем
output:                       \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    numio_output              \ отправляем символ на порт вывода
    @b                        \ пушим слово по адресу из b на стек              D: sym_cnt curr_char_word word_nxt | A: buffer_ptr_nxt | B: buffer_ptr
    @p mask inv and           \ сдвиг текущего                                  D: sym_cnt curr_char_word word_nxt | A: buffer_ptr_nxt | B: buffer_ptr
    +                         \ новое значение                                  D: sym_cnt new_word | A: buffer_ptr_nxt | B: buffer_ptr       
    !b                        \ запись                                          D: sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    ;                       
numio_output:                 \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    a >r                      \ временно пушим a на return stack                D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr | R: buffer_ptr_nxt
    @p output_addr a!         \ запись адреса вывода на a                       D: sym_cnt curr_char_word | A: output_addr | B: buffer_ptr | R: buffer_ptr_nxt
    dup !                     \ вывод копии символа на адрес вывода             D: sym_cnt curr_char_word | A: output_addr | B: buffer_ptr | R: buffer_ptr_nxt
    r> a!                     \ восстанавливаем значение a                      D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr 
    ;


finish:                       \ довольно жёстко зависит от позиции начала буфера
    lit 0x5f5f5f5f !b         \ оверрайдим конец строки
    halt   

error_out:
    lit 0xCCCCCCCC
    numio_output
    halt