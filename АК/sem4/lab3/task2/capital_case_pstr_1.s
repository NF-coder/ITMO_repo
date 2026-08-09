    .data
    .org 0x00
buff_placeholder:          .byte  '\0_______________________________'

    .data
    .org 0x90
mask:                       .word  0x000000ff
buffer_ptr:                 .word  0x00
input_addr:                 .word  0x80
output_addr:                .word  0x84

zero:                       .word  0x00
one:                        .word  0x01
cr:                         .word  0xA
space:                      .word  0x20

buff_placeholder_fragment:  .byte  '____'
error_fill:                 .word  0xCCCCCCCC
max_buffer_len:             .word  0x20

lower_start_idx:             .word  -97
lower_finish_idx:            .word  -122
upper_start_idx:             .word  -65
upper_finish_idx:            .word  -90

high_to_low_shift:          .word  0x20
low_to_high_shift:          .word  -32

    .text
    .org         0x200
_start:
    @p input_addr b!           \                                                 D: | A: | B: input_addr
    @p one                     \                                                 D: text_start_shift | A: | B:
    @p buffer_ptr + a!         \                                                 D: | A: buffer_ptr | B: input_addr
    @p zero                    \ пушим счётчик                                   D: sym_cnt | A: buffer_ptr | B: input_addr
read_sec:
    @b                         \                                                 D: sym_cnt sym | A: buffer_ptr | B: input_addr 
    dup !+                     \                                                 D: sym_cnt sym | A: buffer_ptr_next | B: input_addr
    @p cr xor if save_cnt      \                                                 D: sym_cnt | A: buffer_ptr_next | B: input_addr
    @p one + dup               \ инкремент счётчика символов                     D: sym_cnt_nxt sym_cnt_nxt | A: buffer_ptr_next | B: input_addr
    @p max_buffer_len xor if error_out  \ проверка превышения
    read_sec ;

save_cnt:
    @p buffer_ptr a!           \ пушим указатель на старт буфера в a             D: sym_cnt | A: buffer_ptr | B: X
    @ + !+                     \ сохраняем длину строки                          D: | A: buffer_ptr_nxt | B: X
    @p zero                    \ пушим счётчик символов на стек                  D: sym_cnt | A: buffer_ptr_nxt | B: X
cycle:
    a b!                       \ копируем указатель на буфер из a в b            D: sym_cnt | A: buffer_ptr | B: buffer_ptr
    @p mask                    \ пушим маску на стек                             D: sym_cnt mask | A: buffer_ptr | B: buffer_ptr

    @+                         \ пушим слово по адресу из a на стек              D: sym_cnt mask buff_word | A: buffer_ptr_nxt | B: buffer_ptr
    and                        \ сбиваем маской лишнее                           D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    dup @p cr xor if fill_buffer \ проверяем, является ли символ переносом строки - если да, то В С Ё  D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    dup @p space xor
    if output_and_set_zero     \ проверяем, является ли символ пробелом если да, то обработка отдельно D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr

    is_letter ;

is_letter:                    \ high check
    dup @p upper_finish_idx +             \                                                 D: X curr_char_word (curr_char_word-0x5A)
    -if _is_letter_low_check  \                                                 D: X curr_char_word
    dup @p upper_start_idx +             \                                                 D: X curr_char_word (curr_char_word-0x41)
    -if if_is_letter          \ если буква перед диапазоном заглавных -> out    D: X curr_char_word
    output_and_set_zero ;
_is_letter_low_check:         \ low check
    dup @p lower_start_idx +             \                                                 D: X curr_char_word (curr_char_word-0x61)
    -if if_is_letter          \
    dup @p lower_finish_idx +            \                                                 D: X curr_char_word (curr_char_word-0x7A)
    -if if_is_letter          \ 
    output_and_set_zero ;



if_is_letter:
    over dup if is_first      \ проверяем, является ли символ первым в слове. если да, то обрабатываем отдельно D: curr_char_word sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    over                      \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
not_first: 
    dup @p lower_start_idx +             \                                                 D: sym_cnt curr_char_word (curr_char_word-0x61) | A: buffer_ptr_nxt | B: buffer_ptr
    -if output_and_count
    is_not_first_high ;
is_not_first_high:
    @p high_to_low_shift +                \                                                 D: sym_cnt (curr_char_word+0x20) | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;




is_first:                     \                                                 D: curr_char_word sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    over dup @p lower_start_idx +        \                                                 D: sym_cnt curr_char_word (curr_char_word-0x61) | A: buffer_ptr_nxt | B: buffer_ptr
    -if is_first_low          \ проверяем, является ли символ нижним. если да, то отдельно   D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;
is_first_low:                 \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    @p low_to_high_shift +                 \                                                 D: sym_cnt (curr_char_word-0x20) | A: buffer_ptr_nxt | B: buffer_ptr
    output_and_count ;




output_and_set_zero:          \                                                 D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    over drop @p zero over    \ сбрасываем счётчик символов                     D: sym_cnt curr_char_word | A: buffer_ptr_nxt | B: buffer_ptr
    output                    \                                                 D: sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    cycle ;
output_and_count:
    output                    \                                                 D: sym_cnt | A: buffer_ptr_nxt | B: buffer_ptr
    @p one +                  \                                                 D: sym_cnt_nxt | A: buffer_ptr_nxt | B: buffer_ptr
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


fill_buffer:
    @p buff_placeholder_fragment !b         \ оверрайдим конец строки
    finish ;   

error_out:
    @p error_fill
    numio_output

finish:
    halt