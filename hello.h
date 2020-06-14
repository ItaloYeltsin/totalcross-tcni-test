#ifdef  __cplusplus
extern "C" {
#endif

extern void hello();

extern void hello2(char * name, double dValue, float fValue, int iValue);

extern char * helloStr(char * name, double dValue, float fValue, int iValue);

extern int helloInt(char * name, double dValue, float fValue, int iValue);

extern double helloDouble(char * name, double dValue, float fValue, int iValue);

extern float helloFloat(char * name, double dValue, float fValue, int iValue);

extern char helloChar(char c);

extern long int helloLong(long li);

extern short int helloShort(short si);

extern unsigned short int helloByte(unsigned char by);

extern bool helloBoolean(bool bo);

extern int * helloIntArray(int * array_size);
#ifdef  __cplusplus
}
#endif
