#ifndef TM1637_H
#define TM1637_H

#include <stdio.h>
#include <stdint.h>
#include <string.h>

#include "main.h"

void initKeyboard();
char readKey();
void scanKeyboard();

// my func
char getLastChar();
bool isCharUpdated();

#endif