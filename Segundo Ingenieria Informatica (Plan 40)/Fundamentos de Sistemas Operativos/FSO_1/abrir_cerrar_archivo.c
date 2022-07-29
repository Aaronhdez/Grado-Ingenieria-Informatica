#include <sys/types.h>
#include <sys/stat.h>
#include <errno.h>
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>

int AbrirArchivo(char *nombre);
void CerrarArchivo(int fd);
void ComprobarArgumentos(int argc, char **argv);

int AbrirArchivo(char *nombre) {
int fd;

   if ((fd=open(nombre,O_RDWR))==-1) {
      fprintf(stderr,"error %d: %s\n",errno,strerror(errno));
      return -1;
   }
   return fd;
}

void CerrarArchivo(int fd) {
   if (close(fd)==-1) {
      fprintf(stderr,"error %d: %s\n",errno,strerror(errno));;
      exit(-1);
   }
}

void ComprobarArgumentos(int argc, char **argv){

   if (argc!=2) {
      fprintf(stderr,"Invocación incorrecta: abrir_cerrar_archivo nombrefichero\n");
      exit(-1);
   }
}
   
int main(int argc, char **argv)
{
int fd;

   ComprobarArgumentos(argc,argv);
   fd=AbrirArchivo(argv[1]);
   if (fd!=-1) {
     printf("Todo bien: cerramos el fichero\n");
     CerrarArchivo(fd);
   }
   exit(0);
}
