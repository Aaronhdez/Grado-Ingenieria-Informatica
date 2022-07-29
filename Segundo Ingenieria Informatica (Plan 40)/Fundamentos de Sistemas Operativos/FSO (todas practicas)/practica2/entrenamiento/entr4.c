#include <stdio.h>

// Tabla ASCII
main() {
	printf("Tabla ASCII (32 to 126)\n");
	
	int i;
	for (i=32; i<=126; i++) {
		printf("Decimal: %d, hexadecimal: %x, carácter: %c\n",i,i,i);
	}

	printf("\n");
}
