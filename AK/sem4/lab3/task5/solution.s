    .data
input_addr:              .word  0x80
output_addr:             .word  0x84

    .text
    .org 0x90
_start:
    ; загружаем указатель на яйчейку ввода в S1 и указатель на яйчейку вывода в S2
    lui s1, %lo(input_addr)       / lui s2, %hi(output_addr)       / nop            / nop
    addi s1, s1, %lo(input_addr)  / addi s2, s2, %lo(output_addr)  / nop            / nop

    ; получаем адрес яйчейки ввода. яйчейку вывода получим далее - это оптимпльнене 
    ; + начинаем загрузку значения при ошибке (в S3)
    ; + загружаем -1 (в S4) для индикации неверной длины
    lui s3, %hi(0xCCCCCCCC)       / addi s4, s4, -1                / lw s1, 0(s1)   / nop

    ; сохраняем количество чисел в T0 + заканчиваем загрузку значения при ошибке
    addi s3, s3, %lo(0xCCCCCCCC)  / nop                            / lw t0, 0(s1)   / nop

    ; далее - пусть A0 будет результатом sum, а A1 - результатом sum_sq
    ; прыгаем в вывод если нам дали 0 чисел + ликвидируем должок с адресом яйчейки вывода
    nop                           / nop                            / lw s2, 0(s2)   / beqz t0, finalize
    nop                           / nop                            / nop            / blt  t0, zero, array_len_error

compute:
    ; декремент оставшегося количества чисел + загрузка текущего числа в T1
    addi t0, t0, -1               / nop                            / lw t1, 0(s1)   / nop

    ; суммируем число и считаем квадрат
    add a0, a0, t1                / mul t2, t1, t1                 / nop            / nop

    ; если квадрат отрицательный, значит было переполнение
    add a1, a1, t2                / nop                            / nop            / blt t2, zero, clamp_error_entry

    ; если сумма квадратов стала отрицательной, значит было переполнение
    nop                           / nop                            / nop            / blt a1, zero, clamp_error_entry

    ; продолжаем цикл
    nop                           / nop                            / nop            / bnez t0, compute

finalize:
    ; вывод значений
    nop                           / nop                            / sw a0, 0(s2)   / nop
    nop                           / nop                            / sw a1, 0(s2)   / j stop
    
clamp_error_entry:
    ; поглащаем остаток
    nop                           / nop                            / nop            / beqz t0, clamp_error
    nop                           / addi t0, t0, -1                / lw t1, 0(s1)   / j clamp_error_entry
clamp_error:
    nop                           / nop                            / sw s3, 0(s2)   / j stop

array_len_error:
    nop                           / nop                            / sw s4, 0(s2)   / j stop

stop:
    nop                           / nop                            / nop            / halt