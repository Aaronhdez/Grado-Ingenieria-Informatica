/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_cholesky.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/* Función que calcula las matrices de descomposición de Cholesky. Se implementa
   en una sola matriz pues se trata de una matriz triangular inferior y su inversa */
Array2D< real > mn_cholesky_factorization(const Array2D< real > &A)
{
   int i,j,k;
   if(A.dim1()!=A.dim2() ) return( Array2D< real >());
   int N=A.dim1();

   Array2D< real > B(N,N); // definimos la matriz de CHOLESKY

   // HACER ALUMNO
   for (i=0;i<N;i++){
      real Sum = 0.;
      for (k=0;k<i;k++){  /* Sumatorio de B[i][i] */
         Sum = Sum + B[i][k]*B[i][k];
      }
      if (A[i][i]< Sum)
      {
         printf ("raiz de numero negativo en el metodo de Cholesky \n\n");
         return( Array2D< real >());
      }
      B[i][i]=sqrt(A[i][i]-Sum);

      for  (j=i+1;j<N;j++){ /* Calculamos Elementos de la parte no diagonal de B */
	     Sum = 0;
         if (B[i][i]==0){
            printf ("Division por cero en el metodo de Cholesky\n\n");
            return( Array2D< real >()); // se devuelve una matriz vacía
         }
         for (k=0;k<i;k++){
            Sum = Sum + B[j][k]*B[i][k];
         }
         B[j][i]=(A[j][i]-Sum)/B[i][i];
         B[i][j]= B[j][i]; // hacemos la matriz simetrica para guardar en la misma matriz B y B traspuesta
      }
   }
   return( B );
}


// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR INFERIOR
Array1D< real > mn_descenso (const Array2D< real > &B, const Array1D< real > &b)
{
   int i,j;
   if(B.dim1()!=B.dim2() || B.dim1()!=b.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > z(N);

   // HACER ALUMNO

   // INICIAMOS EL DESCENSO
   for (i=0;i<N;i++){
      if (B[i][i]==0) { // comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      z[i]=b[i]; // inicializamos la solucion
      for (j=0;j<i;j++){ // aplicamos la formula para calcular la solucion
         z[i]=z[i] - B[i][j]*z[j];
      }
      z[i]=z[i]/B[i][i];
  }
  return(z);
}

// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR SUPERIOR
Array1D< real > mn_remonte (const Array2D< real > &B, const Array1D< real > &z)
{
   int i,j;
   if(B.dim1()!=B.dim2()  || B.dim1()!=z.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > DU(N);

   // HACER ALUMNO

   // INICIAMOS EL REMONTE
   for (i=N-1;i>=0;i--){
      if (B[i][i]==0){  // comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      DU[i]=z[i]; // inicializamos la solucion
      for  (j=i+1;j<N;j++){ // aplicamos la formula para calcluar la solucion
         DU[i]=DU[i] - B[i][j]*DU[j];
      }
      DU[i]=DU[i]/B[i][i];
  }
  return(DU);
}


// FUNCION PARA RESOLVER UN SISTEMA POR EL METODO DE CHOLESKY
Array1D< real > mn_cholesky (const Array2D< real > &A, const Array1D< real > &b)
{
    // HACER ALUMNO
    int N=A.dim1();
    Array2D< real > CH = mn_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
    if (CH.dim1()==0) return (Array1D< real >() );
    Array1D< real > z=mn_descenso (CH,b); /* Vector donde devolverá la solución de la triangular inferior */
    if (z.dim()==0) return (Array1D< real >() );
    Array1D< real > u = mn_remonte (CH,z);
    if (u.dim()==0) return (Array1D< real >() );
    return(u);

}

// FUNCION PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ POR LA FACTORIZACION DE CHOLESKY
// ESTA FUNCIÓN UTILIZA QUE SI A=B*B^T ENTONCES |A|=|B|*|B| Y QUE ADEMÁS EL DETERMINANTE
// DE UNA MATRIZ TRIANGULAR ES EL PRODUCTO DE LA DIAGONAL
real mn_determinante_factorizacion_cholesky(const Array2D< real > &A)
{
  // HACER ALUMNO
  Array2D< real > CH = mn_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
  if (CH.dim1()==0) return (-1.);
  double determinante=1.;
  for(int i=0;i<CH.dim1();i++){
    determinante*=CH[i][i];
  }
  return(determinante*determinante);
}
