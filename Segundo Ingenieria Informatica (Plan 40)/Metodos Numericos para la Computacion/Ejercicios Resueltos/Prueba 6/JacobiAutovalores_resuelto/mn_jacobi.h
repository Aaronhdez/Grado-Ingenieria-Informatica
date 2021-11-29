#include <math.h>
#include <stdlib.h>
#include <stdio.h>
#include "mn_aritmeticas.h"
#include "mn_lapack.h"

Array1D< real > jacobi (Array2D< real >&A, Array2D< real >&Autovectores, const int NMaxIter, const real TOL, int &Niter);
real mn_error_autovectores(const Array2D< real > &A, const Array2D< real > &Autovectores, const Array1D< real > &Autovalores);
real mn_error_vectores(const Array1D< real > &u, const Array1D< real > &v);
