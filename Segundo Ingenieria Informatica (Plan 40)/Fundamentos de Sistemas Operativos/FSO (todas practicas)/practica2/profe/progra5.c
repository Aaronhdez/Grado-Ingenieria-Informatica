#include <stdio.h>
#include <stdlib.h>


#define VLENGTH 10


int x;
float v[VLENGTH];

void procedimiento_duplica (int x)
{
  x = 2*x;
}

int funcion_duplica (int x) {
  return 2*x;
}

void rellena_vector_float (float valor) {
  //Rellena un vector con el valor pasado
  for (x=0;x<VLENGTH;x++) {
    v[x] = valor;
  }
}

void imprime_vector () {
  // Imprime el contenido del vector v
  for (x=0;x<VLENGTH;x++) {
    printf("x vale %04X   ", x);
    printf ( "v[%d] = %010.2f\n", x, v[x] );
  }
}



int main()
{
  int mi_variable = 3;

  printf("la variable vale %d\n",mi_variable);
  procedimiento_duplica(mi_variable);
  printf("la variable vale %d\n",mi_variable);

  rellena_vector_float(123.45);
  imprime_vector();
  

}

