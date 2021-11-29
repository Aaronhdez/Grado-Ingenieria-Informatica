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
void mn_evaluar_polinomio_horner(Array1D< real > &a, real x, real &Px, real &PPx);
int calculo_ceros_Newton_Raphson(Array1D< real > &a,real &x0,real TOL,int NMaxIter);

#endif
