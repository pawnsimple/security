#include <stdio.h>
#include <stdlib.h>
#include <math.h>

long long int exp(int a,int b) {
	long long int result = a;
	int i; 
		for(i = 1; i < b; i++) 
				result = result * a;
		return result;
}

int calcula(int prim, int rpt, int numx) {
	long long int expo;
	expo = exp(rpt,numx);
	return (expo-(floor(expo/prim)*prim));
}

int main() {
	int prim,rpt,numa,numb;
	long long int cmp_a,cmp_b;
	
	printf("Digite um numero primo e sua raiz primitiva:\n");
		scanf("%d %d",&prim,&rpt);
	printf("Digite o numero da primeira e da segunda pessoa.\n");
		scanf("%d %d",&numa,&numb);
	
	cmp_a = calcula(prim,rpt,numa);
	cmp_b = calcula(prim,rpt,numb);
	
	printf("A chave para a primeira pessoa e: %d\n",calcula(prim,cmp_b,numa));
	printf("A chave para a primeira pessoa e: %d\n",calcula(prim,cmp_a,numb));
	
	return 0;
}