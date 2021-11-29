#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"


/// CALCULO INTERÉS APLICADO A 3 AÑOS
/// UNA PERSONA INVIERTE 1000 EUROS CADA AÑO EN UN BANCO Y AL
/// FINAL DEL AÑO 3 LE DAN 3200 EUROS. QHE TASA DE INTERÉS x LE HAN APLICADO ANUALMENTE
/// SI TENEMOS EN CUENTA QUE LA FÓRMULA QUE CALCULA LA SUMA TOTAL (3200 EUROS) ES

/// S(x)= 1000*(1+x)+1000*(1+x)*(1+x)+1000*(1+x)*(1+x)*(1+x)

/// CALCULAR EL VALOR DE x POR EL MÉTODO DE LA BISECCIÓN SABIENDO QUE LA TASA DE INTERÉS BUSCADO
/// SE ENCUENTRA ENTRE EL 0% Y EL 10%

/// CUALQUIER OTRO PARÁMETRO DEL MÉTODO LO TIENE QUE ELEGIR EL PROPIO ALUMNO

/// NOTA : HACER MAS OPERACIONES DE LAS INDISPENSABLES BAJA LA CALIFICACIÓN

real interes ()
{
  /// HACER ALUMNO

  /// DECLARAMOS LAS VARIABLES QUE VAMOS A USAR
  real a=0;
  real b=0.1;
  real f_a=1000*(1+a)+1000*(1+a)*(1+a)+1000*(1+a)*(1+a)*(1+a)-3200.;
  real f_b=1000*(1+b)+1000*(1+b)*(1+b)+1000*(1+b)*(1+b)*(1+b)-3200.;

  /// COMPROBAMOS QUE HAY CAMBIO DE SIGNO EN EL INTERVALO
  if(f_a*f_b>0){
    return(-1.);
  }

  /// HACEMOS ITERACIONES DEL BUCLE DEL MÉTODO DE LA BISECCIÓN
  while( mn_distancia(a,b) >= 1e-8 ){
    /// punto medio del intervalo y evaluación de la función
    real xm=(a+b)*0.5;
    real f_paso=1000*(1+xm)+1000*(1+xm)*(1+xm)+1000*(1+xm)*(1+xm)*(1+xm)-3200.;
    if(f_paso==0.){ /// comprobación si hemos obtenido ya la raíz
      return(xm);
    }
    /// actualización de uno de los extremos del intervalo
    if(f_a*f_paso < 0.){
      b=xm;
      f_b=f_paso;
    }
    else{
      a=xm;
      f_a=f_paso;
    }
  }

  /// retornamos el resultado
  return((a+b)*0.5);

}


