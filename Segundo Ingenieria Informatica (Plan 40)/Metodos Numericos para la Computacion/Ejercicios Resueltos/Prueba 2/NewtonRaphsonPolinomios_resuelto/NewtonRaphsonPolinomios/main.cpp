#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_raices_polinomios.h"
#include "../tnt_array/tnt.h"
#include "mn_aritmeticas.h"

int main()
{
    cout << "EJEMPLO 1 (DEBE DAR COMO CERO x=2)\n";
    Array1D< real > a(5);
    a[0]=6.; a[1]=1.; a[2]=-7.; a[3]=-1.; a[4]=1;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3 + " << a[4] << "x^4" << endl;
    // DEFINIMOS LA TOLERANCIA PARA LA PRECISIÓN DEL MÉTODO Y EL MAXIMO DE ITERACIONES
    real TOL=1e-15;
    int NMaxIter=100;
    // DEFINIMOS APROXIMACION INICIAL
    real x0=-8.;
    cout << "APROXIMACION INICIAL x0 = " << x0 << "\n";
    // CALCULAMOS LAS RAÍCES
    int result=calculo_ceros_Newton_Raphson(a,x0,TOL,NMaxIter);
    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "RAIZ ALUMNO x = " <<  x0 ;
      cout << "  ->  P(x) = "<< evaluar_polinomio(a,x0) << endl;
    }
    else{
      cout << "El método no ha funcionado (alumno)\n";
    }

    system("pause");
    cout << "\nEJEMPLO 2 (DEBE FALLAR)\n";
    a[0]=1.; a[1]=0.; a[2]=0.; a[3]=0.; a[4]=1;
     cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3 + " << a[4] << "x^4" << endl;
    // DEFINIMOS INTERVALO
    x0=1.;
    cout << "APROXIMACION INICIAL x0= " << x0 << "\n";
    // CALCULAMOS LAS RAÍCES
    result=calculo_ceros_Newton_Raphson(a,x0,TOL,NMaxIter);

    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "x0= " <<  x0 ;
      cout << "  ->  P(x0) = "<< evaluar_polinomio(a,x0) << endl;
    }
    else{
      cout << "El metodo no ha funcionado (alumno)\n";
    }
    system ("pause");
}

