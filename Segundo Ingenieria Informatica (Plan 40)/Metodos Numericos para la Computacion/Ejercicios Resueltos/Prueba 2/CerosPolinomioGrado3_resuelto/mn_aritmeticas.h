/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON UNA ARITMETICA DE PRECISION FINITA
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef MN_ARITMETICAS_H
#define MN_ARITMETICAS_H

// DEFINICION DE LA PRECISION DE LAS VARIABLE EN COMA FLOTANTE
#define real double

// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
real mn_precision_aritmetica();
int mn_menor_numero_positivo();
int mn_mayor_numero_positivo();
real mn_distancia(real A,real B);

// DEFINICION DE ALGUNAS MACROS UTILES
#define mn_abs(X) ((X)>0?(X):(-(X)))
#define mn_max(X,Y) ((X)>(Y)?(X):(Y))

// DECLARACIONES PARA IMPRIMIR POR PANTALLA USANDO cout
#include <iostream>
using namespace std;

#endif
