/*========================================================================
  FUNCIONES RELACIONADAS CON LA RESOLUCION DE SISTEMAS DE ECUACIONES
  ======================================================================== */

// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "mn_lapack.h"

/** FUNCION PARA RESOLVER SISTEMAS POR EL METODO DE GAUSS CON PIVOTACIÓN FÍSICA
    DEVUELVE EL VECTOR SOLUCIÓN DEL SISTEMA SI TERMINA BIEN
    DEVUELVE UN VECTOR VACÍO EN CASO DE ERROR
    LA FUNCIÓN MODIFICA A Y b PARA OBTENER UN SISTEMA TRIANGULAR*/
Array1D< real > mn_gauss(
  Array2D< real > &A  /** MATRIZ DEL SISTEMA */,
  Array1D< real > &b) /** VECTOR DE TERMINOS INDEPENDINENTES */
{
  /** HACER ALUMNO */

  /** COMPROBAMOS LAS DIMENSIONES DE LA MATRIZ Y EL VECTOR */
  if(A.dim1()!=A.dim2() || A.dim1()!=b.dim() || b.dim()==0) return Array1D<real>();

  /** DECLARAMOS EL VECTOR SOLUCIÓN QUE SE DEVUELVE SI TERMINA BIEN */
  Array1D< real > u(b.dim()); // vector con la solución que se devuelve

  /** APLICAMOS EL METODO DE GAUSS */
  for(int k=0;k<b.dim()-1;k++){
    /** DETECTAMOS EL MAXIMO DE LA DIAGONAL HACIA ABAJO */
    real max=fabs(A[k][k]);
    int kmax=k;
    for(int m=k+1;m<b.dim();m++){
      if(fabs(A[m][k])>max){
        max=fabs(A[m][k]);
        kmax=m;
      }
    }
    /// COMPROBAMOS SI EL MAXIMO DE LA DIAGONAL ES 0
    if(A[kmax][k]==0.) return Array1D<real>();
    /// HACEMOS EL PIVOTEO
    if(kmax!=k){
      for(int j=k;j<b.dim();j++){
        real paso=A[k][j];
        A[k][j]=A[kmax][j];
        A[kmax][j]=paso;
      }
      real paso=b[kmax];
      b[kmax]=b[k];
      b[k]=paso;
    }
    /** CONVERTIMOS EN 0 DE LA DIAGONAL HACIA ABAJO */
    for(int j=k+1;j<b.dim();j++){
          real mul= -A[j][k]/A[k][k];
          A[j][k]=0.;
          for(int n=k+1;n<b.dim();n++)
            A[j][n]+=mul*A[k][n];
            b[j]+=mul*b[k];
    }
  }

  /** REMONTE */
  if(A[b.dim()-1][b.dim()-1]==0.){
    if(b[b.dim()-1]!=0) return Array1D<real>();
    else u[b.dim()-1]=1.;
  }
  else{
    u[b.dim()-1]=b[b.dim()-1]/A[b.dim()-1][b.dim()-1];
  }
  for(int k=b.dim()-2;k>=0;k--)
  {
     real sum=0;
     for(int l=k+1;l<b.dim();l++)
        sum+= A[k][l]*u[l];
     u[k]=(b[k]-sum)/A[k][k];
  }

  return(u);
}



/* FUNCION PARA LEER UN VECTOR DE DISCO. RETORNA LA DIMENSION DEL VECTOR */
int mn_leer_vector(
  char *nombrefichero,
   Array1D< real > &vector)
{
  int dimension;
  float paso;
  FILE *f;

  // ABRIMOS EL FICHERO
  if(f=fopen( nombrefichero, "r"),!f){
    printf("Problema con la apertura del fichero\n");
    return -1;
  }

  // LEEMOS LA DIMENSION
  fscanf(f,"%d\n",&dimension);
  if(dimension<1) return(-2);

  // COGEMOS MEMORIA
   Array1D< real > v(dimension);

  // LEEMOS EL VECTOR
  for(int i=0;i<dimension;i++){
    fscanf(f,"%f\n",&paso);
    v[i]=paso;
  }
  fclose(f);
  vector=v.copy();
  return dimension;
}

/* FUNCION PARA ESCRIBIR UN VECTOR DE DISCO DE DIMENSION dimension Y LO ALMACENA EN vector */
int mn_escribir_vector(
  char *nombrefichero,
   Array1D< real > &vector)
{
  int i;
  FILE *f;
  int dimension=vector.dim();
  if(f=fopen( nombrefichero, "w"),!f){
    printf("Problema con la escritura del fichero\n");
    return 1;
  }
  fprintf(f,"%d\n",dimension);
  for(i=0;i<dimension;i++) fprintf(f,"%f\n",(float) vector[i]);
  fclose(f);
  return 0;
}

///* FUNCION PARA LEER UNA MATRIZ DE DISCO DE DIMENSION dimension Y LO ALMACENA EN LA MATRIZ matriz  */
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

  /// RESERVAMOS MEMORIA PARA LA MATRIZ
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

///* FUNCION PARA ESCRIBIR UNA MATRIZ EN DISCO */
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












