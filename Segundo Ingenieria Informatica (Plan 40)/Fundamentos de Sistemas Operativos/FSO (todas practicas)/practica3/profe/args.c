#include <stdio.h>
int main(int argc, char *argv[]){
  int i;
  for (i=0;i<argc;i++)
     printf("arg[%d] es <%s>\n",i,argv[i]);
}
