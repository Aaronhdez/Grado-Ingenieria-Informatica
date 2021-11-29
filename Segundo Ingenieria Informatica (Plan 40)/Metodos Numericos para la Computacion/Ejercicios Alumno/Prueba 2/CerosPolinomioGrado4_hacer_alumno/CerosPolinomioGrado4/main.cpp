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
    printf("Primer polinomio de ejemplo P(x)=2x^4-36x^3+142x^2+36x-144 (tiene 4 raices) \n");
    Array1D< real > a(5);
    a[0]=-144.; a[1]=36.; a[2]=142.; a[3]=-36.; a[4]=2.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }

  {
    printf("\nSegundo polinomio de ejemplo P(x)=x^4-15x^3+52x^2-30x+100 (tiene 2 raices reales y 2 complejas) \n");
    Array1D< real > a(5);
    a[0]=100.; a[1]=-30.; a[2]=52.; a[3]=-15.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }

  {
    printf("\nTercer polinomio de ejemplo P(x)=x^4-3x^3-18x^2+32x+96 (tiene 3 raices simples y 1 doble) \n");
    Array1D< real > a(5);
    a[0]=96.; a[1]=32.; a[2]=-18.; a[3]=-3.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }


  {
    printf("\nCuarto polinomio de ejemplo P(x)=x^4-12x^3+54x^2-108x+81 (tiene 1 raiz cuadruple) \n");
    Array1D< real > a(5);
    a[0]=81.; a[1]=-108.; a[2]=54.; a[3]=-12.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }

  {
    printf("\nQuinto polinomio de ejemplo P(x)=x^4+1 (no tiene raices) \n");
    Array1D< real > a(5,0.);
    a[0]=1.; a[4]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }

  {
    printf("\nSexto polinomio de ejemplo P(x)=x^5-1 (no se puede aplicar el metodo) \n");
    Array1D< real > a(6,0.);
    a[0]=-1.; a[5]=1.;

    /// CALCULAMOS LAS RAÍCES
    Array1D< real >  Ceros = calcular_ceros_polinomio_grado4(a,TOL);

    printf("IMPRIMIMOS LAS RAICES CALCULADAS DEL POLINOMIO\n");
    for(int m=0;m<Ceros.dim();m++){
      printf("Ceros[%d]=%lf  P(%lf)=%e\n",m,Ceros[m],Ceros[m],evaluar_polinomio(a,Ceros[m]));
    }
  }


}

