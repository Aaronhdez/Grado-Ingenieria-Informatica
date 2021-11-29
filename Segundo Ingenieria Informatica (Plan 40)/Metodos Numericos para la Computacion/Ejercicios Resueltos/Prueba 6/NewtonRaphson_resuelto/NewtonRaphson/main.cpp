/* Procedimiento de prueba para el  uso del método de Cholesky  */
#include <stdio.h>
#include "../mn_sistemas_no_lineales.h"
#include "../mn_lapack.h"
#include <stdlib.h>

Array1D< real > f1(Array1D< real > u){
  Array1D< real > f(u.dim()); // declaración del vector que define la función
  // definición de la función
  f[0]=1.*u[0]+2.*u[1]-5.;
  f[1]=3.*u[0]+4.*u[1]-11.;
  return(f);
}

Array1D< real > f2(Array1D< real > u){
  Array1D< real > f(u.dim()); // declaración del vector que define la función
  // definición de la función
  f[0]=u[0]*u[0]+u[1]*u[1]-1.;
  f[1]=u[0]-u[1];
  return(f);
}

Array1D< real > f3(Array1D< real > u){
  Array1D< real > f(u.dim()); // declaración del vector que define la función
  // definición de la función
  f[0]=u[0]*u[0]+u[1]*u[1]-1.;
  f[1]=u[0]*u[0]+0.8*u[1]*u[1]-2.;
  return(f);
}


int main()
{
  real TOL=1e-5;
  int Nmax=1000;
  double h=1e-8;

  /// EJEMPLO 1
  printf("EJEMPLO 1 : F(x,y)=(x+2y-5,3x+4y-11) \n");
  printf("APROXIMACION INICIAL u0=(1,1) \n");
  {
    Array2D<real> derivada(2,2);
    Array1D<real> u(2,1.);
    derivada[0][0]=1; derivada[0][1]=2;
    derivada[1][0]=3; derivada[1][1]=4;
    printf("matriz derivada inicial (real) \n");
    derivada.print("D");
    printf("matriz derivada inicial (alumno) \n");
    derivada=matriz_derivada(f1,u);
    derivada.print("D");

    printf("solucion real u=(1.,2.) \n");
    u[0]=1; u[1]=1;
    int iter = mn_newton_raphson_sistemas(f1, u,TOL,Nmax);
    printf("N. iteraciones alumno =%d\n",iter);
    printf("solucion alumno u=(%lf,%lf) \n",u[0],u[1]);

    printf("PULSE UNA TECLA PARA VER EL SIGUIENTE EJEMPLO\n");
    system("pause");
  }

  /// EJEMPLO 2
  printf("\n\nEJEMPLO 2 : F(x,y)=(x*x+y*y-1,x-y)\n");
  printf("APROXIMACION INICIAL u0=(1,1) \n");
  {
    Array2D<real> derivada(2,2);
    Array1D<real> u(2,1.);
    derivada[0][0]=2; derivada[0][1]=2;
    derivada[1][0]=1; derivada[1][1]=-1;
    printf("matriz derivada inicial (real) \n");
    derivada.print("D");
    printf("matriz derivada inicial (alumno) \n");
    derivada=matriz_derivada(f2,u);
    derivada.print("D");

    printf("solucion real u=(0.707108,0.707108) \n");
    u[0]=1; u[1]=1;
    int iter = mn_newton_raphson_sistemas(f2, u,TOL,Nmax);
    printf("N. iteraciones alumno =%d\n",iter);
    printf("solucion alumno u=(%lf,%lf) \n",u[0],u[1]);

    printf("PULSE UNA TECLA PARA VER EL SIGUIENTE EJEMPLO\n");
    system("pause");
  }

  // EJEMPLO 3
  printf("\n\nEJEMPLO 3 F(x,y)=(x*x+y*y-1,x*x+0.8*y*y-2) \n\n");
  {
    printf("RESULTADOS CORRECTOS\n");
    printf("El metodo debe dar al final que el sistema no tiene solucion\n");

    // CALCULAMOS UN CERO DEL SISTEMA
    Array1D< real > u(2,1.);
    int iter = mn_newton_raphson_sistemas(f3, u,TOL,Nmax);
    printf("N. iteraciones alumno =%d\n",iter);

  }



  return 0;
}


