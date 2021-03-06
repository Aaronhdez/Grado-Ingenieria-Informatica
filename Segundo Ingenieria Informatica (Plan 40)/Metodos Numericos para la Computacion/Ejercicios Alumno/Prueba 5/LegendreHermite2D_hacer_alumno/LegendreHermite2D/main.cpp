/* Procedimiento de prueba para el  uso del m?todo de integraci?n de Simpson */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_cuadratura.h"
#include "../tnt_array/tnt.h"

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

// DECLARACION EJEMPLOS DE FUNCIONES

real f1(real x,real y){ return (exp(-x*x)*pow(y,1.));}

real f2(real x,real y){ return (exp(-x*x)*pow(x,2.)*pow(y,4.));}

real f3(real x,real y){ return (pow(x,5.)*pow(y,5.));}// funci?n f(x)=x^5*y^5

real f4(real x,real y){ return (pow(x,7.)*pow(y,7.));}// funci?n f(x)=x^7*y^7

real f5(real x,real y){ return (exp(3*x)*cos(y));} // funci?n f(x)=exp(3*x)*cos(y)

int main()
{
   real c=0.,d=1.;  // declaramos los extremos del intervalo en y

   Array2D<real> w_he,w_le; // pesos de la cuadratura de Gauss
   Array2D<real> x_he,x_le; // puntos de la cuadratura de Gauss

   //LEEMOS LAS MATRICES CON LOS PESOS Y LOS PUNTOS
   int dim1=mn_leer_matriz("../TablaPesosLegendre.txt",w_le);
   int dim2=mn_leer_matriz("../TablaPuntosLegendre.txt",x_le);
   dim1=mn_leer_matriz("../TablaPesosHermite.txt",w_he);
   dim2=mn_leer_matriz("../TablaPuntosHermite.txt",x_he);


   // INTEGRAL PRIMERA FUNCION EJEMPLO 1
   printf("EJEMPLO 1. Integral funcion f(x)=exp(-x*x)y en (-infinito,infinito)x[0,1]. \nValor Exacto = %1.4lf \n",0.8862);
   real integral=mn_cuadratura(f1,c,d,x_le,w_le,x_he,w_he,1,1); // calculamos integral primera funci?n ejemplo
   printf("Valor Calculado Alumno = %1.4lf\n",integral);

   // INTEGRAL PRIMERA FUNCION EJEMPLO 2
   printf("\nEJEMPLO 2. Integral funcion f(x)=exp(-x*x)*x^2*y^4 en (-infinito,infinito)x[0,1]. \nValor Exacto = %1.4lf \n",0.1772);
   integral=mn_cuadratura(f2,c,d,x_le,w_le,x_he,w_he,4,2); // calculamos integral primera funci?n ejemplo
   printf("Valor Calculado Alumno = %1.4lf\n",integral);

   printf("\n");

   system("pause");
   return 0;
}
