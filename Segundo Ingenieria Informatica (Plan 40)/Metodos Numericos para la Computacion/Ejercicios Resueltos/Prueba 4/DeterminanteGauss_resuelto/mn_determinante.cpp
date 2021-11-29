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
  /// COMPROBAMOS PARÁMETRO DE ENTRADA
  if(M.dim1()==0 || M.dim1()!=M.dim2()) return 0.;

  /**  HACEMOS UNA COPIA DE LA MATRIZ ORIGINAL PARA MODIFICARLA Y CONVERTIRLA EN TRIANGULAR*/
  Array2D< real > A=M.copy();

  /** DECLARAMOS LA MATRIZ Mi DONDE SE DEVUELVE LA MATRIZ INVERSA SI TODO VA BIEN */
  Array2D< real > Mi(A.dim1(),A.dim2());

  /** VARIABLE DONDE SE ALMACENA Y DEVUELVE EL DETERMINANTE*/
  real determinante;

  /** HACER ALUMNO */

  /** CONVERTIMOS EL SISTEMA EN UNO TRIANGULAR USANDO EL METODO DE GAUSS */
  int Npiv=0;
  for(int k=0;k<A.dim1();k++){
    /** DETECTAMOS EL MAXIMO DE LA DIAGONAL HACIA ABAJO */
    real max=fabs(A[k][k]);
    int kmax=k;
    for(int m=k+1;m<A.dim1();m++){
      if(fabs(A[m][k])>max){
        max=fabs(A[m][k]);
        kmax=m;
      }
    }
    /// SI LA DIAGONAL SE ANULA SALIMOS
    if(max==0.) return 0.;

    /** HACEMOS LA PIVOTACION SI FUERA NECESARIO */
    if(kmax!=k){
      Npiv++;
      for(int i=0;i<A.dim1();i++){
        double temp=A[k][i];
        A[k][i]=A[kmax][i];
        A[kmax][i]=temp;
      }
    }
    /** CONVERTIMOS EN 0 DE LA DIAGONAL HACIA ABAJO */
    for(int j=k+1;j<A.dim1();j++){
          real mul=-A[j][k]/A[k][k];
          A[j][k]=0.;
          for(int n=k+1;n<A.dim1();n++) A[j][n]+=mul*A[k][n];
    }
  }

  /// CALCULAMOS EL DETERMINANTE DE LA MATRIZ TRIANGULAR
  determinante=1;
  for(int k=0;k<A.dim1();k++)
    determinante*=A[k][k];

  if(Npiv%2==1) determinante*=-1.;

  /// SE IMPRIME LA MATRIZ A TRIANGULARIZADA.
  A.print("TRIANGULACION MATRIZ ORIGINAL (ALUMNO)");

  return determinante;

}

