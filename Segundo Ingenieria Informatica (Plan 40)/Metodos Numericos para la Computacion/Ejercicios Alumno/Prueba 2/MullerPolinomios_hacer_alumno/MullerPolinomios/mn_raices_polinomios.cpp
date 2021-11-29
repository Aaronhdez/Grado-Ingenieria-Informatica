/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/** FUNCION QUE IMPLEMENTA EL CALCULO DE LAS RAICES DE UN POLINOMIO DE GRADO 2
EL POLINOMIO ES a*x^2+b*x+c Y LAS RAÍCES SE DEVUELVEN EN LOS PARÁMETROS
DE ENTRADA SALIDA x1 y x2.
LA FUNCIÓN RETORNA EL NÚMERO DE RAÍCES ENCONTRADAS */
int mn_ceros_pol_grado_2(
real a, real b, real c, // coeficientes polinomio de grado 2
real &x1,
real &x2)
{
  // HACER ALUMNO
  if(a==0){
    if(b==0) return(0);
    x1=-c/b;
    return(1);
  }
  real dis=b*b-4*a*c;
  if(dis<0) return(0);
  dis=sqrt(dis);
  if(b>0){
    x1=(-b-dis)/(2*a);
    x2=c/(x1*a);
    return(2);
  }
  else{
    x1=(-b+dis)/(2*a);
    x2=c/(x1*a);
    return(2);
  }
}


/** EVALUACIÓN DE UN POLINOMIO a EN UN PUNTO x */
real evaluar_polinomio(
Array1D< real > &a /** coeficientes polinomio */,
real x /** valor donde se evalua el polinomio */){
  real Px=a[0]; // inicialización suma polinomio
  real xk=x; // variable para guardar x^k
  for(int k=1;k<a.dim();k++){
    Px=Px+a[k]*xk; // actualizamos
    xk=xk*x; // actualizamos x^k
  }
  return Px; // devolvemos resultado
}


/** CALCULO DEL POLINOMIO DERIVADA. LA FUNCIÓN TIENE COMO ENTRADA
UN VECTOR LOS COEFICIENTES DE UN POLINOMIO  Y COMO SALIDA DEVUELVE
UN VECTOR CON EL POLINOMIO DERIVADA */
Array1D< real > mn_calculo_polinomio_derivada(Array1D< real > &a){
  /// HACER ALUMNO
  ///Sólo termino independiente
    if(a.dim()==0){
        return Array1D< real >();
    }
  ///pdx solo tiene 1 x y el termino independiente
    if(a.dim()==1){
        return Array1D< real >(1,0.);
    }
  ///Declaramos el polinomio con un termino menos.
    Array1D <real> b(a.dim()-1);
    for(int i=0; i<b.dim(); i++){
        b[i] = (i+1)*a[i+1];
    }
    return b;

}

/** CALCULO DE UNA RAIZ DE UN POLINOMIO USANDO EL MÉTODO DE MULLER
DEVUELVE EL NÚMERO DE ITERACIONES REALIZADA SI ENCUENTRA LA RAÍZ Y -1 EN
CASO CONTRARIO. HAY QUE USAR LAS FUNCIONES :
mn_calculo_polinomio_derivada() PARA CALCULAR
EL POLINOMIO DERIVADA PRIMERA Y SEGUNDA, LA FUNCIÓN mn_ceros_pol_grado_2()
PARA CALCULAR LOS CEROS DE UN POLINOMIO DE GRADO 2 Y LA FUNCIÓN
evaluar_polinomio() PARA EVALUAR UN POLINOMIO*/
int calculo_ceros_Muller(
Array1D< real > &a /** coeficientes polinomio */,
real &x0 /** aproximación inicial raíz que se devuelve actualizada*/,
real TOL /** Tolerancia para el criterio de parada */,
int NMaxIter /** número máximo de iteraciones */){

  /** HACER ALUMNO */
    ///Calculamos los polinopmios derivados
    Array1D <real>ap1=mn_calculo_polinomio_derivada(a);
    Array1D <real>ap2=mn_calculo_polinomio_derivada(ap1);

    ///Evaluamos en la función y en sus derivadas
    real px0 = evaluar_polinomio(a,x0);
    real p1x0 = evaluar_polinomio(ap1,x0);
    real p2x0 = evaluar_polinomio(ap2,x0);

    ///iteramos
    for(int i=0; i<NMaxIter; i++){
        if(px0==0.){
            return i;
        }
        ///Calculamos las raices
        real z1,z2;
        real raices=mn_ceros_pol_grado_2(p2x0/2., p1x0, px0, z1, z2);
        if(raices == 0){
            return -1;
        }
        real zmin = z1;
        ///Buscamos la raiz mayor
        if(raices == 2 && fabs(z2)<fabs(z1)){
            zmin = z2;
        }
        ///Calculamos x1
        real x1 = x0+zmin;
        if(mn_distancia(zmin,x0)<TOL){
            x1=x0;
            return i;
        }
        x0 = x1;
        px0 = evaluar_polinomio(a,x0);
        p1x0 = evaluar_polinomio(ap1,x0);
        p2x0 = evaluar_polinomio(ap2,x0);
    }
    return -1;
}


