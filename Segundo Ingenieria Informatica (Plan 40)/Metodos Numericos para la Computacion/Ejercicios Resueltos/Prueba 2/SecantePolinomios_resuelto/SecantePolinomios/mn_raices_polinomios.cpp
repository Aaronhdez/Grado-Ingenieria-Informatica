/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

// EVALUACI�N DE UN POLINOMIO a EN UN PUNTO x
real evaluar_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real x /** valor donde se evalua el polinomio */){

  // HACER ALUMNO

  real Px=a[0]; // inicializaci�n suma polinomio
  real xk=x; // variable para guardar x^k
  for(int k=1;k<a.dim();k++){
    Px=Px+a[k]*xk; // actualizamos
    xk=xk*x; // actualizamos x^k
  }
  return Px; // devolvemos resultado
}

// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL M�TODO DE LA SECANTE
// DEVUELVE 0 SI ENCUENTRA LA RA�Z Y -1 EN CASO CONTRARIO
int calculo_ceros_secante(
Array1D< real > &a /** coeficientes polinomio */,
real &x0,real &x1 /** aproximaciones inciales de la ra�z que se modifican*/,
real TOL /** Tolerancia para el criterio de parada */,
int NMaxIter /** n�mero m�ximo de iteraciones */){

  // HACER ALUMNO

  // EVALUAMOS EL POLINOMIO EN x0 Y x1
  real P_x0=evaluar_polinomio(a,x0);
  real P_x1=evaluar_polinomio(a,x1);
  // HACEMOS LAS ITERACIONES PARA REFINAR A , B Y x
  for(int k=0;k<NMaxIter;k++){
    //cout << "k= " << k << " -> x0 = " << x0 << "  x1 = " << x1 << endl;
    if(P_x1==0.){  // si el polinomio vale cero  en x1 paramos
      return 0;
    }
    if(P_x1==P_x0){  // no se puede continuar
      return -1;
    }
    // CALCULAMOS LA NUEVA RAIZ x2
    real x2=x1-(x1-x0)*P_x1/(P_x1-P_x0);
    // APLICAMOS CRITERIO DE PARADA
    if(fabs(x2-x1)<TOL*(fabs(x2)+1.) ){
      x0=x1;
      x1=x2;
      return 0;
    }
    // ACTUALIZAMOS x0 y x1
    x0=x1;
    x1=x2;
    P_x0=P_x1;
    P_x1=evaluar_polinomio(a,x1);

  }
  // NUMERO DE ITERACIONES MAXIMO EXCEDIDO
  return -1;
}


