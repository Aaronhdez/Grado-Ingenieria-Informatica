/* ================================================================
  MACROS Y DECLARACION DE TIPOS PARA GESTIONAR OPERACIONES CON
  MATRICES Y VECTORES
  ================================================================= */

#ifndef mn_LAPACK_H
#define mn_LAPACK_H

#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;


/** DECLARACION DE TIPOS PARA LAS FUNCIONES DE mn_LAPACK */

/** FUNCION PARA CALCULAR EL AUTOVALOR Y AUTOVECTOR MAXIMO POR EL METODO DE LA POTENCIA */
int mn_metodo_potencia(Array2D< real > &A, Array1D< real > &u, real &a_max,int Nmax,real TOL ) ;




#endif
