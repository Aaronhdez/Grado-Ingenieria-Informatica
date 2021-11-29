/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON FUNCIONES DE INTERPOLACION
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef MN_INTERPOLACION_H
#define MN_INTERPOLACION_H
#include "tnt_array/tnt.h"
using namespace TNT;

/// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
int mn_regresion_lineal(Array1D< real > &x,Array1D< real > &y,real &a, real &b);



#endif
