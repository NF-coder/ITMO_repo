#include <inttypes.h>

typedef struct {
    uint8_t day;
    uint8_t month;
    uint16_t year;
} BDay;

typedef enum {
    MALE,
    FEMALE
} SEX;

typedef struct {
    char* name;
    BDay* birthday;
    SEX sex;
} Student;

typedef struct {
    char* groupName;
    Student** students;
} Group;