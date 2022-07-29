/* errores.c: lista los n  primeros errores   */

#include <stdio.h>
#include <errno.h>
#include <string.h>


int main(int argc, char *argv[])
{
  int i;
  int n;
  if (argc < 2){
    fprintf(stdout,"Uso: %s numero_maximo_error\n", argv[0]); 
    return 1;
  }
  //  extern int errno;
  else {
    n = atoi(argv[1]);
    for (i=0;i<=n;i++) {
      fprintf(stderr,"%3d-> %s ---- ",i,strerror(i));
      errno = i;
      perror("Error ");
    }
    return 0;
  }
}
