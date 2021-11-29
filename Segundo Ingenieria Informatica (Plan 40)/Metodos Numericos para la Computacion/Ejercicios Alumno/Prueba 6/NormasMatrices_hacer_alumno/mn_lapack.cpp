/*========================================================================
  FUNCIONES RELACIONADAS CON LA RESOLUCION DE SISTEMAS DE ECUACIONES
  ======================================================================== */

// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "mn_lapack.h"

/// FUNCIÓN QUE DEVUELVE LA NORMA 1 DE LA MATRIZ A. SE DEVUELVE -1 SI TERMINA MAL
double norma_1(Array2D< real > &A){
  /// HACER ALUMNO
  real norm = 0;

  for(int i=0; i<A.dim1(); i++){
    real sum = 0.;
    for(int j=0; j<A.dim2(); j++){
        sum += fabs(A[j][i]);
    }
    if(sum>norm){
        norm = sum;
    }
  }
  return norm;
}

/// FUNCIÓN QUE DEVUELVE LA NORMA INFINITO DE LA MATRIZ A.SE DEVUELVE -1 SI TERMINA MAL
double norma_infinito(Array2D< real > &A){
  /// HACER ALUMNO
  real norm = 0;

  for(int i=0; i<A.dim1(); i++){
    real sum = 0.;
    for(int j=0; j<A.dim2(); j++){
        sum += fabs(A[i][j]);
    }
    if(sum>norm){
        norm = sum;
    }
  }
  return norm;
}

/// FUNCIÓN QUE DEVUELVE LA NORMA 2 DE LA MATRIZ A
/// SE UTILIZA LA FUNCIÓN mn_metodo_potencia() QUE FIGURA DEBAJO PARA CALCULAR EL AUTOVALOR MÁXIMO
/// TOMANDO umax=(1,1,...,1) COMO APROXIMACIÓN INICIAL DEL AUTOVECTOR Y LOS PARÁMETROS
/// TOL Y Nmax. TAMBIEN SE USA EL MÉTODO transpose() DE LA CLASE Array2D PARA CALCULAR LA MATRIZ TRASPUESTA
/// SE DEVUELVE -1 SI TERMINA MAL
double norma_2(Array2D< real > &A,real TOL,int Nmax){
  /// HACER ALUMNO
  Array2D<real> AAT=A.transpose()*A;
  Array1D<real> umax(A.dim1(),1);
  real lmax;
  int niter = mn_metodo_potencia(AAT, umax, lmax, Nmax, TOL);
  if(niter != 0){
    return sqrt(lmax);
  }
}


/** FUNCION PARA CALCULAR EL AUTOVALOR Y AUTOVECTOR MAXIMO POR EL METODO DE LA
POTENCIA. EL AUTOVALOR Y AUTOVECTOR SE PASAN COMO PARAMETROS.
LA FUNCION RETORNA EL NUMERO DE ITERACIONES REALIZADO SI TERMINA BIEN Y UN
NUMERO NEGATIVO SI TERMINA MAL. SE PUEDEN USAR LOS MÉTODOS DE LA CLASE
Array1D norma() PARA CALCULAR LA NORMA Y EL OPERADOR * PARA EL CALCULO DEL
PRODUCTO ESCALAR
*/
int mn_metodo_potencia(
Array2D< real > &A, // MATRIZ PARA APLICAR EL METODO DE LA POTENCIA
Array1D< real > &u_max, // AUTOVECTOR MAXIMO CALCULADO (DEBE ESTAR INICIALIZADO AL ENTRAR)
real &l_max,  // AUTOVALOR MAXIMO
int Nmax, // NUMERO ITERACIONES MAXIMO
real TOL) // TOLERANCIA PARA LA CONVERGENCIA DEL ALGORITMO
{
  l_max=u_max.norma();
  /// NORMALIZAMOS VECTOR
  u_max=u_max/l_max;
  for(int i=0;i<Nmax;i++){
    Array1D< real > u_new=A*u_max;
    real l_new=u_new.norma();
    if( l_new==0) return(-2);
    if(u_new*u_max<0.) l_max=-l_new;
    else l_max=l_new;
    u_new=u_new/l_max;
    if( (u_new-u_max).norma()<TOL ){
      u_new=u_max;
      return(i);
    }
    u_max=u_new;
  }
  return(-3);
}






