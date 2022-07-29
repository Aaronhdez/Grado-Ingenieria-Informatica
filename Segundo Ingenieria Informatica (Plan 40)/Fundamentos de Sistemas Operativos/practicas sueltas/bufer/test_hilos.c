// Prueba concurrente de acceso al búfer
// Se lanzan hilos productores y consumidores
// Al no haber sincronización entre los hilos,
// el resultado es que se puede corromper el búfer

//Archivos cabecera del sistema
#include <stdlib.h> // atoi(), exit()...
#include <stdio.h>  // printf(), fputs(), stderr...
#include <string.h>
#include <errno.h>
#include <pthread.h>
#include <time.h>		//AÑADIDO PARA CONTROLAR INANICIÓN EN EL BUFFER
#include "buffer_circular.h"

time_t tiempoInicial;
int marcador = -1;

pthread_mutex_t mostradorEntrada = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mostradorSalida = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t condicion_prod = PTHREAD_COND_INITIALIZER;
pthread_cond_t condicion_cons = PTHREAD_COND_INITIALIZER;

// Función auxiliar para comprobar errores
// e imprimir un mensaje si hay error
void check_error(int return_code, const char* msg)
{
  if (return_code!=0)
  {
    if (msg != NULL) {
      fprintf(stderr,"%s\n",msg);
    } else {
      fprintf(stderr,"error %d: %s\n",errno,strerror(errno));
    }
    exit(-1);
  }
}

//AÑADIDO

void* Temporizador(void *no_usado){
	while(1){
		if((time(NULL)-tiempoInicial) >= 2){
			errno = EDEADLOCK;
			if(marcador = 1){
				fprintf(stderr,"Atasco: no hay suficientes productores %d: %s\n",errno,strerror(errno));
			} else {
				fprintf(stderr,"Atasco: no hay suficientes consumidores %d: %s\n",errno,strerror(errno));
			}
			exit(-1);
		}
	}
}

// Hilo Productor: inserta un item en el búfer
void* Productor (void *item){

  pthread_mutex_lock(&mostradorEntrada);

  //Espera mientras el búfer está lleno
  while ( buffer_pendientes_consumir() == buffer_capacidad() ) {
	pthread_cond_wait(&condicion_prod,&mostradorEntrada); 
  }
  
  //SECCION CRÍTICA
  buffer_inserta((ITEM)item);
  tiempoInicial = time(NULL);
  marcador = 0;
  //FIN SECCION CRITICA  

  //DESPERTAR Y SALIR
  pthread_cond_signal(&condicion_cons);
  pthread_mutex_unlock(&mostradorEntrada);

  pthread_exit(NULL);
}

// Hilo Consumidor: extrae un item del búfer
void* Consumidor (void* no_se_usa){

  pthread_mutex_lock(&mostradorSalida);

  //Espera si el búfer está vacío
  while ( buffer_pendientes_consumir() == 0 ) {
	pthread_cond_wait(&condicion_cons,&mostradorSalida); 
  }

  //SECCION CRITICA
  ITEM item;
  buffer_extrae(&item);
  printf("Consumidor extrae: %ld\n",item);
  tiempoInicial = time(NULL);
  marcador = 1;
  //FIN SECCION CRITICA

  pthread_cond_signal(&condicion_prod);
  pthread_mutex_unlock(&mostradorSalida);

  pthread_exit(NULL);
}

// Función auxiliar:
// espera a que termine un lote de hilos
// el lote es un vector de pthread_t
void espera_lote_hilos (pthread_t* lote, int nhilos)
{
	void* dummy; // pthread_join obliga a pasar un void*
	
	for (int i=0;i<nhilos;i++)
	{
		int ret=pthread_join(lote[i],&dummy);
		check_error(ret,0);
	}
}

// Rutina que lanza los hilos productores y consumidores
void test_hilos (int nprod, int ncons)
{
  //HACER CAMBIOS AQUI (MUTEX)
  // vectores de hilos (de tamaño variable) 
  pthread_t productores[nprod];
  pthread_t consumidores[ncons];
  pthread_t trigger;

  // Lanzamos los hilos  
  int ret = pthread_create(&trigger, NULL, Temporizador, NULL);

  for(long i=0; i<nprod; i++) 
  {
    // hay que convertir el long en void*
    // porque lo exige la función pthread_create
    void* item = (void*)i;
    int ret = pthread_create(&productores[i], NULL, Productor, item);
    check_error(ret,0);
  }

  for (int i=0; i<ncons; i++) 
  {
    int ret = pthread_create(&consumidores[i], NULL, Consumidor, NULL);
    check_error(ret,0);
  }
 
  // Esperamos a que todos los hilos finalicen
  espera_lote_hilos(productores,nprod);
  espera_lote_hilos(consumidores,ncons);
}


// Estructura con los parámetros de configuración
// para la simulación (se rellenan desde
// los argumentos argc y argv)
struct config {
	int capacidad;
	int nprod;
	int ncons;
};


// Función que comprueba y captura los parámetros pasados por línea de órdenes
void lee_argumentos (int argc, char *argv[], struct config* config)
{
	check_error( argc != 4, 
    "Invocación incorrecta. Sintaxis: ./fich_ejec capacidad num_prod num_cons");

	config->capacidad = atoi(argv[1]);
	check_error( config->capacidad < 1, 
    "Invocación incorrecta. La dimensión del búfer debe ser mayor que cero.");
	
	config->nprod = atoi(argv[2]);
	check_error( config->nprod < 0, 
    "Invocación incorrecta. El número de hilos productores debe ser mayor que cero.");

	config->ncons = atoi( argv[3] );
	check_error( config->ncons < 0, 
    "Invocación incorrecta. El número de hilos consumidores debe ser mayor que cero.");
}

// Función main:
// Invocación:
// 	# ./fich_ejec capacidad num_prod num_cons
// 	fich_ejec: nombre del archivo que contiene el código ejecutable
// 	capacidad: capacidad máxima del búfer (>0)
// 	num_prod: número de hilos productores (>=0)
// 	num_cons: número de hilos consumidores (>=0)
//
int main(int argc, char *argv[])
{
	struct config configuracion;

	puts("»»» Comienza la prueba del búfer...");
	lee_argumentos(argc,argv,&configuracion);

	int ret = buffer_inicia(configuracion.capacidad);
	check_error(ret,"Error al crear el búfer");

	test_hilos(configuracion.nprod,configuracion.ncons);
	puts("»»» Fin de la prueba del búfer");

	pthread_mutex_destroy(&mostradorEntrada);
	pthread_mutex_destroy(&mostradorSalida);
	pthread_cond_destroy(&condicion_prod);
	pthread_cond_destroy(&condicion_cons);

	exit(0);
}

