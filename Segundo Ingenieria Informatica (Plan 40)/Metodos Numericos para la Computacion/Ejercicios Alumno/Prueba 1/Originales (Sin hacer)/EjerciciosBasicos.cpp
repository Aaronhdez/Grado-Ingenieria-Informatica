/// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "EjerciciosBasicos.h"

/// FUNCI�N QUE CALCULA LA MEDIA DE UN VECTOR
real mn_media(Array1D< real > &u){

}

/// FUNCI�N QUE CALCULA EL MAXIMO DE UN VECTOR
real mn_max(Array1D< real > &u){

}

/// FUNCI�N QUE CALCULA EL MINIMO DE UN VECTOR
real mn_min(Array1D< real > &u){

}

/// FUNCI�N QUE ORDENA UN VECTOR DE MENOR A MAYOR
void mn_ordenar(Array1D< real > &u){

}

/// FUNCI�N PARA MULTIPLICAR UNA MATRIZ POR UN VECTOR
Array1D< real > mn_multiplicacion_matriz_vector(Array2D< real > &A,Array1D< real > &u){

}

/// FUNCI�N QUE DETERMINA SI UN N�MERO ENTERO ES PRIMO
bool mn_es_primo(int i){

}

/// FUNCI�N QUE CALCULA EL FACTORIAL DE UN N�MERO NATURAL
real mn_factorial(int n){

}


/// FUNCI�N QUE CALCULA UNA POTENCIA CON UN N�MERO NATURAL
real mn_potencia(real x,int n){

}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE e^x
/// e^x = 1 + x + x^2/2! + ...... +x^n/n!
real mn_exp(real x,int n){

}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)
///  = 1 - x^2/2! + x^4/4! - x^6/6!+...... +- x^(2n)/(2n)!
real mn_cos(real x,int n){

}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE sin(x)
///  = x - x^3/3! + x^5/5! - x^7/7!+...... +- x^(2n+1)/(2n+1)!
real mn_sin(real x,int n){

}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE ln(x)
/// ln(x) = (x-1) - ((x-1)^2)/2 + ((x-1)^3)/3 - ((x-1)^4)/4+...... +- ((x-1)^n)/n
real mn_log(real x,int n){

}

/// FUNCI�N QUE CALCULA y^x DONDE y,x SON N�MERO REALES
/// USAR LAS FUNCIONES IMPLEMENTADAS mn_exp() y mn_log() TENIENDO EN CUENTA y^x=e^(x*log(y))
real mn_pow(real y,real x,int n){

}

/// FUNCI�N QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=(1.+1./n)^n CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES EL NUMERO e=2.71828182846
/// IMPORTANTE : PARA QUE LAS CONSTANTES LAS TRATE COMO N�MEROS REALES HAY QUE A�ADIR UN .,
/// ES DECIR, POR EJEMPLO  1. (EN LUGAR DE 1). SI HACEMOS 1/2 EL RESULTADO ES CERO PORQUE HACE
/// LA DIVISI�N EN PRECISI�N ENTERA. SIN EMBARGO  1./2.=1./2=1/2.=0.5
real mn_limite1(real tolerancia){

}

/// FUNCI�N QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=sin(1/n)/(1/n) CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES 1.
real mn_limite2(real tolerancia){

}

