/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_determinante.h"
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A,Ap;

  /// LEEMOS MATRIZ DESDE DISCO
  int N=mn_leer_matriz("../datos/A_3.txt",A);
  N=mn_leer_matriz("../datos/A_3p.txt",Ap);
  A.print("EJEMPLO 1.");

  Ap.print("TRIANGULACION MATRIZ ORIGINAL (REAL)");

  real determinante=mn_determinante_Gauss(A);
  printf("El determinante que debe salir es : %lf\n",36.);
  printf("El determinante (alumno)          : %f\n\n",determinante);

  system("pause");

  N=mn_leer_matriz("../datos/A_3t.txt",A);
  N=mn_leer_matriz("../datos/A_3p.txt",Ap);
  A.print("EJEMPLO 2.");

  Ap.print("TRIANGULACION MATRIZ ORIGINAL (REAL)");

  determinante=mn_determinante_Gauss(A);
  printf("El determinante que debe salir es : %lf\n",-36.);
  printf("El determinante (alumno)          : %f\n\n",determinante);

  system("pause");

  N=mn_leer_matriz("../datos/A_10.txt",A);
  N=mn_leer_matriz("../datos/A_10p.txt",Ap);
  A.print("EJEMPLO 3.");

  Ap.print("TRIANGULACION MATRIZ ORIGINAL (REAL)");

  determinante=mn_determinante_Gauss(A);
  printf("El determinante que debe salir es : %e\n",2.2e+8);
  printf("El determinante (alumno)          : %e\n\n",determinante);

}


