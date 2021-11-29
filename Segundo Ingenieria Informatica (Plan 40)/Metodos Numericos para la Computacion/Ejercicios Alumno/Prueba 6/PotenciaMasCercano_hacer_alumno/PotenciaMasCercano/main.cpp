#include "../mn_aritmeticas.h"
#include "../mn_lapack.h"

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



int main()
{

  int Nmax=10000; // NUMERO MAXIMO DE ITERACIONES
  real TOL=1e-8; // TOLERANCIA PARA LA CONVERGENCIA
  real l_min=2.; // AUTOVALOR INICIALIZADO
  Array1D< real >  u(3,1.); // AUTOVECTOR INICIALIZADO A 1

  printf("Ejemplo 1\n");
  // LEEMOS E IMPRIMIMOS MATRIZ EJEMPLO
  Array2D< real >  A; // MATRIZ DE EJEMPLO
  int N=mn_leer_matriz("A1.txt",A);
  printf("La matriz de ejemplo es :\n");
  A.print("A");
  printf("El autovalor inicial es : %lf\n\n",l_min);

  // CALCULAMOS EL AUTOVECTOR MAS CERCANO A l_min POR EL METODO DE LA POTENCIA Y COMPROBAMOS LOS RESULTADOS
  int Niter=mn_metodo_potencia(A,u,l_min,Nmax,TOL);
  if(Niter<0){
    printf("El metodo no ha funcionado. Ha salido con codigo de error\n");
    system("pause");
    return(0);
  }
  printf("el numero de iteraciones realizadas por el alumno es %d \n\n",Niter);
  printf("el autovalor exacto es 3. El calculado por el alumno es %1.4lf\n\n",l_min);
  printf("el autovector  exacto es :\n%lf \n%lf \n%lf \n\n",0.,0.707107,0.707107);
  printf("el autovector  calculado por el alumno es\n");
  u.print("u");

  printf("\nEjemplo 2\n");
  system("pause");

  // AHORA CAMBIAMOS EL SIGNO A LA MATRIZ PARA QUE LOS AUTOVALORES SALGAN NEGATIVOS
  // Y VOLVEMOS A APLICAR EL METODO
  l_min=5.5;
  N=mn_leer_matriz("A1.txt",A);
  //A=A*(-1);
  u=1;
  printf("La matriz del ejmplo es :\n");
  A.print("A");
  printf("El autovalor inicial es : %lf\n\n", l_min);

  // CALCULAMOS EL AUTOVECTOR MAXIMO POR EL METODO DE LA POTENCIA Y COMPROBAMOS LOS RESULTADOS
  Niter=mn_metodo_potencia(A,u,l_min,Nmax,TOL);
  if(Niter<0){
    printf("El metodo no ha funcionado. Ha salido con código de error\n");
    system("pause");
    return(0);
  }
  printf("el numero de iteraciones realizadas por el alumno es %d \n\n",Niter);
  printf("el autovalor exacto es 5 El calculado por el alumno es %1.4lf\n\n",l_min);
  printf("el autovector exacto es :\n%lf \n%lf \n%lf \n\n",0.816497,0.408248,0.408248);
  printf("el autovector calculado por el alumno es\n");
  u.print("u");
  system("pause");

}




