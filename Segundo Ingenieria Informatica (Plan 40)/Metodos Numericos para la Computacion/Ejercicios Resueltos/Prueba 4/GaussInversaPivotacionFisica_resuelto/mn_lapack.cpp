/*========================================================================
  FUNCIONES RELACIONADAS CON LA RESOLUCION DE SISTEMAS DE ECUACIONES
  ======================================================================== */

// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "mn_lapack.h"

/* FUNCION PARA LEER UNA MATRIZ DE DISCO DE DIMENSION
dimension Y LO ALMACENA EN LA MATRIZ matriz  */
int mn_leer_matriz(
  char *nombrefichero,
  Array2D< real > &matriz)
{
  int dimension1,dimension2;
  float paso;
  FILE *f;
  if(f=fopen( nombrefichero, "r"),!f){
    printf("Problema con la apertura del fichero\n");
    return 1;
  }
  fscanf(f,"%d %d\n",&dimension1, &dimension2);
  if(dimension1<1 || dimension2<1) return(-1);

  // RESERVAMOS MEMORIA PARA LA MATRIZ
  Array2D< real > m(dimension1,dimension2);

  for(int i=0;i<dimension1;i++){
    for(int j=0;j<dimension2;j++){

       fscanf(f,"%f ",&paso);
       m[i][j]=paso;
       //printf("paso=%e\n",(double) m[i][j]);
    }
    fscanf(f,"\n");
  }
  fclose(f);
  matriz=m.copy();
  return dimension1;
}

/* FUNCION PARA ESCRIBIR UNA MATRIZ EN DISCO
dimension */
int mn_escribir_matriz(
  char *nombrefichero,
  Array2D< real > &matriz)
{
  int i,j;
  FILE *f;
  if(f=fopen( nombrefichero, "w"),!f){
    printf("Problema con la escritura del fichero\n");
    return 1;
  }
  fprintf(f,"%d %d\n",matriz.dim1(),matriz.dim2());
  for(i=0;i<matriz.dim1();i++){
    for(j=0;j<matriz.dim2();j++){
       fprintf(f,"%f ",(float) matriz[i][j]);
    }
    fprintf(f,"\n");
  }
  fclose(f);
  return 0;
}






/** FUNCION PARA CALCULAR LA INVERSA DE UNA MATRIZ POR EL METODO DE GAUSS CON  PIVOTACIÓN
    FÍSICA. ES DECIR NO SE USA UN VECTOR PIV[] PARA GESTIONAR LA PIVOTACIÓN
    DEVUELVE LA MATRIZ INVERSA SI TERMINA BIEN EN CASO CONTRARIO DEVUELVE UNA MATRIZ VACÍA
*/
Array2D< real > mn_gauss_inversa(
const Array2D< real > &M  /** MATRIZ  */)
{

  /** COMPROBAMOS LAS DIMENSIONES DE LA MATRIZ */
  if(M.dim1()!=M.dim2() || M.dim1()==0) return Array2D<real>();

  /**  HACEMOS UNA COPIA DE LA MATRIZ ORIGINAL PARA MODIFICARLA Y CONVERTIRLA EN TRIANGULAR*/
  Array2D< real > A=M.copy();

  /** DECLARAMOS LA MATRIZ B DE TERMINOS INDEPENDIENTES  Y LA INICIALIZAMOS A LA IDENTIDAD */
  Array2D< real > B(A.dim1(),A.dim2());
  for(int k=0;k<A.dim1();k++){
    for(int l=0;l<A.dim2();l++){
      B[k][l]=0.;
    }
    B[k][k]=1.;
  }

  /** DECLARAMOS LA MATRIZ Mi DONDE SE DEVUELVE LA MATRIZ INVERSA SI TODO VA BIEN */
  Array2D< real > Mi(A.dim1(),A.dim2());

  /** HACER ALUMNO */

  /** CONVERTIMOS EL SISTEMA EN UNO TRIANGULAR USANDO EL METODO DE GAUSS */
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
    if(max==0.) return Array2D< real >();

    /** HACEMOS LA PIVOTACION SI FUERA NECESARIO */
    if(kmax!=k){
      for(int i=0;i<A.dim1();i++){
        double temp=A[k][i];
        A[k][i]=A[kmax][i];
        A[kmax][i]=temp;
        temp=B[k][i];
        B[k][i]=B[kmax][i];
        B[kmax][i]=temp;
      }
    }
    /** CONVERTIMOS EN 0 DE LA DIAGONAL HACIA ABAJO */
    for(int j=k+1;j<A.dim1();j++){
          real mul=-A[j][k]/A[k][k];
          A[j][k]=0.;
          for(int n=k+1;n<A.dim1();n++) A[j][n]+=mul*A[k][n];
          for(int n=0;n<A.dim1();n++) B[j][n]+=mul*B[k][n];
    }
  }

  /** REMONTE PARA CALCULAR TODOS LOS ELEMENTOS DE LA MATRIZ INVERSA POR COLUMNAS A PARTIR DE B*/
  for(int k=A.dim1()-1;k>=0;k--){
    for(int n=0;n<A.dim1();n++){
      Mi[k][n]=B[k][n];
      for(int l=k+1;l<A.dim1();l++){
        Mi[k][n]-= A[k][l]*Mi[l][n];
      }
      Mi[k][n]/=A[k][k];
    }
  }

  /// SE IMPRIME LA MATRIZ A TRIANGULARIZADA. LA MATRIZ DE TÉRMINOS INDEPENDIENTES B Y LA MATRIZ INVERSA
  A.print("TRIANGULACION MATRIZ ORIGINAL (ALUMNO)");
  B.print("MATRIZ DE TERMINOS INDEPENDIENTES (ALUMNO)");
  Mi.print("MATRIZ INVERSA (ALUMNO)");


  return(Mi);
}















