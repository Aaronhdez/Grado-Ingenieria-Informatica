#include "mn_aritmeticas.h"
#include <math.h>

real mn_simpson(real (*f)(real x),real a, real b, int N); // declaraci�n funci�n
real mn_simpson(real (*f)(real x),real a, real b, int &Niter,real TOL); // declaraci�n funci�n
