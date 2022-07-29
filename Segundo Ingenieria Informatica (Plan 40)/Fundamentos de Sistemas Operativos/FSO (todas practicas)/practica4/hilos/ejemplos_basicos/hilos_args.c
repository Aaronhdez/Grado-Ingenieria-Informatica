#include <stdio.h>
#include <pthread.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>

// Utilizamos un struct para pasar varios parámetros al hilo
typedef struct {
  int nveces;
  char* texto;
} arg_t;

void* escribe (void* arg)
{
  // recuperamos los parámetros con una conversión de tipo
  arg_t* args = (arg_t*)arg; 
  for (int j=1;j<=args->nveces;j++) {
    printf("imprimo el texto: %s\n", args->texto);
  }
  return NULL;
}


int main() {
  pthread_t hilo;
  int ret;

  // preparamos unos parámetros
  // OJO - este código sólo compila con C99
  arg_t params = { .nveces=10, .texto="hola" };

  // llamamos al hilo con los parámetros que hemos definido
  ret=pthread_create(&hilo, NULL, escribe, &params);
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_create al crear el hilo: %s\n",errno,strerror(errno));
	exit(-1);
  } 

  void* dummy;
  ret=pthread_join(hilo,&dummy);
  if (ret) {
	errno=ret;
	fprintf(stderr,"Error %d pthread_join sobre hilo: %s\n",errno,strerror(errno));
	exit(-1);
  }
}
