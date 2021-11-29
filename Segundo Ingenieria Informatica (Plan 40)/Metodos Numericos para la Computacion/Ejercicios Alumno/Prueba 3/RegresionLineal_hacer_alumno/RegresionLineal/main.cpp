/*==========================================================================
       PRACTICA 3 METODOS NUMERICOS. INTERPOLACION
  ==========================================================================*/

// INCLUSION DE LA LIBRERIA STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "../mn_aritmeticas.h"
#include "../mn_interpolacion.h"


main()
{
   real a,b; 
  printf("\nEJEMPLO 1 \n"); 
  {
    Array1D< real > x(3);
    Array1D< real > y(3);   
    x[0]=0; y[0]=1.;
    x[1]=1; y[1]=3.; 
    x[2]=2; y[2]=5.;  
    int k=mn_regresion_lineal(x,y,a,b);
    printf("Recta de regresion. Solucion ejemplo 1\n"); 
    printf("  La recta de regresion es %lf x + %lf\n",2.,1.);
    printf("Recta de regresion. Solucion ejemplo 1 Propuesta Alumno/a\n"); 
    if(k==-1) printf ("  La recta de regresion no se puede calcular\n");
    else printf ("  La recta de regresion es %lf x + %lf\n",a,b);
  }   
  
  printf("\nEJEMPLO 2 \n"); 
  {
    Array1D< real > x(4);
    Array1D< real > y(4);   
    x[0]=-2; y[0]=-10.;
    x[1]=-1; y[1]=-6.; 
    x[2]=1; y[2]=2.;  
    x[3]=2; y[3]=6.;  
    int k=mn_regresion_lineal(x,y,a,b);
    printf("Recta de regresion. Solucion ejemplo 2\n"); 
    printf("  La recta de regresion es %lf x + %lf\n",4.,-2.);
    printf("Recta de regresion. Solucion ejemplo 2 Propuesta Alumno/a\n"); 
    if(k==-1) printf ("  La recta de regresion no se puede calcular\n");
    else printf ("  La recta de regresion es %lf x + %lf\n",a,b);
  }   
  
  printf("\nEJEMPLO 3 \n"); 
  {
    Array1D< real > x(3);
    Array1D< real > y(3);   
    x[0]=0; y[0]=1.;
    x[1]=0; y[1]=3.; 
    x[2]=0; y[2]=5.;  
    int k=mn_regresion_lineal(x,y,a,b);
    printf("Recta de regresion. Solucion ejemplo 3\n"); 
    printf ("  La recta de regresion no se puede calcular\n");
    printf("Recta de regresion. Solucion ejemplo 3 Propuesta Alumno/a\n"); 
    if(k==-1) printf ("  La recta de regresion no se puede calcular\n");
    else printf ("  La recta de regresion es %lf x + %lf\n",a,b);
  }   
  printf("\n");    
  
  // HACEMOS UNA PAUSA EN EL PROGRAMA PARA PODER EXAMINAR EL RESULTADO POR CONSOLA
  system("pause");
  return 0;
}



