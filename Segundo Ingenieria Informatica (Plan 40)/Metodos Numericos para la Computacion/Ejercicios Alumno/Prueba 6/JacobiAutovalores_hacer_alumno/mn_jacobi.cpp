
// FUNCIONES METODO DE JACOBI
#include "mn_jacobi.h"

/******************************************************************************
// FUNCION QUE CALCULA LOS AUTOVALORES DE UNA MATRIZ (LOS DEVUELVE EN UN ARRAY)
// PARA IMPLEMENTAR LA FUNCIÓN TENER EN CUENTA LO SIGUIENTE :
//  (1) la función atan(x) devuelve el arco tangente de x
//*****************************************************************************/
Array1D< real > jacobi (Array2D< real >&A, // matriz original
Array2D< real >&Autovectores,  // matriz de salida con los autovectores ordenados por columna
const int NMaxIter,  // número máximo de iteraciones
const real TOL, // tolerancia para detener el algoritmo
int &Niter) // variable de salida con el numero  de iteraciones
{
  /// HACER ALUMNO

    /// COMPROBAMOS DIMENSIONES
    if (A.dim1() != A.dim2() ||
        Autovectores.dim1() != Autovectores.dim2() ||
        A.dim1() != Autovectores.dim1() ||
        A.dim2() != Autovectores.dim2() ){
        return Array1D<real>();
    }
    /// Comprobar simetría
    for(int i=0; i<A.dim1(); i++){
        for(int j=i+1; j<A.dim1(); j++){
            if(A[i][j] != A[j][i]){
                return Array1D<real>();
            }
        }
    }

    /// Declarar vectroe de salida
    Array1D<real> autoval(A.dim1());

    /// Inicializar a 0 la matriz AV
    Autovectores = 0.;
    for(int i=0; i<A.dim1(); i++){
        Autovectores[i][i] = 1.;
    }

    int p,q;
    real Max;
    /// Iniciar iteracion Jacobi for principal
    for(Niter=0; Niter<NMaxIter; Niter++){
        ///Calcular máximo
        p = 0;
        q = 1;
        Max = 0;
        for(int i=0; i<A.dim1(); i++){
            for(int j=i+1; j<A.dim1(); j++){
                if(fabs(A[i][j]) > Max){
                    p = i;
                    q = j;
                    Max = fabs(A[i][j]);
                }
            }
        }

        ///Verificar maximo y salida
        if(Max < TOL){
            for(int l=0; l<A.dim1(); l++){
                autoval[l] = A[l][l];
            }
            return autoval;
        }

        /// Calculo de la atan
        real alfa = 0.5*atan(( 2.*A[p][q]) / (A[q][q]-A[p][p]) );
        real co = cos(alfa);
        real se = sin(alfa);

        /// Calculos finales de los elementos.

        for(int i=0; i<A.dim1(); i++){
            real temp = Autovectores[i][p];
            Autovectores[i][p] = co*temp - se*Autovectores[i][q];
            Autovectores[i][q] = co*Autovectores[i][q] + se*temp;
            if(i==p || i==q){
                continue;
            }
            temp = A[p][i];
            A[i][p] = A[p][i] = co*temp - se*A[q][i];
            A[i][q] = A[q][i] = co*A[q][i] + se*temp;
        }
        real app = A[p][p];
        A[p][p] = co*(co*app-se*A[p][q])-se*(co*A[p][q]-se*A[q][q]);
        A[q][q] = co*(co*A[q][q]+se*A[p][q])+se*(co*A[p][q]+se*app);
        A[p][q] = A[q][p]=0.;
    }

    return Array1D<real>();
}

