#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../mn_aritmeticas.h"
#include "../mn_raices_polinomios.h"


int main()
{
    /// DEFINIMOS LA TOLERANCIA PARA LA PRECISIÓN DEL MÉTODO
    double TOL=1e-12;

    printf("Primer polinomio de ejemplo P(x)=x^4-x^3-7x^2+x+6 (TIENE 4 RAICES)\n");
    Array1D< real > a(5);
    a[0]=6.; a[1]=1.; a[2]=-7.; a[3]=-1.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D <Array1D< real > > Ceros = calcular_ceros_polinomio(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO Y SUS DERIVADAS\n");
    for(int m=0;m<Ceros.dim();m++){
        printf("\nCeros de la derivada %d del Polinomio\n",m);
      for(int n=0;n<Ceros[m].dim();n++){
        printf("Ceros[%d][%d]=%lf\n",m,n,Ceros[m][n]);
      }
    }
    printf("IMPRIMIMOS LA EVALUACION DE LAS RAICES EN EL POLINOMIO ORIGINAL\n");
    for(int n=0;n<Ceros[0].dim();n++){
      printf("P(%f)=%e\n",Ceros[0][n],evaluar_polinomio(a,Ceros[0][n]));
    }

    printf("\nSIGUIENTE EJEMPLO\n");
    system("pause");
    printf("Segundo polinomio de ejemplo P(x)=x^6-3x^4+3x^2-1 (TIENE 2 RAICES)\n");
    a=Array1D< real >(7,0.);
    a[0]=-1.; a[2]=3.; a[4]=-3.; a[6]=1.;

    /// CALCULAMOS LAS RAÍCES
    Ceros = calcular_ceros_polinomio(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO Y SUS DERIVADAS\n");
    for(int m=0;m<Ceros.dim();m++){
        printf("\nCeros de la derivada %d del Polinomio\n",m);
      for(int n=0;n<Ceros[m].dim();n++){
        printf("Ceros[%d][%d]=%lf\n",m,n,Ceros[m][n]);
      }
    }
    printf("IMPRIMIMOS LA EVALUACION DE LAS RAICES EN EL POLINOMIO ORIGINAL\n");
    for(int n=0;n<Ceros[0].dim();n++){
      printf("P(%f)=%e\n",Ceros[0][n],evaluar_polinomio(a,Ceros[0][n]));
    }

    printf("\nSIGUIENTE EJEMPLO\n");
    system("pause");
    printf("Tercer ejemplo P(x)=(x^31-2^31)(x^7+2^7)=x^38+128x^31-2147483648x^7-274877906944\n (TIENE 2 RAICES)\n");
    a=Array1D< real >(39,0.);
    a[0]=-274877906944.; a[7]=-2147483648.; a[31]=128.; a[38]=1.;

    /// CALCULAMOS LAS RAÍCES
    Ceros = calcular_ceros_polinomio(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO Y SUS DERIVADAS\n");
    for(int m=0;m<Ceros.dim();m++){
        printf("\nCeros de la derivada %d del Polinomio\n",m);
      for(int n=0;n<Ceros[m].dim();n++){
        printf("Ceros[%d][%d]=%lf\n",m,n,Ceros[m][n]);
      }
    }
    printf("IMPRIMIMOS LA EVALUACION DE LAS RAICES EN EL POLINOMIO ORIGINAL\n");
    for(int n=0;n<Ceros[0].dim();n++){
      printf("P(%f)=%e\n",Ceros[0][n],evaluar_polinomio(a,Ceros[0][n]));
    }

}

