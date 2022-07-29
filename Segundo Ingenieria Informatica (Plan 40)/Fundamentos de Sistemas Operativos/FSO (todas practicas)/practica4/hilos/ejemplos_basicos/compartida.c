// Varios hilos acceden sin control a una variable compartida.
// Los hilos continuamente incrementan y decrementan la variable.
// si las operaciones fueran atómicas, la variable debería mantenerse
// dentro del rango 1..3, pero la ejecución muestra un comportamiento errático.
//
// Para compilar este programa hay que incluir la biblioteca pthreads:
// cc compartida.c -o programa -lpthread

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <errno.h>

// La variable compartida
int compartida = 1;

// Código que ejecuta cada uno de los hilos
void* BucleSinFin (void* nada)
{

  for (;;) {
    compartida++;
    compartida--;
  }
}

// Rutina que lanza los hilos y
// los pone a manipular continuamente la variable compartida
int main()
{
  // dos hilos
  pthread_t hilo1, hilo2;
  int ret;
  
  ret=pthread_create(&hilo1, NULL, BucleSinFin, NULL);
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_create al crear el hilo1: %s\n",errno,strerror(errno));
	exit(-1);
  } 
  ret=pthread_create(&hilo2, NULL, BucleSinFin, NULL);
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_create al crear el hilo2: %s\n",errno,strerror(errno));
	exit(-1);
  }

  // el hilo principal monitoriza la variable:
  // Cada segundo imprime su valor actual
  for (;;) {
    printf ("%d ",compartida);
    fflush(stdout);
    sleep(1);
  }  
}


