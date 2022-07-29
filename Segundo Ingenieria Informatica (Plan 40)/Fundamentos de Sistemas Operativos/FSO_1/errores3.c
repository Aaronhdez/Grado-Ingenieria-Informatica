#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

int main() {
int cont;

for(cont=0;cont<=53;cont++) {
  printf("%d",cont);
  fflush(NULL);
  errno=cont;
  perror(" ");
}

}

