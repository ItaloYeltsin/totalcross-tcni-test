#include <iostream>
#include <cstdio>
#include <cstdlib>
#include "hello.h"
#include "string.h"
void hello() {
    std::cout << "Hello World!";
}

void hello2(char * name, double dValue, float fValue, int iValue) {
    printf("Hello, %s, %f, %f, %d\n", name, dValue, fValue, iValue);
}

char * helloStr(char * name, double dValue, float fValue, int iValue) {
    char *ret = (char *) malloc(sizeof(char)*6);
    strcpy(ret, "Italo");
    return ret;
}

int helloInt(char * name, double dValue, float fValue, int iValue) {
    return iValue;
}

double helloDouble(char * name, double dValue, float fValue, int iValue) {
    return dValue;
}

float helloFloat(char * name, double dValue, float fValue, int iValue) {
    return fValue;
}

char helloChar(char c) {
    printf("char, %c\n", c);
    return c;
}

long int helloLong(long li) {
    printf("long, %ld\n", li);
    return li;
}

short int helloShort(short si) {
    printf("short, %d\n", si);
    return si;
}

unsigned short int helloByte(unsigned char by) {
    printf("byte, %d\n", (int) by);
    return by;
}

bool helloBoolean(bool bo) {
    printf("char, %s\n", bo ? "true" : "false");
    return bo;
}

int * helloIntArray(int * array_size) {
    printf("printf array: 1 2 3 4 5\n");
    const int len = 5;
    * array_size = sizeof(int) * len;
    static int arr[len];
    for (size_t i = 0; i < len; i++)
    {
        arr[i] = i + 1;
    }
    return arr;
}