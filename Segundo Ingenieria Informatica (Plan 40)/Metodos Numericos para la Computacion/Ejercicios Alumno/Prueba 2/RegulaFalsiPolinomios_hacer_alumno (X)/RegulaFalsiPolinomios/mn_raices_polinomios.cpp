/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_raices_polinomios.h"

/// EVALUACI�N DE UN POLINOMIO a EN UN PUNTO x
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

// CALCULO DE UNA RAIZ DE UN POLINOMIO EN UN INTERVALO USANDO EL M�TODO DE LA REGULA FALSI
// DEVUELVE 0 SI ENCUENTRA LA RA�Z Y -1 EN CASO CONTRARIO
int calculo_ceros_regula_falsi(
Array1D< real > &a /** coeficientes polinomio */,
real A,real B /** intervalo donde buscar la ra�z */,
real TOL /** Tolerancia para el criterio de parada */,
real &root /** variable donde se devuelve la ra�z */,
int NMaxIter /** n�mero m�ximo de iteraciones */){

  /// HACER ALUMNO

    real p_a = evaluar_polinomio(a,A);
    real p_b = evaluar_polinomio(a,B);
    ///evaluamos el polinomio y verificamos el cmabio de signo
    if(p_a*p_b>0){
        return -1.;
    }
    ///Inicializamos las variables reales y el contador;
    root= A-((B-A)*p_a/(p_b-p_a));
    real p_root=evaluar_polinomio(a,root);
    ///Inicialismoa el bucle
    for(int i=0; i<NMaxIter; i++){
        ///verificamos que Px no sea cero;
        if(p_root == 0.){
            return 0;
        }
        ///Comprobamos fa*fx
        if(p_a*p_root<0.){
            B = root;
            p_b = p_root;
        } else {
            A = root;
            p_a = p_root;
        }
        ///Calculamos P_new y su evaluaci�n
        real rootNew= A-((B-A)*p_a/(p_b-p_a));
        ///Corroboramos tolerancia
        if(mn_distancia(root,rootNew)<TOL){
            root = rootNew;
            return 0;
        }
        root = rootNew;
        p_root = evaluar_polinomio(a,root);
    }
    return -1;
}


