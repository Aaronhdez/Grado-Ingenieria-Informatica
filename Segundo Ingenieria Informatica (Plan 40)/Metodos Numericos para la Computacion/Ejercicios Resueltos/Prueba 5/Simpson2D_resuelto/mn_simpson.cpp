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
   /** HACER ALUMNO. NOTA: PARA EVALUAR F EN (x,y) SE HACE : (*F)(x,y) */
   real integral=0; // variable donde se acumula el valor de la integral
   real hx=(b-a)/M;  // tamaño del subintervalo en x
   real hy=(d-c)/N;  // tamaño del subintervalo en y

    /** CALCULAMOS LA INTEGRAL */
   for(int k=0;k<M;k++) {
      real xk=a+k*hx;
      real xk1=xk+hx;
      real xm=xk+0.5*hx;
      for(int n=0;n<N;n++){
        real yn=c+n*hy;
        real yn1=yn+hy;
        real ym=yn+0.5*hy;
        real fxk=((*F)(xk,yn)+4*(*F)(xk,ym)+(*F)(xk,yn1))*hy/6.;
        real fxm=((*F)(xm,yn)+4*(*F)(xm,ym)+(*F)(xm,yn1))*hy/6.;
        real fxk1=((*F)(xk1,yn)+4*(*F)(xk1,ym)+(*F)(xk1,yn1))*hy/6.;
        integral+=(fxk+4.*fxm+fxk1)*hx/6.;
      }
   }
   return integral; /** se devuelve el valor de la integral */
}

