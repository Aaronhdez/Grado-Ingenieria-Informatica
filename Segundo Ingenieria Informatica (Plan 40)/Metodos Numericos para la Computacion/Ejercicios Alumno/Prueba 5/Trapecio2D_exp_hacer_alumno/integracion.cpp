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
  /// HACER ALUMNO
  /// Hay que tener en cuneta que el numero de intervalos SI o SI es 20, luego el truco del ejecicio
  /// Está en cuanto dividimos el incremento para verificar que se ajuste al valor.
  /// Las pruebas demuestran que la aproximación mímima es de 26
  /// Secumple la norma de
  real integral = 0;
  int N = 26;
  int M = 26;
  real dx = 20./N;
  real dy = 20./M;

  ///Iteramos según el método del trapecio
  for(int i=0; i<N; i++){
    real x0 = -10.+dx*i;
    real x1 = x0+dx;
    for(int j=0; j<M; j++){
        real y0 = -10.+dy*j;
        real y1 = y0+dy;
        integral += exp(-x0*x0-y0*y0)+exp(-x1*x1-y0*y0)+exp(-x0*x0-y1*y1)+exp(-x1*x1-y1*y1);
    }
  }
  return integral/4*dx*dy;
}

