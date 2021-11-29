/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

// EVALUACIÓN DE UN POLINOMIO a EN UN PUNTO x
real evaluar_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real x /** valor donde se evalua el polinomio */){

  // HACER ALUMNO

  real Px=a[0]; // inicialización suma polinomio
  real xk=x; // variable para guardar x^k
  for(int k=1;k<a.dim();k++){
    Px=Px+a[k]*xk; // actualizamos
    xk=xk*x; // actualizamos x^k
  }
  return Px; // devolvemos resultado
}

// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL MÉTODO DE LA SECANTE
// DEVUELVE 0 SI ENCUENTRA LA RAÍZ Y -1 EN CASO CONTRARIO
int calculo_ceros_secante(
Array1D< real > &a /** coeficientes polinomio */,
real &x0,real &x1 /** aproximaciones inciales de la raíz que se modifican*/,
real TOL /** Tolerancia para el criterio de parada */,
int NMaxIter /** número máximo de iteraciones */){

  /// HACER ALUMNO
    real px0 = evaluar_polinomio(a,x0);
    real px1 = evaluar_polinomio(a,x1);
    for(int i=0; i<NMaxIter; i++){
        if(px1==0.){
            return 0;
        }
        if(px0==px1){
            return -1;
        }
        real pp = (px1-px0)/(x1-x0);
        real x2 = x1-px1/pp;
        if(mn_distancia(x2,x1)<TOL){
            x0 = x1;
            x1 = x2;
            return 0;
        }
        x0 = x1;
        px0 = px1;
        x1 = x2;
        px1 = evaluar_polinomio(a,x1);
    }
    return -1;
}


