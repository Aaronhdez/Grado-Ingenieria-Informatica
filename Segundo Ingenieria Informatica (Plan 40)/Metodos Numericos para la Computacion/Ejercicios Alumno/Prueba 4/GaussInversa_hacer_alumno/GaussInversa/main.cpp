/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A, A2,A_1,B;
  int N;

  // LEEMOS UN SISTEMA EJEMPLO DESDE DISCO
  N=mn_leer_matriz("../datos/A_gauss_1.txt",A);
  N=mn_leer_matriz("../datos/A_gauss_s.txt",A2);
  N=mn_leer_matriz("../datos/A_gauss_1i.txt",A_1);
  N=mn_leer_matriz("../datos/A_gauss_B.txt",B);

  printf("MATRIZ A\n");
   for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim1();j++){
      printf("%1.5lf ",A[i][j]);
    }
    printf("\n");
  }
  printf("\n");

  printf("RESULTADOS QUE SE DEBEN OBTENER \n\n");

  printf("Matriz triangular que sale del proceso de GAUSS\n ");
  for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim1();j++){
      printf("%1.5lf ",A2[i][j]);
    }
    printf("\n");
  }
  printf("\n");
  printf("Matriz B que sale del proceso de GAUSS\n ");
  for(int i=0;i<B.dim1();i++){
    for(int j=0;j<B.dim1();j++){
      printf("%1.5lf ",B[i][j]);
    }
    printf("\n");
  }
  printf("\n");

  printf("Matriz inversa de A\n ");
  for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim1();j++){
      printf("%1.5lf ",A_1[i][j]);
    }
    printf("\n");
  }
  printf("\n");


  printf("RESULTADOS ALUMNO \n\n");

  A_1=mn_gauss_inversa(A);
    printf("Matriz inversa de A\n ");
  for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim1();j++){
      printf("%1.5lf ",A_1[i][j]);
    }
    printf("\n");
  }
  printf("\n");

  printf("Resultado de multiplicar A y su inversa calculada por el alumno\n");
  Array2D< real > C=A*A_1;
  for(int i=0;i<C.dim1();i++){
    for(int j=0;j<C.dim1();j++){
      printf("%1.5lf ",C[i][j]);
    }
    printf("\n");
  }
  printf("\n");


  system("pause");
  return 0;
}



