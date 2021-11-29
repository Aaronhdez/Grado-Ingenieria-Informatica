#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

/// FUNCION QUE IMPLEMENTA EL METODO DE LA BISECCION
real mn_biseccion (
real (*f)(const real), /// funci�n a la cual se calcula un cero
real &a, real &b, /// intervalo inicial para buscar la ra�z
const real TOL,  /// tolerancia para parar las iteraciones del algoritmo
int &error) /// c�digo de salida de error :
            ///       Si error=0 la funci�n ha terminado bien
            ///       Si error=-1 la funci�n ha terminado mal
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
  while( mn_distancia(a,b) >= TOL ){ /// el bucle se detiene si el intervalo es muy peque�o
    real paso=(a+b)*0.5; /// punto medio del intervalo
    real f_paso=f(paso);
    if(f_paso==0.){ /// verificamos si se ha encontrado la ra�z
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

  /// RETORNAMOS EL PUNTO MEDIO DEL �LTIMO INTERVALO
  real paso=(a+b)*0.5;
  error=0;
  return(paso);

}


