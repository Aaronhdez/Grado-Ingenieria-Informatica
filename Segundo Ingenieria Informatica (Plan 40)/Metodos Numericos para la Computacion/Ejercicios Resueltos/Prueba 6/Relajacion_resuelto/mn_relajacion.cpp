// Implementación del método de Gauss - Seidel
#include "mn_aritmeticas.h"
#include "mn_lapack.h"
#include "mn_relajacion.h"
#include <stdio.h.>


/******************************************************************************
  FUNCION QUE CALCULA LA SOLUCION DE UN SISTEMA POR EL METODO DE RELAJACIÓN
  DEVUELVE EL NUMERO DE ITERACIONES REALIZADA.
*******************************************************************************/
int mn_relajacion (
const Array2D< real > &A, // MATRIZ DEL SISTEMA
const Array1D< real > &b, // VECTOR DE TÉRMINOS INDEPENDIENTES DEL SISTEMA
Array1D< real > &u,       // VECTOR SOLUCION (DE ENTRADA ES UNA INICIALIZACIÓN)
const int nMax,           // NÚMERO DE ITERACIONES MAXIMO
const real TOL,           // TOLERANCIA PARA CONTROLAR LA CONVERGENCIA DEL ALGORITMO
const real w)             // PARÁMETRO DE RELAJACIÓN
{
    if(A.dim1()!=A.dim2() || A.dim1()!=b.dim() || u.dim()!=b.dim() || b.dim()==0){
     return -1;
    }
    for(int k=0;k<b.dim();k++){
      if(A[k][k]==0) return -1;
    }

    // HACER ALUMNO
    // UTILIZAR LA FUNCION mn_error_vectores() PARA CALCULAR EL ERROR ENTRE 2 ITERACIONES
    for(int n=1;n<nMax;n++)
    {
       real error=0;
       for (int i=0;i<b.dim();i++)
       {
           real suma=0;
           for(int j=0;j<b.dim();j++)
           {
              if(i!=j)
              {
                 suma = suma - A[i][j]*u[j];
              }
           }
           suma = w*(suma + b[i])/A[i][i]+(1-w)*u[i];
           error+=mn_distancia(suma,u[i]);
           u[i] = suma;
       }
       if (error/b.dim()<=TOL){  return n;}
    }
    return -1;
}


