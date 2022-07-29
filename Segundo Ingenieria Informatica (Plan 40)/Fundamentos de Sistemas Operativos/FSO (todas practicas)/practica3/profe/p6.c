// Este programa es la version final, en la que intenta abrir todos los
// archivos que se le pasan por la linea de ordenes, y va indicando que 
// ha ocurrido en el proceso

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>

#define MAX 80

extern FILE *stdin;
extern FILE *stdout;
extern FILE *stderr;




char *nombre="/bin/ls";
char *nombre1="/var/log/messages";
char *nomb="less.11";

 
int Abrir(char *nombre)
{
  int resul;
   resul = open(nombre, O_RDONLY);
  return resul;

}



int main(int argc, char *argv[])

{
  int resp, final,i;
  char *fichero;
  char *nombres[50];
  char buffer[200];

  if (argc == 1) {
	       printf("\nEs necesario entrar al menos un archivo a abrir\n");
               printf("Uso: %s \"archivo1\" \"archivo2\" \"archivo3\" \"archivo4\" ...\n\n",argv[0]);
               exit(-1);}
  else {
    for (i=1; i<argc; i++) {
      resp = Abrir(argv[i]);
      if (resp >= 3) {
	printf("Archivo %s: se ha podido abrir correctamente, ident = %d\n",argv[i],resp);
      }
      else {
	fprintf(stderr,"Archivo %s: no se ha podido abrir, error = %d\n",argv[i],errno);
	perror("error: ");
	  }
      final = close(resp);
    }

  //  fprintf(stderr, "%s: error %d: %s\n", nombre, errno, strerror(errno));
   
  //  printf("%d\n",ERRNO);


    //  final = close(resp);

  }
  exit(0);
}
