#include <stdio.h>

// Número de decimal a binario
main() {
	// En binario al revés
	
	int x;
	printf("Introduzca un número:");
	scanf("%d", &x);

	int c = x;
	int r = 0;
	while (c != 0) {
		r = c%2;
		c = c/2;
		printf("%d", r);
	}
	printf("\n");

	// En binario al derecho
/*
	int x;
	printf("Introduzca un número:");
	scanf("%d", &x);
*/
	c = x;
	r = 0;
	int n = 0;
	while (c != 0) {
		c = c/2;
		n++;
	}
	
	c = x;
	int bin[n];
	int i;
	for (i=0; i<n; i++) {
		r = c%2;
		c = c/2;
		bin[i] = r;
	}
	
	for (i=n-1; i>=0; i--) {
		printf("%d", bin[i]);
	}

	printf("\n");
//	printf("%d\n", n);
		
}



