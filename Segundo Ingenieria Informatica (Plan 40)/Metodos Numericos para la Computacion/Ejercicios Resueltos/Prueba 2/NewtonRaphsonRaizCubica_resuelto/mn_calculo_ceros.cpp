#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

///* ALGORITMO PARA CALCULAR LA RAIZ CUBICA DE UN NÚMERO A BUSCANDO LA RAIZ DE LA
///FUNCION  X*X*X-A=0  UTILIZANDO EL METODO DE NEWTON-RAPSHON CON UNA TOLERANCIA PARA LA
///CONVERGENCIA DE TOL Y UN NUMERO MAXIMO DE ITERACIONES Nmax. EL VALOR INICIAL DE LA RAIZ
///ES EL PARAMETRO x QUE ES TAMBIEN LA VARIABLE DONDE SE DEVUELVE LA RAIZ FINAL.
///EL ALGORITMO DEVUELVE EL  NUMERO DE ITERACIONES NECESARIO PARA CONVERGER Y SI
///TERMINA MAL SE DEVUELVE -1
///*/

int mn_raiz_cubica_newton(real A,real &x,int Nmax,real TOL){

  real fx=x*x*x-A; /// evaluacion de la funcion
  for(int i=0;i<Nmax;i++){
    if( fx==0.){return(i);} /// test de salida por el valor de la funcion
    real derivada=3*x*x; /// calculo de la derivada
    if(derivada==0.) return(-1);  /// test de salida por el valor de la derivada
    real x2=x-fx/derivada; /// calculo nuevo valor raiz
    fx=x2*x2*x2-A;  /// calculo de la función en el nuevo valor
    if( mn_abs(x-x2)<TOL*(mn_abs(x)+1) ){  /// test de salida por proximidad de raices
      x=x2;
      return(i);
    }
    x=x2;  /// actualizacion raiz
  }
  return(-1); /// salida si se ha superado el numero de iteraciones maximo

}

