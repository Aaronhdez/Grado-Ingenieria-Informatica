#include "mn_simpson.h"
#include <stdio.h>

/************************************************************
LA DISTRUCION NORMAL N(0,1) SE UTILIZA MUCHO EN ESTADISTICA Y
SU FORMULA VIENE DADA POR LA INTEGRAL :

   F(x)=integral en el intervalo (-infinito,x] de la funci?n f(z)=exp(-z*z/2.)/sqrt(2.*M_PI)

EN ESTA FUNCI?N SE APROXIMA ESTA INTEGRAL USANDO EL M?TODO DE SIMPSON Y TENIENDO
EN CUENTA QUE SI z<-10. PODEMOS CONSIDERAR QUE f(z)=0 Y ENTONCES PARA x>=-10 PODEMOS CONSIDERAR QUE

   F(x)=integral en el intervalo (-10,x] de la funci?n f(z)=exp(-z*z/2.)/sqrt(2.*M_PI)

EL ALUMNO TIENE QUE VALORAR (HACIENDO PRUEBAS) CUANTOS INTERVALOS HACEN FALTA EN EL METODO DE
SIMPSON PARA OBTENER LA MISMA PRECISION QUE EN LOS EJEMPLOS QUE SE MUESTRAN.

LA FUNCION DEVUELVE EL VALOR DE LA INTEGRAL F(x) Y EN ESTA PRACTICA SE VALORARA ESPECIALMENTE
QUE EL NUMERO DE OPERACIONES REALIZADAS SEA EL MENOR POSIBLE. HACER OPERACIONES Y CALCULOS QUE
PUEDEN EVITARSE PUEDE BAJAR MUCHO LA NOTA.
//************************************************************/
real distribucion_normal( real x)
{
   /** HACER ALUMNO. NOTA : ES INDISPENSABLE USAR EL METODO DE INTEGRACION DE SIMPSON */

}

