#include "../mn_aritmeticas.h"
#include "../mn_lapack.h"
#include "../mn_jacobi.h"


int main()
{

  int i,N;
  int Niter;
  int NMaxIter=10000;
  real TOL=1e-8;

  /// USAMOS VARIOS EJEMPLOS DE MATRICES
  {
    /// LEEMOS EJEMPLO 1
    Array2D< real >  A(2,2,1.);
    A[0][1]=-1.;  A[1][0]=-1;
    Array2D< real >  Autovectores(2,2);

    printf("El ejemplo 1 es la matriz \n");
    A.print("A");
    // LEEMOS LAS SOLUCIONES DEL EJEMPLO
    Array2D< real > eigenvectors;
    Array1D< real > eigenvalues;
    N=mn_leer_matriz("../datos/Autovectores_1.txt",eigenvectors);
    N=mn_leer_vector("../datos/Autovalores_1.txt",eigenvalues);
    printf("APLICAMOS EL METODO DE JACOBI\n");
    Array1D< real > autovalores=jacobi(A,Autovectores,NMaxIter,TOL,Niter);
    printf("N. Iteraciones metodo Jacobi (real): %d\n",1);
    printf("N. Iteraciones metodo Jacobi (alumno): %d\n\n",Niter);
    eigenvalues.print("autovalores (real)");
    autovalores.print("autovalores (alumno)");
    printf("Matriz de autovectores (real): \n");
    eigenvectors.print("B");
    printf("Matriz de autovectores (alumno): \n");
    Autovectores.print("B");
    //real error=mn_error_autovectores(A,Autovectores,autovalores);
    //printf("error=%lf\n",error);


    printf("PRESIONAR UNA TECLA PARA VER EL EJEMPLO 2\n");
    system("pause");
  }
  {
    // LEEMOS EJEMPLO 2
    Array2D< real >  A;
    N=mn_leer_matriz("../datos/A_jacobi_1.txt",A);
    printf("El ejemplo 2 es la matriz \n");
    A.print("A");
    Array2D< real >  Autovectores(N,N);
    // LEEMOS LAS SOLUCIONES DEL EJEMPLO
    Array2D< real > eigenvectors;
    Array1D< real > eigenvalues;
    N=mn_leer_matriz("../datos/Autovectores_2.txt",eigenvectors);
    N=mn_leer_vector("../datos/Autovalores_2.txt",eigenvalues);
    printf("APLICAMOS EL METODO DE JACOBI\n");
    Array1D< real > autovalores=jacobi(A,Autovectores,NMaxIter,TOL,Niter);
    printf("N. Iteraciones metodo Jacobi (real): %d\n",7);
    printf("N. Iteraciones metodo Jacobi (alumno): %d\n\n",Niter);
    eigenvalues.print("autovalores (real)");
    autovalores.print("autovalores (alumno)");
    printf("Matriz de autovectores (real): \n");
    eigenvectors.print("B");
    printf("Matriz de autovectores (alumno): \n");
    Autovectores.print("B");

    system("pause");
  }
  return 0;
}




