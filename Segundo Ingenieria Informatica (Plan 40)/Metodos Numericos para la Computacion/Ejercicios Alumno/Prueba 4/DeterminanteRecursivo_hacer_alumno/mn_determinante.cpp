/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_determinante.h"
#include <stdlib.h>
#include <stdio.h>

/// CÁLCULO DEL DETERMINANTE DE UNA MATRIZ USANDO UN ALGORITMO RECURSIVO
/// DESARROLLANDO EL DETERMINANTE POR LA PRIMERA FILA
/// DEVUELVE 0 SI LA MATRIZ ESTÁ VACÍA O NO ES CUADRADA
real mn_determinante_recursivo(Array2D< real > &A)
{
  /// HACER ALUMNO
    if(A.dim1() == 0){
       return 0;
    }
    if(A.dim1() == 1){
        return A[0][0];
    }
  /// SI n>1
    real determinante = 0;
    if(A.dim1()>1){
        for(int i=0; i<A.dim1();i++){
            Array2D< real > B(A.dim1()-1,A.dim1()-1);
            for(int j=0; j<B.dim1(); j++){
                for(int k=0; k<B.dim1();k++){
                    if(k<i){
                        B[j][k] = A[j+1][k];
                    } else {
                        B[j][k] = A[j+1][k+1];
                    }
                }
            }
            ///Multiplicamso el resultado del determinante cmabiando el signo en los terminos impares
            if(i%2==0){
                determinante += A[0][i]*mn_determinante_recursivo(B);
            } else {
                determinante -= A[0][i]*mn_determinante_recursivo(B);
            }
        }
    }
    return determinante;
}

