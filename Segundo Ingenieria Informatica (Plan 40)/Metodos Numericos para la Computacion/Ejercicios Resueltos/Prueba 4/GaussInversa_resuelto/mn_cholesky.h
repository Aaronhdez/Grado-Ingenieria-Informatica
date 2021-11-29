
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

Array2D< real > mn_cholesky_factorization(Array2D< real > &A);
Array1D< real > mn_descenso (Array2D< real > &B,  Array1D< real > &b);
Array1D< real > mn_remonte (Array2D< real > &B, Array1D< real > &z);
Array1D< real > mn_cholesky(Array2D< real > &A, Array1D< real > &b);
real mn_determinante_factorizacion_cholesky(Array2D< real > &A);
