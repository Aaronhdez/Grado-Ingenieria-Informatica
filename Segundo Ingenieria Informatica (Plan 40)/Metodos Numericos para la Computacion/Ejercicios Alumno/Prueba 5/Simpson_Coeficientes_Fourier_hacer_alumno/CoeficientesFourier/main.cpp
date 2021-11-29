/* Procedimiento de prueba para el  uso del método de integración de Simpson */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_simpson.h"

real f(real x){ return x*x;}

int main()
{
    /// Cálculo coeficientes de Fourier de la función f(x)=x^2

    printf("Coeficiente Fourier de fx)=x*x para n=0   (real) : %lf \n",6.579736267);
    printf("Coeficiente Fourier de fx)=x*x para n=0 (alumno) : %lf \n",CoeficienteFourier(f,0));

    printf("Coeficiente Fourier de fx)=x*x para n=1   (real) : %lf \n",-4.);
    printf("Coeficiente Fourier de fx)=x*x para n=1 (alumno) : %lf \n",CoeficienteFourier(f,1));

    printf("Coeficiente Fourier de fx)=x*x para n=2   (real) : %lf \n",1.);
    printf("Coeficiente Fourier de fx)=x*x para n=2 (alumno) : %lf \n",CoeficienteFourier(f,2));

    printf("Coeficiente Fourier de fx)=x*x para n=3   (real) : %lf \n",-0.44444444);
    printf("Coeficiente Fourier de fx)=x*x para n=3 (alumno) : %lf \n",CoeficienteFourier(f,3));

}
