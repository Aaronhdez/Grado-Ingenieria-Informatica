/* Funciones para la resolución de un sistema matricial por el método de Cholesky */

#include "mn_cholesky.h"
#include "mn_lapack.h"
#include <stdlib.h>
#include <stdio.h>

/* FUNCION PARA CALCULAR EL DETERMINANTE DE UNA MATRIZ POR LA FACTORIZACION DE CHOLESKY. 
SE CALCULA LA FACTORIZACION DE CHOLESKY 

            A=B*B^T 

Y SE UTILIZA LA PROPIEDAD DE QUE 

        determinante(A)=determinante(B)*determinante(B^T)

Y QUE EL DETERMINANTE DE UNA MATRIZ TRIANGULAR ES EL PRODUCTO DE LOS ELEMENTOS DE LA DIAGONAL.
ES DECIR : 

    determinante(B) = determinante(B^T) = B[0][0]*B[1][1]*B[2][2]*.......

*/
real mn_determinante_factorizacion_cholesky(Array2D< real > &A)
{
  Array2D< real > B = mn_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
  if (B.dim1()==0) return (-1.);
  
  //HACER ALUMNO
  
}


/* FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR INFERIOR. LA MATRIZ T SE SUPONE
QUE TIENE CEROS DE LA DIAGONAL HACIA ARRIBA. EL TERMINO INDEPENDIENTE DEL 
SISTEMA ES b Y LA SOLUCION SE DEVUELVE RETORNANDO UN VECTOR v */
Array1D< real > mn_descenso (Array2D< real > &T, Array1D< real > &b)
{
   int i,j;
   if(T.dim1()!=T.dim2() || T.dim1()!=b.dim() ) return(Array1D< real >());
   int N=T.dim1();
   Array1D< real > v(N); // vector donde se retorna la solución 

  //HACER ALUMNO
  
}

/* FUNCION PARA RESOLVER UN SISTEMA TRIANGULAR SUPERIOR. LA MATRIZ T SE SUPONE
QUE TIENE CEROS DE LA DIAGONAL HACIA ABAJO. EL TERMINO INDEPENDIENTE DEL 
SISTEMA ES b Y LA SOLUCION SE DEVUELVE RETORNANDO UN VECTOR v */
Array1D< real > mn_remonte (Array2D< real > &T, Array1D< real > &b)
{
   int i,j;
   if(T.dim1()!=T.dim2()  || T.dim1()!=b.dim() ) return(Array1D< real >());
   int N=T.dim1();
   Array1D< real > v(N);

   //HACER ALUMNO
}



/* Función que calcula las matrices de descomposición de Cholesky. Se implementa
   en una sola matriz pues se trata de una matriz triangular inferior y su inversa */
Array2D< real > mn_cholesky_factorization(Array2D< real > &A)
{
   int i,j,k;
   if(A.dim1()!=A.dim2() ) return( Array2D< real >());
   int N=A.dim1();

   Array2D< real > B(N,N); // definimos la matriz de CHOLESKY

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



// FUNCION PARA RESOLVER UN SISTEMA POR EL METODO DE CHOLESKY
Array1D< real > mn_cholesky (Array2D< real > &A, Array1D< real > &b)
{
    int c;
    int N=A.dim1();
    Array2D< real > CH = mn_cholesky_factorization (A); /*Calculamos la matriz de Cholesky */
    if (CH.dim1()==0) return (Array1D< real >() );
    Array1D< real > z=mn_descenso (CH,b); /* Vector donde devolverá la solución de la triangular inferior */
    if (z.dim()==0) return (Array1D< real >() );
    Array1D< real > u = mn_remonte (CH,z);
    if (u.dim()==0) return (Array1D< real >() );
    return(u);

}

