/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_factorizacion.h"
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A,L,U;
  Array1D< real > b, b2,u;
  int N;

  /// LEEMOS UN SISTEMA EJEMPLO DESDE DISCO
  N=mn_leer_matriz("../datos/A_LU_1.txt",A);
  N=mn_leer_vector("../datos/b_LU_1.txt",b);
  N=mn_leer_matriz("../datos/L_1.txt",L);
  N=mn_leer_matriz("../datos/U_1.txt",U);
  N=mn_leer_vector("../datos/u_sol_1.txt",u);
  A.print("EJEMPLO 1: matriz A");

  printf("VECTOR TERMINOS INDEPENDIENTES\n");
  b.print("b");

  printf("\nRESULTADOS DE LA FACTORIZACION\n");
  L.print("MATRIZ L (REAL)");
  U.print("MATRIZ U (REAL)");

  L=Array2D< real >(L.dim1(),L.dim2(),0.);
  U=Array2D< real >(L.dim1(),L.dim2(),0.);

  mn_LU_factorization(A,L,U);
  L.print("MATRIZ L (ALUMNO)");
  U.print("MATRIZ U (ALUMNO)");

  printf("SOLUCION DEL SISTEMA (REAL)\n");
  u.print("u");

  printf("\nSOLUCION DEL SISTEMA (ALUMNO)\n");
  u=mn_LU(A,b);
  u.print("u");

  printf("\nSIGUIENTE EJEMPLO\n");
  system("pause");

  N=mn_leer_matriz("../datos/A_LU_2.txt",A);
  A.print("EJEMPLO 2: matriz A (LA FACTORIZACION DEBE FALLAR)");

  N=mn_LU_factorization(A,L,U);
  if(N==0) L.print("\nMATRIZ L (ALUMNO)");
  else{
    printf("LA FACTORIZACION HA FALLADO (ALUMNO)\n");
  }
}


