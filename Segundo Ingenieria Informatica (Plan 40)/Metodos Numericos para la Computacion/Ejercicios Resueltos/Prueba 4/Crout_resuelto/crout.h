
/* DECLARACION PROTOTIPOS FUNCIONES METODO DE CHOLESKY*/

#include <stdlib.h>
#include <math.h>
#include "aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

int crout_descomposicion(Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,Array1D< real > &l,Array1D< real > &m,Array1D< real > &u);
Array1D< real > crout_descenso (Array1D< real > &l,Array1D< real > &m,Array1D< real > &t);
Array1D< real > crout_remonte(Array1D< real > &u,Array1D< real > &z);
Array1D< real > crout_metodo_completo(Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,Array1D< real > &t);

