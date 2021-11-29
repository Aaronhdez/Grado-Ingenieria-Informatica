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
    int NMaxIter=10000;
    // DEFINIMOS INTERVALO
    real A=-8.;
    real B=8.;
    cout << "intervalo : [" << A << "," << B << "]\n";
    // CALCULAMOS LAS RAÍCES
    real root;
    int result=calculo_ceros_regula_falsi(a,A,B,TOL,root,NMaxIter);
    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "root (alumno) = " <<  root ;
      cout << "  ->  P(root) = "<< evaluar_polinomio(a,root) << endl;
    }
    else{
      cout << "El método no ha funcionado\n";
    }

    cout << "\nEJEMPLO 2 (METODO FALLA)\n";
    a[0]=-6.; a[1]=1.; a[2]=-7.; a[3]=1.;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3" << endl;
    // DEFINIMOS INTERVALO
    A=8.;
    B=16.;
    cout << "intervalo : [" << A << "," << B << "]\n";
    // CALCULAMOS LAS RAÍCES
    result=calculo_ceros_regula_falsi(a,A,B,TOL,root,NMaxIter);

    // IMPRIMIMOS EL RESULTADO Y COMPROBAMOS QUE LA RAÍZ CALCULADA ES CORRECTA
    // EVALUANDO EL POLINOMIO EN ELLA
    if(result==0){
      cout << "root= " <<  root ;
      cout << "  ->  P(root) = "<< evaluar_polinomio(a,root) << endl;
    }
    else{
      cout << "El metodo no ha funcionado (alumno)\n";
    }



    system ("pause");
}

