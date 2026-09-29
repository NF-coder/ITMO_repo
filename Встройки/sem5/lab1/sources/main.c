#include "main.h"
#include "tm1637.h"

volatile uint32_t tickCount;


// my NEW vars
int operations[4];
int operationIndex;
bool blockOperationSelect;

struct Variable {
  bool isSet;
  int value;
};

struct Variable var1;
struct Variable var2;



void osSystickHandler(void) {
  tickCount++;
}

void initGPIO() {
  // Включаем тактирование GPIOA и GPIOB
  RCC->AHBENR |= RCC_AHBENR_GPIOAEN | RCC_AHBENR_GPIOBEN;

  // Настраиваем PA5 как выход
  GPIOA->MODER = (GPIOA->MODER & ~(3 << 10)) | (1 << 10);
  GPIOA->OTYPER &= ~(1 << 5);
  GPIOA->OSPEEDR |= (1 << 10);
}

void initUSART2() {
  // Включаем тактирование USART2
  RCC->APB1ENR |= RCC_APB1ENR_USART2EN;

  // Настраиваем PA2 и PA3 в альтернативный режим
  GPIOA->MODER = (GPIOA->MODER & ~(0xF << 4)) | (0xA << 4);
  GPIOA->AFR[0] = (GPIOA->AFR[0] & ~(0xFF << 8)) | (1 << 8) | (1 << 12);

  // Настраиваем USART2
  USART2->BRR = 417; // 48MHz/115200
  USART2->CR1 = USART_CR1_TE | USART_CR1_UE;
}

void initSysTick() {
  SysTick->LOAD = 2*47999; // 1ms при 48MHz
  SysTick->VAL = 0;
  SysTick->CTRL = (1 << 2) | (1 << 1) | (1 << 0);
}

int _write(int file, uint8_t *ptr, int len) {
  for (int i = 0; i < len; i++) {
    while (!(USART2->ISR & USART_ISR_TXE));
    USART2->TDR = ptr[i];
  }
  return len;
}

// my func
void initVariables() {
  var1.value = 0;
  var1.isSet = false;

  var2.value = 0;
  var2.isSet = false;
}

void initOperations() {
  operations[0] = '+';
  operations[1] =  '-';
  operations[2] =  '*';
  operations[3] =  '/';
  operationIndex = 0;
  blockOperationSelect = false;
}
void incOperationIndex() {
  operationIndex = (operationIndex + 1) % 4; // (sizeof(operations)/sizeof(operations[0]))
}
void clearOperationIndex() {
  operationIndex = 0;
}
void unlockOperationSelect() {
  blockOperationSelect = false;
}
void lockOperationSelect() {
  blockOperationSelect = true;
}
char getOperation() {
  char currentOp = operations[operationIndex];
  return currentOp;
}

bool isNumeric(int symbol) {
  return (symbol - '0') >= 0 && (symbol - '0') <= 9;
}
bool isOperationSelect(int symbol) {
  return symbol == '*';
}
bool isEnter(int symbol) {
  return symbol == '#';
}

void finalizeCalc() {
  if (getOperation() == '+') {
    tm1637_display_number(var1.value + var2.value);
  } else if (getOperation() == '-') {
    tm1637_display_number(var1.value - var2.value);
  } else if (getOperation() == '*') {
    tm1637_display_number(var1.value * var2.value);
  } else if (getOperation() == '/') {
    tm1637_display_number(var1.value / var2.value);
  }
  initVariables();
  clearOperationIndex();
}

void serveKeyboard() {
  if (isCharUpdated()) {
    char currentKey = getLastChar();

    if (isNumeric(currentKey)) {
      if (!var1.isSet) {
        var1.value = var1.value*10 + (currentKey - '0');

        tm1637_display_number(var1.value);
      } else if (!var2.isSet) {
        lockOperationSelect();
        var2.value = var2.value*10 + (currentKey - '0');

        tm1637_display_number(var2.value);
      }
    } else if (var1.isSet && !var2.isSet && isOperationSelect(currentKey) && !blockOperationSelect) {
      incOperationIndex();

      tm1637_display_number(operationIndex);
    } else if (isEnter(currentKey)) {
      if (!var1.isSet) {
        var1.isSet = true;
      } else if (!var2.isSet) {
         var2.isSet = true;
         finalizeCalc();
      }
    }

    // printf("Var1 = %d (%d) , Var2 = %d  (%d), Op = %c \n", var1.value, var1.isSet,  var2.value, var2.isSet,  getOperation());
  }
}


int main(void) {
  initGPIO();
  initUSART2();
  initSysTick();
  initKeyboard();
  tm1637_init();
  initVariables();
  initOperations();

  while (1) {
    scanKeyboard();
    serveKeyboard();
  }

  return 0;
}

