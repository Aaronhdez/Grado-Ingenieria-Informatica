// Prueba concurrente de acceso al búfer
// Se lanzan hilos productores y consumidores
// Al no haber sincronización entre los hilos,
// el resultado es que se puede corromper el búfer

//Archivos cabecera del sistema
#include <stdlib.h> // Requerido para atoi
#include <stdio.h> // Requerido para printf
#include <errno.h>
#include <pthread.h>
#include "Buffer_Circular.h"

// Función que comprueba y captura los parámetros pasados por línea de órdenes
void Comprobar_Argumentos(int argc, char *argv[], int *dim, int *np, int *nc);

// Hilo Productor: inserta un item en el búfer
void *Productor(void *item);

// Hilo Consumidor: extrae un item del búfer
void *Consumidor(void *item);

// Rutina que lanza los hilos productores y consumidores
void test_recurso_hilos(int np, int nc);


// Función que comprueba y captura los parámetros pasados por línea de órdenes
void Comprobar_Argumentos(int argc, char *argv[], int *dim, int *np, int *nc){
	if (argc != 4) {
		fprintf(stderr,"Invocación incorrecta: ./fich_ejec dim_buff num_prod num_cons\n");		
		exit(-1);
	}

	*dim = atoi(argv[1]);
	if (*dim<1) {
		fprintf(stderr,"Invocación incorrecta. La dimensión del búfer debe ser >0: ./fich_ejec dim_buff num_prod num_cons\n");
		exit(-1);
	}
	
	*np = atoi( argv[2] );
	if ( *np < 0 ) {
		fprintf(stderr,"Invocación incorrecta. El número de hilos productores debe ser >0: ./fich_ejec dim_buff num_prod num_cons\n");
		exit(-1);
	}

	*nc = atoi( argv[3] );
	if ( *nc < 0 ) {
		fprintf(stderr,"Invocación incorrecta. El número de hilos consumidores debe ser >0: ./fich_ejec dim_buff num_prod num_cons\n");
		exit(-1);
	}	
}

// Hilo Productor: inserta un item en el búfer
void *Productor(void *item){
	while (Num_Pendientes_Consumir() == Capacidad_Buffer()) ;
	//printf("Hilo productor va a insertar %ld\n",(long)item);
	Inserta_Item(item);
	pthread_exit(NULL);
}

// Hilo Consumidor: extrae un item del búfer
void *Consumidor(void *item)
{
	while (Num_Pendientes_Consumir() == 0) ;
	Extrae_Item(item);
	pthread_exit(NULL);
}

// Rutina que lanza los hilos productores y consumidores
void test_recurso_hilos(int np, int nc)
{
  pthread_t *productores;
  pthread_t *consumidores;
  int ret;
  long int i;
  void* dummy;
  
  productores=malloc(np*sizeof(pthread_t));
  if (productores==NULL) {
    fprintf(stderr,"Error en la petición de memoria para pthread_t productores\n");
    exit(-1);
  }

  consumidores=malloc(nc*sizeof(pthread_t));
  if (consumidores==NULL) {
    fprintf(stderr,"Error en la petición de memoria para pthread_t consumidores\n");
    exit(-1);
  }

  for(i=0; i<np; i++) {
    ret = pthread_create(&productores[i], NULL, Productor, (void *)i);
    if (ret) {
	errno=ret;
	fprintf(stderr,"error %d: %s\n",errno,strerror(errno));
      	exit(-1);
    }
  }

  for (i=0; i<nc; i++) {
    ret=pthread_create(&consumidores[i], NULL, Consumidor, (void *)i);
    if (ret) {
	errno=ret;
	fprintf(stderr,"error %d: %s\n",errno,strerror(errno));
      	exit(-1);
    }
  }
 
  for(i=0;i<np;i++) {
    ret=pthread_join(productores[i],&dummy);
    if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d en el join del hilo productor %d: %s\n",errno,i,strerror(errno));
	exit(-1);
    }
  }

  for(i=0;i<nc;i++) {
    ret=pthread_join(consumidores[i],&dummy);
    if (ret) {
	errno=ret;
	fprintf(stderr,"Erro %d en el join del hilo consumidor %d: %s\n",errno,i,strerror(errno));
	exit(-1);
    }
  }
}

// Función main:
// Invocación:
// 	# ./fich_ejec dim_buff num_prod num_cons
// 	fich_ejec: nombre del archivo que contiene el código ejecutable
// 	dim_buff: dimensión del búfer (>0)
// 	num_prod: número de hilos productores (>=0)
// 	num_cons: número de hilos consumidores (>=0)
//
int main(int argc, char *argv[]) {
  int dim,np,nc;

  printf("»»» Comienza la prueba del búfer...\n");
  Comprobar_Argumentos(argc, argv,&dim,&np,&nc);
  if (Crea_Buffer(dim) < 0) {
	fprintf(stderr,"Error al crear buffer\n");
	exit(-1);
  }
  test_recurso_hilos(np,nc);
  printf("»»» Fin de la prueba del búfer\n");
  exit(0);
}


