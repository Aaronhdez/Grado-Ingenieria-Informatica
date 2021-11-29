/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON FUNCIONES DE INTERPOLACION
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef MN_INTERPOLACION_H
#define MN_INTERPOLACION_H
#include "tnt_array/tnt.h"
using namespace TNT;

/// INTERPOLACION LINEAL
real interpolacion_lineal(Array1D<real> &x,Array1D<real> &f,real x0);


#endif
