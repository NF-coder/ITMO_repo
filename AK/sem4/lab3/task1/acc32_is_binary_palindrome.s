    .data
.org             0x10
result_addr:     .word  0x84
input_addr:      .word  0x80
input_value:     .word  0x0
low_bit:         .word  0x0
high_bit:        .word  0x0
low_shift:       .word  0x0
high_shift:      .word  0x1F
iterations:      .word  0x10
one:             .word  0x1

    .text
    .org         0x90
_start:
    load_addr    input_addr
    load_acc
    store_addr   input_value
loop:
    load_addr    input_value                 ; загружаем ввод
    shiftr       low_shift                   ; сдвигаем на i вправо
    and          one                         ; acc <- acc & 1
    store_addr   low_bit                     ; записывааем значение младшего бита

    load_addr    input_value                 ; загружаем ввод
    shiftr       high_shift                  ; сдвигаем на 31-i вправо
    and          one                         ; acc <- acc & 1
    store_addr   high_bit                    ; записывааем значение старшего бита

    load_addr    low_bit                     ; загружаем младший бит
    xor          high_bit                    ; XOR со старшим битом
    bnez         not_palindrome              ; если не 0 - не палиндром

    load_addr    low_shift                   ; инкремент сдвига младшего бита
    add          one
    store_addr   low_shift

    load_addr    high_shift                  ; декремент сдвига старшего бита
    sub          one
    store_addr   high_shift

    load_addr    iterations                  ; декремент числа итераций
    sub          one
    store_addr   iterations

    load_addr    iterations                  ; проверяем сколько осталось (нам же не гарантируется созранение acc после store_addr)
    bnez         loop                        ; если осталось 0 итераций, то идём далее иначе к старту цикла

palindrome:
    load_imm     1
    store_ind    result_addr
    halt

not_palindrome:
    load_imm     0
    store_ind    result_addr
    halt
