#include "mn_trapecio.h"
#include <stdio.h>

/************************************************************
// FUNCIÓN PARA CALCULAR UNA INTEGRAL POR EL METODO DEL TRAPECIO
// DE UNA FUNCION DE 2 VARIABLES EN [a,b]x[c,d]
// RETORNA EL VALOR DE LA INTEGRAL
//************************************************************/
real mn_trapecio_2D(
real (*F)(real x,real y) /** funcion que se integra */,
real a /** extremo izquierdo del intervalo x */,
real b /** extremo derecho del invervalo x */,
real c /** extremo izquierdo del intervalo y */,
real d /** extremo derecho del invervalo y */,
int M /** numero de intervalos en x para calcular la integral */,
int N /** numero de intervalos en y para calcular la integral */)
{
   /** HACER ALUMNO. */
   real integral = 0;
   real hx = (b-a)/M;
   real hy = (d-c)/N;

   /// ITERAMOS
    for(int i=0; i<M; i++){
        real xi = a+i*hx;
        real xi1 = xi+hy;

        for(int j=0; j<N; j++){
            real yj = c+j*hy;
            real yj1 = yj+hy;

            ///Definimos la funcion de f con las dos x respecto de las dos y
            real fxi=((*F)(xi,yj)+(*F)(xi,yj1))*hy/2.;
            real fxi1=((*F)(xi1,yj)+(*F)(xi1,yj1))*hy/2.;

            /// Integramos respecto de la x
            integral += (fxi1+fxi)*hx/2.;
        }
    }
    return integral;
}

