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
Array1D< real > &a /** COEFICIENTES POLINOMIO */,
real x /** VALOR DONDE SE EVALUA EL POLINOMIO */){
  real Px=a[a.dim()-1]; /// SE USA EL METODO DE HORNER
  for(int k=a.dim()-2;k>=0;k--){
    Px=Px*x+a[k];
  }
  return Px;
}

/// ***************************************************************************************
/// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL MÉTODO DE LA BISECCIÓN
/// ANTES DE LLAMAR A LA FUNCIÓN SE HA VERIFICADO QUE HAY CAMBIO DE SIGNO (ES DECIR Pa*Pb<0)
/// ***************************************************************************************
real biseccion(
Array1D< real > &P /** COEFICIENTES POLINOMIO */,
real a,real b /** INTERVALO DONDE BUSCAR EL CERO */,
real Pa,real Pb /** VALOR DEL POLINOMIO EVALUADO EN a Y b*/,
real TOL /** TOLERANCIA PARA EL CRITERIO DE PARADA */){
  /// HACEMOS LAS ITERACIONES PARA REFINAR EL INTERVALO
  while ( fabs(b-a)>TOL*(fabs(a)+1.) ){
    real xm=(a+b)/2.; /// calculamos el punto medio
    real Pxm=evaluar_polinomio(P,xm); /// evaluamos el polinomio en el punto medio
    if(Pxm==0.) return xm; /// si el polinomio vale cero devolvemos xm
    /// ACTUALIZAMOS a ó b EN FUNCION DE LOS CAMBIOS DE SIGNO
    if(Pa*Pxm<0.){ b=xm;  Pb=Pxm; }
    else{ a=xm; Pa=Pxm;}
  }
  /// DEVOLVEMOS EL PUNTO MEDIO FINAL
  return (a+b)/2.;
}




/// *******************************************************************************************************************
/// CALCULO RAÍCES DE UN POLINOMIO DE GRADO 3 (SOLO PARA GRADO 3)
/// DEVUELVE UN VECTOR CON LAS RAÍCES DEL POLINOMIO
/// EL MÉTODO SE BASA EN SEPARAR LAS RAÍCES EN 3 INTERVALOS Y APLICAR EL MÉTODO DE LA
/// BISECCIÓN PARA CADA INTERVALO. SE USARÁN LAS SIGUIENTES FUNCIONES YA IMPLEMENTADAS:
///      evaluar_polinomio() PARA EVALUAR UN POLINOMIO EN UN PUNTO
///      biseccion() PARA CALCULAR LA RAÍZ EN UN INTERVALO
/// PARA AÑADIR UN ELEMENTO A UN VECTOR SE PUEDE USAR EL MÉTODO push_back() DE LA CLASE Array1D
/// *******************************************************************************************************************
Array1D< real > calcular_ceros_polinomio_grado3(
Array1D< real > &P /** COEFICIENTES POLINOMIO */,
real TOL /** TOLERANCIA PARA EL METODO DE LA BISECCION */){
  /// HACER ALUMNO
  /// Polinomio de menos de grado 3
  Array1D< real > r
  if(P[3]==0 || P.dim()!=4){
    return -1;
  }
  /// Calculamos el máximo
  double pmax = fabs(P[2]);
  if(P[1]>pmax){
    pmax = P[1];
  }
  if(P[0]>pmax){
    pmax = P[0];
  }
  pmax = 1+pmax/P[3];
  ///Constriumos el polinomio derivada
  double a=3*P[3]+, b=2*P[2], c=1*P[1], d=1.;
  ///Creamos un vector con los extremos de los intervalos
  x.push_back(-pmax);




  return r;
}

