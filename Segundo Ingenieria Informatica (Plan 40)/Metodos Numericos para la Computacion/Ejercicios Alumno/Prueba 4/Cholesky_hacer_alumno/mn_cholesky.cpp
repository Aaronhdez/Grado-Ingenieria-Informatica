/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_cholesky.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/** Función que calcula las matrices de descomposición de Cholesky. Se almacena en una
   sola matriz B y B^T pues se trata de una matriz triangular inferior y su traspuesta */
Array2D< real > mn_cholesky_factorization(const Array2D< real > &A)
{
   /// HACER ALUMNO
   ///Aplicamos el cálculo de la forma de choleski
   ///Revisamos que ka natriz sea cuadrada. Si cholesky no da problemas, será simétrica
   if(A.dim1() != A.dim2() || A.dim1() == 0){
        return Array2D<real>();
   }
   ///Creamos la matriz de cholesky
   Array2D <real> B(A.dim1(),A.dim2());
   int i,j,k;

   ///Iteración principal
   for(int i=0; i<B.dim1(); i++){
        ///calculamos el valor de la diagonal
        real Sum = 0;
        for(int k=0;k<i;k++){
            Sum += (B[i][k]*B[i][k]);
        }
        if(A[i][i] < Sum){
            printf("raiz negativa");
            return Array2D<real>();
        }
        B[i][i] = sqrt(A[i][i]-Sum);

        ///Ahora calculamos el valor de cada uno de los elementos de la columna
        for(int j=i+1; j<A.dim1(); j++){
            Sum = 0;
            if(B[i][i] == 0){
                printf("división infinito");
                return Array2D<real>();
            }
            for(int k=0; k<i; k++){
                Sum += (B[j][k]*B[i][k]);
            }
            B[j][i] = (A[j][i]-Sum)/B[i][i];
            /// Replicamos el valor en la POSICION simetrica
            B[i][j] = B[j][i];
        }
   }
   return B;
}

/// FUNCION PARA RESOLVER UN SISTEMA POR EL METODO DE CHOLESKY
Array1D< real > mn_cholesky (const Array2D< real > &A, const Array1D< real > &b)
{
    /// HACER ALUMNO
    ///Verificamos que sea cuadrada y simetrica
    if(A.dim1() != A.dim2() || A.dim1() == 0){
        return Array1D<real>();
    }
    Array2D<real>CH = mn_cholesky_factorization(A);
    if(CH.dim1()==0){
        return Array1D <real>();
    }
    ///Creamos el primer vector z ===> B*z=b
    Array1D<real>z = mn_descenso(CH,b);
    if(z.dim1()==0){
        return Array1D <real>();
    }
    ///Creamos el vector u resultante ---> Bt*u=z
    Array1D<real>u = mn_remonte(CH,z);
    if(z.dim1()==0){
        return Array1D <real>();
    }
    return u;
}

/// FUNCION PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ POR LA FACTORIZACION DE CHOLESKY
/// ESTA FUNCIÓN UTILIZA QUE SI A=B*B^T ENTONCES |A|=|B|*|B| Y QUE ADEMÁS EL DETERMINANTE
/// DE UNA MATRIZ TRIANGULAR ES EL PRODUCTO DE LA DIAGONAL
real mn_determinante_factorizacion_cholesky(const Array2D< real > &A)
{
  /// HACER ALUMNO
    ///
    Array2D<real>CH = mn_cholesky_factorization(A);
    ///Si la dimensión de la factorizada es 0, salimos
    if(CH.dim1()==0){
        return 0;
    }
    double determinante = 1.;
    ///El resultado del determinante viene dado por la diagonal princiupal
    for(int i=0; i<CH.dim1(); i++){
        determinante*=CH[i][i];
    }
    return determinante*determinante;
}


// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR INFERIOR
Array1D< real > mn_descenso (const Array2D< real > &B, const Array1D< real > &b)
{
   int i,j;
   if(B.dim1()!=B.dim2() || B.dim1()!=b.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > z(N);

   /// INICIAMOS EL DESCENSO
   for (i=0;i<N;i++){
      if (B[i][i]==0) { /// comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      z[i]=b[i]; /// inicializamos la solucion
      for (j=0;j<i;j++){ /// aplicamos la formula para calcular la solucion
         z[i]=z[i] - B[i][j]*z[j];
      }
      z[i]=z[i]/B[i][i];
  }
  return(z);
}

/// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR SUPERIOR
Array1D< real > mn_remonte (const Array2D< real > &B, const Array1D< real > &z)
{
   int i,j;
   if(B.dim1()!=B.dim2()  || B.dim1()!=z.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > DU(N);

   /// INICIAMOS EL REMONTE
   for (i=N-1;i>=0;i--){
      if (B[i][i]==0){  /// comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      DU[i]=z[i]; /// inicializamos la solucion
      for  (j=i+1;j<N;j++){ /// aplicamos la formula para calcluar la solucion
         DU[i]=DU[i] - B[i][j]*DU[j];
      }
      DU[i]=DU[i]/B[i][i];
  }
  return(DU);
}





