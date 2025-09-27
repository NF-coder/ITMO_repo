#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

char shiftChar(int8_t shift, char symbol, uint8_t alphabet_start, uint8_t alphabet_size) {
    int new_alph_pos = (symbol - alphabet_start + shift) % alphabet_size;
    if (new_alph_pos < 0) {
        new_alph_pos += alphabet_size;
    }
    return alphabet_start + new_alph_pos;
}

void run(char* text, int8_t shift) {
    for (int i = 0; text[i] != '\0'; i++) {
        if (text[i] >= 'A' && text[i] <= 'Z') {
            text[i] = shiftChar(shift, text[i], 'A', 26);
        }
        else if (text[i] >= 'a' && text[i] <= 'z') {
            text[i] = shiftChar(shift, text[i], 'a', 26);
        }
    }
}

int main(int argc, char* argv[]) {
    if (argc < 4) {
        printf("Usage: %s <text> <shift> <e/d>\n", argv[0]);
        printf("e - encrypt, d - decrypt\n");
        printf("Example: %s HELLO 4 e\n", argv[0]);
        return 1;
    }
    
    char* text = argv[1];
    uint8_t shift = atoi(argv[2]);
    char task = argv[3][0];
    
    if (task == 'd') {
        shift = -shift;
    }

    run(text, shift);
    printf("%s\n", text);

    return 0;
}