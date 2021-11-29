#include "mn_aritmeticas.h"

#ifndef MN_CALCULO_CEROS_H
#define MN_CALCULO_CEROS_H


// PROTOTIPOS FUNCIONES PARA CALCULAR CEROS EN UNA FUNCION
real mn_regula_falsi (real (*f)( real), real &a, real &b,  real TOL, int NiterMax,int &error);


#endif
