#include <stdio.h>
#include <stdlib.h>

int *asientos;
int tamano;

  
int Inicializa_Asientos() {  // Inicializa el vector a -1. Memoria dinámica
   int contador;
   
   asientos=malloc(tamano*sizeof(int));

   if (asientos==0) {
      printf("Error en la reserva de memoria\n");
      return -1;
   }

     for(contador=0;contador<tamano;contador++)
      *(asientos+contador)=-1;
}

void Libera_Asientos() { // Libera la memoria dinámica reservada

   free(asientos);
}

void Imprime_Asientos() { //Imprime todos los asientos con su valor
   int contador;

   for(contador=0;contador<tamano;contador++)
      printf("asientos[%d]=%d\n",contador,*(asientos+contador));
}

int Find(int dni) { // Búsqueda de asiento libre
   int contador;
   
   for(contador=0;contador<tamano;contador++)
	if (*(asientos+contador)==-1) {  // o bien asientos[cont]
		*(asientos+contador)=dni;
		return contador;
	}
   return -1;
}	

void Sentarse(int dni) { // Encuentra asiento a una persona
   int asiento;

   if ((asiento=Find(dni))>=0)
	printf("Asiento %d ocupado por %d\n",asiento,dni);
   else
	printf("No hay asientos libres\n");

}


main()
{
   int contador, dni;
 
   printf("Introduzca la dimensión del vector: ");
   scanf("%d",&tamano);

   if (Inicializa_Asientos()==-1) {
	printf("Error al inicializar el vector\n");
	return;
   }

   printf("Reserva de asiento para persona con DNI: ");
   scanf("%d",&dni);
   
   Sentarse(dni);

   Imprime_Asientos();

   Libera_Asientos();
}
