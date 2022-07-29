#include <errno.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int Abrir(char *ptr);


int Abrir(char *ptr)
{
   int fd;

   fd=open(ptr,O_RDONLY);
   if (fd==-1) {
      perror("Error en la apertura del fichero\n");
      return -1;
   }
   else return fd;
}

main() {

char nombrefichero[]="/bin/lssss";
int fd;

   fd=Abrir(nombrefichero);

   if (fd != -1) {
      printf("Todo bien: cerramos el fichero\n");
      close(fd);
   }
}
