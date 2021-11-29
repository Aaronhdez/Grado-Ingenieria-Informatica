/* Funciones para la resolución de un sistema no-lineal por el método de Newton-Raphson*/

#include "integracion.h"
#include <stdlib.h>
#include <stdio.h>



/** Función que devuelve  la integral de la función exp(-x*x-y*y) en el cuadrado
   [-10,10]x[-10,10] usando el método del trapecio

    El alumno debe elegir todos los parámetros del método para que el resultado final sea
    parecido al que se propone. Se tendrá en cuenta en la calificación realizar el menor
    número posible de operaciones.
*/
real integracion(){
  real integral=0.;
  int Nx=30;
  int Ny=30;
  real dx=20./Nx;
  real dy=20./Ny;
  for(int i=0;i<Nx;i++){
    real x0=-10.+dx*i;
    real x1=x0+dx;
    for(int j=0;j<Ny;j++){
      real y0=-10.+dy*j;
      real y1=y0+dy;
      integral+=(exp(-x0*x0-y0*y0)+exp(-x0*x0-y1*y1)+exp(-x1*x1-y0*y0)+exp(-x1*x1-y1*y1));
    }
  }

  return integral/4.*dx*dy;
}

