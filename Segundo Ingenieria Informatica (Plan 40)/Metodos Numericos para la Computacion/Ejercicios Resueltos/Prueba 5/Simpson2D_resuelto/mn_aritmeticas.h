/*========================================================================
  DECLARACION DE TIPOS PARA TRABAJAR CON UNA ARITMETICA DE PRECISION FINITA
  =========================================================================*/

// SI EL FICHERO HA SIDO INCLUIDO PREVIAMENTE POR OTRO INCLUDE NO SE AÑADE
// PARA EVITAR ERRORES POR TENER REPETIDA UNA FUNCION
#ifndef AN_ARITMETICAS_H
#define AN_ARITMETICAS_H

// DEFINICION DE LA PRECISION DE LAS VARIABLE EN COMA FLOTANTE
#define real double

// DECLARACION DE TIPOS DE LAS FUNCIONES BASICAS
real mn_precision_aritmetica();
int mn_menor_numero_positivo();
int mn_mayor_numero_positivo();
real mn_distancia(real A,real B);

// DEFINICION DE ALGUNAS MACROS UTILES
#define an_abs(X) ((X)>0?(X):(-(X)))

#endif
