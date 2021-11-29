#include "mn_derivadas2D.h"
#include <stdio.h>

/************************************************************
FUNCION PARA CALCULAR EL LAPLACIANO UNA FUNCION F DADA EN FORMA
MATRICIAL DONDE F[i][j] REPRESENTA EL VALOR DE LA FUNCION EN EL
PUNTO (i,j). EL LAPLACIANO ES LA SUMA DE LAS DERIVADAS SEGUNDAS
EN LA DIRECCION HORIZONTAL Y EN LA DIRECCIÓN VERTICAL. UNA FORMA
DE APROXIMARLO ES USANDO LA FÓRMULA

LAPLACIANO[i][j]=F[i+1][j]+F[i-1][j]+F[i][j+1]+F[i][j-1]-4*F[i][j]

AL IMPLEMENTAR LA FORMULA, SI F[i+1][j], F[i-1][j], F[i][j+1] O F[i][j-1]
SE SALEN DEL RANGO DE LA MATRIZ, ENTONCES SE SUSTITUYEN POR F[i][j]
EN LA FÓRMULA

LA FUNCION RETORNA UNA MATRIZ CON EL CALCULO DEL LAPLACIANO
************************************************************/
Array2D< real > mn_derivada_laplaciano(
Array2D< real > F /** funcion que en forma de matriz para derivar*/)
{
   /** HACER ALUMNO */
   /** AL VALORAR ESTE EJERCICIO SE TENDRÁ ESPECIALMENTE EN CUENTA QUE NO SE HAGAN
       OPERACIONES O TESTS INNECESARIOS. NO SE PERMITE USAR LA INSTRUCCIÓN if() O
       EQUIVALENTE
   */
   int Nfilas=F.dim1();  // numero columnas matriz
   int Ncolumnas=F.dim2(); // numero de filas de la matriz

   /** DECLARAMOS LA MATRIZ LAPLACIANO */
   Array2D< real > LAPLACIANO(Nfilas,Ncolumnas);

   /** IMPLEMENTACIÓN BLOQUE CENTRAL */
   for(int i=Nfilas-2;i>0;i--){
    for(int j=Ncolumnas-2;j>0;j--){
        LAPLACIANO[i][j]=F[i+1][j]+F[i-1][j]+F[i][j+1]+F[i][j-1]-4*F[i][j];
    }
   }

   /** IMPLEMENTACIÓN LINEAS SUPERIOR E INFERIOR */
   for(int j=Ncolumnas-2;j>0;j--){
     LAPLACIANO[0][j]=F[1][j]+F[0][j+1]+F[0][j-1]-3.*F[0][j];
     LAPLACIANO[Nfilas-1][j]=F[Nfilas-2][j]+F[Nfilas-1][j+1]+F[Nfilas-1][j-1]-3.*F[Nfilas-1][j];
   }

   /** IMPLEMENTACIÓN COLUMNA IZQUIERDA Y DERECHA */
   for(int i=Nfilas-2;i>0;i--){
     LAPLACIANO[i][0]=F[i+1][0]+F[i-1][0]+F[i][1]-3.*F[i][0];
     LAPLACIANO[i][Ncolumnas-1]=F[i+1][Ncolumnas-1]+F[i-1][Ncolumnas-1]+F[i][Ncolumnas-2]-3.*F[i][Ncolumnas-1];
   }

   /** IMPLEMENTACIÓN ESQUINAS */
   LAPLACIANO[0][0]=F[1][0]+F[0][1]-2.*F[0][0];
   LAPLACIANO[0][Ncolumnas-1]=F[1][Ncolumnas-1]+F[0][Ncolumnas-2]-2.*F[0][Ncolumnas-1];
   LAPLACIANO[Nfilas-1][0]=F[Nfilas-2][0]+F[Nfilas-1][1]-2.*F[Nfilas-1][0];
   LAPLACIANO[Nfilas-1][Ncolumnas-1]=F[Nfilas-2][Ncolumnas-1]+F[Nfilas-1][Ncolumnas-2]-2.*F[Nfilas-1][Ncolumnas-1];

   return LAPLACIANO; /** DEVUELVE LA MATRIZ LAPLACIANA */
}



