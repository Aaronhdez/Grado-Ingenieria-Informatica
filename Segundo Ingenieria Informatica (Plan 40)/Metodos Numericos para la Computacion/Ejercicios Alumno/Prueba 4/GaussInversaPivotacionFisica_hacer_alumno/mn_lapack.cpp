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




  /// SE IMPRIME LA MATRIZ A TRIANGULARIZADA. LA MATRIZ DE TÉRMINOS INDEPENDIENTES B Y LA MATRIZ INVERSA
  A.print("TRIANGULACION MATRIZ ORIGINAL (ALUMNO)");
  B.print("MATRIZ DE TERMINOS INDEPENDIENTES (ALUMNO)");
  Mi.print("MATRIZ INVERSA (ALUMNO)");


  return(Mi);
}















