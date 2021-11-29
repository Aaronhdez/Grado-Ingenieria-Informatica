///*========================================================================
///  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
///  ======================================================================== */

/// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
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

/// C�DIGO C++ M�TODO HORNER
void mn_evaluar_polinomio_horner(
Array1D< real > &a, /// vector con los coeficientes del polinomio
real x, /// punto donde se evalua el polinomio
real &Px, real &PPx) /// evaluaci�n del polinomio y su derivada (par�metros de salida)
{
  /// HACER ALUMNO

  Px= a[a.dim()-1];
  PPx= a[a.dim()-1];
  for(int k= a.dim()-2;k>0;k=k-1){
    Px= Px*x+a[k];
    PPx= PPx*x+Px;
  }
  Px=Px*x+a[0];
}

/// CALCULO DE UNA RAIZ DE UN POLINOMIO USANDO EL M�TODO DE NEWTON-RAPHSON
/// DEVUELVE 0 SI ENCUENTRA LA RA�Z Y -1 EN CASO CONTRARIO
int calculo_ceros_Newton_Raphson(
Array1D< real > &a /** coeficientes polinomio */,
real &x0 /** aproximaci�n inicial ra�z que se devuelve actualizada*/,
real TOL /** Tolerancia para el criterio de parada */,
int NMaxIter /** n�mero m�ximo de iteraciones */){

  /// HACER ALUMNO

  /// EVALUAMOS EL POLINOMIO Y SU DERIVADA EN x0
  real Px0,PPx0;
  mn_evaluar_polinomio_horner(a,x0,Px0,PPx0);

  /// HACEMOS LAS ITERACIONES PARA REFINAR EL CERO
  for(int k=0;k<NMaxIter;k++){
    ///cout << "k= " << k << " -> x0 = " << x0 << endl;
    if(Px0==0.){  /// si el polinomio vale cero  en x0
      return 0;
    }
    if(PPx0==0.){  /// si la derivada vale 0 no se puede continuar
      return -1;
    }
    /// CALCULAMOS NUEVA RA�Z
    real x1=x0-Px0/PPx0;
    /// APLICAMOS CRITERIO DE PARADA
    if(fabs(x1-x0)<TOL*(fabs(x1)+1.) ){
      x0=x1;
      return 0;
    }
    /// ACTUALIZAMOS x0
    x0=x1;
    mn_evaluar_polinomio_horner(a,x0,Px0,PPx0);

  }
  /// NUMERO DE ITERACIONES MAXIMO EXCEDIDO
  return -1;
}


