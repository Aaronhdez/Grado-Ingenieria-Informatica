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
    /// Revisamos que los dos arrays sean estrictamente iguales.
    if(X.dim() != F.dim()){
        return Array1D<real>();
    }
    /// Si no lo fuesen, iteramos. Creoando dos arrays previamente.
    Array1D< real > A(X.dim());
    int N=X.dim()-1;
    Array1D< real > B(A.dim());

    /// Cargamos el Array de funciones en B.
    for(int i=0; i<=N; i++){
        B[i]=F[i];
    }
    /// Preparamos el primer valor de la función.
    A[0] = F[0];
    /// Ahora recorremos el array de X, verificando que se cumples las condiciones de Newton
    for(int i=1; i<=N; i++){
        for(int k=0; k<=(N-i); k++){
            /// Si en algún momento secumple la condición de que el punto es igual al siguiente, sacamos un array nulo
            if(X[i+k]==X[k]){
                return Array1D<real>();
            }
            /// Si no, retornamos en el punto la formula f(x+1)-f(x)/(x+1)-x.
            B[k] = (B[k+1]-B[k])/(X[i+k]-X[k]);
        }
        A[i] = B[0];
    }
    return A;
}


/// FUNCION QUE EVALUA EL POLINOMIO INTERPOLADOR DE NEWTON EN UN PUNTO
real mn_evaluar_polinomio_interpolador(
const Array1D< real > &A, // VECTOR CON LOS COEFICIENTES DEL POLINOMIO
const Array1D< real > &X, // VECTOR CON LOS VALORES DE LOS PUNTOS DE INTERPOLACION
const real X0) // VALOR DONDE SE INTERPOLA EL POLINOMIO
{
  /// HACER ALUMNO
    /// Preparamos el polinomio nuevo.
    int N=A.dim()-1;
    /// Colocamos el polinomio al final y recorremos.
    real res=A[N];
    /// Por cada vuelta incrementamos res a su resultado mas el polinomio.
    for(int i=N-1; i>=0; i--){
        res = res*(X0-X[i])+A[i];
    }
    return res;
}


