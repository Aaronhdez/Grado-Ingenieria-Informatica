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
   // DEFINIMOS ARRAYS NECESARIOS
   Array1D< real > x(3); // Puntos de interpolación
   Array1D< real > f(3); // Valores de la función en los puntos interpolados

   x[0]=0.; f[0]=1.;
   x[1]=1.; f[1]=7.;
   x[2]=3.; f[2]=16.;
   Array1D< real > a,b,c;
   real cLast=2.;

   int result = mn_calculo_splines_2(x,f,cLast,a,b,c);

   cout << "PUNTOS DE INTERPOLACION Y VALORES DE LA FUNCION\n" ;
   printf("    x[%d]=%1.2lf x[%d]=%1.2lf x[%d]=%1.2lf\n",0,x[0],1,x[1],2,x[2]);
   printf("    f[%d]=%1.2lf f[%d]=%1.2lf f[%d]=%1.2lf\n\n",0,f[0],1,f[1],2,f[2]);

   cout << "CALCULO COEFICIENTES SPLINES GRADO 2 CON c1=2\n" ;
   cout << "  Resultado obtenido por el alumno \n" ;
   for(int i=0;i<a.dim();i++){
     printf("    a[%d]=%1.2lf b[%d]=%1.2lf c[%d]=%1.2lf\n",i,a[i],i,b[i],i,c[i]);
   }

   printf("\nCOMPROBAMOS LAS CONDICIONES QUE DEBE CUMPLIR EL SPLINE DE GRADO 2\n");
   printf("  f[0] = a[0]  -> %lf = %lf \n",f[0],a[0]);
   printf("  f[1] = a[0]+(b[0]+c[0]*(x[1]-x[0]))*(x[1]-x[0])  -> %lf = %lf \n",
          f[1],a[0]+(b[0]+c[0]*(x[1]-x[0]))*(x[1]-x[0]));
   printf("  f[1] = a[1]  -> %lf = %lf \n",f[1],a[1]);
   printf("  f[2] = a[1]+(b[1]+c[1]*(x[2]-x[1]))*(x[2]-x[1])  -> %lf = %lf \n",
          f[2],a[1]+(b[1]+c[1]*(x[2]-x[1]))*(x[2]-x[1]));
   printf("  b[0]+2*c[0]*(x[1]-x[0]) = b[1]  -> %lf = %lf \n",
          (b[0]+2*c[0]*(x[1]-x[0])),b[1]);

   cout << "\nPRUEBA EVALUACION SPLINE GRADO 2 EN DIFERENTES PUNTOS \n" ;
   real x0;
   for(int i=0;i<x.dim();i++){
      x0=x[i];
      printf("  x0=%1.2lf P(x0)=%1.2lf (real) P(x0)=%1.2lf (obtenido alumno)\n",x0,f[i],mn_evaluar_splines_2(x,a,b,c,x0));
   }
   x0=-1.;
   printf("  x0=%1.2lf P(x0)=%1.2lf (real) P(x0)=%1.2lf (obtenido alumno)\n",x0,-16.,mn_evaluar_splines_2(x,a,b,c,x0));
   x0=1.5;
   printf("  x0=%1.2lf P(x0)=%1.2lf (real) P(x0)=%1.2lf (obtenido alumno)\n",x0,7.75,mn_evaluar_splines_2(x,a,b,c,x0));
   x0=2.5;
   printf("  x0=%1.2lf P(x0)=%1.2lf (real) P(x0)=%1.2lf (obtenido alumno)\n",x0,12.25,mn_evaluar_splines_2(x,a,b,c,x0));
   x0=4.;
   printf("  x0=%1.2lf P(x0)=%1.2lf (real) P(x0)=%1.2lf (obtenido alumno)\n",x0,26.5,mn_evaluar_splines_2(x,a,b,c,x0));


}



