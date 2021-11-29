/* Procedimiento de prueba para el  uso del método de Gauss-Seidel  */
#include <stdio.h>
#include "../mn_relajacion.h"
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A;
  Array1D< real > b, b2;
  int i,N,iter,nMax=100000;
  real TOL=1e-8;
  real wr=1.2;

  printf("EJEMPLO DE SISTEMA 1 \n");
  // LEEMOS MATRIZ Y VECTOR DESDE DISCO
  N=mn_leer_matriz("../datos/A_cholesky_1.txt",A);
  N=mn_leer_vector("../datos/b_cholesky_1.txt",b);
  printf("LA MATRIZ DEL SISTEMA ES: \n");
  A.print("A");
  printf("EL VECTOR DE TERMINOS INDEPENDIENTES ES: \n");
  b.print("b");
  printf("RESOLVEMOS POR EL METODO DE RELAJACION \n");
  printf("El valor del parametro de relajacion es %lf \n\n",wr);
  Array1D< real > u(b.dim(),1.);
  printf("LA SOLUCION POR EL METODO DE RELAJACION (real) ES: \n");
  u.print("u");
  u=0;
  iter=mn_relajacion(A,b,u,nMax,TOL,wr);
  if (iter>0){

    real error=mn_error_sistema(A,u,b);
    printf("LA SOLUCION POR EL METODO DE RELAJACION (alumno) ES: \n");
    u.print("u");
    printf ("Relajacion : El error al resolver el sistema (real) es: %e\n",(double) 1.133109e-9);
    printf ("Relajacion : El error al resolver el sistema (alumno) es: %e\n\n",(double) error);
    printf("el numero de iteraciones realizado (real) es : %d\n",23);
    printf("el numero de iteraciones realizado (alumno) es : %d\n",iter);
  }
  else{
    printf("FALLO EN EL METODO DE RELAJACION\n");
  }
  system("pause");

  printf("EJEMPLO DE SISTEMA DIMENSION 10 \n");
  wr=1.3;
  // LEEMOS MATRIZ Y VECTOR DESDE DISCO
  N=mn_leer_matriz("../datos/A_10.txt",A);
  N=mn_leer_vector("../datos/b_10.txt",b);
  u = Array1D< real > (b.dim(),1.);
  printf("LA MATRIZ DEL SISTEMA ES: \n");
  A.print("A");
  printf("EL VECTOR DE TERMINOS INDEPENDIENTES ES: \n");
  b.print("b");
  printf("RESOLVEMOS POR EL METODO DE RELAJACION \n");
  printf("El valor del parametro de relajacion es %lf \n\n",wr);
  u=1.;
  printf("LA SOLUCION POR EL METODO DE RELAJACION (real) ES: \n");
  u.print("u");
  u=0;
  iter=mn_relajacion(A,b,u,nMax,TOL,wr);
  if (iter>0){

    real error=mn_error_sistema(A,u,b);
    printf("LA SOLUCION POR EL METODO DE RELAJACION (alumno) ES: \n");
    u.print("u");
    printf ("Relajacion : El error al resolver el sistema (real) es: %e\n",(double) 4.740668e-8);
    printf ("Relajacion : El error al resolver el sistema (alumno) es: %e\n\n",(double) error);
    printf("el numero de iteraciones realizado (real) es : %d\n",199);
    printf("el numero de iteraciones realizado (alumno) es : %d\n",iter);
  }
  else{
    printf("FALLO EN EL METODO DE RELAJACION\n");
  }
  system("pause");


  return 0;
}


