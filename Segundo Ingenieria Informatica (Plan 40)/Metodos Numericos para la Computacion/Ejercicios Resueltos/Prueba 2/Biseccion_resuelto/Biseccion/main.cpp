#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>
using namespace std;
#include "../mn_calculo_ceros.h"

// FUNCION DE PRUEBA Y SU DERIVADA
real f1(const real x){ return x-2.; }
real f1p(const real x){return 1.;}

// FUNCION DE PRUEBA Y SU DERIVADA
real f2(const real x){ return x*x-2.; }
real f2p(const real x){return 2.*x;}

// FUNCION DE PRUEBA Y SU DERIVADA
real f3(const real x){ return cosl((long double) x) +  0.5; }
real f3p(const real x){return -sinl((long double) x);}

// FUNCION DE PRUEBA Y SU DERIVADA
real f4(const real x){ return 1.; }
real f4p(const real x){return 0.;}

// FUNCION DE PRUEBA Y SU DERIVADA
real f5(const real x){ return x*x+1; }
real f5p(const real x){return 2.*x;}


int main()
{
    real root,a,b;
    real TOL=100.*mn_precision_aritmetica();
    int error;

    printf("La manera de comprobar los resultados es verificando que la evaluacion\n");
    printf("de la funcion en la raiz debe ser un numero muy cercano a cero\n\n");

    a=-10.;
    b=10.;
    printf("Raiz ejemplo 1 : f(x)=x-2 en [%1.0lf,%1.0lf] (METODO DEBE FUNCIONAR)\n",a,b);
    root=mn_biseccion(f1,a,b,TOL,error);
    if(error==0){
      printf ("El resultado metodo de biseccion : %1.16e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f1(root));
    }
    else{
      printf ("El metodo de la biseccion falla\n", (double) root);
    }

    a=0.;
    b=2.;
    printf("\nRaiz ejemplo 2 : f(x)=x*x-2 en [%1.0lf,%1.0lf] (METODO DEBE FUNCIONAR)\n",a,b);
    root=mn_biseccion(f2,a,b,TOL,error);
    if(error==0){
      printf ("El resultado metodo de biseccion : %1.16e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f2(root));
    }
    else{
      printf ("El metodo de la biseccion falla\n", (double) root);
    }

    a=0;
    b=4.;
    printf("\nRaiz ejemplo 3 : f(x)=cos(x)+0.5 en [%1.0lf,%1.0lf] (METODO DEBE FUNCIONAR)\n",a,b);
    root=mn_biseccion(f3,a,b,TOL,error);
    if(error==0){
      printf ("El resultado metodo de biseccion : %1.16e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f3(root));
    }
    else{
      printf ("El metodo de la biseccion falla\n", (double) root);
    }

    a=-10.;
    b=10.;
    printf("\nRaiz ejemplo 4 : f(x)=1 en [%1.0lf,%1.0lf] (METODO DEBE FALLAR)\n",a,b);
    root=mn_biseccion(f4,a,b,TOL,error);
    if(error==0){
      printf ("El resultado metodo de biseccion : %1.16e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f4(root));
    }
    else{
      printf ("El metodo de la biseccion falla\n", (double) root);
    }


    a=-10.;
    b=10.;
    printf("\nRaiz ejemplo 5 : f(x)=x*x+1 en [%1.0lf,%1.0lf] (METODO DEBE FALLAR)\n",a,b);
    root=mn_biseccion(f5,a,b,TOL,error);
    if(error==0){
      printf ("El resultado metodo de biseccion : %1.16e\n", (double) root);
      printf ("La funcion evaluada en el punto es : %1.16e\n", (double) f5(root));
    }
    else{
      printf ("El metodo de la biseccion falla\n", (double) root);
    }


    system ("pause");
}

