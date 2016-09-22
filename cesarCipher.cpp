#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <cstring> 

char Cipher(char ch, int key)
{
	return (char)((((ch + key)) % 256));
}

char* Encipher(char* input, int key)
{
	int inputLen = strlen(input);
	char* output = (char*)malloc(inputLen + 1);

	for (int i = 0; i < inputLen; ++i)
		output[i] = Cipher(input[i], key);

	output[inputLen] = '\0';
	return output;
}

char* Decipher(char* input, int key)
{
	return Encipher(input, 256 - key);
}



int main() {
	int key;
	FILE *f;
	FILE *fp;
    char c;
    key = 5;
    f=fopen("C:\\Users\\MisterMap\\Documents\\Seguranca\\input\\cesar\\1.input","rt");
    fp = fopen("C:\\Users\\MisterMap\\Documents\\Seguranca\\output\\cesar\\saida.txt", "w+");
    char * temp;
    char  temp2;
    while((c=fgetc(f))!=EOF){
    	temp = Encipher(&c, key);
        temp2 = *temp;
        fputc(temp2, fp);
	}
	
	fclose(fp);
	fclose(f);

	
    f=fopen("C:\\Users\\MisterMap\\Documents\\Seguranca\\output\\cesar\\saida.txt","rt");
    fp = fopen("C:\\Users\\MisterMap\\Documents\\Seguranca\\output\\cesar\\reverse\\saidaDescriptografada.txt", "w+");
    
    while((c=fgetc(f))!=EOF){
    	temp = Decipher(&c, key);
        temp2 = *temp;
        fputc(temp2, fp);
	}
	
	fclose(fp);
	fclose(f);
	
	return 0;
}