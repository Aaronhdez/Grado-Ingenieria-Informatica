#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"


// FUNCION QUE IMPLEMENTA EL CALCULO DE LAS RAICES DE UN POLINOMIO DE GRADO 2
// DEVUELVE EL NÚMERO DE RAÍCES OBTENIDAS
// LAS RAÍCES SALEN ORDENADAS POR VALOR ABSOLUTO. ES DECIR |x1|<=|x2|
int mn_ceros_pol_grado_2(
real a, real b, real c, // coeficientes polinomio de grado 2
real &x1, // primera raíz
real &x2) // segunda raíz
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
/// LA FUNCIÓN DEVUELVE EL NÚMERO DE ITERACIONES REALIZADAS SI TERMINA BIEN Y DEVUELVE -1 EN CASO CONTRARIO
/// USAR LA SIGUIENTE FUNCIÓN QUE CALCULA LAS RAICES DE UN POLINOMIO DE GRADO 2 ORDENADAS POR VALOR ABSOLUTO.
/// int mn_ceros_pol_grado_2(real a, real b, real c, real &x1, real &x2) (la función retorna el número de raíces)
int mn_muller (
real (*f)( real), /// funcion sobre la que se calcula el cero
real (*fp)( real), /// funcion derivada
real (*fpp)( real), /// funcion derivada segunda
real &x0, /// raíz inicial que actualiza la función
int NiterMax, /// número de iteraciones máximo
real TOL) /// tolerancia para para el algoritmo
{
  /// HACER ALUMNO
    real fx0 = f(x0);
    for(int i=0; i<NiterMax; i++){
        if(fx0 == 0){
            return i;
        }
        real x1; ///Raiz uno
        real x2; ///Raiz 2 (Las modifica el método)
        real roots = mn_ceros_pol_grado_2(fpp(x0)/2, fp(x0), fx0, x1, x2);
        if(roots == 0){
            return -1;
        }
        x1 = x0 + x1;
        fx0 = f(x1);
        if(mn_distancia(x1,x0)<TOL){
            return i+1;
        }
        x0 = x1;
    }
    return -1;
}



