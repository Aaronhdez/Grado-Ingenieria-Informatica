/*========================================================================
  FUNCIONES RELACIONADAS CON LA RESOLUCION DE SISTEMAS DE ECUACIONES
  ======================================================================== */

// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "mn_lapack.h"


/** FUNCION PARA CALCULAR EL AUTOVALOR Y AUTOVECTOR MAS CERCANO A UN VALOR DADO
(QUE ES LA APROXIMACIÓN INICIAL DEL AUTOVALOR)
USANDO UNA VARIANTE DEL MÉTODO DE LA POTENCIA INVERSA VISTO EN CLASE
EL AUTOVALOR INICIAL Y EL AUTOVECTOR SE PASAN COMO PARAMETROS.
LA FUNCION RETORNA EL NUMERO DE ITERACIONES REALIZADO SI TERMINA BIEN Y UN
NUMERO NEGATIVO SI TERMINA MAL.
NOTA: EN ESTA FUNCION SE DEBE USAR LA FUNCION mn_gauss() PARA RESOLVER SISTEMAS
DECLARADA ARRIBA, EL MÉTODO DE LA CLASE Array1D norma() PARA CALCULAR LA NORMA Y
EL OPERADOR * PARA EL CALCULO DEL PRODUCTO ESCALAR ENTRE VECTORES
*/
int mn_metodo_potencia(
Array2D< real > &A, /// MATRIZ PARA APLICAR EL METODO DE LA POTENCIA
Array1D< real > &u_min, /// AUTOVECTOR CALCULADO (DEBE ESTAR INICIALIZADO AL ENTRAR)
real &l_min,  /// AUTOVALOR MAS CERCANO AL l_min INICIAL. ESTO ES UN PARAMETRO DE ENTRADA SALIDA. EN LA ENTRADA
              /// ES LA APROXIMACIÓN DEL AUTOVALOR, Y EN LA SALIDA ES EL RESULTADO ACTUALIZADO POR EL METODO
int Nmax, /// NUMERO ITERACIONES MAXIMO
real TOL) /// TOLERANCIA PARA LA CONVERGENCIA DEL ALGORITMO
{
  /// HACER ALUMNO
  for(int k=0;k<A.dim1();k++){
    A[k][k]-=l_min;
  }
  real l_min0=l_min;
  l_min=u_min.norma();
  // NORMALIZAMOS VECTOR
  u_min=u_min/l_min;
  for(int i=0;i<Nmax;i++){
    Array1D< real > u_new=mn_gauss(A,u_min);
    if(u_new.dim()==0) return -1;
    real l_new=u_new.norma();
    if( l_new==0) return(-2);
    if(u_new*u_min<0.) l_min=-l_new;
    else l_min=l_new;
    u_new=u_new/l_min;
    //v.print("v"); system("pause");
    if((u_new-u_min).norma()<TOL ){
      u_new=u_min;
      l_min=l_min0+1./l_min;
      return(i);
    }
    u_min=u_new;
  }
  return(-3);
}


/** FUNCION PARA RESOLVER SISTEMAS POR EL METODO DE GAUSS CON PIVOTACIÓN
    DEVUELVE EL VECTOR SOLUCIÓN DEL SISTEMA SI TERMINA BIEN
    DEVUELVE UN VECTOR VACÍO EN CASO DE ERROR */
Array1D< real > mn_gauss(
  const Array2D< real > &A  /** MATRIZ DEL SISTEMA */,
  const Array1D< real > &b) /** VECTOR DE TERMINOS INDEPENDINENTES */
{
  /** COMPROBAMOS LAS DIMENSIONES DE LA MATRIZ Y EL VECTOR */
  if(A.dim1()!=A.dim2() || A.dim1()!=b.dim() || b.dim()==0) return Array1D<real>();

  /**  HACEMOS UNA COPIA DE A y b PARA MODIFICARLAS */
  Array2D< real > A1=A.copy();
  Array1D< real > b1=b.copy();

  /** DECLARAMOS EL VECTOR SOLUCIÓN QUE SE DEVUELVE SI TERMINA BIEN */
  Array1D< real > u(b.dim()); // vector con la solución que se devuelve

  /** DECLARAMOS EL VECTOR PARA GESTIONAR EL PIVOTEO */
  Array1D<int> piv(b.dim());

  /** HACER ALUMNO */

  /** INICIALIZAMOS EL VECTOR CON EL PIVOTE */
  for(int k=0;k<b.dim();k++) piv[k]=k;

  /** APLICAMOS EL METODO DE GAUSS */
  for(int k=0;k<b.dim();k++){
    /** DETECTAMOS EL MAXIMO DE LA DIAGONAL HACIA ABAJO */
    real max=fabs(A1[piv[k]][k]);
    int kmax=k;
    for(int m=k+1;m<b.dim();m++){
      if(fabs(A1[piv[m]][k])>max){
        max=fabs(A1[piv[m]][k]);
        kmax=m;
      }
    }
    if(kmax!=k){
      int paso=piv[kmax];
      piv[kmax]=piv[k];
      piv[k]=paso;
    }
    /** CONVERTIMOS EN 0 DE LA DIAGONAL HACIA ABAJO */
    for(int j=k+1;j<b.dim();j++){
          real mul=-A1[piv[j]][k]/A1[piv[k]][k];
          A1[piv[j]][k]=0.;
          for(int n=k+1;n<b.dim();n++) A1[piv[j]][n]+=mul*A1[piv[k]][n];
          b1[piv[j]]+=mul*b1[piv[k]];
    }
  }

  /** REMONTE */
  if(A1[piv[b.dim()-1]][b.dim()-1]==0.) return Array1D<real>();
  u[b.dim()-1]=b1[piv[b.dim()-1]]/A1[piv[b.dim()-1]][b.dim()-1];
  for(int k=b.dim()-2;k>=0;k--)
  {
     real sum=0;
     for(int l=k+1;l<b.dim();l++) sum+= A1[piv[k]][l]*u[l];
     u[k]=(b1[piv[k]]-sum)/A1[piv[k]][k];
  }

  return(u);
}







