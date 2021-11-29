#include "mn_aritmeticas.h"
#include <math.h>
#include "tnt_array/tnt.h"
using namespace TNT;

real mn_cuadratura(real (*f)(real x,real y),real a, real b,real c,real d,Array2D< real > &x,Array2D< real > &w,int N); // declaración función
