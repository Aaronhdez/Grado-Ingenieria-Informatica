/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "an_cholesky.h"
#include "an_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/* Función que calcula las matrices de descomposición de Cholesky. Se implementa
   en una sola matriz pues se trata de una matriz triangular inferior y su inversa */
Array2D< real > an_cholesky_factorization(Array2D< real > &A)
{
   int i,j,k;
   if(A.dim1()!=A.dim2() ) return( Array2D< real >());
   int N=A.dim1();

   Array2D< real > B(N,N); // definmos la matriz de CHOLESKY

   // APLICAMOS EL ALGORITMO DE CHOLESKY
   for (i=0;i<N;i=i+1){
      real Sum = 0.;
      for (k=0;k<=(i-1);k=k+1){  /* Sumatorio de B[i][i] */
         Sum = Sum + (B[i][k])*(B[i][k]);
      }
      if (A[i][i]< Sum)
      {
         printf ("La matriz no esta definida positiva\n\n");
         return( Array2D< real >());
      }
      B[i][i]=sqrtl((long double) A[i][i]-Sum);

      for  (j=i+1;j<N;j=j+1){ /* Calculamos Elementos de la parte no diagonal de B */
	     Sum = 0;
         if (B[i][i]==0){
            printf ("Ha ocurrido un error en la ejecucion de la factorizacion\n\n");
            return( Array2D< real >());
         }
         for (k=0;k<=(i-1);k=k+1){
            Sum = Sum + (B[j][k]*(B[i][k]));
         }
         B[j][i]=(1/(B[i][i]))*((A[j][i])-Sum);
         B[i][j]= B[j][i]; // hacemos la matriz simetrica para guardar en la misma matriz B y B traspuesta
      }
   }
   return( B );
}


// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR INFERIOR
Array1D< real > an_descenso (Array2D< real > &B, Array1D< real > &b)
{
   int i,j;
   if(B.dim1()!=B.dim2() || B.dim1()!=b.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > z(N);

   // INICIAMOS EL DESCENSO
   for (i=0;i<N;i=i+1){
      if (B[i][i]==0) { // comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      z[i]=b[i]; // inicializamos la solucion
      for (j=0;j<i;j=j+1){ // aplicamos la formula para calcluar la solucion
         z[i]=z[i] - B[i][j]*z[j];
      }
      z[i]=z[i]/B[i][i];
  }
  return(z);
}

// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR SUPERIOR
Array1D< real > an_remonte (Array2D< real > &B, Array1D< real > &z)
{
   int i,j;
   if(B.dim1()!=B.dim2()  || B.dim1()!=z.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > DU(N);

   // INICIAMOS EL REMONTE
   for (i=N-1;i>=0;i=i-1){
      if (B[i][i]==0){  // comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      DU[i]=z[i]; // inicializamos la solucion
      for  (j=i+1;j<N;j=j+1){ // aplicamos la formula para calcluar la solucion
         DU[i]=DU[i] - B[i][j]*DU[j];
      }
      DU[i]=DU[i]/B[i][i];
  }
  return(DU);
}


// FUNCION PARA RESOLVER UN SISTEMA POR EL METODO DE CHOLESKY
Array1D< real > an_cholesky (Array2D< real > &A, Array1D< real > &b)
{
    int c;
    int N=A.dim1();
    Array2D< real > CH = an_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
    if (CH.dim1()==0) return (Array1D< real >() );
    Array1D< real > z=an_descenso (CH,b); /* Vector donde devolverá la solución de la triangular inferior */
    if (z.dim()==0) return (Array1D< real >() );
    Array1D< real > u = an_remonte (CH,z);
    if (u.dim()==0) return (Array1D< real >() );
    return(u);

}

// FUNCION PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ POR LA FACTORIZACION DE CHOLESKY
real an_determinante_factorizacion_cholesky(Array2D< real > &A)
{
  Array2D< real > CH = an_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
  if (CH.dim1()==0) return (-1.);
  double determinante=1.;
  for(int i=0;i<CH.dim1();i=i+1){
    determinante*=CH[i][i];
  }
  return(determinante*determinante);
}
