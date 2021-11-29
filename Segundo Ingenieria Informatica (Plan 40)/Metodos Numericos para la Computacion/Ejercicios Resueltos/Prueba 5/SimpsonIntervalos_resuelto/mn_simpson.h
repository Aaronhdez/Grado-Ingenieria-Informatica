#include "mn_aritmeticas.h"
#include <math.h>

real mn_simpson(real (*f)(real x),real a, real b, int N); // declaración función
real mn_simpson(real (*f)(real x),real a, real b, int &Niter,real TOL); // declaración función
