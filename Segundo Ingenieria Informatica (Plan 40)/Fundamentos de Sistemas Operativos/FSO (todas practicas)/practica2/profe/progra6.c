#include <stdio.h>


int main()
{
  
  int i,tamano;
  int *puntero;  // Declaracion. Puntero a Enteros

  printf("Introduzca el tamaño del bucle :");
  scanf("%d",&tamano);
  
  puntero = &tamano;  // Asignacion

  *puntero+=2; //Desreferencia
  *puntero*=2;

 //4  puntero ++; //  O J O  

   
  for (i=1;i<=*puntero;i++) {
    printf ("i vale %5d , %10x\n",i,i);
  }
   
}

