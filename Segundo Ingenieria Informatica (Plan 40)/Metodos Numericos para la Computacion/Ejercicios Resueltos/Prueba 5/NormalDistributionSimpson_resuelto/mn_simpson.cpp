#include "mn_simpson.h"
#include <stdio.h>

/************************************************************
LA DISTRUCION NORMAL N(0,1) SE UTILIZA MUCHO EN ESTADISTICA Y
SU FORMULA VIENE DADA POR LA INTEGRAL :

   F(x)=integral en el intervalo (-infinito,x] de la función f(z)=exp(-z*z/2.)/sqrt(2.*M_PI)

EN ESTA FUNCIÓN SE APROXIMA ESTA INTEGRAL USANDO EL MÉTODO DE SIMPSON Y TENIENDO
EN CUENTA QUE SI z<-10. PODEMOS CONSIDERAR QUE f(z)=0 Y ENTONCES PARA x>=-10 PODEMOS CONSIDERAR QUE

   F(x)=integral en el intervalo (-10,x] de la función f(z)=exp(-z*z/2.)/sqrt(2.*M_PI)

EL ALUMNO TIENE QUE VALORAR (HACIENDO PRUEBAS) CUANTOS INTERVALOS HACEN FALTA EN EL METODO DE
SIMPSON PARA OBTENER LA MISMA PRECISION QUE EN LOS EJEMPLOS QUE SE MUESTRAN.

LA FUNCION DEVUELVE EL VALOR DE LA INTEGRAL F(x) Y EN ESTA PRACTICA SE VALORARA ESPECIALMENTE
QUE EL NUMERO DE OPERACIONES REALIZADAS SEA EL MENOR POSIBLE. HACER OPERACIONES Y CALCULOS QUE
PUEDEN EVITARSE PUEDE BAJAR MUCHO LA NOTA.
//************************************************************/
real distribucion_normal( real x)
{
   /** HACER ALUMNO. NOTA : ES INDISPENSABLE USAR EL METODO DE INTEGRACION DE SIMPSON */

   real a=-10.; /// fijamos extremo inferior
   if(x<=a) return 0.; /// por debajo del a retornamos 0
   int Nintervalos=100; /// numero de intervalos que se van a usar
   real step=(x-a)/Nintervalos; /// tamaño de cada intervalo
   real aux=step/(sqrt(2.*M_PI)*6.); /// variable auxiliar para evitar repetir calculos
   real f0=exp(-a*a/2.); /// evaluación función extremo izquierdo intervalo
   real x1=a+step; /// primer extremo derecho subintervalo
   real xm=(a+x1)/2.; /// primer punto medio subintervalo
   /// APLICAMOS METODO SIMPSON
   real integral=0.; /// variable para acumular el valor de la integral
   for(int k=0;k<Nintervalos;k++){
     real f1=exp(-x1*x1/2.); /// evaluamos función extremo derecho subintervalo
     integral+=(f0+4.*exp(-xm*xm/2.)+f1)*aux; /// calculamos expresión fórmula Simpson
     /// ACTUALIZACION VARIABLES PARA LA SIGUIENTE ITERACION
     f0=f1;
     x1+=step;
     xm+=step;
   }
   return integral;
}

