/* Funciones para la resoluci�n de un sistema no-lineal por el m�todo de Newton-Raphson*/

#include "mn_sistemas_no_lineales.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/** FUNCIONES PARA CALCULAR EL PASO h PARA CALCULAR LAS DERIVADAS EN FUNCION
DE LA MAGNITUD DE LA VARIABLE x */
float mn_calcular_h( float x){  return fabsf(x)/(1<<12) +1e-30; }
double mn_calcular_h( double x){  return fabs(x)/(1<<26) +1e-300; }
long double mn_calcular_h( long double x){  return fabsl(x)/(1<<31) +1e-4000; }

/** Funci�n que calcula la matriz derivada de una funci�n de varias variables utilizando
siempre la aproximaci�n de la derivada tipo (f(x+h)-f(x))/h
Utilizar la funci�n mn_calcular_h() que est� encima para calcular el paso h de forma autom�tica
*/
Array2D< real > matriz_derivada(
Array1D< real >  (*f)(Array1D< real >), ///funci�n de varias variables a derivar
Array1D< real > &u) /// vector donde se calcula la derivada
{
  /** HACER ALUMNO */
  int N=u.dim(); // tama�o del vector
  Array2D< real > derivada(N,N);

  Array1D< real > u2=u.copy(); // vector auxiliar
  for(int k=0;k<N;k++){
    real h=mn_calcular_h(u2[k]);
    u2[k]+=h;
    Array1D< real > derivada_parcial=(f(u2)-f(u))/h;
    for(int l=0;l<N;l++) derivada[l][k]=derivada_parcial[l];
    u2[k]=u[k];
  }
  return(derivada);
}

/** funci�n que implementa el m�todo de Newton-Raphson para sistemas
devuelve el n�mero de iteraciones si termina bien y -1 si termina mal.
Se puede utilizar la funci�n mn_gauss(A,b) para resolver el sistema lineal
en cada iteraci�n*/
int mn_newton_raphson_sistemas(
Array1D< real >  (*f)(Array1D< real >), /** funci�n */
Array1D< real > &u, /** aproximaci�n de la soluci�n que es actulizada por la funci�n */
real TOL, /** tolerancia para parar las iteraciones */
int Nmax) /** n�mero m�ximo de iteraciones */
{
  /** HACER ALUMNO */

  Array1D<real> fu=(*f)(u); // evaluacion de la funci�n
  for(int i=0;i<Nmax;i++){
    if(fu.norm()<TOL){return(i);} // test de salida por la norma de la funcion
    Array2D<real> Derivada=matriz_derivada(f,u); // calculo de la matriz derivada
    Array1D<real> sol=mn_gauss(Derivada,fu*(-1.)); // resolvemos por gauss el sistema asociado
    //sol.print("sol");
    if(sol.dim()==0) return(-1);  // test de salida porque la el sistema no tiene soluci�n
    if(sol.norm()<TOL) return(i); // test de salida por el incremento de la funci�n
    u=u+sol; // actualizamos la soluci�n
    fu=f(u);  // calculo de la funci�n en el nuevo valor

  }
  return(-1); // salida si se ha superado el numero de iteraciones maximo
}

