#include "mn_derivadas2D.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR EL LAPLACIANO UNA FUNCION F DADA EN FORMA
MATRICIAL DONDE F[i][j] REPRESENTA EL VALOR DE LA FUNCION EN EL
PUNTO (i,j). EL LAPLACIANO ES LA SUMA DE LAS DERIVADAS SEGUNDAS
EN LA DIRECCION HORIZONTAL Y EN LA DIRECCI�N VERTICAL. UNA FORMA
DE APROXIMARLO ES USANDO LA F�RMULA

LAPLACIANO[i][j]=F[i+1][j]+F[i-1][j]+F[i][j+1]+F[i][j-1]-4*F[i][j]

AL IMPLEMENTAR LA FORMULA, SI F[i+1][j], F[i-1][j], F[i][j+1] O F[i][j-1]
SE SALEN DEL RANGO DE LA MATRIZ, ENTONCES SE SUSTITUYEN POR F[i][j]
EN LA F�RMULA

LA FUNCION RETORNA UNA MATRIZ CON EL CALCULO DEL LAPLACIANO
************************************************************/
Array2D< real > mn_derivada_laplaciano(
Array2D< real > F /** funcion que en forma de matriz para derivar*/)
{
   /** HACER ALUMNO */
   /** AL VALORAR ESTE EJERCICIO SE TENDR� ESPECIALMENTE EN CUENTA QUE NO SE HAGAN
       OPERACIONES O TESTS INNECESARIOS. NO SE PERMITE USAR LA INSTRUCCI�N if() O
       EQUIVALENTE
   */

}



