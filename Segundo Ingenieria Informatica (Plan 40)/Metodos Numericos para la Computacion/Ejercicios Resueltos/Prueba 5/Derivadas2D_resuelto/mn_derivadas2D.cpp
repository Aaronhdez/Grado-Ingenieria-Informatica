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
   int Nfilas=F.dim1();  // numero columnas matriz
   int Ncolumnas=F.dim2(); // numero de filas de la matriz
   //DEFINIMOS MATRIZ DERIVADA HORIZONTAL
   Array2D< real > DH(Nfilas,Ncolumnas);

   // HACER ALUMNO (TOMAR h=1 EN LAS FORMULAS DE LAS DERIVADAS)

   for(int i=0;i<Nfilas;i++){
    for(int j=1;j<(Ncolumnas-1);j++){
        DH[i][j]=(F[i][j+1]-F[i][j-1])/2.;
    }
    DH[i][0]=F[i][1]-F[i][0];
    DH[i][Ncolumnas-1]=F[i][Ncolumnas-1]-F[i][Ncolumnas-2];
   }



   return DH; // devuelve la matriz derivada
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
   int Nfilas=F.dim1();  // numero columnas matriz
   int Ncolumnas=F.dim2(); // numero de filas de la matriz
   //DEFINIMOS MATRIZ DONDE GUARDAMOS LA DERIVADA VERTICAL
   Array2D< real > DV(Nfilas,Ncolumnas);

   // HACER ALUMNO (TOMAR h=1 EN LAS FORMULAS DE LAS DERIVADAS)

   for(int j=0;j<Ncolumnas;j++){
     for(int i=1;i<(Nfilas-1);i++){
        DV[i][j]=(F[i+1][j]-F[i-1][j])/2.;
    }
    DV[0][j]=F[1][j]-F[0][j];
    DV[Nfilas-1][j]=F[Nfilas-1][j]-F[Nfilas-2][j];
   }

   return DV; // devuelve la matriz derivada
}

