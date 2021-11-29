#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"



// FUNCION QUE IMPLEMENTA EL METODO DE NEWTON-RAPHSON CONOCIENDO LA FUNCION DERIVADA
// LA FUNCI�N DEVUELVE EL N�MERO DE ITERACIONES REALIZADAS SI TERMINA BIEN Y DEVUELVE -1
// EN CASO CONTRARIO
int mn_newton_raphson (
real (*f)( real), /// funcion sobre la que se calcula el cero
real (*fp)( real), /// funcion derivada
real &x0, /// ra�z inicial que actualiza la funci�n
int NiterMax, /// n�mero de iteraciones m�ximo
real TOL) /// tolerancia para para el algoritmo
{
  /// HACER ALUMNO
    real fx0=f(x0);
    for(int i=0;i<NiterMax;i++){
        ///Si f0 es 0 retornamos. Implica que x0 es la raiz
        if(fx0 == 0.){
            return i;
        }
        real fpx0 =fp(x0);
        ///Si su derivada es 0, retornamos (implica que i es la raiz)
        if(fpx0== 0.){
            return -1;
        }
        ///Si lo anterior no es correcto, calculamos x1 y fx1
        real x1=x0-(fx0/fpx0);
        fx0 = f(x1);

        if(mn_distancia(x1,x0)<TOL){
            x0 = x1;
            return i+1;
        }
        x0=x1;
    }
    return -1;
}



