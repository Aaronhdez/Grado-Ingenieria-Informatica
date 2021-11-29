
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

int mn_newton_raphson_sistemas(Array1D< real >  (*f)(Array1D< real >), Array1D< real > &u,real TOL,int Nmax);
Array2D< real > matriz_derivada(Array1D< real >  (*f)(Array1D< real >), Array1D< real > &u);
