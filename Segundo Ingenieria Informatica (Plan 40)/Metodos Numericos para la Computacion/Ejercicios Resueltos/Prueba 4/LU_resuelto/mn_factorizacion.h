
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

Array1D< real > mn_descenso (const Array2D< real > &B,  const Array1D< real > &b);
Array1D< real > mn_remonte (const Array2D< real > &B, const Array1D< real > &z);
int mn_LU_factorization(const Array2D< real > &A,Array2D< real > &L,Array2D< real > &U);
Array1D< real > mn_LU(const Array2D< real > &A, const Array1D< real > &b);
