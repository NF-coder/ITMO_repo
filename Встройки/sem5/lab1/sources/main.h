#ifndef MAIN_H
#define MAIN_H

#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <stdbool.h>

// Базовые адреса периферии
#define RCC_BASE        0x40021000
#define GPIOA_BASE      0x50000000
#define GPIOB_BASE      0x50000400
#define USART2_BASE     0x40004400
#define SYSTICK_BASE    0xE000E010

// Структуры регистров
typedef struct {
  volatile uint32_t CR;
  volatile uint32_t CFGR;
  volatile uint32_t CIR;
  volatile uint32_t APB2RSTR;
  volatile uint32_t APB1RSTR;
  volatile uint32_t AHBENR;
  volatile uint32_t APB2ENR;
  volatile uint32_t APB1ENR;
} RCC_TypeDef;

typedef struct {
  volatile uint32_t MODER;
  volatile uint32_t OTYPER;
  volatile uint32_t OSPEEDR;
  volatile uint32_t PUPDR;
  volatile uint32_t IDR;
  volatile uint32_t ODR;
  volatile uint32_t BSRR;
  volatile uint32_t LCKR;
  volatile uint32_t AFR[2];
  volatile uint32_t BRR;
} GPIO_TypeDef;

typedef struct {
  volatile uint32_t CR1;
  volatile uint32_t CR2;
  volatile uint32_t CR3;
  volatile uint32_t BRR;
  volatile uint32_t GTPR;
  volatile uint32_t RTOR;
  volatile uint32_t RQR;
  volatile uint32_t ISR;
  volatile uint32_t ICR;
  volatile uint32_t RDR;
  volatile uint32_t TDR;
} USART_TypeDef;

typedef struct {
  volatile uint32_t CTRL;
  volatile uint32_t LOAD;
  volatile uint32_t VAL;
  volatile uint32_t CALIB;
} SysTick_TypeDef;

// Преобразование адресов в указатели
#define RCC     ((RCC_TypeDef*) RCC_BASE)
#define GPIOA   ((GPIO_TypeDef*) GPIOA_BASE)
#define GPIOB   ((GPIO_TypeDef*) GPIOB_BASE)
#define USART2  ((USART_TypeDef*) USART2_BASE)
#define SysTick ((SysTick_TypeDef*) SYSTICK_BASE)

// Бит маски
#define RCC_AHBENR_GPIOAEN  (1 << 17)
#define RCC_AHBENR_GPIOBEN (1 << 18)
#define RCC_APB1ENR_USART2EN (1 << 17)
#define GPIO_MODER_MODER5_0 (1 << 10)
#define GPIO_AFRL_AFSEL2_0  (1 << 8)
#define USART_CR1_UE        (1 << 0)
#define USART_CR1_TE        (1 << 3)
#define USART_ISR_TXE       (1 << 7)

extern volatile uint32_t tickCount;

#endif