#include "mn_derivadas2D.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR LA DERIVADA EN LA DIRECCION HORIZONTAL DE
UNA FUNCION F DADA EN FORMA MATRICIAL DONDE F[i][j] REPRESENTA
EL VALOR DE LA FUNCION EN EL PUNTO (i,j). PARA CALCULAR LA DERIVADA
USAMOS LA FORMULA :

f'(x)=(f(x+h)-f(x-h))/(2h).

APLICANDOLA EN LA DIRECCION HORIZONTAL Y TOMANDO h=1. SI (x+h) O (x-h)
SE SALEN DE LA MATRIZ USAMOS LAS FORMULAS

f'(x)=(f(x+h)-f(x))/(h)   ó    f'(x)=(f(x)-f(x-h))/(h)

LA FUNCION RETORNA UNA MATRIZ CON EL CALCULO DE LA DERIVADA HORIZONTAL
************************************************************/
Array2D< real > mn_derivada_horizontal(
Array2D< real > F /* funcion que en forma de matriz para derivar*/)
{

   /// HACER ALUMNO (TOMAR h=1 EN LAS FORMULAS DE LAS DERIVADAS)
    Array2D< real > DH(F.dim1(),F.dim2());

    for(int i=0; i<F.dim1(); i++){
        for(int j=1; j<(F.dim2()-1); j++){
            DH[i][j] = (F[i][j+1]-F[i][j-1])/2*1;
        }
        DH[i][0] = (F[i][1]-F[i][0]);
        DH[i][F.dim2()-1] = (F[i][F.dim2()-1]-F[i][F.dim2()-2]);
    }

    return DH;
}


/************************************************************
FUNCION PARA CALCULAR LA DERIVADA EN LA DIRECCION VERTICAL DE
UNA FUNCION F DADA EN FORMA MATRICIAL DONDE F[i][j] REPRESENTA
EL VALOR DE LA FUNCION EN EL PUNTO (i,j). PARA CALCULAR LA DERIVADA
USAMOS LA FORMULA :

f'(x)=(f(x+h)-f(x-h))/(2h).

APLICANDOLA EN LA DIRECCION VERTICAL Y TOMANDO h=1. SI (x+h) O (x-h)
SE SALEN DE LA MATRIZ USAMOS LAS FORMULAS

f'(x)=(f(x+h)-f(x))/(h)   ó    f'(x)=(f(x)-f(x-h))/(h)

LA FUNCION RETORNA UNA MATRIZ CON EL CALCULO DE LA DERIVADA VERTICAL
************************************************************/
Array2D< real > mn_derivada_vertical(
Array2D< real > F /* funcion que en forma de matriz para derivar*/)
{

    Array2D< real > DV(F.dim1(),F.dim2());

   /// HACER ALUMNO (TOMAR h=1 EN LAS FORMULAS DE LAS DERIVADAS)
    for(int j=0; j<F.dim2(); j++){
        for(int i=1; i<(F.dim1()-1); i++){
            DV[i][j] = (F[i+1][j]-F[i-1][j])/2*1;
        }
        DV[0][j] = (F[1][j]-F[0][j]);
        DV[F.dim1()-1][j] = (F[F.dim1()-1][j]-F[F.dim1()-2][j]);
    }

    return DV;
}

