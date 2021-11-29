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
  /// HACER ALUMNO
    /// Calculamos las fx0 y fx1
    real fx0 = f(x0);
    real fx1 = f(x1);
    ///Iteramos
    for(int i=0; i<NiterMax; i++){
        ///Verificamos que fx1 == 0
        if(fx1 == 0){
            return i;
        }
        ///Verificamos que fx0 == fx1
        if(fx0 == fx1){
            return -1;
        }
        real fp =(fx1-fx0)/(x1-x0);
        ///Verificamos la derivada
        if(fp == 0.){
            return -2;
        }
        real x2=x1-(fx1/fp);
        x0 = x1;
        fx0 = f(x0);
        x1 = x2;
        fx1 = f(x1);
        if(mn_distancia(x1,x0)<TOL){
            return i+1;
        };
        ///Actualizamos los valores

    }
    return -1;
}




