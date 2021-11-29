/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"



/**
 LA INTERPOLACION POR SPLINES DE GRADO 2 SEGÚN SE EXPLICÓ EN CLASE.
 EN ESTE CASO SE SUPONE CONOCIDO EL ÚLTIMO VALOR DEL VECTOR c Y SE CALCULA EL RESTO DE COEFICIENTES
 LA FUNCION DEVUELVE -1 SI ENCUENTRA ALGÚN PROBLEMA Y 0 EN CASO CONTRARIO
*/
int mn_calculo_splines_2(
const Array1D< real > &x, // vector con los puntos de interpolación
const Array1D< real > &f, // vector con los valores de la función
const real &cLast,        // último valor del vector c[] asignado como parámetro
Array1D< real > &a,       // vector de salida con los coeficientes a[i] del spline de grado 2
Array1D< real > &b,       // vector de salida con los coeficientes b[i] del spline de grado 2
Array1D< real > &c)       // vector de salida con los coeficientes c[i] del spline de grado 2
{
  /// HACER ALUMNO
}

real mn_evaluar_splines_2(const Array1D< real > &x,Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,real &x0 ){
  /// HACER ALUMNO
}

