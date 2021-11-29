#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

// FUNCION QUE IMPLEMENTA EL METODO DE LA REGULA FALSI  Y DEVUELVE LA RAIZ
real mn_regula_falsi (
real (*f)( real), // función a la cual se calcula un cero
real &a, real &b, // intervalo inicial para buscar la raíz
real TOL,  // tolerancia para parar las iteraciones del algoritmo
int NiterMax, // número máximo de iteraciones permitidas
int &error) // código de salida de error :
            //       Si error=0 la función ha terminado bien
            //       Si error=-1 la función ha terminado mal
{
  // HACER ALUMNO
  real f_a=f(a);
  real f_b=f(b);
  if(f_a*f_b>0){
    error=-1;
    return(-1.);
  }
  real x=a-(b-a)*f(a)/(f(b)-f(a));
  real f_x=f(x);
  int iter=0;
  while( mn_distancia(a,b) >= TOL ){
    if(f_x==0.){
      error=0;
      return x;
    }
    if(iter++>=NiterMax){
      error=-2;
      return(-1.);
    }
    if(f_a*f_x < 0.){
      b=x;
      f_b=f_x;
    }
    else{
      a=x;
      f_a=f_x;
    }

    real xn=a-(b-a)*f(a)/(f(b)-f(a));
    if(mn_distancia(x,xn)<=TOL){
      error=0;
      return xn;
    }
    x=xn;
    f_x=f(x);

  }
  error=-1;
  return(1.);
}





