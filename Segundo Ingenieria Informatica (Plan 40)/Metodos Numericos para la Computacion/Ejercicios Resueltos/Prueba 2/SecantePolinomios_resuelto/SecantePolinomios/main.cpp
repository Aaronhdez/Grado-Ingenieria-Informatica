#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_raices_polinomios.h"
#include "../tnt_array/tnt.h"
#include "mn_aritmeticas.h"

int main()
{
    cout << "EJEMPLO 1 (METODO FUNCIONA)\n";
    Array1D< real > a(4);
    a[0]=-6.; a[1]=1.; a[2]=-7.; a[3]=1.;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3" << endl;
    // DEFINIMOS LA TOLERANCIA PARA LA PRECISIÓN DEL MÉTODO Y EL MAXIMO DE ITERACIONES
    real TOL=1e-15;
    int NMaxIter=100;
    // DEFINIMOS x0 y x1
    real x0=0.;
    real x1=1.;
    cout << "x0= " << x0 << "  x1= " << x1 << "\n";
    // CALCULAMOS LAS RAÍCES
    real root;
    int result=calculo_ceros_secante(a,x0,x1,TOL,NMaxIter);
    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "(alumno) x0= " << x0 << "  x1= " << x1 ;
      cout << "  ->  P(x1) = "<< evaluar_polinomio(a,x1) << endl;
    }
    else{
      cout << "El método no ha funcionado\n";
    }

    system("pause");
    cout << "\nEJEMPLO 2 (METODO FALLA)\n";
    a.resize(3);
    a[0]=1.; a[1]=0.; a[2]=1.;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2" << endl;
    // DEFINIMOS INTERVALO
    x0=1.;
    x1=2.;
    cout << "x0= " << x0 << "  x1= " << x1 << "\n";
    result=calculo_ceros_secante(a,x0,x1,TOL,NMaxIter);

    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "x0= " << x0 << "  x1= " << x1 ;
      cout << "  ->  P(x1) = "<< evaluar_polinomio(a,x1) << endl;
    }
    else{
      cout << "El metodo no ha funcionado (alumno)\n";
    }

    system ("pause");
}

