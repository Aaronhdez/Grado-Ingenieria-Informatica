#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "mn_raices_polinomios.h"
#include "../tnt_array/tnt.h"
#include "mn_aritmeticas.h"

int main()
{
    cout << "EJEMPLO 1\n";
    Array1D< real > a(5);
    a[0]=6.; a[1]=1.; a[2]=-7.; a[3]=-1.; a[4]=1;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3 + " << a[4] << "x^4" << endl;
    cout << "Comprobamos la funcion que calcula el polinomio derivada : " << "\n";
    cout << " Polinomio derivada real : " << "\n";
    cout << "   P'(x)= " << 1 << " + " << -14 << "x + " << -3 << "x^2 + " << 4 << "x^3"  << endl;
    Array1D< real > b=mn_calculo_polinomio_derivada(a);
    cout << " Polinomio derivada alumno : " << "\n";
    cout << "   P'(x)= " << b[0] << " + " << b[1] << "x + " << b[2] << "x^2 + " << b[3] << "x^3"  << endl;

    // DEFINIMOS LA TOLERANCIA PARA LA PRECISIÓN DEL MÉTODO Y EL MAXIMO DE ITERACIONES
    real TOL=1e-15;
    int NMaxIter=100;
    // DEFINIMOS APROXIMACION INICIAL
    real x0=2;
    cout << "\nAproximacion inicial Metodo de Muller : x0 = " << x0 << "\n";
    // CALCULAMOS LAS RAÍCES
    int result=calculo_ceros_Muller(a,x0,TOL,NMaxIter);
    cout << " Numero de iteraciones reales = " << 4 << "\n";
    cout << " Numero de iteraciones alumno = " << result << "\n";
    cout << "\n Raiz que debe encontrar el metodo : x0 = " << 1 << "\n";
    cout << " Raiz encontrada por el alumno : x0 = " << x0 << "\n";


    cout << "\nPara pasar al EJEMPLO 2" << "\n";
    system("pause");

    cout << "\nEJEMPLO 2\n";
    a[0]=1.; a[1]=0.; a[2]=0.; a[3]=0.; a[4]=1;
    cout << "P(x)= " << a[0] << " + " << a[1] << "x + " << a[2] << "x^2 + " << a[3] << "x^3 + " << a[4] << "x^4" << endl;
    cout << "Comprobamos la funcion que calcula el polinomio derivada : " << "\n";
    cout << " Polinomio derivada real : " << "\n";
    cout << "   P'(x)= " << 0 << " + " << 0 << "x + " << 0 << "x^2 + " << 4 << "x^3"  << endl;
    b=mn_calculo_polinomio_derivada(a);
    cout << " Polinomio derivada alumno : " << "\n";
    cout << "   P'(x)= " << b[0] << " + " << b[1] << "x + " << b[2] << "x^2 + " << b[3] << "x^3"  << endl;

    // DEFINIMOS APROXIMACION INICIAL
    x0=2;
    cout << "\nAproximacion inicial Metodo de Muller : x0 = " << x0 << "\n";
    // CALCULAMOS LAS RAÍCES
    result=calculo_ceros_Muller(a,x0,TOL,NMaxIter);
    cout << " Numero de iteraciones reales = " << -1 << "\n";
    cout << " Numero de iteraciones alumno = " << result << "\n";
    system ("pause");
}

