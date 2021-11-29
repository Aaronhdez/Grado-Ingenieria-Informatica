/// *========================================================================
///  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
///  ======================================================================== */

///  INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/// EVALUACI�N DE UN POLINOMIO a EN UN PUNTO x
real evaluar_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real x /** valor donde se evalua el polinomio */){

  /// HACER ALUMNO
    real Px = a[0];
    real xk = x;

    for(int i=1; i<a.dim();i++){
        Px = Px+a[i]*xk;
        xk = xk*x;
    }
    return Px;
}

/// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL M�TODO DE LA BISECCI�N
/// DEVUELVE 0 SI ENCUENTRA LA RA�Z Y -1 EN CASO CONTRARIO
int calculo_ceros_biseccion(
Array1D< real > &a /** coeficientes polinomio */,
real A,real B /** intervalo donde buscar la ra�z */,
real TOL /** Tolerancia para el criterio de parada */,
real &root /** variable donde se devuelve la ra�z */){

  /// HACER ALUMNO
    ///Se comprueba el cambio de signo
    real Pol_a = evaluar_polinomio(a,A);
    real Pol_b = evaluar_polinomio(a,B);

    ///Si hay cambio retorna.
    if(Pol_a*Pol_b > 0){
        return -1;
    }

    ///Si no lo hay, aplicamos la bisecci�n
    while(fabs(A-B)>TOL*(fabs(A)+1.)){
        real C = (A+B)*0.5;
        real Pol_c = evaluar_polinomio(a,C);
        if(Pol_c == 0.){
            root = C;
            return 0;
        }
        if(Pol_a*Pol_c<.0){
            B = C;
            Pol_b = Pol_c;
        } else {
            A = C;
            Pol_a = Pol_c;
        }
    }
    root = (A+B)*0.5;
    return 0;
}


