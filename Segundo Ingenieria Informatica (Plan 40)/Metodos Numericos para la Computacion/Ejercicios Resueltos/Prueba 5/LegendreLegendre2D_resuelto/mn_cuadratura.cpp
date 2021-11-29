#include "mn_cuadratura.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR UNA INTEGRAL POR EL METODO DE CUADRATURA DE GAUSS UTILIZANDO
UN VECTOR DE PUNTOS Y PESOS PARA EL INTERVALO [-1,1]. LOS VALORES DE PUNTOS Y PESOS
VIENEN EN LAS MATRICES w Y x, POR EJEMPLO PARA LA F�RMULA DE 2 PUNTOS LOS PESOS
SER�AN w[1][0] Y w[1][1] y LOS PUNTOS SER�AN x[1][0] Y x[1][1]

NOTA : HAY QUE TENER EN CUENTA EL CAMBIO DE VARIABLE VISTO EN CLASE PARA PASAR UNA
INTEGRAL EN UN INTERVALO [a,b] AL INTERVALO [-1,1]

EN ESTE CASO LA INTEGRAL ES EN 2 DIMENSIONES Y POR TANTO LA FUNCI�N A INTEGRAR DEPENDE
DE 2 VARIABLES Y HAY QUE AJUSTAR LA INTEGRAL TAL Y COMO SE EXPLIC� EN CLASE. EL N� DE
PUNTOS DE CUADRATURA A UTILIZAR ES EL MISMO EN LA VARIABLE x E y Y VIENE DADO EL PAR�METRO
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
int N) /** N� de puntos a usar en la f�rmula de cuadratura */
{
   real integral=0; // se inicializa el resultado de la integral a 0
   for(int k=0;k<N;k++){ // se recorren los puntos de cuadratura en la variable x
     real x2=0.5*((b-a)*x[N-1][k]+b+a); // se calcula el punto asociado en la variable x
     for(int m=0;m<N;m++){ // se recorren los puntos de cuadratura en la variable y
       real y2=0.5*((d-c)*x[N-1][m]+c+d); // se calcula el punto asociado en la variable y
       integral +=(b-a)*(d-c)*0.25*(*f)(x2,y2)*w[N-1][k]*w[N-1][m]; // se calcula la aportaci�n a la integral del punto
     }
   }
   return integral; // se devuelve el valor de la integral
}

