#include "mn_simpson.h"
#include <stdio.h>

//************************************************************
// FUNCION PARA CALCULAR UNA INTEGRAL POR EL METODO DE SIMPSON
// UTILIZANDO N INTERVALOS EN UN INTERVALO [a,b]
//************************************************************
real mn_simpson(
real (*f)(real x) /* funcion que se integra */,
real a /* extremo izquierdo del intervalo */,
real b /* extremo derecho del invervalo*/,
int N /* numero de intervalos para calcular la integral */)
{
   real integral=0; // variable donde se acumula el valor de la integral
   real h=(b-a)/N;  // tamaño del subintervalo
   real xk,xk1; // extremos del subintervalo [xk,xk1]
   xk=a; // inicialización extremo primer subintervalo
   real fk=(*f)(xk);  // inicialización evaluacion de la funcion en xk
   real S=(b-a)/(6.*N);  // factor multiplicativo de Simpson


   for(int k=0;k<N;k++) // bucle para acumular el valor de la integral
   {
      xk1=a+(k+1)*h; // extremo derecho subintervalo
	  real xm=(xk+xk1)/2; // punto medio del subintervalo
	  real fm=(*f)(xm);  // evaluación de la función en el punto medio
      real fk1=(*f)(xk1);  // evaluación de la función en el extremo derecho
      integral+=S*(fk+fk1+4*fm); // acumulacion valor integral
	  xk=xk1; //actualización extremo izquierdo
      fk=fk1; // actualizacion valor integral extremo izquierdo
   }
   return integral; // se devuelve el valor de la integral
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
  int N=1;
  real integral = mn_simpson((*f),a,b,N);
  real error=TOL+1;
  Niter=0;
  while(error>TOL ){
    if(N>1e7) break; // fijamos "a priori" el numero máximo de intervalo a 1e7
    Niter++;
    N*=2;
    real integral2=mn_simpson((*f),a,b,N);
    error=mn_distancia(integral,integral2);
    integral=integral2;
    //printf("integral=%e error=%e N=%d \n",(double) integral,(double) error,N);
  }
  return(integral);
}
