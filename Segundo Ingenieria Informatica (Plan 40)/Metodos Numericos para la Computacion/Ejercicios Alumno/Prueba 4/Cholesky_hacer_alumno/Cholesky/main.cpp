/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_cholesky.h"
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A,B;
  Array1D< real > b,b2,u;

  int N=mn_leer_matriz("../datos/A_cholesky_1.txt",A);
  N=mn_leer_vector("../datos/b_cholesky_1.txt",b);
  N=mn_leer_vector("../datos/u_cholesky_1.txt",u);
  N=mn_leer_matriz("../datos/B_cholesky_1.txt",B);

  A.print("EJEMPLO 1: matriz A");

  printf("VECTOR TERMINOS INDEPENDIENTES\n");
  b.print("b");
  B.print("\nFACTORIZACION DE LA MATRIZ (REAL)");

  printf("SOLUCION DEL SISTEMA (REAL)\n");
  u.print("u");

  printf("\nDETERMINANTE (REAL) : %e\n",36.);


  B=mn_cholesky_factorization(A);
  B.print("\nFACTORIZACION DE LA MATRIZ (ALUMNO)");

  u=mn_cholesky(A,b);
  printf("SOLUCION DEL SISTEMA (ALUMNO)\n");
  u.print("u");

  printf("\nDETERMINANTE (ALUMNO) : %e\n",(double) mn_determinante_factorizacion_cholesky(A));
  printf ("----------------------------------------------\n");

  printf("\nSIGUIENTE EJEMPLO\n");
  system("pause");

  N=mn_leer_matriz("../datos/A_10.txt",A);
  N=mn_leer_matriz("../datos/B_10.txt",B);

  A.print("EJEMPLO 2: matriz A");
  B.print("\nFACTORIZACION DE LA MATRIZ (REAL)");

  printf("\nDETERMINANTE (REAL) : %e\n",2.200000e+008);


  B=mn_cholesky_factorization(A);
  B.print("\nFACTORIZACION DE LA MATRIZ (ALUMNO)");

  printf("\nDETERMINANTE (ALUMNO) : %e\n",(double) mn_determinante_factorizacion_cholesky(A));
  printf ("----------------------------------------------\n");

  printf("\nSIGUIENTE EJEMPLO\n");
  system("pause");

  N=mn_leer_matriz("../datos/A_cholesky_2.txt",A);
  A.print("EJEMPLO 3: matriz A (LA FACTORIZACION DEBE FALLAR)");


  B=mn_cholesky_factorization(A);
  B.print("\nFACTORIZACION DE LA MATRIZ (ALUMNO)");
  if(B.dim1()==0){
    printf("LA FACTORIZACION HA FALLADO\n");
  }
}


