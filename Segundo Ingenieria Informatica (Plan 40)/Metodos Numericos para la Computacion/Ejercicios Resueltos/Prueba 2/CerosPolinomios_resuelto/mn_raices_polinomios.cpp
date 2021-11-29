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
  int n=a.dim()-1; /// grado del polinomio

  /// COMPROBAMOS QUE EL COEFICIENTE DE MAYOR GRADO NO ES CERO
  if(a[n]==0.) return Array1D <Array1D< real > > ();

  /// CALCULAMOS UN VECTOR DE VECTORES CON LAS DERIVADAS DEL
  /// POLINOMIO ORIGINAL NORMALIZADAS
  Array1D <Array1D< real > > P(n);
  P[0]=a;  /// POLINOMIO ORIGINAL
  for(int k=1;k<P.dim();k++){
    P[k]=calcular_derivada_polinomio(P[k-1]);
  }

  /// CALCULAMOS UN VECTOR DE VECTORES CON LAS RAÍCES DEL
  /// POLINOMIO Y SUS DERIVADAS
  Array1D <Array1D< real > > Ceros(n);

  /// CALCULAMOS LA RAÍZ DE LA DERIVADA n-1 (QUE ES UN POLINOMIO DE GRADO 1)
  Ceros[n-1].push_back(-P[n-1][0]/P[n-1][1]);
  for(int k=n-2;k>=0;k--){
    real Pmax=fabs(P[k][P[k].dim()-2]);
    for(int i=P[k].dim()-3;i>=0;i--){
      if(Pmax<fabs(P[k][i])) Pmax=fabs(P[k][i]);
    }
    Pmax=Pmax/fabs(P[k][P[k].dim()-1])+1.;

    /// CONSTRUIMOS UN VECTOR TEMPORAL CON LOS EXTREMOS DE LOS INTERVALOS
    /// DONDE HAY QUE BUSCAR LOS CEROS
    Array1D< real > T(1,-Pmax);
    for(int i=0;i<Ceros[k+1].dim();i++){
      T.push_back(Ceros[k+1][i]);
    }
    T.push_back(Pmax);

    /// CALCULO RAÍCES
    for(int i=0;i<T.dim()-1;i++){
      real A=T[i];
      real B=T[i+1];
      real PA=evaluar_polinomio(P[k],A);
      real PB=evaluar_polinomio(P[k],B);
      if(PB==0){
        Ceros[k].push_back(B);
        continue;
      }
      if(PB*PA<0){
        Ceros[k].push_back(calculo_ceros_biseccion(P[k],A,B,PA,PB,TOL));
      }
    }
  }

  return Ceros;
}

