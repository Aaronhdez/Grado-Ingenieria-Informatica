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

int mn_calculo_splines_2(const Array1D< real > &x, const Array1D< real > &f,const real &cLast,Array1D< real > &a,Array1D< real > &b,Array1D< real > &c);

real mn_evaluar_splines_2(const Array1D< real > &x,Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,real &x0 );



#endif
