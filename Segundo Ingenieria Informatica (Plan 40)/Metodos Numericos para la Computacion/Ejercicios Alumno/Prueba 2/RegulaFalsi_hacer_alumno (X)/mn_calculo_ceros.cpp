#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_calculo_ceros.h"

// FUNCION QUE IMPLEMENTA EL METODO DE LA REGULA FALSI  Y DEVUELVE LA RAIZ
real mn_regula_falsi (
real (*f)( real), // función a la cual se calcula un cero
real &a, real &b, // intervalo inicial para buscar la raíz
real TOL,  // tolerancia para parar las iteraciones del algoritmo
int NiterMax, // número máximo de iteraciones permitidas
int &error) // código de salida de error :
            //       Si error=0 la función ha terminado bien
            //       Si error=-1 la función ha terminado mal
{
  /// HACER ALUMNO

    ///Comprobamos si la función cambia de signo
    real f_a = f(a);
    real f_b = f(b);

    if(f_a*f_b > 0.){
        error = -1;
        return -1.;
    }

    /// Si cambia, Calculamos el valor del primer punto
    int i=0;
    real x = a-(((b-a)/(f_b-f_a))*f_a);
    real fx=f(x);
    while(mn_distancia(a,b) >=TOL ){
        if(fx ==0.){
            error = 0;
            return x;
        }
        ///Incrementamos iter
        if(i++>=NiterMax){
            error == -2; /// Asignamos -2 para indicar que ha llegado al limite
            return -1.;
        }
        ///si fa*fx == 0 --> b=x
        ///si no --> a=x
        if(f_a*fx==0.){
            b=x;
            f_b=fx;
        } else {
            a=x;
            f_a=fx;
        }
        ///calculamos xnew
        real xnew = a-(((b-a)/(f_b-f_a))*f_a);
        /// Si se cumple la tolerancia, entramos
        if(mn_distancia(x,xnew)<=TOL){
            error = 0;
            return xnew;
        }
        x=xnew;
        fx=f(x);
    }
    error = -1;
    return 1.;
}





