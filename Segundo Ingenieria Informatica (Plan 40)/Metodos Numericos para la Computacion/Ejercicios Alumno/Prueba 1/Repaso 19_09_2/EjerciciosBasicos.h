/* ================================================================
  MACROS Y DECLARACION DE TIPOS PARA GESTIONAR OPERACIONES CON
  MATRICES Y VECTORES
  ================================================================= */

#ifndef MN_preliminares_H
#define MN_preliminares_H

#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;

/// FUNCIÓN QUE CALCULA LA MEDIA DE UN VECTOR
real mn_media(Array1D< real > &u);

/// FUNCIÓN QUE CALCULA EL MAXIMO DE UN VECTOR
real mn_max(Array1D< real > &u);

/// FUNCIÓN QUE CALCULA EL MINIMO DE UN VECTOR
real mn_min(Array1D< real > &u);

/// FUNCIÓN QUE ORDENA UN VECTOR DE MENOR A MAYOR
void mn_ordenar(Array1D< real > &u);

/// FUNCIÓN PARA MULTIPLICAR UNA MATRIZ POR UN VECTOR
Array1D< real > mn_multiplicacion_matriz_vector(Array2D< real > &A,Array1D< real > &u);

/// FUNCIÓN QUE DETERMINA SI UN NÚMERO ENTERO ES PRIMO
bool mn_es_primo(int i);

/// FUNCIÓN QUE CALCULA EL FACTORIAL DE UN NÚMERO NATURAL
real mn_factorial(int n);

/// FUNCIÓN QUE CALCULA UNA POTENCIA CON UN NÚMERO NATURAL
real mn_potencia(real x,int n);

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE e^x
/// e^x = 1 + x + x^2/2! + ...... +x^n/n!
real mn_exp(real x,int n);

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)
///  cos(x) = 1 - x^2/2! + x^4/4! - x^6/6!+...... +- x^(2n)/(2n)!
real mn_cos(real x,int n);

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)
/// sin(x) = x - x^3/3! + x^5/5! - x^7/7!+...... +- x^(2n+1)/(2n+1)!
real mn_sin(real x,int n);

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE ln(x)
/// ln(x) = (x-1) - ((x-1)^2)/2 + ((x-1)^3)/3 - ((x-1)^4)/4+...... +- ((x-1)^n)/n
real mn_log(real x,int n);

/// FUNCIÓN QUE CALCULA y^x DONDE y,x SON NÚMERO REALES
real mn_pow(real y,real x,int n);

/// FUNCIÓN QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=(1+1/n)^n CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN EL ELEMENTO Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
real mn_limite1(real tolerancia);

/// FUNCIÓN QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=sin(1/n)/(1/n) CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN EL ELEMENTO Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
real mn_limite2(real tolerancia);





#endif
