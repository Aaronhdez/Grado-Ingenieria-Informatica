#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

int main() {
int *asientos;

asientos=(int*)malloc(-100*sizeof(int));
if (asientos==NULL) {
  //Error en el malloc
  perror("Error en el malloc");
}
}

