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
  Array1D< real > r; /// VECTOR CON LOS CEROS DEL POLINOMIO
  if(P.dim()!=4 || P[3]==0) return r;
  /// CALCULO INTERVALO INICIAL DONDE ESTAN LOS CEROS
  double Pmax=fabs(P[2]);
  if(Pmax<fabs(P[1])) Pmax = fabs(P[1]);
  if(Pmax<fabs(P[0])) Pmax = fabs(P[0]);
  Pmax=1.+Pmax/P[3];
  /// POLINOMIO DERIVADA
  double a=3*P[3],b=2*P[2],c=P[1],d=b*b-4.*a*c;
  /// CONSTRUIMOS LOS INTERVALOS DONDE ESTAN LOS CEROS
  Array1D< real > x; /// VECTOR CON LOS EXTREMOS DE LOS INTERVALOS
  x.push_back(-Pmax);
  if(d==0.) x.push_back(-b/(2.*a));
  else if(d>0.){
    x.push_back((-b-sqrt(d))/(2.*a));
    x.push_back((-b+sqrt(d))/(2.*a));
  }
  x.push_back(Pmax);
  /// CALCULAMOS LOS CEROS EN CADA INTERVALO
  for(int k=0;k<x.dim()-1;k++){
    real Pk=evaluar_polinomio(P,x[k]);
    real Pk1=evaluar_polinomio(P,x[k+1]);
    if(Pk1==0.) r.push_back(x[k+1]);
    else if(Pk*Pk1<0.) r.push_back(biseccion(P,x[k],x[k+1],Pk,Pk1,TOL));
  }
  return r;
}

