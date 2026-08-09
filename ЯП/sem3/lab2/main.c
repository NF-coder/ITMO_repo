#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <inttypes.h>

// CRD + Serialize/Deserialize

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


BDay* createRandomBirthday() {
    BDay* birthday = (BDay*)malloc(sizeof(BDay));
 
    if (!birthday) {
        fprintf(stderr, "malloc failed\n");
        return NULL;
    }
    
    // TODO: valid dates
    uint16_t year = rand() % 30 + 1980;
    uint8_t month = rand() % 12 + 1;
    uint8_t day = rand() % 28 + 1;

    birthday->day = day;
    birthday->month = month;
    birthday->year = year;
 
    return birthday;
}
 

Student* createStudent(char* name, BDay* birthday, SEX sex) {
    Student* student = (Student*)malloc(sizeof(Student));
 
    if (!student) {
        fprintf(stderr, "malloc failed\n");
        return NULL;
    }
 
    student->name = name;
    student->birthday = birthday;
    student->sex = sex;
 
    return student;
}

void printStudent(const Student* student) {

    if (!student) {
        fprintf(stderr, "Invalid student\n");
        return;
    }
 
    const char* typeStr;

    switch (student->sex) {
        case MALE:
            typeStr = "male";
            break;
        case FEMALE:
            typeStr = "female";
            break;
        default:
            typeStr = "HOW?";
            break;
    }
 
    printf("Name: %s\n", student->name);
    printf("Birthday: %d.%d.%d\n", student->birthday->day, student->birthday->month, student->birthday->year);
    printf("Sex: %s\n", typeStr);
}

void serializeUnit(const Student* student, const char* filename) {
    if (!student || !filename) {
        fprintf(stderr, "Invalid arguments for serialization\n");
        return;
    }
 
    FILE* file = fopen(filename, "wb");
    if (!file) {
        fprintf(stderr, "Failed to open file for writing\n");
        return;
    }
 
    fwrite(student, sizeof(Student), 1, file);
    fclose(file);
}
 
Student* deserializeUnit(const char* filename) {
    if (!filename) {
        fprintf(stderr, "Invalid filename for deserialization\n");
        return NULL;
    }
 
    FILE* file = fopen(filename, "rb");
    if (!file) {
        fprintf(stderr, "Failed to open file for reading\n");
        return NULL;
    }
 
    Student* student = (Student*)malloc(sizeof(Student));
    if (!student) {
        fprintf(stderr, "Memory allocation failed\n");
        fclose(file);
        return NULL;
    }
 
    fread(student, sizeof(Student), 1, file);
    fclose(file);
 
    return student;
}

Group* createGroup(int size, char* groupName, char** studentsNames, SEX* studentSex) {
    Group* group = (Group*)malloc(size * sizeof(Group*));
    if (!group) {
        fprintf(stderr, "group malloc failed\n");
        return NULL;
    }

    group->students = (Student**)malloc(size * sizeof(Student*));
    if (!group->students) {
        fprintf(stderr, "malloc failed for students array\n");
        return NULL;
    }
 
    for (int i = 0; i < size; i++) {
        BDay* birthday = createRandomBirthday();
        Student* student = createStudent(studentsNames[i], birthday, studentSex[i]);
        group->students[i] = student;
    }
    
    group->groupName = groupName;
 
    return group;
}

int main () {
    // One student
    BDay* birthday = createRandomBirthday();
    
    serializeUnit(
        createStudent("test name", birthday, MALE),
        "student_bin.txt"
    );

    free(birthday);
    
    Student* student = deserializeUnit("student_bin.txt");

    printStudent(student);

    free(student);
    
    printf("\n=======================\n\n");

    // Group of students

    const int GROUP_SIZE = 5;
    char* studentNames[] = {"S1", "S2", "S3", "S4", "S5"};
    SEX studentSex[] = {MALE, MALE, FEMALE, FEMALE, MALE};

    Group* group = createGroup(
        GROUP_SIZE,
        "Test Group Name", 
        studentNames,
        studentSex
    );
    
    printf("Group name: %s\n", group->groupName);
    printf("\n");

    for (int i = 0; i < GROUP_SIZE; i++) {
        printStudent(group->students[i]);
    }
    free(group);

    return 0;
}