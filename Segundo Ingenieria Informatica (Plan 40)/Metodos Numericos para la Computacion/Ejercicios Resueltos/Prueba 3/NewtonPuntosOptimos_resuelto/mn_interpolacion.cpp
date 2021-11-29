/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// FUNCION QUE CALCULA LOS PUNTOS DE INTERPOLACION OPTIMOS
/// USANDO N PUNTOS EN UN INTERVALO [a,b]
Array1D< real > mn_puntos_interpolacion_optimos(int N,real a,real b)
{
  if(N<=0) return( Array1D< real >());

  Array1D< real > v(N);

  for (int i=0;i<N;i++)
  {
    v[i] = a+(b-a)*0.5*(1+cos((M_PI*(2*i+1)/(2*N))));
  }

  return(v);
}

/// FUNCION QUE CALCULA EL POLINOMIO INTERPOLADOR POR LAS DIFERENCIAS DE NEWTON
Array1D< real > mn_construir_polinomio_interpolador(
const Array1D< real > &X, // VECTOR CON LOS VALORES DE LOS PUNTOS DE INTERPOLACION
const Array1D< real > &F) // VECTOR DE VALORES DE LA FUNCION EN LOS PUNTOS DE INTERPOLACION
{
  /// HACER ALUMNO

  if(X.dim()!=F.dim()) return(Array1D< real >());
  Array1D< real > A(X.dim());
  int N=X.dim()-1;
  Array1D< real > B(A.dim());

  for(int k=0;k<=N;k++){
    B[k]=F[k];
  }
  A[0]=F[0];
  for(int k=1;k<=N;k++){
    for(int l=0;l<=(N-k);l++){
      if(X[k+l]==X[l]){
        return(Array1D< real >()); // SE RETORNA UN VECTOR VACIO
      }
      B[l]=(B[l+1]-B[l])/(X[k+l]-X[l]);
    }
    A[k]=B[0];
  }
  return(A);
}


// FUNCION QUE EVALUA EL POLINOMIO INTERPOLADOR DE NEWTON EN UN PUNTO
real mn_evaluar_polinomio_interpolador(
const Array1D< real > &A, // VECTOR CON LOS COEFICIENTES DEL POLINOMIO
const Array1D< real > &X, // VECTOR CON LOS VALORES DE LOS PUNTOS DE INTERPOLACION
const real X0) // VALOR DONDE SE INTERPOLA EL POLINOMIO
{
    int N=A.dim()-1;
    // HACER ALUMNO
	real E=A[N];
	for(int k=N-1;k>=0;k--){
      E=E*(X0-X[k])+A[k];
    }

    return E;
}


