#include <stdio.h>

//#define A 32
main() {
	
	char x[100];
	printf("Introduce una frase corta:");
	scanf("%[^\n]s", x);
	
	char res[100];
	for (int i=0; x[i]!=0; i++) {
		if (x[i] == ' ') {
			x[i] = '\n';
		}
		printf("%c",x[i]);
	}

	printf("\n");
}
