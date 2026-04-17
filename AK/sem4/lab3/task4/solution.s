    .data
    .org 0x00
input_addr:              .word  0x80
output_addr:             .word  0x84

    .text
    .org 0x90
_start:
    lui a0, %hi(input_addr)
    addi a0, a0, %lo(input_addr)
    lw t0, 0(a0)
    lw t0, t0

    addi t1, t1, 1                   ; t1 = 1
    sra t2, t0, t1                   ; 
    addi t2, t2, 1                   ; t2 = t0/2 + 1 (t2 - верхняя граница)

    ble t0, zero, return_error       ; если t0 <= 0
    beq t0, t1, return_false         ; если t0 == 1
    addi t1, t1, 1                   ; t1 = 2        (t1 - делитель)
    
    rem t3, t0, t1
    beq t3, zero, return_false       ; чтоб отсечь чётные

    addi t1, t1, 1                   ; t1 = 3
prime_start:
    div t3, t0, t1                   ; t3 = t0 / t1
    bgt t1, t3, return_true          ; если t1^2 > t0 то простое

    rem t3, t0, t1                   ; t3 = t0 % t1
    beq t3, zero, return_false

    addi t1, t1, 2
    j prime_start

return_true:
    lui t0, 0
    addi t0, t0, 1
    j out
return_false:
    lui t0, 0
    j out
return_error:
    lui t0, 0
    addi t0, t0, -1
    j out

out:
    lui a1, %hi(output_addr)
    addi a1, a1, %lo(output_addr)
    lw t1, 0(a1)
    sw t0, 0(t1)
    halt