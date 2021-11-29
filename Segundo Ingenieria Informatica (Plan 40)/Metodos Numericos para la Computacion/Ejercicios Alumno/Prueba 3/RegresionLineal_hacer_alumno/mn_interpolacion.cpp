/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

///* FUNCION QUE CALCULA LA RECTA DE REGRESION LINEAL y=ax+b PARA APROXIMAR UNA
/// NUBE DE PUNTOS (x[k],y[k]). LA FUNCION DEVUELVE 0 SI TERMINA BIEN Y -1 SI
/// TERMINA MAL
/// */
int mn_regresion_lineal(
Array1D< real > &x, /// VECTOR DE COORDENADAS x DE LA NUBE DE PUNTOS
Array1D< real > &y, /// VECTOR DE COORDENADAS y DE LA NUBE DE PUNTOS
real &a, /// COMPONENTE a DE LA RECTA DE REGRESIÓN. (PARÁMETRO DE SALIDA)
real &b) /// COMPONENTE b DE LA RECTA DE REGRESIÓN. (PARÁMETRO DE SALIDA)
{
  /// HACER ALUMNO
    /// EL nuevo array de elementos en base al cual extrapolaremos la funciñon de la recta correspondiente.
    int N=x.dim();
    /// Si dicho array es menor de 2 (solo un elemento) o diferente en tamaño al dependiente, retornamos -1
    if(y.dim() != N || N<2){
        return -1;
    }
    /// Si ambos son del mismo tamaño comenzamos la gregresión
    real sum_x=0,sum_y=0,sum_xy=0,sum_x2=0;
    for(int i=0;i<N;i++){
        sum_x+=x[i];
        sum_y+=y[i];
        sum_xy+=x[i]*y[i];
        sum_x2+=x[i]*x[i];
    }
    ///Realizamos el calculo final
    real den = N*sum_x2-sum_x*sum_x;
    /// Si el denominador sale 0, significa que la tangente es infinita y no hay recta.
    if(den==0){
        return -1;
    }
    ///Calculamos a y b
    a = (N*sum_xy-sum_x*sum_y)/den;
    b = (sum_x2*sum_y-sum_xy*sum_x)/den;
    return 0;
}



