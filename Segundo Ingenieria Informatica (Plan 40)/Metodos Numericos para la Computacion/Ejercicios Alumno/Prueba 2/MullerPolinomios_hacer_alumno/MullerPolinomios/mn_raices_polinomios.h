/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON FUNCIONES DE INTERPOLACION
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef AN_RAICES_POLINOMIOS_H
#define AN_RAICES_POLINOMIOS_H
#include "../tnt_array/tnt.h"
#include "mn_aritmeticas.h"
using namespace TNT;

// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
real evaluar_polinomio(Array1D< real > &a,real x);
int calculo_ceros_Muller(Array1D< real > &a,real &x0,real TOL,int NMaxIter);
Array1D< real > mn_calculo_polinomio_derivada(Array1D< real > &a);

#endif
