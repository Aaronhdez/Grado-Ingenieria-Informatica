#include <stdio.h>

main() {
	int x;
	
	printf("Introduzca un número entero:");
	scanf("%d", &x);
	
	printf("El número %d se representa en hexadecimal como: %x\n", x, x);
}
