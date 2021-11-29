// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_mascara3x3.h"

/// FUNCI�N QUE APLICA UNA M�SCARA 3X3 A UNA FUNCI�N TABULADA F[][]
/// Y RETORNA LA MATRIZ RESULTADO
/// SE DEVUELVE UNA MATRIZ VAC�A SI HAY ALG�N PROBLEMA
Array2D< real > mn_mascara3x3(
Array2D< real > &F, /// funci�n tabulada
Array2D< real > &m) /// coeficientes m�scara 3x3
{
  /// HACER ALUMNO
  if(F.dim1()<1 || F.dim2()<1 || m.dim1()!=3 || m.dim2()!=3) return Array2D< real >();

  /// SE DECLARA E INICIALIZA A CERO LA MATRIZ RESULTADO
  Array2D< real > M(F.dim1(),F.dim2(),0.);

  /// SE GESTIONA EL BUCLE INTERIOR PRINCIPAL
  for(int i=1;i<M.dim1()-1;i++){
    for(int j=1;j<M.dim2()-1;j++){
      for(int k=-1;k<2;k++){
        for(int l=-1;l<2;l++){
          M[i][j]+=m[k+1][l+1]*F[k+i][l+j];
        }
      }
    }
  }

  /// SE GESTIONAN LOS BORDES HORIZONTALES DE LA MATRIZ
   for(int j=1;j<M.dim2()-1;j++){
      for(int k=-1;k<2;k++){
        for(int l=-1;l<2;l++){
          M[0][j]+=m[k+1][l+1]*F[max(k,0)][l+j];
          M[M.dim1()-1][j]+=m[k+1][l+1]*F[M.dim1()-1+min(k,0)][l+j];
        }
      }
  }

  /// SE GESTIONAN LOS BORDES VERTICALES DE LA MATRIZ
  for(int i=1;i<M.dim1()-1;i++){
      for(int k=-1;k<2;k++){
        for(int l=-1;l<2;l++){
          M[i][0]+=m[k+1][l+1]*F[k+i][max(l,0)];
          M[i][M.dim2()-1]+=m[k+1][l+1]*F[k+i][M.dim2()-1+min(l,0)];
        }
      }
  }

  /// SE GESTIONAN LAS ESQUINAS
  for(int k=-1;k<2;k++){
    for(int l=-1;l<2;l++){
      M[M.dim1()-1][M.dim2()-1]+=m[k+1][l+1]*F[M.dim1()-1+min(k,0)][M.dim2()-1+min(l,0)];
      M[0][M.dim2()-1]+=m[k+1][l+1]*F[max(k,0)][M.dim2()-1+min(l,0)];
      M[M.dim1()-1][0]+=m[k+1][l+1]*F[M.dim1()-1+min(k,0)][max(l,0)];
      M[0][0]+=m[k+1][l+1]*F[max(k,0)][max(l,0)];
    }
  }


  return M;

}
