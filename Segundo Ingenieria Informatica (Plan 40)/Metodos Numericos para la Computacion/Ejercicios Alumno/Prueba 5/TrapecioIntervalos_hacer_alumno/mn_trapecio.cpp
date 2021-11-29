#include "mn_trapecio.h"
#include <stdio.h>

//************************************************************
// FUNCION PARA CALCULAR UNA INTEGRAL POR EL METODO DEL TRAPECIO
// UTILIZANDO N INTERVALOS EN UN INTERVALO [a,b]
//************************************************************
real mn_trapecio(
real (*f)(real x) /* funcion que se integra */,
real a /* extremo izquierdo del intervalo */,
real b /* extremo derecho del invervalo*/,
int N /* numero de intervalos para calcular la integral */)
{
   /// HACER ALUMNO
}

//*************************************************************************
// FUNCION PARA CALCULAR UNA INTEGRAL POR ITERACIONES DEL METODO DEL TRAPECIO
// SE PARTE DE N=1 INTERVALOS Y SE CALCULA LA INTEGRAL CON LA FUNCION ANTERIOR
// SE ACTUALIZA N MULTIPLICANDOLO POR 2 Y SE CALCULA DE NUEVO LA INTEGRAL
// SE REALIZA ESTE PROCESO HASTA QUE LA DISTANCIA RELATIVA ENTRE LOS 2
// VALORES DE LA INTEGRAL ES MENOR QUE LA TOLERANCIA. EN Niter  SE DEVUELVE
// EL NUMERO DE ITERACIONES QUE SE REALIZA DE ESTE PROCESO
//*************************************************************************
real mn_trapecio(
real (*f)(real x) /* funcion que se integra */,
real a /* extremo izquierdo del intervalo */,
real b /* extremo derecho del invervalo*/,
int &Niter /* variable de salida con el numero de iteraciones realizadas */,
real TOL /* tolerancia para controlar la convergencia */)
{
  /// HACER ALUMNO
}
