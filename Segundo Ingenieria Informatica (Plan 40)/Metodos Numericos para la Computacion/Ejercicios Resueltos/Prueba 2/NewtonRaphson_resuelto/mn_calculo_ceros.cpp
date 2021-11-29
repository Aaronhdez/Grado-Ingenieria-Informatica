#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"



// FUNCION QUE IMPLEMENTA EL METODO DE NEWTON-RAPHSON CONOCIENDO LA FUNCION DERIVADA
// LA FUNCIÓN DEVUELVE EL NÚMERO DE ITERACIONES REALIZADAS SI TERMINA BIEN Y DEVUELVE -1
// EN CASO CONTRARIO
int mn_newton_raphson (
real (*f)( real), /// funcion sobre la que se calcula el cero
real (*fp)( real), /// funcion derivada
real &x0, /// raíz inicial que actualiza la función
int NiterMax, /// número de iteraciones máximo
real TOL) /// tolerancia para para el algoritmo
{
  // HACER ALUMNO
  real f_x0=f(x0); // evaluacion de la funcion
  for(int i=0;i<NiterMax;i++){
    //printf("x0=%lf\n",x0);
    if(f_x0==0.){return(i);} // test de salida por el valor de la funcion
    real derivada=fp(x0); // calculo de la derivada
    //printf("x0=%e derivada=%e\n",(double) x0, (double) derivada);
    if(derivada==0.) return(-1);  // test de salida por el valor de la derivada
    real x1=x0-f_x0/derivada; // calculo nuevo valor raiz
    f_x0=f(x1);  // calculo de la función en el nuevo valor
    if(mn_distancia(x1,x0)<TOL){  // test de salida por proximidad de raices
      x0=x1;
      return(i+1);
    }
    x0=x1;  // actualizacion raiz
  }
  return(-1); // salida si se ha superado el numero de iteraciones maximo
}



