#include "mn_simpson.h"
#include <stdio.h>

///************************************************************
/// FUNCION PARA CALCULAR UNA INTEGRAL POR EL METODO DE SIMPSON
/// UTILIZANDO N INTERVALOS EN UN INTERVALO [a,b]
///************************************************************
real mn_simpson(
real (*f)(real x) /* funcion que se integra */,
real a /* extremo izquierdo del intervalo */,
real b /* extremo derecho del invervalo*/,
int N /* numero de intervalos para calcular la integral */)
{
   /// HACER ALUMNO
   real integral = 0.;
   real h=(b-a)/N;
   real xi,xi1;
   xi = a;
   ///Actualizamos la función.
   real fxi = (*f)(xi);
   real S = (b-a)/(6.*N);

    for(int i=0; i<N;i++){
        xi1 = a+(i+1)*h;
        real xm = (xi+xi1)/2;
        real fm = (*f)(xm);
        real fxi1 = (*f)(xi1);
        integral += S*(fxi+fxi1+4*fm);

        xi = xi1;
        fxi= fxi1;
    }
    return integral;
}

//*************************************************************************
// FUNCION PARA CALCULAR UNA INTEGRAL POR ITERACIONES DEL METODO DE SIMPSON
// SE PARTE DE N=1 INTERVALOS Y SE CALCULA LA INTEGRAL CON LA FUNCION ANTERIOR
// SE ACTUALIZA N MULTIPLICANDOLO POR 2 Y SE CALCULA DE NUEVO LA INTEGRAL
// SE REALIZA ESTE PROCESO HASTA QUE LA DISTANCIA RELATIVA ENTRE LOS 2
// VALORES DE LA INTEGRAL ES MENOR QUE LA TOLERANCIA. EN Niter  SE DEVUELVE
// EL NUMERO DE ITERACIONES QUE SE REALIZA DE ESTE PROCESO
//*************************************************************************
real mn_simpson(
real (*f)(real x) /* funcion que se integra */,
real a /* extremo izquierdo del intervalo */,
real b /* extremo derecho del invervalo*/,
int &Niter /* variable de salida con el numero de iteraciones realizadas */,
real TOL /* tolerancia para controlar la convergencia */)
{
    /// HACER ALUMNO
    int N=1;
    real integral = mn_simpson((*f),a,b,N);
    real error=TOL+1;
    Niter=0;
    while(error>TOL){
        if(N>1e7){
            break;
        }
        ///Si no se cumple el error, duplica N y ejecuta el método de nuevo.
        Niter++;
        N*=2;
        real integral2 = mn_simpson((*f),a,b,N);

        ///Recargamos los valores
        error = mn_distancia(integral,integral2);
        integral=integral2;
    }
    return(integral);
}
