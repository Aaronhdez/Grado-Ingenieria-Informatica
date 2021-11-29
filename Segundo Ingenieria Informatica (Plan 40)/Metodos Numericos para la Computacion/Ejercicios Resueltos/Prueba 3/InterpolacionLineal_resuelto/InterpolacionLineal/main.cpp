/*==========================================================================
       PRACTICA 3 METODOS NUMERICOS. INTERPOLACION
  ==========================================================================*/

// INCLUSION DE LA LIBRERIA STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "../mn_aritmeticas.h"
#include "../mn_interpolacion.h"

main()
{

   printf("INTERPOLACION LINEAL\n\n");

   Array1D<real> x(3),f(3);

   x[0]=1.; x[1]=2.; x[2]=4.;
   f[0]=3.; f[1]=1.; f[2]=2.;

   printf("PUNTOS DE INTERPOLACION Y VALORES DE LA FUNCION \n");
   for(int k=0;k<x.dim();k++)
      printf("x[%d]=%lf ",k,x[k]);
    printf("\n");
    for(int k=0;k<f.dim();k++)
      printf("f[%d]=%lf ",k,f[k]);
    printf("\n\n");

    printf("RESULTADO DE LA INTERPOLACION EN ALGUNOS PUNTOS:\n");
    real x0=0.;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,5.,interpolacion_lineal(x,f,x0));
    x0=1.;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,3.,interpolacion_lineal(x,f,x0));
    x0=1.5;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,2.,interpolacion_lineal(x,f,x0));
    x0=2.;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,1.,interpolacion_lineal(x,f,x0));
    x0=2.7;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,1.35,interpolacion_lineal(x,f,x0));
    x0=4.;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,2.,interpolacion_lineal(x,f,x0));
    x0=5.;
    printf("x0=%lf, valor interpolado (real) =%lf, valor interpolado (alumno) =%lf\n",
           x0,2.5,interpolacion_lineal(x,f,x0));

}



