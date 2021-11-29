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
  /// CONTROL PARAMETROS
  if(A.dim1()!=A.dim2() || A.dim1()!=b.dim() || u.dim()!=b.dim() || b.dim()==0){
    return -1;
  }
  for(int k=0;k<b.dim();k++){
    if(A[k][k]==0.) return -1;
  }

  /// ITERACIONES ALGORITMO
  for(int n=1;n<=nMax;n++){
    real error=0.;
    if(n%2==0){
      for (int i=0;i<b.dim();i++){
        real suma=0;
        for(int j=0;j<b.dim();j++){
          if(i!=j) suma = suma - A[i][j]*u[j];
        }
        suma = (suma + b[i])/A[i][i];
        error+=mn_distancia(suma,u[i]);
        u[i] = suma;
      }
    }
    else{
      for (int i=b.dim()-1;i>=0;i--){
        real suma=0;
        for(int j=0;j<b.dim();j++){
          if(i!=j) suma = suma - A[i][j]*u[j];
        }
        suma = (suma + b[i])/A[i][i];
        error+=mn_distancia(suma,u[i]);
        u[i] = suma;
      }
    }
    if (error/b.dim()<=TOL){  return n;}
  }
  return -1;
}
