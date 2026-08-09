    .data
    .org 0x00
buffer:                  .byte  '\0'

    .data
    .org 0x40
input_addr:              .word  0x80
output_addr:             .word  0x84

    .text
    .org     0x100
_start:
    movea.l 0x70, A7          ; определяем старт стека
    movea.l input_addr, A1    ; addr[input_addr] -> A1
    movea.l (A1), A1          ; value[A1] -> A1
    movea.l output_addr, A3   ; addr[output_addr] -> A3
    movea.l (A3), A3          ; value[A3] -> A3
    movea.l buffer, A2        ; addr[buffer] -> A2

    move.l 0, D4              ; используем D4 как глобальный счётчик итераций
read_next_3_sym:
    move.l 0, D1              ; используем D1 как результат
    move.l 0, D2              ; используем D2 как внутренний счётчик итераций
read_next_fragment:
    add.l 1, D4
    cmp.l 0x41, D4
    beq overflow_sym

    move.l (A1), D0           ; запись букву base64 из ввода в D0

    ; "Мам, а можно мне switch-case?"
    ; "У нас уже есть switch-case дома"
    ; switch-case дома:

    cmp.l 10, D0              ; new line
    beq flush_buffer

    cmp.l 61, D0              ; =
    beq eq_sym

    cmp.l 43, D0              ; +
    beq plus_sym

    cmp.l 47, D0              ; /
    beq slash_sym

    cmp.l 58, D0              ; сравниваем (для цифр)
    blt digit_sym

    cmp.b 91, D0              ; сравниваем (для заглавных)
    blt upper_sym

    cmp.b 123, D0             ; сравниваем (для маленьких)
    blt lower_sym

    jmp invalid_sym

digit_sym:
    cmp.l 48, D0 
    blt invalid_sym

    add.l 4, D0               ; - смещение в ASCII + смещение в алфавите base64 (D0 - 48 + 52)
    jmp concat_sym
upper_sym:
    cmp.l 65, D0 
    blt invalid_sym

    sub.l 65, D0               ; вычитаем смещение в ASCII чтобы получить номер
    jmp concat_sym
lower_sym: 
    cmp.l 97, D0 
    blt invalid_sym

    sub.l 71, D0               ; - смещение в ASCII + добавляем смещение в алфавите base64 (D0 - 97 + 26)
    jmp concat_sym
plus_sym:
    move.b 62, D0
    jmp concat_sym
slash_sym:
    move.b 63, D0
    jmp concat_sym
eq_sym:
    cmp.l 2, D2
    beq eq_two_chars
    jmp eq_three_chars
invalid_sym:
    ; доедаем
    move.l (A1), D0
    cmp.l 10, D0
    beq error
    jmp invalid_sym
overflow_sym:
    jmp overflow

concat_sym:
    lsl.l 6, D1                ; сдвигаем D1 на 6 бит 
    or.l D0, D1                ; добавляем в результат

    add.l 1, D2

    cmp.l 4, D2                ; проверяем заполнение
    beq write_chunk

    jmp read_next_fragment

write_chunk:
    move.l D1, D3
    lsr.l 16, D3
    move.b D3, (A2)+
    
    move.l D1, D3
    lsr.l 8, D3
    move.b D3, (A2)+
    
    move.b D1, (A2)+
    
    jmp read_next_3_sym

eq_two_chars:
    move.l (A1), D0 
    move.l (A1), D0 
    
    lsr.l 4, D1

    move.l 0, -(A7)
    jsr output

    jmp flush_buffer
eq_three_chars:
    move.l (A1), D0

    lsr.l 2, D1

    move.l 1, -(A7)
    jsr output
    move.l 0, (A7)
    jsr output

    jmp flush_buffer

output:
    link A6, 24
    move.b 8(A6), D3           ; индекс символа для обработки
    mul.l 8, D3                ; смещение
    move.l D1, -24(A6)         ; сохраняем старое значение переменной D1 

    lsr.l D3, D1
    move.b D1, (A2)+

    move.l -24(A6), D1         ; восстановление
    unlk A6
    rts

error:
    move.l -1, (A3)
    jmp end
overflow:
    move.l 0xCCCCCCCC, (A3)
    jmp end

flush_buffer:
    movea.l buffer, A4
flush_buffer_cycle:
    move.b (A4)+, D3
    beq end
    move.b D3, (A3)
    jmp flush_buffer_cycle
end:
    halt