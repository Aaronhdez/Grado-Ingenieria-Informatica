/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// INTERPOLACION LINEAL
real interpolacion_lineal(
Array1D<real> &x, /// puntos de interpolaci�n
Array1D<real> &f, /// valores de funci�n en los puntos de interpolaci�n
real x0)  /// punto donde se evalua la funci�n interpolada
{
  for(int i=f.dim()-2; i>=0; i=i-1){
    if( x[i]<x0 ){
      return f[i]+(x0-x[i])*(f[i+1]-f[i])/(x[i+1]-x[i]);
    }
  }
  return f[0]+(x0-x[0])*(f[1]-f[0])/(x[1]-x[0]);
}



