/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// INTERPOLACION LINEAL
real interpolacion_lineal(
Array1D<real> &x, /// puntos de interpolación
Array1D<real> &f, /// valores de función en los puntos de interpolación
real x0)  /// punto donde se evalua la función interpolada
{
  /// HACER ALUMNO
    real a,b;
    ///Si llegamos un intervalo en el que el siguiente punto
    ///al que buscamos evaluar es menor o igual que éste, calculamos la formula
    for(int i=x.dim()-2; i>=0; i--){
        if(x[i]<=x0){
            a = f[i];
            b = (f[i+1]-f[i])/(x[i+1]-x[i]);
            return a+b*(x0-x[i]);
        }
    }
    ///Si no existe, ajustamos al ultimo punto empezando por el principio.
    a = f[0];
    b = (f[1]-f[0])/(x[1]-x[0]);
    return a+b*(x0-x[0]);
}



