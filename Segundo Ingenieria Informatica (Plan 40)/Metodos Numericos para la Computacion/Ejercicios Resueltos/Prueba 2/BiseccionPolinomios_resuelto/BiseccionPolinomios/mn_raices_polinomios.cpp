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

  real Px=a[0]; /// inicializaci�n suma polinomio
  real xk=x; /// variable para guardar x^k
  for(int k=1;k<a.dim();k++){
    Px=Px+a[k]*xk; /// actualizamos
    xk=xk*x; /// actualizamos x^k
  }
  return Px; /// devolvemos resultado
}

/// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL M�TODO DE LA BISECCI�N
/// DEVUELVE 0 SI ENCUENTRA LA RA�Z Y -1 EN CASO CONTRARIO
int calculo_ceros_biseccion(
Array1D< real > &a /** coeficientes polinomio */,
real A,real B /** intervalo donde buscar la ra�z */,
real TOL /** Tolerancia para el criterio de parada */,
real &root /** variable donde se devuelve la ra�z */){

  /// HACER ALUMNO

  /// EVALUAMOS EL POLINOMIO EN A Y B
  real P_A=evaluar_polinomio(a,A);
  real P_B=evaluar_polinomio(a,B);
  /// COMPROBAMOS SI HAY CAMBIO DE SIGNO
  if(P_A*P_B>0){
    return -1;
  }
  /// HACEMOS LAS ITERACIONES PARA REFINAR A Y B
  while (fabs(A-B)>TOL*(fabs(A)+1.) ){
    real C=(A+B)/2.; /// calculamos el punto medio
    real P_C=evaluar_polinomio(a,C); /// evaluamos el polinomio en el punto medio
    if(P_C==0.){  /// si el polinomio vale cero la ra�z es C
      root=C;
      return 0;
    }
    /// ACTUALIZAMOS A � B EN FUNCION DE LOS CAMBIOS DE SIGNO
    if(P_A*P_C<0.){
      B=C;
      P_B=P_C;
    }
    else{
      A=C;
      P_A=P_C;
    }
  }
  /// DEVOLVEMOS EL PUNTO MEDIO FINAL
  root=(A+B)/2.;
  return 0;
}


