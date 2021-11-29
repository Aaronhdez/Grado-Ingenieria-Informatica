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

    ///Creamos dos variable y evaluamos el prolinomio usando Horner
    real Px0;
    real Ppx0;
    mn_evaluar_polinomio_horner(a,x0,Px0,Ppx0);

  /// HACER ALUMNO
    for(int i=0; i<NMaxIter; i++){
        ///Si polinomio == 0 -> retornamos 0
        if(Px0 == 0.){
            return 0;
        }
        /// Si la evaluaci�n en i de px es 0, no se continua
        if(Ppx0 == 0.){
            return -1;
        }
        /// Calcualmos el siguiente
        real x1 = x0-(Px0/Ppx0);
        if(fabs(x1-x0)<TOL*(fabs(x1)+1.)){
            x0 = x1;
            return 0;
        }
        x0=x1;
        mn_evaluar_polinomio_horner(a,x0,Px0,Ppx0);
    }
    return -1;
}


