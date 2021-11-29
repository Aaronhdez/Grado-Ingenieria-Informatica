/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_determinante.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/// CÁLCULO DEL DETERMINANTE DE UNA MATRIZ USANDO UN ALGORITMO DEL
/// MÉTODO DE GAUSS PARA CONVERTIR A UNA MATRIZ EN TRIANGULAR USANDO PIVOTACIÓN FÍSIC
/// DEVUELVE 0 SI LA MATRIZ ESTÁ VACÍA O NO ES CUADRADA
real mn_determinante_Gauss(Array2D< real > &M)
{
  /// HACER ALUMNO
    /// Revisamos la dimensionalidad de la matriz M
    if(M.dim1() != M.dim2() || M.dim1() ==0){
        return 0.;
    }

    /// copiamos la matriz original
    /// Preparamos una matriz inversa por si todo va bien
    /// Reparamos el determinante resultante
    Array2D <real> A = M.copy();
    Array2D <real> Mi(A.dim1(),A.dim2());
    real determinante;

    /// Bajamos por la diagonal y pivotamos, a saber:
    int npiv=0;
    /// Generamos el primer elemento en el a[k][k] (primera esquina por arriba)
    for(int k=0;k<A.dim1();k++){
        real max=fabs(A[k][k]);
        int kmax=k;
        /// Recorremos la columna buscando algún otro valor que sea mayor o no que a[k][k]
        /// Si lo es, cambiamos el máximo
        for(int m=k+1;m<A.dim1();m++){
            if(fabs(A[m][k])>max){
                max = fabs(A[m][k]);
                kmax = m;
            }
        }
        /// Si el máximo es 0 después de filtrar salimos, porque el sistema no es resoluble (toda la columna es 0).
        if(max==0.){
            return 0.;
        }

        /// Luego hacemos el cambio si es necesario, comprobamos si kmax es diferente a k orginal
        /// Esto significa que la fila donde está el maximo NO es la fila 1
        /// Aumentamos el numero de pivotaciones;
        if(kmax != k){
            npiv++;
            for(int i=0; i<A.dim1();i++){
                double temp = A[k][i];
                A[k][i] = A[kmax][i];
                A[kmax][i] = temp;
            }
        }
        /// Recorremos la diagonal haciendo cero los elementos inferiores
        for(int j=k+1; j<A.dim1(); j++){
            real mul=-A[j][k]/A[k][k];
            A[j][k] = 0.;
            for(int n=k+1; n<A.dim1(); n++){
                A[j][n]+=mul*A[k][n];
            }
        }
    }

    /// Con la matriz triangularizada, calculamos el determinante por descenso
    determinante = 1.;
    for(int i=0; i<A.dim1(); i++){
        determinante*=A[i][i];
    }

    /// Verificamos que el numero de pivotaciones sea par, si no lo es, hay que invertir el determinante
    if(npiv%2 == 1){
        determinante = determinante*-1;
    }
    A.print("TRIANGULACION MATRIZ ORIGINAL (ALUMNO)");

    return determinante;









}

