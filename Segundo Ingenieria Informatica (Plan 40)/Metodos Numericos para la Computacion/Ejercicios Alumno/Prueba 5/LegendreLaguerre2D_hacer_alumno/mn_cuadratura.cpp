#include "mn_cuadratura.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR LA SIGUIENTE INTEGRAL POR EL METODO DE CUADRATURA DE GAUSS
DE LA FUNCION f(x,y) EN EL INTERVALO [a,infinito]x[c,d]

UTILIZANDO UN VECTOR DE PUNTOS Y PESOS PARA EL INTERVALO [0,infinito].
Y LOS PUNTOS Y PESOS PARA EL INTERVALO [-1,1]

************************************************************/
real mn_cuadratura(
real (*f)(real x,real y) /** funcion que se integra */,
real a /** extremo inferior del intervalo para x*/,
real c /** extremo inferior del intervalo para y*/,
real d /** extremo superior del invervalo para y*/,
Array2D< real > &x_le, /** matriz con los puntos de la tabla de cuadratura para el intervalo [-1,1]*/
Array2D< real > &w_le, /** matriz con los pesos de la tabla de cuadratura para el intervalo [-1,1] */
Array2D< real > &x_la, /** matriz con los puntos de la tabla de cuadratura para el intervalo [0,infinito]*/
Array2D< real > &w_la, /** matriz con los pesos de la tabla de cuadratura para el intervalo [0,infinito] */
int N_le, /** N? de puntos a usar en la f?rmula de cuadratura en el intervalo [1,1] */
int N_la) /** N? de puntos a usar en la f?rmula de cuadratura en el intervalo [0,infinito) */

{
 /// HACER ALUMNO

}

