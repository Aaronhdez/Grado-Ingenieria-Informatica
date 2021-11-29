/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// FUNCIÓN PARA CALCULAR UN ZOOM DE FACTOR z A UN Array2D< real >
/// USANDO INTERPOLACIÓN BILINEAL
/// SE CONSIDERA QUE LA DISTANCIA ENTRE LOS PIXELS DEL Array2D ES 1
/// DADO UN PUNTO EN LA IMAGEN DE ÍNDICES (i,j) SI AL ACCEDER AL
/// PUNTO (i+1,j) NOS SALIMOS DE LA IMAGEN, TOMAMOS EN SU LUGAR EL PUNTO (i,j)
/// LO MISMO SI NOS SALIMOS AL ACCEDER A (i,j+1) O (i+1,j+1)
/// PARA VALIDAR LOS RESULTADOS DESDE EL main() SE LEE LA IMAGE eiiBW.bmp Y SE GUARDA
/// EL RESULTADO DEL ZOOM OBTENIDO POR EL ALUMNO EN LA IMAGEN  eiiBW_zoom.bmp
/// SE DEBE MIRAR DICHA IMAGEN PARA COMPROBAR SI LOS RESULTADOS SON COHERENTES
Array2D< real > zoom(Array2D< real > &A,real z){
  /// HACER ALUMNO

  /// CALCULAMOS DIMENSIONES DE LA NUEVA MATRIZ
  int dim1New=A.dim1()*z;
  int dim2New=A.dim2()*z;

  /// COMPROBAMOS QUE LAS DIMENSIONES DE LA NUEVA MATRIZ SON POSITIVAS
  if(dim1New<=0 || dim2New<=0) return Array2D< real >();


  /// DEFINIMOS EL Array2D DE SALIDA
  Array2D< real > B(dim1New,dim2New);

  /// RECORREMOS EL Array2D DE SALIDA Y APLICAMOS LA FÓRMULA DE INTERPOLACIÓN
  for(int ip=0;ip<B.dim1();ip++){
    for(int jp=0;jp<B.dim2();jp++){
      real x=ip/z;
      real y=jp/z;
      int i=x;
      int j=y;
      int i1=min(i+1,A.dim1()-1);
      int j1=min(j+1,A.dim2()-1);
      real dx=x-i;
      real dy=y-j;
      B[ip][jp]=(1.-dx)*(1.-dy)*A[i][j] +
                dx*(1.-dy)*A[i1][j] +
                (1.-dx)*dy*A[i][j1] +
                dx*dy*A[i1][j1];
    }
  }
  return B;
}
