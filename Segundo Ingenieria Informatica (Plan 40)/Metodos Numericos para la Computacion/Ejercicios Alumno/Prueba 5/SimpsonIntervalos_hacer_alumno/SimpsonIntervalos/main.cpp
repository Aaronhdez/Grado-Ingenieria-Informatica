/* Procedimiento de prueba para el  uso del método de integración de Simpson */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_simpson.h"

// DECLARACION EJEMPLOS DE FUNCIONES
real f1(real x){ return (sinl((long double)x));} // función f(x)=sen(x)

real f2(real x){ return (x/sqrtl((long double)1-x*x)); } // función f(x)=1-x*x

real f3(real x){ return (expl((long double)- x*x/2)/sqrtl((long double) 2.*M_PI));}
int main()
{
   int Niter; // declaramos la variable donde acumulamos las iteraciones realizadas en el proceso de integración
   real TOL=100.*mn_precision_aritmetica(); // tomamos como precisión de la aritmética quitándole 2 cifras significativas
   real a,b;  // declaramos los extremos del intervalo

   // INTEGRAL PRIMERA FUNCION EJEMPLO
   a=0;
   b=M_PI; // M_PI es la constante donde se almacena el valor de pi.
   real integral=mn_simpson(f1,a,b,Niter,TOL); // calculamos integral primera función ejemplo
   printf("Integral ejemplo 1\n"); // imprimimos el resultado y lo comparamos con el valor exacto
   printf ("RESULTADOS DEL SISTEMA : Niter=%d integral=%1.16lf  \n\n",12, 2.);
   printf ("RESULTADOS DEL ALUMNO : Niter=%d integral=%1.16lf  \n\n",Niter, (double) integral);

   // INTEGRAL SEGUNDA FUNCION EJEMPLO
   a=0.;
   b=0.99999999; // no tomamos b=1 para evitar la división por cero.
   integral=mn_simpson(f2,a,b,Niter,TOL); // calculamos integral segunda función ejemplo
   printf("Integral ejemplo 2\n"); // imprimimos el resultado y lo comparamos con el valor exacto
   printf ("RESULTADOS DEL SISTEMA : Niter=%d integral=%1.16lf  \n\n",24, 1.);
   printf ("RESULTADOS DEL ALUMNO : Niter=%d integral=%1.16lf  \n\n",Niter, (double) integral);

   // INTEGRAL TERCERA FUNCION EJEMPLO
   a=-10.; // tomamos un intervalo finito para calcular la integral
   b=10.;
   integral=mn_simpson(f3,a,b,Niter,TOL); // calculamos integral tercera función ejemplo
   printf("Integral ejemplo 3\n"); // imprimimos el resultado y lo comparamos con el valor exacto
   printf ("RESULTADOS DEL SISTEMA : Niter=%d integral=%1.16lf  \n\n",6, 1.);
   printf ("RESULTADOS DEL ALUMNO : Niter=%d integral=%1.16lf  \n\n",Niter, (double) integral);

   system("pause");
   return 0;
}
