/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON FUNCIONES DE INTERPOLACION
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef AN_RAICES_POLINOMIOS_H
#define AN_RAICES_POLINOMIOS_H
#include "tnt_array/tnt.h"
#include "mn_aritmeticas.h"
using namespace TNT;

// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
real evaluar_polinomio(Array1D< real > &a,real x);
real calculo_ceros_biseccion(Array1D< real > &P,real a,real b,real Pa,real Pb,real TOL);
Array1D< real >  calcular_ceros_polinomio_grado4(Array1D< real > &a,real TOL);

#endif


