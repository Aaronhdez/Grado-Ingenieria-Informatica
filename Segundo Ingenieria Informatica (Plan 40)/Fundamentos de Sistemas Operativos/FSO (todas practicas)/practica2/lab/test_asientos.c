#include <stdio.h>
#include "asientos.h"

void sentarse(int dni) {
	int res = find(dni);
	
	if (res != -1) {
		printf("Se ha asignado al dni %d el asiento número %d\n", dni, res);

	} else {
		printf("No hay asientos disponibles. Vacie alguno antes de intentarlo de nuevo.\n");

	}
}

void levantarse(int dni) {
	int res;
	int i;
	
	// -1: Se acabó la lista
	for (i=0; i>-1; i++) {
		res = test(i);
		if (res == dni) {
			clear(i);
			break;
		}
	}
	
	if (res != -1) {
		printf("Asiento %d de %d liberado con éxito.\n", res, i);

	} else {
		printf("El dni %d no tiene ningún asiento.\n", dni);

	}
}

void reserva_multiple(int npersonas, int* lista_dni) {
	if (numClear() >= npersonas) {
		int* ptr = lista_dni;
		int n;
	
		for (n=0; n<npersonas; n++) {
			find(ptr[n]);
		}
		printf("Éxito en reserva múltiple.\n");
		
	} else {
		printf("No hay espacio suficiente para reserva múltiple.\n");
		
	}	
}

int main() {
	int N;
	printf("Introduzca el número de elementos máximos:\n");
	scanf("%d", &N);
	inicialice(N);
	printf("\n");

	int max = N+1;
	int vec[max];
	int* ptr = vec;
	int n;
	
	for (n=0; n<max; n++){
		ptr[n] = 6540+n;
	}
	
	// Prueba: sentarse()
	for (n=0; n<max; n++){
		sentarse(ptr[n]);
	}
	
	// Prueba: levantarse()
	levantarse(ptr[0]);
	levantarse(ptr[max-1]);
	
	// Prueba: reserva_multiple()
	reserva_multiple(max, ptr);
	
	for (n=0; n<max-1; n++) {
		levantarse(ptr[n]);
	}
	
	reserva_multiple(max, ptr);
	reserva_multiple(max-1, ptr);
}
