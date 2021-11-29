/* Procedimiento de prueba para el  uso del m�todo de integraci�n de trapecio */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_trapecio.h"

// DECLARACION EJEMPLOS DE FUNCIONES
real F1(real x,real y){ return x*x +3.*y*y;}
real F2(real x,real y){ return 3.*cos(x)*cos(y);}
real F3(real x,real y){ return exp(-x*x-y*y);}

int main()
{
    real a=-1.;
    real b=1.;
    real c=-1.;
    real d=1.;
    int M=600;
    int N=400;

    printf("\nEJEMPLO 1 : F1(x,y)=x*x +3.*y*y en [-1,1]x[-1,1]\n");
    printf("             Integral real = %lf\n",5.333391);
    printf("Integral calculada alumnos = %lf\n",mn_trapecio_2D(F1,a,b,c,d,M,N));

    printf("\nEJEMPLO 2 : F2(x,y)=3.*cos(x)*cos(y) en [-1,1]x[-1,1]\n");
    printf("             Integral real = %lf\n",8.496855);
    printf("Integral calculada alumnos = %lf\n",mn_trapecio_2D(F2,a,b,c,d,M,N));

    printf("\nEJEMPLO 3 : F3(x,y)=exp(-x*x-y*y) en [-1,1]x[-1,1]\n");
    printf("             Integral real = %lf\n",2.230979);
    printf("Integral calculada alumnos = %lf\n",mn_trapecio_2D(F3,a,b,c,d,M,N));

}