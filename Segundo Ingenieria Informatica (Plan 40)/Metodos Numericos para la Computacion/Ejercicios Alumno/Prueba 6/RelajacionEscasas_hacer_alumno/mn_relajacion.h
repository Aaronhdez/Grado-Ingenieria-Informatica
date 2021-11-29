
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
#include <vector>
using namespace TNT;
using namespace std;

int mn_relajacion_escasa (const Array1D < Array1D< real > > &A, const Array1D < Array1D< int > > &J , const Array1D< real > &b, Array1D< real > &u,
                 const int nMax, const real TOL,const real w);

real mn_error_vectores(Array1D< real > &u, Array1D< real > &v);
