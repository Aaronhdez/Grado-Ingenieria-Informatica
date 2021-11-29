/* Funciones para la resolución de un sistema no-lineal por el método de Newton-Raphson*/

#include "mn_sistemas_no_lineales.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/** FUNCIONES PARA CALCULAR EL PASO h PARA CALCULAR LAS DERIVADAS EN FUNCION
DE LA MAGNITUD DE LA VARIABLE x */
float mn_calcular_h( float x){  return fabsf(x)/(1<<12) +1e-30; }
double mn_calcular_h( double x){  return fabs(x)/(1<<26) +1e-300; }
long double mn_calcular_h( long double x){  return fabsl(x)/(1<<31) +1e-4000; }

/** Función que calcula la matriz derivada de una función de varias variables utilizando
siempre la aproximación de la derivada tipo (f(x+h)-f(x))/h
Utilizar la función mn_calcular_h() que está encima para calcular el paso h de forma automática
*/
Array2D< real > matriz_derivada(
Array1D< real >  (*f)(Array1D< real >), ///función de varias variables a derivar
Array1D< real > &u) /// vector donde se calcula la derivada
{
  /** HACER ALUMNO */
    Array2D<real> Derivada (u.dim(),u.dim());
    Array1D<real> u2 = u.copy();
    for(int i=0; i<u.dim(); i++){
        real h = mn_calcular_h(u2[i]);
        u2[i] += h;
        Array1D<real> parcial = (f(u2)-f(u))/h;
        for(int j=0; j<u.dim(); j++){
            Derivada[j][i] = parcial[j];
        }
        u2[i] = u[i];
    }
    return Derivada;
}

/** función que implementa el método de Newton-Raphson para sistemas
devuelve el número de iteraciones si termina bien y -1 si termina mal.
Se puede utilizar la función mn_gauss(A,b) para resolver el sistema lineal
en cada iteración*/
int mn_newton_raphson_sistemas(
Array1D< real >  (*f)(Array1D< real >), /** función */
Array1D< real > &u, /** aproximación de la solución que es actulizada por la función */
real TOL, /** tolerancia para parar las iteraciones */
int Nmax) /** número máximo de iteraciones */
{
  /** HACER ALUMNO */
    Array1D<real> fu = (*f)(u);
    for(int i=0; i<Nmax; i++){
        if(u.norm()<=TOL){
            return i;
        }
        Array2D<real> Deriv = matriz_derivada(f,u);
        Array1D<real> res = mn_gauss(Deriv, fu*(-1));
        if(res.dim()==0){
            return -1;
        }
        if(res.norm()<=TOL){
            return i;
        }
        u = u + res;
        fu = (*f)(u);
    }
    return -1;

}

