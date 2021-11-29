#include "mn_aritmeticas.h"
#include <math.h>
#include "tnt_array/tnt.h"
using namespace TNT;

real mn_cuadratura(
real (*f)(real x,real y) /** funcion que se integra */,
real c /** extremo inferior del intervalo para y*/,
real d /** extremo superior del invervalo para y*/,
Array2D< real > &x_le, /** matriz con los puntos de la tabla de cuadratura para el intervalo [-1,1]*/
Array2D< real > &w_le, /** matriz con los pesos de la tabla de cuadratura para el intervalo [-1,1] */
Array2D< real > &x_la, /** matriz con los puntos de la tabla de cuadratura para el intervalo [0,infinito]*/
Array2D< real > &w_la, /** matriz con los pesos de la tabla de cuadratura para el intervalo [0,infinito] */
int N_le, /** Nº de puntos a usar en la fórmula de cuadratura en el intervalo [1,1] */
int N_la);
