#include "mn_aritmeticas.h"

#ifndef MN_CALCULO_CEROS_H
#define MN_CALCULO_CEROS_H


// PROTOTIPOS FUNCIONES PARA CALCULAR CEROS EN UNA FUNCION
int mn_newton_raphson (real (*f)( real), real (*f_1)( real), real &root,  int Nmax,  real TOL);
int mn_newton_raphson (real (*f)( real), real &root,  int Nmax,  real TOL);
int mn_secante (real (*f)( real), real &root_0, real &root_1, int Nmax,  real TOL);
real mn_biseccion (real (*f)( real), real &a, real &b,  real TOL,int &error);
int mn_muller (real (*f)( real), real (*fp)( real),real (*fpp)( real),
real &x0, int NiterMax, real TOL);

#endif
