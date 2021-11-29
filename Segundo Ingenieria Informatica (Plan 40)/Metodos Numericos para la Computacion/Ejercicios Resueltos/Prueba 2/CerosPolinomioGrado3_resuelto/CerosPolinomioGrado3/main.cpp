#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../mn_aritmeticas.h"
#include "../mn_raices_polinomios.h"


int main()
{
  /// DEFINIMOS LA TOLERANCIA PARA LA PRECISIÓN DEL MÉTODO
  double TOL=1e-14;
  {
    printf("Primer polinomio de ejemplo P(x)=2x^3-26x^2+92x-96  (tiene 3 raices) \n");
    Array1D< real > a(4);
    a[0]=-96.; a[1]=92.; a[2]=-26.; a[3]=2.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado3(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }

  {
    printf("\nSegundo polinomio de ejemplo P(x)=2x^3-4x^2+2x-4  (tiene 1 raiz) \n");
    Array1D< real > a(4);
    a[0]=-4.; a[1]=2.; a[2]=-4.; a[3]=2.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado3(a,TOL);
    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }
  {
    printf("\nTercer polinomio de ejemplo P(x)=x^3-x^2-x+1  (tiene 1 raiz doble y una simple) \n");
    Array1D< real > a(4);
    a[0]=1.; a[1]=-1.; a[2]=-1.; a[3]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado3(a,TOL);
    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }
  {
    printf("\nCuarto polinomio de ejemplo P(x)=x^3-3x^2+3x-1  (tiene 1 raiz triple) \n");
    Array1D< real > a(4);
    a[0]=-1.; a[1]=3.; a[2]=-3.; a[3]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado3(a,TOL);
    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }
  {
    printf("\nQuinto polinomio de ejemplo P(x)=x^4+x^3-3x^2+3x-1  (no se puede aplicar) \n");
    Array1D< real > a(5);
    a[0]=-1.; a[1]=3.; a[2]=-3.; a[3]=1.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado3(a,TOL);
    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }



}

