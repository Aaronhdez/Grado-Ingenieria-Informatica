#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../mn_calculo_ceros.h"

int main()
{
    int Nmax=100000;
    real TOL=10.*mn_precision_aritmetica();

    printf("Metodo de Newton-Raphson para calcular la raiz cubica 1\n\n");

    real A=8.;
    real x=(1.+A)*0.5;
    printf ("A=%e, aproximacion inicial raiz : %e\n",A,x);
    int iter=mn_raiz_cubica_newton(A,x,Nmax,TOL);
    printf ("La raiz cubica usando funcion pow() del sistema es : %e\n", (double) pow((double)A,(double) 1./3.));
    printf ("La raiz cubica usando nuestra funcion es : %e\n", (double) x);
    printf ("La diferencia entre las dos estimaciones es : %e\n", (double) x-pow((double)A,(double) 1./3.));
    printf ("N. Iteraciones realizadas por nuestro metodo : %d \n",iter);

    A=1E6;
    x=(1.+A)*0.5;
    printf ("\nA=%e, aproximacion inicial raiz : %e\n",A,x);
    iter=mn_raiz_cubica_newton(A,x,Nmax,TOL);
    printf ("La raiz cubica usando funcion pow() del sistema es : %e\n", (double) pow((double)A,(double) 1./3.));
    printf ("La raiz cubica usando nuestra funcion es : %e\n", (double) x);
    printf ("La diferencia entre las dos estimaciones es : %e\n", (double) x-pow((double)A,(double) 1./3.));
    printf ("N. Iteraciones realizadas por nuestro metodo : %d \n",iter);

    A=1E-6;
    x=(1.+A)*0.5;
    printf ("\nA=%e, aproximacion inicial raiz : %e\n",A,x);
    iter=mn_raiz_cubica_newton(A,x,Nmax,TOL);
    printf ("La raiz cubica usando funcion pow() del sistema es : %e\n", (double) pow((double)A,(double) 1./3.));
    printf ("La raiz cubica usando nuestra funcion es : %e\n", (double) x);
    printf ("La diferencia entre las dos estimaciones es : %e\n", (double) x-pow((double)A,(double) 1./3.));
    printf ("N. Iteraciones realizadas por nuestro metodo : %d \n",iter);

    A=-8.;
    x=(-1.+A)*0.5;
    printf ("\nA=%e, aproximacion inicial raiz : %e\n",A,x);
    iter=mn_raiz_cubica_newton(A,x,Nmax,TOL);
    printf ("La raiz cubica usando nuestra funcion es : %e\n", (double) x);
    printf ("N. Iteraciones realizadas por nuestro metodo : %d \n",iter);



    system ("pause");
}

