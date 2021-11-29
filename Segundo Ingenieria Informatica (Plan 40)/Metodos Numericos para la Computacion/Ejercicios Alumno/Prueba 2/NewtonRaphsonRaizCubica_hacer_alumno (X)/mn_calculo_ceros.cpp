#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

///* ALGORITMO PARA CALCULAR LA RAIZ CUBICA DE UN NÚMERO A BUSCANDO LA RAIZ DE LA
///FUNCION  X*X*X-A=0  UTILIZANDO EL METODO DE NEWTON-RAPSHON CON UNA TOLERANCIA PARA LA
///CONVERGENCIA DE TOL Y UN NUMERO MAXIMO DE ITERACIONES Nmax. EL VALOR INICIAL DE LA RAIZ
///ES EL PARAMETRO x QUE ES TAMBIEN LA VARIABLE DONDE SE DEVUELVE LA RAIZ FINAL.
///EL ALGORITMO DEVUELVE EL  NUMERO DE ITERACIONES NECESARIO PARA CONVERGER Y SI
///TERMINA MAL SE DEVUELVE -1
///*/

int mn_raiz_cubica_newton(real A,real &x,int Nmax,real TOL){
  /// HACER ALUMNO
    real fx = x*x*x-A; ///Evaluamos la función
    for(int i=0; i<Nmax; i++){
        ///revisamos que la función no sea 0;
        if(fx==0.){
            return i;
        }
        real fxp=3*x*x; ///calculamos la derivada
        if(fxp==0.){
            return -1;
        }
        real x1 = x-(fx/fxp); /// Calculamos x1
        fx = x1*x1*x1-A; /// Re-evaluamos la función, ejecutamos condición y actualizamos
        if(fabs(x1-x)<TOL*(fabs(x1)+1.)){
            x = x1;
            return i;
        }
        x=x1;
    }
    return -1;
}
