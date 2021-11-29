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

// DECLARACION DE TIPOS PARA LAS FUNCIONES DE MN_LAPACK

// FUNCION PARA RESOLVER SISTEMAS POR EL METODO DE GAUSS
Array1D< real > mn_gauss(Array2D< real > &A,Array1D< real > &b);


/* FUNCION PARA LEER UN VECTOR DE DISCO. RETORNA LA DIMENSION DEL VECTOR */
int mn_leer_vector(char *nombrefichero, Array1D< real > &vector);

/* FUNCION PARA ESCRIBIR UN VECTOR DE DISCO DE DIMENSION dimension Y LO ALMACENA EN vector */
int mn_escribir_vector(char *nombrefichero, Array1D< real > &vector);

/* FUNCION PARA LEER UNA MATRIZ DE DISCO DE DIMENSION dimension Y LO ALMACENA EN LA MATRIZ matriz  */
int mn_leer_matriz( char *nombrefichero,  Array2D< real > &matriz);

/* FUNCION PARA ESCRIBIR UNA MATRIZ DE DISCO DE DIMENSION dimension */
int mn_escribir_matriz( char *nombrefichero,  Array2D< real > &vmatriz);

#endif

