#include <stdio.h>


int main()
{
  
  int i,tamano;

  printf("Introduzca el tamaño del bucle :");
  scanf("%d",&tamano);
  
  for (i=1;i<=tamano;i++) {
    printf ("i vale %d , %x\n",i,i);
  }
   
}

