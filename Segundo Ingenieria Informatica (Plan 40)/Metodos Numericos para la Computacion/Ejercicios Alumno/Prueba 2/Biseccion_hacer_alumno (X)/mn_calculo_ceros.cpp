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
  ///Comprobamos que hay cambio de signo
    real f_a=f(a);
    real f_b=f(b);
    if(f_a*f_b>0){
        error = -1;
        return (-1.);
    }

    ///Aplicamos la fórmula
    while(mn_distancia(a,b) >= TOL){
        real xm=(a+b)*0.5;
        real fdexm=f(xm);
        ///Si Xm == 0, tenemos raíz
        if(fdexm==0.){
            error=0;
            return (xm);
        }
        if(f_a*fdexm < 0.){
            b = xm;
            f_b = fdexm;
        } else {
            a = xm;
            f_a = fdexm;
        }
    }
    ///Acaba el procedimiento, retornamos el iterativo
    real xm = (a+b)*0.5;
    error = 0;
    return (xm);
}


