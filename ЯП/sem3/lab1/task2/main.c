#include <stdio.h>
#include "inttypes.h"

typedef struct {
    uint8_t x;
    uint8_t y;
} Point;

int main () {
    Point p1 = {.x=10, .y=14};
    
    printf("%i\n", p1.x);
    
    return 0;
}