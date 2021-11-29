/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_determinante.h"
#include <stdlib.h>
#include <stdio.h>

/// CÁLCULO DEL DETERMINANTE DE UNA MATRIZ USANDO UN ALGORITMO RECURSIVO
/// DESARROLLANDO EL DETERMINANTE POR LA PRIMERA FILA
/// DEVUELVE 0 SI LA MATRIZ ESTÁ VACÍA O NO ES CUADRADA
real mn_determinante_recursivo(Array2D< real > &A)
{
  /// COMPROBAMOS PARÁMETRO DE ENTRADA
  if(A.dim1()==0 || A.dim1()!=A.dim2()) return 0.;
  if(A.dim1()==1) return A[0][0];

  /// RECORREMOS LA PRIMERA FILA DE LA MATRIZ
  /// Y VAMOS CALCULANDO EL DETERMINANTE DE FORMA RECURSIVA
  real determinante=0.;
  for(int k=0;k<A.dim1();k++){
    Array2D< real > B(A.dim1()-1,A.dim1()-1);
    for(int i=0;i<B.dim1();i++){
      for(int j=0;j<B.dim1();j++){
        if(j<k) B[i][j]=A[i+1][j];
        else  B[i][j]=A[i+1][j+1];
      }
    }
    if(k%2==0) determinante+=A[0][k]*mn_determinante_recursivo(B);
    else determinante-=A[0][k]*mn_determinante_recursivo(B);
  }
  return determinante;
}

