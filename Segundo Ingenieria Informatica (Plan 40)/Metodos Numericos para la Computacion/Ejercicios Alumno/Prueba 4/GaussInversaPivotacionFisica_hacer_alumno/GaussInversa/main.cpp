/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A, A2,A_1,B,M,Mi;
  int N;

  /// LEEMOS EJEMPLO 1 DESDE DISCO
  N=mn_leer_matriz("../datos/M1.txt",M);
  N=mn_leer_matriz("../datos/Mi1.txt",Mi);
  N=mn_leer_matriz("../datos/B1.txt",B);
  N=mn_leer_matriz("../datos/A1.txt",A);

  M.print("Ejemplo 1. Matriz original");
  A.print("TRIANGULACION MATRIZ ORIGINAL (REAL)");
  B.print("MATRIZ DE TERMINOS INDEPENDIENTES (REAL)");
  Mi.print("MATRIZ INVERSA (REAL)");

  A_1=mn_gauss_inversa(M);

  /// LEEMOS EJEMPLO 2 DESDE DISCO
  N=mn_leer_matriz("../datos/M2.txt",M);
  M.print("Ejemplo 2. Matriz original (el algoritmo debe fallar)");

  A_1=mn_gauss_inversa(M);
  printf("Resultado alumno: \n");
  if(A_1.dim1()==0){
    printf("La matriz no es invertible\n\n");
  }

  /// LEEMOS EJEMPLO 3 DESDE DISCO
  N=mn_leer_matriz("../datos/M3.txt",M);
  M.print("Ejemplo 3. Matriz original (el algoritmo debe fallar)");
  mn_escribir_matriz("M.txt",M);

  A_1=mn_gauss_inversa(M);
  printf("Resultado alumno: \n");
  if(A_1.dim1()==0){
    printf("La matriz no es invertible\n");
  }

}



