/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

///* FUNCION QUE CALCULA LA RECTA DE REGRESION LINEAL y=ax+b PARA APROXIMAR UNA
/// NUBE DE PUNTOS (x[k],y[k]). LA FUNCION DEVUELVE 0 SI TERMINA BIEN Y -1 SI
/// TERMINA MAL
/// */
int mn_regresion_lineal(
Array1D< real > &x, /// VECTOR DE COORDENADAS x DE LA NUBE DE PUNTOS
Array1D< real > &y, /// VECTOR DE COORDENADAS y DE LA NUBE DE PUNTOS
real &a, /// COMPONENTE a DE LA RECTA DE REGRESIÓN. (PARÁMETRO DE SALIDA)
real &b) /// COMPONENTE b DE LA RECTA DE REGRESIÓN. (PARÁMETRO DE SALIDA)
{
  int N=x.dim();
  if(y.dim()!=N || N<2) return(-1);

  /// CALCULAMOS LAS DIFERENTES SUMAS QUE APARECEN EN LAS FORMULAS
  real suma_x=0,suma_y=0,suma_xy=0,suma_x2=0;
  for(int k=0;k<N;k++){
    suma_x+=x[k];
    suma_y+=y[k];
    suma_xy+=x[k]*y[k];
    suma_x2+=x[k]*x[k];
  }
  /// CALCULAMOS a y b SEGUN LAS FORMULAS
  real denominador=N*suma_x2-suma_x*suma_x;
  if(denominador==0.) return(-1);
  a=(N*suma_xy-suma_x*suma_y)/denominador;
  b=(suma_x2*suma_y-suma_xy*suma_x)/denominador;
  return(0);
}



