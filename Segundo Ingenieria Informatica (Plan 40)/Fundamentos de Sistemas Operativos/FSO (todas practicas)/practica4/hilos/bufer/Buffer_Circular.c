// Archivo de definición de las funciones
//
// Ficheros cabecera
#include <stdlib.h> // Requerido para malloc
#include <unistd.h>  // Requerido para Sleep  
#include <stdio.h>   // Requerido para lecturas y escrituras en los canales de entrada/salida


// Se incluye fichero cabecera en el que se declara los tipos y funciones de manejo del buffer circular
#include "Buffer_Circular.h"

// Puntero a una estructura de tipo Buffer_Circular
struct Buffer_Circular *Buffer=NULL;

// Función de creación del búfer circular
int Crea_Buffer(int Capacidad)
{
	long *p0;	
	struct Buffer_Circular *p1;
	int i;

	if (Capacidad <= 0) return -1;
	p0 = malloc( sizeof(long) * Capacidad);
	p1 = malloc(sizeof(struct Buffer_Circular));
	if ( (p0 != NULL) && (p1 != NULL) ) {
		Buffer = p1;
		Buffer->Buff = p0;
		Buffer->Inserta = 0;
		Buffer->Extrae = 0;
		Buffer->Nelementos = Capacidad;
		Buffer->Pendientes_Consumir = 0;
		for(i=0;i<Capacidad;i++) Buffer->Buff[i]=-1;
		return 0;
	}
	else {
		return -1;
	}
}


// Función que retorna el número de ítems pendientes de consumir
int Num_Pendientes_Consumir(){
return Buffer->Pendientes_Consumir;
}

// Función que retorna la capacidad máxima del búfer
int Capacidad_Buffer(){
return Buffer->Nelementos;
}

// Inserta un item en el búfer y actualiza los campos de datos del búfer
void *Inserta_Item(void *item)
{
	Buffer->Buff[Buffer->Inserta] = (long)item;
	if ( (long)item % 2 )
		sleep(1);
	printf("Se ha insertado en %d el item %ld\n",Buffer->Inserta,(long)item);
	Buffer->Inserta = (Buffer->Inserta+1) % Buffer->Nelementos;
	Buffer->Pendientes_Consumir++;
}

// Extrae un elemento del búfer y actualiza los campos de datos del búfer
void *Extrae_Item(void *item)
{
	item = (void *)(Buffer->Buff[Buffer->Extrae]);
	Buffer->Buff[Buffer->Extrae] = -1;
	printf("Se extrajo de %d el item %ld\n",Buffer->Extrae,(long)item);
	Buffer->Extrae = (Buffer->Extrae+1) % Buffer->Nelementos;
	Buffer->Pendientes_Consumir--;
}

