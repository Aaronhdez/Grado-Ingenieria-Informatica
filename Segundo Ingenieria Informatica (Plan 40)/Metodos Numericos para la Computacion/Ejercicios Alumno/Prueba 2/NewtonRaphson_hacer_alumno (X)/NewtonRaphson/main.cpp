#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>
using namespace std;
#include "../mn_calculo_ceros.h"

// FUNCION DE PRUEBA Y SUS DERIVADAS
real f1( real x){ return x-tan(x)+1.; }
real f1p( real x){return -tan(x)*tan(x);}
real f1pp( real x){return -2.*tan(x)*(tan(x)*tan(x)+1.);}

// FUNCION DE PRUEBA Y SU DERIVADA
real f2( real x){ return x-sin(x)-1.; }
real f2p( real x){return 1-cos(x);}
real f2pp( real x){return sin(x);}


int main()
{
    real x0;
    real TOL=1e-12;
    int iter,NiterMax;

    printf("La manera de comprobar los resultados es verificando que la evaluacion\n");
    printf("de la funcion en la raiz debe ser un numero muy cercano a cero\n\n");

    printf("Raiz  f(x)=x-tan(x)+1, x0=1, TOL=1e-12 NiterMax=4 (METODO FALLA) \n");
    x0=1.;
    NiterMax=4;
    iter=mn_newton_raphson(f1,f1p,x0,NiterMax,TOL);
    if(iter>=0){
      printf ("El resultado metodo de newton_raphson (alumno): %1.16e\n", (double) x0);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f1(x0));
      printf ("El numero de iteraciones realizada es (alumno): %d\n",  iter);
    }
    else{
      printf ("El metodo de la newton_raphson falla (alumno)\n");
    }

    printf("\nRaiz  f(x)=x-tan(x)+1, x0=1, TOL=1e-12 NiterMax=10000 (METODO FUNCIONA)\n");
    x0=1.;
    NiterMax=10000;
    iter=mn_newton_raphson(f1,f1p,x0,NiterMax,TOL);
    if(iter>=0){
      printf ("El resultado metodo de newton_raphson (alumno): %1.16e\n", (double) x0);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f1(x0));
      printf ("El numero de iteraciones realizada es (alumno) : %d\n", iter);
    }
    else{
      printf ("El metodo de la newton_raphson falla (alumno)\n");
    }

    printf("\nRaiz  f(x)=x-tan(x)+1, x0=0, TOL=1e-12 NiterMax=10000 (METODO FALLA) \n");
    x0=0.;
    NiterMax=10000;
    iter=mn_newton_raphson(f1,f1p,x0,NiterMax,TOL);
    if(iter>=0){
      printf ("El resultado metodo de newton_raphson (alumno) : %1.16e\n", (double) x0);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f1(x0));
      printf ("El numero de iteraciones realizada es (alumno) : %d\n", iter);
    }
    else{
      printf ("El metodo de la newton_raphson falla (alumno)\n");
    }

       printf("\nRaiz  f(x)=x-sin(x)-1., x0=-5, TOL=1e-12 NiterMax=10000 (METODO FUNCIONA)\n");
    x0=-5.;
    NiterMax=10000;
    iter=mn_newton_raphson(f2,f2p,x0,NiterMax,TOL);
    if(iter>=0){
      printf ("El resultado metodo de newton_raphson (alumno): %1.16e\n", (double) x0);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f2(x0));
      printf ("El numero de iteraciones realizada es (alumno): %d\n", iter);
    }
    else{
      printf ("El metodo de la newton_raphson falla (alumno)\n");
    }

}



