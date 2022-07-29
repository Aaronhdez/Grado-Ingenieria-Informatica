#include <stdio.h>

//#define A 32
main() {
	
	char x[50];
	printf("Introduce una frase corta:");
	scanf("%[^\n]s", x);
//	scanf("%s\0", &x[0]);

//	printf("%s\n", x);
	

	for (int i=0; x[i]!=0; i++) {
		char c = x[i];
		printf("%c, %d\n", c, c);
	}
	
	for (int i=0; x[i]!=0; i++) {
		char c = x[i];

		if (c=='a'|c=='e'|c=='i'|c=='o'|c=='u'|c=='A'|c=='E'|c=='I'|c=='O'|c=='U'){
			printf("%c ",c);
		}
	}
	
	printf("\n");
}
