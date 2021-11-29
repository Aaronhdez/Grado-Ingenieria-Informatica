/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON FUNCIONES DE INTERPOLACION
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef MN_INTERPOLACION_H
#define MN_INTERPOLACION_H
#include "tnt_array/tnt.h"
using namespace TNT;

// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
Array2D< real > zoom(Array2D< real > &A,real z);


#endif
