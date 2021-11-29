/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_factorizacion.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/* FUNCION PARA RESOLVER UN SISTEMA POR EL METODO DE FACTORIZACION LU. 
   PASO 1 : SE LLAMA A LA FUNCION mn_LU_factorizacion() PARA OBTENER L y U
   PASO 2 : RESOLVEMOS EL SISTEMA Lz=b UTILIZANDO mn_descenso() 
   PASO 3 : RESOLVEMOS EL SISTEMA Uu=z UTILIZANDO mn_remonte()
   PASO 4 : RETORNAMOS u
*/
Array1D< real > mn_LU (const Array2D< real > &A, const Array1D< real > &b)
{
    int k;
    int N=A.dim1();
    Array2D< real > L(N,N);
    Array2D< real > U(N,N);
    Array1D< real > z(N); 
    Array1D< real > u(N); 
    
    // FACTORIZAMOS LA MATRIZ A
    k=mn_LU_factorization(A,L,U);
    if(k==-1) return (Array1D< real >());
    z=mn_descenso (L,b); /* Vector donde devolverá la solución de la triangular inferior */
    if (z.dim()==0) return (Array1D< real >() );
    u = mn_remonte (U,z);
    if (u.dim()==0) return (Array1D< real >() );
    return(u);

}


/** Función que calcula la factorización LU de una matriz devuelve -1 si termina mal y 0 si termina bien.
La factorización se devuelve en la matrices de entrada salida L y U. a las matrices L y U se le asigna memoria
antes de entrar en la función.
**/
int mn_LU_factorization(const Array2D< real > &A,Array2D< real > &L,Array2D< real > &U){
   int i,j,k;
   int N=A.dim1();
   if(N!=A.dim2() || N!=L.dim1() || N!=L.dim2() || N!=U.dim1() || N!=U.dim2()) return(-1);

   // APLICAMOS EL ALGORITMO DE DESCOMPONER L y U
   L=0.;
   U=0.;
   for (i=0;i<N;i++){
     L[i][i]=1;
      real Sum = 0.;
      for (k=0;k<=(i-1);k++){  /* Sumatorio de B[i][i] */
         Sum = Sum + (L[i][k])*(U[k][i]);
      }
      U[i][i]=A[i][i]-Sum;
      if(U[i][i]==0.) return(-1); /* Comprobamos que test de salida */
      for  (j=i+1;j<N;j++){ /* Calculamos Elementos de la parte no diagonal de B */
	     Sum = 0;
       for (k=0;k<=(i-1);k++){
         Sum = Sum + (L[i][k]*(U[k][j]));
       }
       U[i][j]=A[i][j]-Sum;
       Sum = 0;
       for (k=0;k<=(i-1);k++){
         Sum = Sum + (L[j][k]*(U[k][i]));
       }
       L[j][i]=(A[j][i]-Sum)/U[i][i];
      }
   }
   return(0);
}



// FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR INFERIOR
Array1D< real > mn_descenso (const Array2D< real > &B, const Array1D< real > &b)
{
   int i,j;
   if(B.dim1()!=B.dim2() || B.dim1()!=b.dim() ) return(Array1D< real >());
   int N=B.dim1();
   Array1D< real > z(N);

   // INICIAMOS EL DESCENSO
   for (i=0;i<N;i++){
      if (B[i][i]==0) { // comprobamos que la diagonal es distinto de cero
         return(Array1D< real >());
      }
      z[i]=b[i]; // inicializamos la solucion
      for (j=0;j<i;j++){ // aplicamos la formula para calcluar la solucion
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

