
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

Array2D< real > mn_cholesky_factorization(const Array2D< real > &A);
Array1D< real > mn_descenso (const Array2D< real > &B,  const Array1D< real > &b);
Array1D< real > mn_remonte (const Array2D< real > &B, const Array1D< real > &z);
Array1D< real > mn_cholesky(const Array2D< real > &A, const Array1D< real > &b);
real mn_determinante_factorizacion_cholesky(const Array2D< real > &A);
