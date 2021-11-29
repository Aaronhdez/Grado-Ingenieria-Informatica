#include "mn_cuadratura.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR UNA INTEGRAL POR EL METODO DE CUADRATURA DE GAUSS UTILIZANDO
UN VECTOR DE PUNTOS Y PESOS PARA EL INTERVALO [-1,1]. LOS VALORES DE PUNTOS Y PESOS
VIENEN EN LAS MATRICES w Y x, POR EJEMPLO PARA LA FÓRMULA DE 2 PUNTOS LOS PESOS
SERÍAN w[1][0] Y w[1][1] y LOS PUNTOS SERÍAN x[1][0] Y x[1][1]

NOTA : HAY QUE TENER EN CUENTA EL CAMBIO DE VARIABLE VISTO EN CLASE PARA PASAR UNA
INTEGRAL EN UN INTERVALO [a,b] AL INTERVALO [-1,1]

EN ESTE CASO LA INTEGRAL ES EN 2 DIMENSIONES Y POR TANTO LA FUNCIÓN A INTEGRAR DEPENDE
DE 2 VARIABLES Y HAY QUE AJUSTAR LA INTEGRAL TAL Y COMO SE EXPLICÓ EN CLASE. EL Nº DE
PUNTOS DE CUADRATURA A UTILIZAR ES EL MISMO EN LA VARIABLE x E y Y VIENE DADO EL PARÁMETRO
DE ENTRADA N
************************************************************/
real mn_cuadratura(
real (*f)(real x,real y) /** funcion que se integra */,
real a /** extremo izquierdo del intervalo para x*/,
real b /** extremo derecho del invervalo para x*/,
real c /** extremo inferior del intervalo para y*/,
real d /** extremo superior del invervalo para y*/,
Array2D< real > &x, /** matriz con los puntos de la tabla de cuadratura para el intervalo [-1,1]*/
Array2D< real > &w, /** matriz con los pesos de la tabla de cuadratura para el intervalo [-1,1] */
int N) /** Nº de puntos a usar en la fórmula de cuadratura */
{
   /// HACER ALUMNO

}

