#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"


/// FUNCION QUE IMPLEMENTA EL CALCULO DE LAS RAICES DE UN POLINOMIO DE GRADO 2
/// DEVUELVE EL N�MERO DE RA�CES OBTENIDAS
/// LAS RA�CES SALEN ORDENADAS POR VALOR ABSOLUTO. ES DECIR |x1|<=|x2|
int mn_ceros_pol_grado_2(
real a, real b, real c, // coeficientes polinomio de grado 2
real &x1, // primera ra�z
real &x2) // segunda ra�z
{
  // HACER ALUMNO
  if(a==0){
    if(b==0) return(0);
    x1=-c/b;
    return(1);
  }
  real dis=b*b-4*a*c;
  if(dis<0) return(0);
  dis=sqrt(dis);
  if(b>0){
    x2=(-b-dis)/(2*a);
  }
  else{
    x2=(-b+dis)/(2*a);
  }
  if(x2==0){
    x1=0;
    return(2);
  }
  x1=c/(x2*a);
  return(2);
}


/// FUNCION QUE IMPLEMENTA EL METODO DE MULLER
/// LA FUNCI�N DEVUELVE EL N�MERO DE ITERACIONES REALIZADAS SI TERMINA BIEN Y DEVUELVE -1 EN CASO CONTRARIO
/// USAR LA SIGUIENTE FUNCI�N QUE CALCULA LAS RAICES DE UN POLINOMIO DE GRADO 2 ORDENADAS POR VALOR ABSOLUTO.
/// int mn_ceros_pol_grado_2(real a, real b, real c, real &x1, real &x2) (la funci�n retorna el n�mero de ra�ces)
int mn_muller (
real (*f)( real), /// funcion sobre la que se calcula el cero
real (*fp)( real), /// funcion derivada
real (*fpp)( real), /// funcion derivada segunda
real &x0, /// ra�z inicial que actualiza la funci�n
int NiterMax, /// n�mero de iteraciones m�ximo
real TOL) /// tolerancia para para el algoritmo
{
  /// HACER ALUMNO
  real f_x0=f(x0); /// evaluacion de la funci�n
  for(int i=0;i<NiterMax;i++){
    if(f_x0==0.){return(i);} /// test de salida por el valor de la funcion
    real x1,x2;
    int Nroots=mn_ceros_pol_grado_2(fpp(x0)/2.,fp(x0),f_x0,x1,x2);
    if(Nroots==0) return(-1);  /// test de salida por el valor de la derivada
    x1=x0+x1; /// calculo nuevo valor raiz
    f_x0=f(x1);  /// calculo de la funci�n en el nuevo valor
    if(mn_distancia(x1,x0)<TOL){  /// test de salida por proximidad de raices
      x0=x1;
      return(i+1);
    }
    x0=x1;  /// actualizacion raiz
  }
  return(-1); /// salida si se ha superado el numero de iteraciones maximo
}



