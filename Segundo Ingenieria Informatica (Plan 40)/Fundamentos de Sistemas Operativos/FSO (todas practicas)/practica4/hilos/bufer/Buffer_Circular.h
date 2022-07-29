#ifndef _BUFFER
#define _BUFFER
// Definición de la estructura búfer 
// El búfer no tiene tamaño fijo
struct Buffer_Circular {
	long *Buff;	// Puntero al bloque de memoria dónde se almacenan los item
	int Nelementos;	// Número máximo de elementos que se pueden almacenar
	int Extrae;	// Indica la posición del próximo item a extraer
	int Inserta;	// Indica dónde se insertará el próximo item a almacenar
	int Pendientes_Consumir;	// Indica el número de items que aún no han sido extraídos
};

// Función de creación del búfer circular
// Parámetro de entrada:
//	Capacidad: número máximo de elementos que pueden ser almacenados
// Devuelve
//	Si no hay error retorna valor cero, en caso contrario devuelve un valor negativo
int Crea_Buffer(int Capacidad);

// Función que inserta un item en el búfer
// Parámetros de entrada:
//	Nuevo item a almacenar en el búfer
void *Inserta_Item(void *item);

// Función que extrae un item del búfer
// Parámetros de entrada:
//	Puntero que almacenará el item a extraer
void *Extrae_Item(void *item);

// Función que retorna el número de ítems pendientes de consumir
int Num_Pendientes_Consumir();

// Función que retorna la capacidad máxima del búfer
int Capacidad_Buffer();
#endif
