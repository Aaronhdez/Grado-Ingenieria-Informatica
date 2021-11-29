/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/// EVALUACIÓN DE UN POLINOMIO a EN UN PUNTO x
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

// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL MÉTODO DE LA REGULA FALSI
// DEVUELVE 0 SI ENCUENTRA LA RAÍZ Y -1 EN CASO CONTRARIO
int calculo_ceros_regula_falsi(
Array1D< real > &a /** coeficientes polinomio */,
real A,real B /** intervalo donde buscar la raíz */,
real TOL /** Tolerancia para el criterio de parada */,
real &root /** variable donde se devuelve la raíz */,
int NMaxIter /** número máximo de iteraciones */){

  // HACER ALUMNO

  // EVALUAMOS EL POLINOMIO EN A Y B
  real P_A=evaluar_polinomio(a,A);
  real P_B=evaluar_polinomio(a,B);
  // COMPROBAMOS SI HAY CAMBIO DE SIGNO
  if(P_A*P_B>0){
    return -1;
  }
  root=A-(B-A)*P_A/(P_B-P_A);
  real P_root=evaluar_polinomio(a,root);
  // HACEMOS LAS ITERACIONES PARA REFINAR A , B Y x
  for(int k=0;k<NMaxIter;k++){
    //cout << "k= " << k << " -> root = " << root << endl;
    if(P_root==0.){  // si el polinomio vale cero  en root
      return 0;
    }
    // ACTUALIZAMOS A ó B EN FUNCION DE LOS CAMBIOS DE SIGNO
    if(P_A*P_root<0.){
      B=root;
      P_B=P_root;
    }
    else{
      A=root;
      P_A=P_root;
    }
    // CALCULAMOS NUEVA RAÍZ
    real rootNew=A-(B-A)*P_A/(P_B-P_A);
    // APLICAMOS CRITERIO DE PARADA
    if(fabs(root-rootNew)<TOL*(fabs(rootNew)+1.) ){
      root=rootNew;
      return 0;
    }
    // ACTUALIZAMOS root
    root=rootNew;
    P_root=evaluar_polinomio(a,root);

  }
  // NUMERO DE ITERACIONES MAXIMO EXCEDIDO
  return -1;
}


