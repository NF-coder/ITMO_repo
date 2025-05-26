ORG 0x0 ; Инициализация векторов прерывания
V0: 	WORD 	$INT1,0x180	; Вектор прерывания #0
V1: 	WORD 	$INT3,0x180 ; Вектор прерывания #1
V2: 	WORD 	$DEFAULT,0x180 ; Вектор прерывания #3

ORG 0x010
DEFAULT: IRET

ORG 0x018
X: WORD 0x0000
CACHE1: WORD 0x0000
CACHE2: WORD 0x0000
MIN_VAL: WORD 0xFFEC ; -20
MAX_VAL: WORD 0x0015 ; 21


START:
	DI
	LD #0x08 	; Разрешить прерывания на вектор 0 
	OUT 0x03 	; (1000 | 0000 = 1000) в MR КВУ-1
	LD #0x09 	; Разрешить прерывания на вектор 1
	OUT 0x07 	; (1000 | 0001 = 1001) в MR КВУ-3

	LD #0x0A	
	OUT 0x01 	; MR КВУ-0 на вектор 2
	OUT 0x05 	; MR КВУ-2 на вектор 2
	OUT 0x0B 	; MR КВУ-4 на вектор 2
	OUT 0x0D 	; MR КВУ-5 на вектор 2
	OUT 0x11	; MR КВУ-6 на вектор 2
	OUT 0x15 	; MR КВУ-7 на вектор 2
	OUT 0x1A 	; MR КВУ-8 на вектор 2
	OUT 0x1E  	; MR КВУ-9 на вектор 2
	EI
MAIN:
	LD X
	INC

	PUSH
	CALL CHECKER
	POP

	ST X
	JUMP MAIN

CHECKER:
	LD (SP+1)
	CMP $MIN_VAL
	BLT CHECKER_FIN
	CMP $MAX_VAL
	BGE CHECKER_FIN
	ST (SP+1)
	RET
CHECKER_FIN:
	LD MIN_VAL
	ST (SP+1)
	RET

INT1:
	PUSH

	LD X
	ASL ;*2
	ASL ;*4
	ADD X ;*5
	ADD X ;*6
	SUB #0x03
	OUT 0x02

	POP
	IRET
INT3:
	PUSH

	IN 0x06
	ST CACHE1
	
	; NOT
	NEG
	DEC

	AND X

	ST CACHE2 ; A(^B)

	LD X

	; NOT
	NEG
	DEC

	AND CACHE1 ; (^A)B

	OR CACHE2 ; A(^B) + (^A)B

	LD X

	POP
	IRET