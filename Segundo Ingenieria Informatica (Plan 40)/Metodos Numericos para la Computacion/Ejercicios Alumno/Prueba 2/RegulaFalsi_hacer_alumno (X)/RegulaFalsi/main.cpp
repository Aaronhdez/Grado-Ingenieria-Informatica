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
    real root,a,b;
    real TOL=1e-12;
    int NiterMax=10;
    int error;

    printf("La manera de comprobar los resultados es verificando que la evaluacion\n");
    printf("de la funcion en la raiz debe ser un numero muy cercano a cero\n\n");

    printf("Raiz  f(x)=x-tan(x)+1, intervalo [a,b]=[0,1.5] TOL=1e-12 NiterMax=10 (METODO FALLA)\n");
    a=0.;
    b=1.5;
    root=mn_regula_falsi(f1,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }

    NiterMax=10000;
    printf("\nRaiz  f(x)=x-tan(x)+1, intervalo [a,b]=[0,1.5] TOL=1e-12 NiterMax=10000 (METODO FUNCIONA)\n");
    a=0.;
    b=1.5;
    root=mn_regula_falsi(f1,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }
    printf("\nRaiz  f(x)=x-tan(x)+1, intervalo [a,b]=[0,1] TOL=1e-12 NiterMax=10000 (METODO FALLA)\n");

    a=0.;
    b=1.;
    root=mn_regula_falsi(f1,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }
    printf("\nRaiz  f(x)=x-tan(x)+1, intervalo [a,b]=[4,4.7] TOL=1e-12 NiterMax=10000 (METODO FUNCIONA)\n");
    a=4.;
    b=4.7;
    root=mn_regula_falsi(f1,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }

    printf("\nRaiz f(x)=x-tan(x)+1, intervalo [a,b]=[1.5,3] TOL=1e-12 NiterMax=10000 (METODO DETECTA DISCONTINUIDAD)\n");
    a=1.5;
    b=3.;
    root=mn_regula_falsi(f1,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }

    printf("\nRaiz f(x)=x-sin(x)-1., intervalo [a,b]=[0,5] TOL=1e-12 NiterMax=10000 (METODO FUNCIONA)\n");
    a=0.;
    b=5.;
    root=mn_regula_falsi(f2,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f2(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }

    printf("\nRaiz f(x)=x-sin(x)-1., intervalo [a,b]=[0,1] TOL=1e-12 NiterMax=10000 (METODO FALLA)\n");
    a=0.;
    b=1.;
    root=mn_regula_falsi(f2,a,b,TOL,NiterMax,error);
    if(error==0){
      printf ("El resultado metodo de regula-falsi (alumno): %e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %e\n", (double) f2(root));
    }
    else{
      printf ("El metodo de la regula-falsi falla\n", (double) root);
    }

}

