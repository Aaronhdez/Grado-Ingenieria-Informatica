#include <stdio.h>

// Tabla ASCII
main() {
	printf("Tabla ASCII (32 to 127)\n");
	printf("DecHexChar | DecHexChar  | DecHexChar\n");	

	int i;
	int j = 1;
	for (i=32; i<=127; i++) {
		printf("%d %x %c",i,i,i);
		if (j%3 == 0) {
			printf("\n");
		} else {
			printf("|");
		}
		j++;
	}

	printf("\n");
}
