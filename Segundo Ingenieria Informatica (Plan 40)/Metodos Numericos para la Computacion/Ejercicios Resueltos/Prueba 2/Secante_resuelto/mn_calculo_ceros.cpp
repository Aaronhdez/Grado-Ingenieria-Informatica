#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"


// FUNCION QUE IMPLEMENTA EL METODO DE LA SECANTE
// LA FUNCI�N DEVUELVE EL N�MERO DE ITERACIONES REALIZADAS SI TERMINA BIEN Y DEVUELVE -1
// EN CASO CONTRARIO
int mn_secante (
real (*f)( real), /// funcion sobre la que se calcula el cero
real &x0, /// primera aproximaci�n ra�z que actualiza la funci�n
real &x1, /// segunda aproximaci�n ra�z que actualiza la funci�n
int NiterMax, /// n�mero de iteraciones m�ximo
real TOL) /// tolerancia para para el algoritmo
{
  // HACER ALUMNO
  real f_x0=f(x0); // evaluacion de la funcion
  real f_x1=f(x1); // evaluacion de la funcion
  for(int i=0;i<NiterMax;i++){
    //printf("x0=%lf\n",x0);
    if(f_x1==0.){return(i);} // test de salida por el valor de la funcion
    real h=x1-x0;
    if(h==0.) return(-1);
    real derivada=(f_x1-f_x0)/h;
    //printf("root_1=%e derivada=%e\n",(double) root_1, (double) derivada);
    if(derivada==0.) return(-2);
    real x2=x1-f_x1/derivada; // calculo nuevo valor raiz
    x0=x1;
    x1=x2;
    f_x0=f_x1;
    f_x1=f(x1);  // calculo de la funci�n en el nuevo valor
    if(mn_distancia(x1,x0)<TOL){  // test de salida por proximidad de raices
      return(i+1);
    }
  }
  return(-2); // salida si se ha superado el numero de iteraciones maximo
}




