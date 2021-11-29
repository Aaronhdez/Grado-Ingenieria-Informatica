
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

int mn_gauss_seidel (const Array2D< real > &A, const Array1D< real > &b, Array1D< real > &u, 
                 const int nMax, const real TOL);
