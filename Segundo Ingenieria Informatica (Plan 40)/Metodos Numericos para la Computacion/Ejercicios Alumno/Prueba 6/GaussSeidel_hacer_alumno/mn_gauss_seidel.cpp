// Implementación del método de Gauss - Seidel
#include "mn_aritmeticas.h"
#include "mn_lapack.h"
#include <stdio.h.>


/******************************************************************************
  FUNCION QUE CALCULA LA SOLUCION DE UN SISTEMA POR EL METODO DE GAUSS-SEIDEL
  DEVUELVE EL NUMERO DE ITERACIONES REALIZADA. DEVUELVE WL Nº DE ITERACIONES
  SI TERMINA BIEN Y -1 SI TERMINA MAL
  EN LAS ITERACIONES SE ALTERNAN LA DIRECCION DE LOS RECORRIDOS AL ACTUALIZAR
  LAS INCOGNITAS
*******************************************************************************/
int mn_gauss_seidel (
const Array2D< real > &A, /// MATRIZ DEL SISTEMA
const Array1D< real > &b, /// VECTOR DE TÉRMINOS INDEPENDIENTES DEL SISTEMA
Array1D< real > &u,       /// VECTOR SOLUCION (DE ENTRADA ES UNA INICIALIZACIÓN)
const int nMax,           /// NÚMERO DE ITERACIONES MAXIMO
const real TOL)           /// TOLERANCIA PARA CONTROLAR LA CONVERGENCIA DEL ALGORITMO
{
  /// HACER ALUMNO

  ///cONTROL DE DIMENSIONES DE LOS ARRAYS QUE NOS PASAN Y DE LA DIAGONAL DE LA MATRIZ PARA LA RESOLUCIÓN DEL SISTEMA
    if(A.dim1()!=A.dim2() || A.dim1()!=b.dim() || b.dim()!=u.dim() || b.dim()==0){
        return -1;
    }
    for(int i=0; i<b.dim(); i++){
        if(A[i][i] == 0.){
            return -1;
        }
    }

    ///Iteración principal teniendo en cuenta el error
    real error;
    for(int i=1; i<=nMax; i++){
        error=0.;
        ///Recorremos la matriz y aplicamos la formula de resolución
        if(i%2==0){
            ///Aplicación por le lado de la izquierda del vector u
            for(int j=0; j<A.dim1(); j++){
                real suma=0;
                for(int k=0; k<A.dim1(); k++){
                    /// Decrementa según todos los anteriores
                    if(j!=k){
                        suma = suma - A[j][k]*u[k];
                    }
                }
                /// Aplicamos el algoritmo final
                suma = (suma + b[j])/A[j][j];
                error += mn_distancia(suma,u[j]);
                u[j] = suma;
            }
        } else {
            ///Aplicación por le lado de la derecha del vector u
            for(int j=A.dim1()-1; j>=0; j--){
                real suma=0;
                for(int k=0; k<A.dim1(); k++){
                    /// Decrementa según todos los anteriores
                    if(j!=k){
                        suma = suma - A[j][k] * u[k];
                    }
                }
                /// Aplicamos el algoritmo final
                suma = (suma + b[j])/A[j][j];
                error += mn_distancia(suma,u[j]);
                u[j] = suma;
            }
        }
        ///Ejecutamos salida si se cumple la condición de parada
        if(error/b.dim()<=TOL){
            return i;
        }
    }
    ///Si no se completa, retornamos -1;
    return 1;
}
