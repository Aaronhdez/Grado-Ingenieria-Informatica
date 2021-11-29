/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A, A2;
  Array1D< real > b, b2,u,u2;
  int N;

  /// LEEMOS UN SISTEMA EJEMPLO DESDE DISCO
  N=mn_leer_matriz("../datos/A_gauss_1.txt",A);
  N=mn_leer_vector("../datos/b_gauss_1.txt",b);
  N=mn_leer_matriz("../datos/A_gauss_1s.txt",A2);
  N=mn_leer_vector("../datos/b_gauss_1s.txt",b2);
  N=mn_leer_vector("../datos/u_gauss_1s.txt",u2);

  A.print("EJEMPLO 1. MATRIZ A Y VECTOR b");
  b.print("b");

  A2.print("MATRIZ TRIANGULAR VECTOR b Y SOLUCION u (REAL)");
  b2.print("b");
  u2.print("u");

  u=mn_gauss(A,b);
  A.print("MATRIZ TRIANGULAR VECTOR b Y SOLUCION u (ALUMNO)");
  b.print("b");
  u.print("u");

  printf("PASAMOS AL SIGUIENTE EJEMPLO\n");
  system("pause");
  N=mn_leer_matriz("../datos/A_gauss_2.txt",A);
  N=mn_leer_vector("../datos/b_gauss_2.txt",b);
  N=mn_leer_matriz("../datos/A_gauss_2s.txt",A2);
  N=mn_leer_vector("../datos/b_gauss_2s.txt",b2);
  N=mn_leer_vector("../datos/u_gauss_2s.txt",u2);
  A.print("EJEMPLO 2. MATRIZ A Y VECTOR b");
  b.print("b");

  A2.print("MATRIZ TRIANGULAR VECTOR b Y SOLUCION u (REAL)");
  b2.print("b");
  u2.print("u");

  u=mn_gauss(A,b);
  A.print("MATRIZ TRIANGULAR VECTOR b Y SOLUCION u (ALUMNO)");
  b.print("b");
  u.print("u");

  printf("PASAMOS AL SIGUIENTE EJEMPLO\n");
  system("pause");
  A=Array2D<real>(3,3,1.);
  A.print("EJEMPLO 3. MATRIZ A Y VECTOR b (DEBE DAR QUE NO TIENE SOLUCION)");
  b.print("b");
  u=mn_gauss(A,b);
  if(u.dim()==0) printf("EL SISTEMA NO TIENE SOLUCION (ALUMNO)\n");
  else{
    printf("EL SISTEMA TIENE SOLUCION (ALUMNO)\n");
    u.print("u");
  }


  return 0;
}



