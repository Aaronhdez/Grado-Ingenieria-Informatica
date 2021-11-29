#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

/// FUNCION QUE IMPLEMENTA EL METODO DE LA BISECCION
real mn_biseccion (
real (*f)(const real), /// función a la cual se calcula un cero
real &a, real &b, /// intervalo inicial para buscar la raíz
const real TOL,  /// tolerancia para parar las iteraciones del algoritmo
int &error) /// código de salida de error :
            ///       Si error=0 la función ha terminado bien
            ///       Si error=-1 la función ha terminado mal
{
  /// HACER ALUMNO

  /// COMPROBAMOS QUE HAY CAMBIO DE SIGNO EN EL INTERVALO
  real f_a=f(a);
  real f_b=f(b);
  if(f_a*f_b>0){
    error=-1;
    return(-1.);
  }

  /// HACEMOS IERACIONES DEL ALGORITMO PARA ACTUALIZAR EL INTERVALO
  while( mn_distancia(a,b) >= TOL ){ /// el bucle se detiene si el intervalo es muy pequeño
    real paso=(a+b)*0.5; /// punto medio del intervalo
    real f_paso=f(paso);
    if(f_paso==0.){ /// verificamos si se ha encontrado la raíz
      error=0;
      return(paso);
    }
    if(f_a*f_paso < 0.){ /// actualizamos el intervalo
      b=paso;
      f_b=f_paso;
    }
    else{
      a=paso;
      f_a=f_paso;
    }
  }

  /// RETORNAMOS EL PUNTO MEDIO DEL ÚLTIMO INTERVALO
  real paso=(a+b)*0.5;
  error=0;
  return(paso);

}


