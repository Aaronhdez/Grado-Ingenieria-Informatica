#include "mn_simpson.h"
#include <stdio.h>

/************************************************************
// FUNCIÓN PARA CALCULAR UNA INTEGRAL POR EL METODO DE SIMPSON
// DE UNA FUNCION DE 2 VARIABLES EN [a,b]x[c,d]
// RETORNA EL VALOR DE LA INTEGRAL
//************************************************************/
real mn_simpson_2D(
real (*F)(real x,real y) /** funcion que se integra */,
real a /** extremo izquierdo del intervalo x */,
real b /** extremo derecho del invervalo x */,
real c /** extremo izquierdo del intervalo y */,
real d /** extremo derecho del invervalo y */,
int M /** numero de intervalos en x para calcular la integral */,
int N /** numero de intervalos en y para calcular la integral */)
{
   /** HACER ALUMNO. */
    real hx = (b-a)/M;
    real hy = (d-c)/N;
    real integral = 0.;

    ///Iteramos
    for(int i=0; i<M; i++){
        real xi = a+i*hx;
        real xi1 = xi+hx;
        real xm = xi+hx/2;
        for(int j=0; j<N; j++){
            real yj = c+j*hy;
            real yj1 = yj+hy;
            real ym = yj+hy/2;
            ///Formula de simpson
            ///Iteramos respecto a la y
            real fxi = ((*F)(xi,yj)+(*F)(xi,yj)+4*(*F)(xi,ym))*hy/6.;
            real fxm = ((*F)(xm,yj)+(*F)(xm,yj)+4*(*F)(xm,ym))*hy/6.;
            real fxi1 = ((*F)(xi1,yj)+(*F)(xi1,yj)+4*(*F)(xi1,ym))*hy/6.;
            /// Iteramos respecto a la x
            integral += (fxi1+fxi+4*fxm)*hx/6;
        }
    }
    return integral;
}

