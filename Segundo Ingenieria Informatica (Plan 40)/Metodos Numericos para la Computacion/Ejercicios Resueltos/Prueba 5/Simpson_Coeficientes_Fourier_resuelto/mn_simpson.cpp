#include "mn_simpson.h"
#include <stdio.h>

/************************************************************
   DADA UNA FUNCIÓN f(x) Y UN NÚMERO NATURAL n SE DEFINE EL
   COEFICIENTE DE FOURIER COMO :

   (1/pi)*INTEGRAL ENTRE -pi Y pi DE LA FUNCIÓN  f(x)*cos(n*x) dx

   CALCULAR ESTA INTEGRAL USANDO EL MÉTODO DE SIMPSON DIVIDIENDO
   EN 100 INVERVALOS  EL INTERVALO DE INTEGRACION [-pi,pi]

   NOTA: EL NÚMERO pi EN C++ SE ESCRIBE M_PI
//************************************************************/
real CoeficienteFourier(real (*f)(real),int n)
{
   /** HACER ALUMNO. NOTA : ES INDISPENSABLE USAR EL METODO DE INTEGRACION DE SIMPSON */
   /// EL HACER MÁS OPERACIONES DE LAS NECESARIAS REDUCE LA NOTA

   /// DECLARAMOS E INICIALIZAMOS LAS VARIABLES NECESARIAS
   real integral=0; /// variable donde se acumula el valor de la integral
   real paso = 2* M_PI/100; /// tamaño del intervalo al dividir [-pi,pi] en 100 intervalos
   real paso2 = paso/2.; /// la mitad del tamaño del intervalo (variable para ir más rápido en el bucle)
   real xk=-M_PI; /// extremo izquierdo del primer intervalo
   real fxk=f(xk)*cos(n*xk); /// evaluación de la función que se integra en xk

   /// RECORREMOS LOS 100 INTERVALOS Y APLICAMOS LA FÓRMULA DE SIMPSON
   /// PARA HACER MENOS OPERACIONES ALGUNOS CÁLCUL0S SE HACEN FUERA DEL BUCLE
   for(int k=0;k<100;k++){
     real xk1=xk+paso;
     real fxk1=f(xk1)*cos(n*xk1);
     real xm=xk+paso2;
     real fxm=f(xm)*cos(n*xm);
     integral+=fxk+4*fxm+fxk1;
     xk=xk1;
     fxk=fxk1;
   }
   return integral/M_PI/6.*paso;
}

