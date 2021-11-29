/*========================================================================
  FUNCIONES RELACIONADAS CON LA RESOLUCION DE SISTEMAS DE ECUACIONES
  ======================================================================== */

// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "mn_lapack.h"

/** FUNCION PARA CALCULAR LA INVERSA DE UNA MATRIZ POR EL METODO DE GAUSS CON PIVOTACIÓN
    DEVUELVE LA MATRIZ INVERSA SI TERMINA BIEN EN CASO CONTRARIO DEVUELVE UNA MATRIZ VACÍA
*/
Array2D< real > mn_gauss_inversa(
const Array2D< real > &A  /** MATRIZ  */)
{
  /** COMPROBAMOS LAS DIMENSIONES DE LA MATRIZ */
  if(A.dim1()!=A.dim2() || A.dim1()==0) return Array2D<real>();

  /**  HACEMOS UNA COPIA DE A PARA MODIFICARLA Y CONVERTIRLA EN TRIANGULAR*/
  Array2D< real > Acopy=A.copy();

  /** DECLARAMOS LA MATRIZ B DE TERMINOS INDEPENDIENTES  Y LA INICIALIZAMOS A LA IDENTIDAD */
  Array2D< real > B(A.dim1(),A.dim2());
  for(int k=0;k<A.dim1();k++){
    for(int l=0;l<A.dim2();l++){
      B[k][l]=0.;
    }
    B[k][k]=1.;
  }

  /** DECLARAMOS LA MATRIZ A_1 DONDE SE DEVUELVE LA MATRIZ INVERSA SI TODO VA BIEN */
  Array2D< real > A_1(A.dim1(),A.dim2());

  /** DECLARAMOS EL VECTOR PARA GESTIONAR EL PIVOTEO */
  Array1D<int> piv(A.dim1());

  /** HACER ALUMNO */

  /** INICIALIZAMOS EL VECTOR DEL PIVOTE */
  for(int k=0;k<A.dim1();k++) piv[k]=k;

  /** CONVERTIMOS EL SISTEMA EN UNO TRIANGULAR USANDO EL METODO DE GAUSS */
  for(int k=0;k<A.dim1();k++){
    /** DETECTAMOS EL MAXIMO DE LA DIAGONAL HACIA ABAJO */
    real max=fabs(Acopy[piv[k]][k]);
    int kmax=k;
    for(int m=k+1;m<A.dim1();m++){
      if(fabs(Acopy[piv[m]][k])>max){
        max=fabs(Acopy[piv[m]][k]);
        kmax=m;
      }
    }
    /** CAMBIAMOS EL PIVOTE SI FUERA NECESARIO */
    if(kmax!=k){
      int paso=piv[kmax];
      piv[kmax]=piv[k];
      piv[k]=paso;
    }
    /** CONVERTIMOS EN 0 DE LA DIAGONAL HACIA ABAJO */
    for(int j=k+1;j<A.dim1();j++){
          real mul=-Acopy[piv[j]][k]/Acopy[piv[k]][k];
          Acopy[piv[j]][k]=0.;
          for(int n=k+1;n<A.dim1();n++) Acopy[piv[j]][n]+=mul*Acopy[piv[k]][n];
          for(int n=0;n<A.dim1();n++) B[piv[j]][n]+=mul*B[piv[k]][n];
    }
  }

  /** REMONTE PARA CALCULAR TODOS LOS ELEMENTOS DE LA MATRIZ A_1 POR COLUMNAS A PARTIR DE B*/
  for(int k=A.dim1()-1;k>=0;k--){
    if(Acopy[piv[k]][k]==0.) return Array2D<real>();
    for(int n=0;n<A.dim1();n++){
      A_1[k][n]=B[piv[k]][n];
      for(int l=k+1;l<Acopy.dim1();l++)
        A_1[k][n]-= Acopy[piv[k]][l]*A_1[l][n];
      A_1[k][n]/=Acopy[piv[k]][k];
    }
  }


  /** IMPRIMIR Acopy y B PARA COMPROBAR SI SON CORRECTAS */
  printf("Matriz triangular que sale del proceso de GAUSS\n ");
  for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim1();j++){
      printf("%1.5lf ",Acopy[piv[i]][j]);
    }
    printf("\n");
  }
  printf("\n");
  printf("Matriz B que sale del proceso de GAUSS\n ");
  for(int i=0;i<B.dim1();i++){
    for(int j=0;j<B.dim1();j++){
      printf("%1.5lf ",B[piv[i]][j]);
    }
    printf("\n");
  }
  printf("\n");



  return(A_1);
}


// FUNCION PARA CALCULAR EL ERROR DEL SISTEMA
real mn_error_sistema(const Array2D< real > &A, const Array1D< real > &u, const Array1D< real > &b)
{
   int i;
   if(b.dim()==0 || b.dim()!=u.dim() || b.dim()!=A.dim1() ||  b.dim()!=A.dim2()) return(0.);
   Array1D< real > e=A*u-b;

   real Sum=0.;
   for (i=0;i<b.dim();i++){
      Sum = Sum + mn_abs(e[i])/(mn_abs(b[i])+ 1.);
   }
   return (Sum/b.dim());
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












