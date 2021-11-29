/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/// ESTE CÓDIGO SOLO VALE PARA ESTA PRÁCTICA Y NO ES UNA IMPLEMENTACIÓN VÁLIDA
/// DEVUELVE LAS RAÍCES DE LOS POLINOMIOS DERIVADAS DE LOS EJEMPLOS DE LA PRÁCTICA
Array1D< real >  calcular_ceros_polinomio_grado3(Array1D< real > &a){
  Array1D< real > Ceros;
  if(fabs(evaluar_polinomio(a,-0.1211307545))<1e-5) Ceros.push_back(-0.1211307545);
  if(fabs(evaluar_polinomio(a,3.771838191))<1e-5) Ceros.push_back(3.771838191);
  if(fabs(evaluar_polinomio(a,9.849292563))<1e-5) Ceros.push_back(9.849292563);

  if(fabs(evaluar_polinomio(a,0.3357948406))<1e-5) Ceros.push_back(0.3357948406);
  if(fabs(evaluar_polinomio(a,2.728567744))<1e-5) Ceros.push_back(2.728567744);
  if(fabs(evaluar_polinomio(a,8.185637415))<1e-5) Ceros.push_back(8.185637415);

  if(fabs(evaluar_polinomio(a,-2.538016837))<1e-5) Ceros.push_back(-2.538016837);
  if(fabs(evaluar_polinomio(a,0.7880168370))<1e-5) Ceros.push_back(0.7880168370);
  if(fabs(evaluar_polinomio(a,4.))<1e-5) Ceros.push_back(4.);

  if(fabs(evaluar_polinomio(a,3.))<1e-5) Ceros.push_back(3.);

  return Ceros;
};

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

/// ***************************************************************************************
/// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL MÉTODO DE LA BISECCIÓN
/// ANTES DE LLAMAR A LA FUNCIÓN SE HA VERIFICADO QUE HAY CAMBIO DE SIGNO (ES DECIR Pa*Pb<0)
/// ***************************************************************************************
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



/// *******************************************************************************************************************
/// CALCULO RAÍCES DE UN POLINOMIO DE GRADO 4 (SOLO PARA GRADO 4)
/// DEVUELVE UN VECTOR CON LAS RAÍCES DEL POLINOMIO
/// EL MÉTODO SE BASA EN SEPARAR LAS RAÍCES EN 4 INTERVALOS Y APLICAR EL MÉTODO DE LA
/// BISECCIÓN PARA CADA INTERVALO. SE USARÁN LAS SIGUIENTES FUNCIONES YA IMPLEMENTADAS:
///      evaluar_polinomio() PARA EVALUAR UN POLINOMIO EN UN PUNTO
///      calculo_ceros_biseccion() PARA CALCULAR LA RAÍZ EN UN INTERVALO
///      calcular_ceros_polinomio_grado3(Array1D< real > &a) devuelve un Array1D con los ceros polinomio grado 3
/// PARA AÑADIR UN ELEMENTO A UN VECTOR SE PUEDE USAR EL MÉTODO push_back() DE LA CLASE Array1D
/// *******************************************************************************************************************
Array1D< real > calcular_ceros_polinomio_grado4(
Array1D< real > &P /** coeficientes polinomio */,
real TOL /** Tolerancia para el método de la bisección */){

  /// HACER ALUMNO

  /// COMPROBACIÓN PARÁMETROS
  Array1D< real > raices;
  if(P.dim()!=5 || P[4]==0) return raices;

  /// CALCULO INTERVALO DONDE ESTÁN LAS RAÍCES
  double xmax=fabs(P[3]);
  for(int k=0;k<3;k++){
    if(xmax<fabs(P[k])) xmax = fabs(P[k]);
  }
  xmax=1.+xmax/P[4];

  /// CEROS POLINOMIO DERIVADA
  Array1D<real> Pp(4);
  for(int k=0;k<4;k++) Pp[k]=P[k+1]*(k+1);
  //Pp.print("Pp");
  Array1D<real> Ceros3=calcular_ceros_polinomio_grado3(Pp);
  //Ceros3.print("Ceros3");

  /// SE AÑADEN LOS EXTREMOS DEL INTERVALO INICIAL EN LA PRIMERA POSICIÓN Y ÚLTIMA DEL VECTOR DE CEROS DE LA DERIVADA
  Ceros3.resize(Ceros3.dim()+2);
  for(int k=Ceros3.dim()-2;k>0;k--) Ceros3[k]=Ceros3[k-1];
  Ceros3[0]=-xmax;
  Ceros3[Ceros3.dim()-1]=xmax;

  /// CALCULO CEROS POR INTERVALOS
  for(int k=0;k<Ceros3.dim()-1;k++){
    double x1=Ceros3[k];
    double x2=Ceros3[k+1];
    double P1=evaluar_polinomio(P,x1);
    double P2=evaluar_polinomio(P,x2);
    //printf("x1=%lf x2=%lf P1=%lf P2=%lf\n",x1,x2,P1,P2);
    if(P1==0.){
      raices.push_back(x1);
      continue;
    }
    if(P1*P2<0.){
      raices.push_back(calculo_ceros_biseccion(P,x1,x2,P1,P2,TOL));
    }
  }
  return raices;


}

