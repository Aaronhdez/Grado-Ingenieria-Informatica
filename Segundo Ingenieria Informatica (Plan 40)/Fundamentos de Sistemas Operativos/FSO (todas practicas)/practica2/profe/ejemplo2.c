#include <stdio.h>
#include <math.h>
#include <stdlib.h>

main()
{ // Rellenar un vector de enteros

  int* ptr; int vec[30];
  for (ptr=vec; ptr<vec+30; ptr++)
    *ptr = 0;

  // Copiar dos vectores

  int *p, *q; int a[30], b[30]; int k;
  printf("Tamano de un puntero: %d, %d\n\n",sizeof(ptr),sizeof(p));
  printf("Contenido del vector b:\n");
  for (k=0; k<30; k++) {
    b[k]=1+(int) (10.0*rand()/(RAND_MAX+1.0));
    printf("%d, ",b[k]);
   }
  // Ahora copiamos

  for ( p=a,q=b; p<a+30; )
    *(p++) = *(q++);

  // y vemos
  printf("\nContenido del vector a:\n");
  for (k=0; k<30; k++) 
    printf("%d, ",a[k]);

}

