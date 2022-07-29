// Ejemplo sencillo de dos hilos que se ejecutan de forma concurrente.
// Compilar con la biblioteca pthreads. Ejemplo:
// 	gcc prueba_hilos.c -o hilos -lpthread
//

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

  rutina1(NULL);
  rutina2(NULL);

  exit(0);
}








