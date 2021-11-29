
// FUNCIONES METODO DE JACOBI
#include "mn_jacobi.h"

/******************************************************************************
// FUNCION QUE CALCULA LOS AUTOVALORES DE UNA MATRIZ (LOS DEVUELVE EN UN ARRAY)
// PARA IMPLEMENTAR LA FUNCI�N TENER EN CUENTA LO SIGUIENTE :
//  (1) la funci�n atan(x) devuelve el arco tangente de x
//*****************************************************************************/
Array1D< real > jacobi (Array2D< real >&A, // matriz original
Array2D< real >&Autovectores,  // matriz de salida con los autovectores ordenados por columna
const int NMaxIter,  // n�mero m�ximo de iteraciones
const real TOL, // tolerancia para detener el algoritmo
int &Niter) // variable de salida con el numero  de iteraciones
{
  /** COMPROBAMOS QUE LAS DIMENSIONES SON COHERENTES */
  if(A.dim1()!=A.dim2() || A.dim1()!=Autovectores.dim1() || A.dim2()!=Autovectores.dim2() ){
    return(Array1D< real >());
  }

  /** COMPROBAMOS QUE LA MATRIZ A ES SIM�TRICA */
  int dim=A.dim1();
  for(int i=0;i<dim;i++){
    for(int j=i+1;j<dim;j++){
      if(A[i][j]!=A[j][i]){
        return(Array1D< real >());
      }
    }
  }

  /** HACER ALUMNO */

  /** definimos el vector de autovalores que se utilizar� para retornar los autovalores */
  Array1D< real > autovalores(dim);

  /** inicializamos la matriz de autovectores a la identidad */
  Autovectores=0.;
  for(int i=0;i<dim;i++) Autovectores[i][i]=1.;


  /** HACEMOS ITERACIONES M�TODO DE JACOBI */
  for (Niter=0;Niter<NMaxIter;Niter++){
    /** detectamos el valor m�ximo no diagonal en valor absoluto */
    int p=0;
    int q=1;
    real Max = 0;
    for (int i=0;i<dim;i++){
      for (int j=i+1;j<dim;j++){
        if (fabs(A[i][j])>Max){
          Max=fabs(A[i][j]);
          p=i;
          q=j;
        }
      }
    }
    /** salida correcta en el caso en que el m�ximo encontrado sea menor que TOL */
    if (Max<TOL)
    {
      for(int l=0;l<dim;l++) autovalores[l]=A[l][l];
      return (autovalores);
    }
    /** calculamos el �ngulo para hacer cero el elemento A[p][q] */
    real alfa=0.5*atan( (2.*A[p][q])/(A[q][q]-A[p][p]) );
    real co=cos(alfa);
    real si=sin(alfa);

    /** actualizamos la matriz de autovectores y la matriz A haciendo R^t*A*R  */
    for(int k=0;k<dim;k++){
      real temp= Autovectores[k][p];
      Autovectores[k][p]=co*temp-si*Autovectores[k][q];
      Autovectores[k][q]=co*Autovectores[k][q]+si*temp;
      if(k==p || k==q) continue;
      temp=A[p][k];
      A[k][p]=A[p][k]=co*temp-si*A[q][k];
      A[k][q]=A[q][k]=co*A[q][k]+si*temp;
    }
    real App=A[p][p];
    A[p][p]=co*(co*App-si*A[p][q])-si*(co*A[p][q]-si*A[q][q]);
    A[q][q]=co*(co*A[q][q]+si*A[p][q])+si*(co*A[p][q]+si*App);
    A[p][q]=A[q][p]=0.;

  }

  return(Array1D< real >());
}

