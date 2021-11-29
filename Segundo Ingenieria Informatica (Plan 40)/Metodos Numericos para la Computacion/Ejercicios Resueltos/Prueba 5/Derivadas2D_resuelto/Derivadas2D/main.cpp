/* Procedimiento de prueba para el  uso del método de integración de Simpson */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_derivadas2D.h"
#include "../tnt_array/tnt.h"

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


int main()
{
   // DEFINIMOS LA FUNCIÓN F EN FORMA DE MATRIZ CON LA QUE VAMOS A TRABAJAR
   Array2D< real > F(9,7,0.);
   for(int i=0;i<9;i++){
     for(int j=0;j<7;j++){
        F[i][j]=9*exp(-0.1*((i-4.)*(i-4.)+(j-3.)*(j-3.)));
     }
   }
   printf("Funcion en dimension 2 en forma de matriz que vamos a derivar:\n");
   F.print("F");

   // CALCULO DE LA DERIVADA EN LA DIRECCION HORIZONTAL
   Array2D<real> H;
   mn_leer_matriz("derivada_horizontal.txt",H); //leemos de disco los resultados exactos de la derivada
   printf("\nResultados exactos de la derivada horizontal\n");
   H.print("DH");

   // LLAMAMOS A LA FUNCION QUE CALCULA LA DERIVADA HORIZONTAL
   Array2D<real> DH=mn_derivada_horizontal(F);
   printf("\nResultados obtenidos por el alumno de la derivada horizontal\n");
   DH.print("DH");

   printf("\n\nPULSAR UNA TECLA PARA VER RESULTADOS DERIVADA VERTICAL\n");
   system("pause");


   // CALCULO DE LA DERIVADA EN LA DIRECCION VERTICAL
   Array2D<real> V;
   mn_leer_matriz("derivada_vertical.txt",V); //leemos de disco los resultados exactos de la derivada
   printf("\nResultados exactos de la derivada vertical\n");
   V.print("DV");

   // LLAMAMOS A LA FUNCION QUE CALCULA LA DERIVADA VERTICAL
   Array2D<real> DV=mn_derivada_vertical(F);
   printf("\nResultados obtenidos por el alumno de la derivada vertical\n");
   DV.print("DV");

}
