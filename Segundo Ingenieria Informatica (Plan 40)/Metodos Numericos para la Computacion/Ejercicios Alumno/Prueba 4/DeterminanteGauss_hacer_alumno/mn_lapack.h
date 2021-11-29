/* ================================================================
  MACROS Y DECLARACION DE TIPOS PARA GESTIONAR OPERACIONES CON
  MATRICES Y VECTORES
  ================================================================= */

#ifndef MN_LAPACK_H
#define MN_LAPACK_H

#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

/* FUNCION PARA LEER UNA MATRIZ DE DISCO DE DIMENSION dimension Y LO ALMACENA EN LA MATRIZ matriz  */
int mn_leer_matriz( char *nombrefichero,  Array2D< real > &matriz);

/* FUNCION PARA ESCRIBIR UNA MATRIZ DE DISCO DE DIMENSION dimension */
int mn_escribir_matriz( char *nombrefichero,  Array2D< real > &vmatriz);

#endif
