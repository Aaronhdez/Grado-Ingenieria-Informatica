// Ejemplo sencillo de dos hilos que se ejecutan de forma concurrente.
// Compilar con la biblioteca pthreads. Ejemplo:
// 	gcc prueba_hilos.c -o hilos -lpthread
//

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <unistd.h>

void retardo_aleatorio()
{
  unsigned long retardo=rand()%1000000;
  usleep(retardo);
}

// Objetos de tipo hilo
pthread_t un_hilo;
pthread_t otro_hilo;

// Las funciones que ejecutan los hilos SIEMPRE deben respetar ese formato:
// void* nombre_de_funcion (void*);

// Rutina que ejecutará uno de los hilos
void* rutina1(void* arg)
{
  int i;
  for (i=1; i<=10;i++)
  {
    retardo_aleatorio();
    printf("*** soy el HILO 1");
    fflush(stdout);
  }
  puts("*** HILO1 - the end");
  return NULL;
}

// Rutina que ejecutará el otro hilo
void* rutina2(void* arg)
{
  int i;
  for (i=1; i<=10;i++)
  {
    retardo_aleatorio();
    printf("@@@ soy el HILO 2");
    fflush(stdout);
  }
  puts("@@@ HILO2 - the end");
  return NULL;
}

// Aquí empieza el programa
int main()
{
  int ret;

  // Lanzo un hilo que ejecuta: rutina1(NULL)
  ret=pthread_create(&un_hilo, NULL, rutina1, NULL); 
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_create al crear el hilo1: %s\n",errno,strerror(errno));
	exit(-1);
  } 
 
  // Lanzo otro hilo que ejecuta: rutina2(NULL)
  ret=pthread_create(&otro_hilo, NULL, rutina2, NULL); 
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_create al crear el hilo2: %s\n",errno,strerror(errno));
	exit(-1);
  }
  retardo_aleatorio(); 
  exit(0);
}








