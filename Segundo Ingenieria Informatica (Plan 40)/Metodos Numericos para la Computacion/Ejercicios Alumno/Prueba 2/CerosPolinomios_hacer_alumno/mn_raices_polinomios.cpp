/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/// *************************************************************************************
///         EVALUACIÓN DE UN POLINOMIO a EN UN PUNTO x POR EL MÉTODO DE HORNER
/// *************************************************************************************
real evaluar_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real x /** valor donde se evalua el polinomio */){

  /// HACER ALUMNO
  real Px=a[a.dim()-1];
  for(int k=a.dim()-2;k>=0;k--){
    Px=Px*x+a[k];
  }
  return Px;
}

/// *************************************************************************************
/// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL MÉTODO DE LA BISECCIÓN
/// ANTES DE LLAMAR A LA FUNCIÓN SE HA VERIFICADO QUE HAY CAMBIO DE SIGNO
/// *************************************************************************************
real calculo_ceros_biseccion(
Array1D< real > &P /** coeficientes polinomio */,
real a,real b /** intervalo donde buscar la raíz */,
real Pa,real Pb /** valor del polinomio evaluado en a y b */,
real TOL /** Tolerancia para el criterio de parada */){

  /// HACEMOS LAS ITERACIONES PARA REFINAR EL INTERVALO
  while ( fabs(b-a)>TOL*(fabs(a)+1.) ){
    real xm=(a+b)/2.; /// calculamos el punto medio
    real Pxm=evaluar_polinomio(P,xm); /// evaluamos el polinomio en el punto medio
    if(Pxm==0.) return xm; /// si el polinomio vale cero devolvemos C
    /// ACTUALIZAMOS a ó b EN FUNCION DE LOS CAMBIOS DE SIGNO
    if(Pa*Pxm<0.){
      b=xm;
      Pb=Pxm;
    }
    else{
      a=xm;
      Pa=Pxm;
    }
  }
  /// DEVOLVEMOS EL PUNTO MEDIO FINAL
  return (a+b)/2.;
}

/// ****************************************************
///        CALCULO POLINOMIO DERIVADA
/// ****************************************************
Array1D< real > calcular_derivada_polinomio(
Array1D< real > &a /** coeficientes del polinomio */){

  /// HACER ALUMNO
  if(a.dim()==1) return Array1D< real >();
  Array1D< real > b(a.dim()-1);
  for(int k=0;k<b.dim();k++){
    b[k]=(k+1.)*a[k+1];
  }
  //b.print("b");
  return b;
}

/// *************************************************************************************
/// CALCULO RAÍCES DE UN POLINOMIO Y DE SUS DERIVADAS
/// DEVUELVE UN VECTOR DE VECTORES DONDE LA POSICIÓN k
/// SEÑALA A UN VECTOR CON LOS CEROS DE LA DERIVADA k ÉSIMA
/// SE PUEDEN USAR LAS FUNCIONES :
///   Array1D< real > calcular_derivada_polinomio(Array1D< real > &a)
///   real calculo_ceros_biseccion(Array1D< real > &P,real a,real b, real Pa,real Pb,real TOL)
///   real evaluar_polinomio( Array1D< real > &a,real x){
///   el método push_back() para añadir elementos a un Array1D
/// *************************************************************************************
Array1D <Array1D< real > >calcular_ceros_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real TOL /** Tolerancia para el método de la bisección */){

  /// HACER ALUMNO

}

