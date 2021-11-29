/* Procedimiento de prueba para el  uso del método de Gauss-Seidel  */
#include <stdio.h>
#include "../mn_gauss_seidel.h"
#include "../mn_lapack.h"
#include <stdlib.h>

int main()
{
  Array2D< real > A;
  Array1D< real > b, b2;
  int i,N,iter,nMax=100000;
  real TOL=1e-8;

  printf("EJEMPLO DE SISTEMA 1 \n");
  // LEEMOS MATRIZ Y VECTOR DESDE DISCO
  N=mn_leer_matriz("../datos/A_cholesky_1.txt",A);
  N=mn_leer_vector("../datos/b_cholesky_1.txt",b);
  printf("LA MATRIZ DEL SISTEMA ES: \n");
  A.print("A");
  printf("EL VECTOR DE TERMINOS INDEPENDIENTES ES: \n");
  b.print("b"); 
  printf("RESOLVEMOS POR GAUSS-SEIDEL \n");
  Array1D< real > u(b.dim(),0.);
  iter=mn_gauss_seidel(A,b,u,nMax,TOL);
  if (iter>0){
    real error=mn_error_sistema(A,u,b);
    printf("LA SOLUCION POR EL METODO DE GAUSS-SEIDEL ES: \n");
    u.print("u"); 
    printf ("Gauss-Seidel : El error al resolver el sistema es: %e\n\n",(double) error);
    printf("el numero de iteraciones realizado es : %d\n",iter);
  }
  else{
    printf("FALLO EN EL METODO DE GAUSS-SEIDEL\n");
  }
  system("pause");
  
  printf("EJEMPLO DE SISTEMA DIMENSION 10 \n");
  // LEEMOS MATRIZ Y VECTOR DESDE DISCO
  N=mn_leer_matriz("../datos/A_10.txt",A);
  N=mn_leer_vector("../datos/b_10.txt",b);
  printf("LA MATRIZ DEL SISTEMA ES: \n");
  A.print("A");
  printf("EL VECTOR DE TERMINOS INDEPENDIENTES ES: \n");
  b.print("b"); 
  printf("RESOLVEMOS POR GAUSS-SEIDEL \n");
  Array1D< real > v(b.dim(),0.);
  iter=mn_gauss_seidel(A,b,v,nMax,TOL);
  if (iter>0){
    real error=mn_error_sistema(A,v,b);
    printf("LA SOLUCION POR EL METODO DE GAUSS-SEIDEL ES: \n");
    v.print("u"); 
    printf ("Gauss-Seidel : El error al resolver el sistema es: %e\n\n",(double) error);
    printf("el numero de iteraciones realizado es : %d\n",iter);
  }
  else{
    printf("FALLO EN EL METODO DE GAUSS-SEIDEL \n");
  }
  system("pause");
  
  printf("\nEJEMPLO DE SISTEMA DE DIMENSION 100 \n");
  // LEEMOS MATRIZ Y VECTOR DESDE DISCO
  N=mn_leer_matriz("../datos/A_100.txt",A);
  N=mn_leer_vector("../datos/b_100.txt",b);
  //printf("LA MATRIZ DEL SISTEMA ES: \n");
  //A.print("A");
  //printf("EL VECTOR DE TERMINOS INDEPENDIENTES ES: \n");
  //b.print("b"); 
  printf("RESOLVEMOS POR GAUSS-SEIDEL \n");
  Array1D< real > w(b.dim(),0.);
  iter=mn_gauss_seidel(A,b,w,nMax,TOL);
  if (iter>0){
    real error=mn_error_sistema(A,w,b);
    printf("LA SOLUCION POR EL METODO DE GAUSS-SEIDEL ES: \n");
    w.print("u"); 
    printf ("Gauss-Seidel : El error al resolver el sistema es: %e\n\n",(double) error);
    printf("el numero de iteraciones realizado es : %d\n",iter);
  }
  else{
    printf("FALLO EN EL METODO DE GAUSS-SEIDEL \n");
  }
  system("pause");

  
  return 0;
}


