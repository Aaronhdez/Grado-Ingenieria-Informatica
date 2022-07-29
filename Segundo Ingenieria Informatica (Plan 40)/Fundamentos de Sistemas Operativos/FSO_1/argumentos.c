#include <stdio.h>
#include <stdlib.h>

// Procedimiento que comprueba los argumentos
void ComprobarArgumentos(int argc, char **argv);

// Procedimiento que imprime los argumentos pasados por línea de órdenes
void ImprimeArgumentos(int argc, char **argv);

void ComprobarArgumentos(int argc, char **argv){

   if (argc!=3) {
      printf("Invocación incorrecta: ejecutable cadena1 cadena2\n");
      exit(-1);
   }
}

void ImprimeArgumentos(int argc, char **argv) {
int cont;

for(cont=0;cont<argc;cont++) 
  printf("%s\n", argv[cont]);

}
   
int main(int argc, char **argv)
{
  ComprobarArgumentos(argc,argv);
  ImprimeArgumentos(argc,argv);

  exit(0);
}

