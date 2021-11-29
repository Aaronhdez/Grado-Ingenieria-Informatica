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
    for(int i=0; i<u.dim(); i++){
        for(int j=i+1; j<u.dim(); j++){
            if(u[i]>u[j]){
                real inter=u[i];
                u[i]=u[j];
                u[j]= inter;
            }
        }
    }
}

/// FUNCI�N PARA MULTIPLICAR UNA MATRIZ POR UN VECTOR
Array1D< real > mn_multiplicacion_matriz_vector(Array2D< real > &A,Array1D< real > &u){
    Array1D< real > V(A.dim1(),0.);
    for(int i=0; i<A.dim1(); i++){
        for(int j=0; j<A.dim2(); j++){
            V[i]+=A[i][j]*u[j];
        }
    }
    return V;
}

/// FUNCI�N QUE DETERMINA SI UN N�MERO ENTERO ES PRIMO
bool mn_es_primo(int i){
    if(i==1){
        return true;
    }
    for(int n=2; n<i;n++){
        if(i%n==0){
            return false;
        }
    }
    return true;
}

/// FUNCI�N QUE CALCULA EL FACTORIAL DE UN N�MERO NATURAL
real mn_factorial(int n){
    if(n==0){
        return 1;
    }else{
        return n*mn_factorial(n-1);
    }
}


/// FUNCI�N QUE CALCULA UNA POTENCIA CON UN N�MERO NATURAL
real mn_potencia(real x,int n){
    if(n==0){
        return 1;
    }else{
        return x*mn_potencia(x,n-1);
    }
}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE e^x
/// e^x = 1 + x + x^2/2! + ...... +x^n/n!
real mn_exp(real x,int n){
    real e = 1.;
    for(int i=1; i<n; i++){
        e += mn_potencia(x,i)/mn_factorial(i);
    }
    return e;
}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)
///  = 1 - x^2/2! + x^4/4! - x^6/6!+...... +- x^(2n)/(2n)!
real mn_cos(real x,int n){
    real cos = 1.;
    for(int i=1; i<n; i++){
        if(i%2==0){
            cos += mn_potencia(x,2*i)/mn_factorial(2*i);
        }else{
            cos -= mn_potencia(x,2*i)/mn_factorial(2*i);
        }
    }
    return cos;
}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE sin(x)
///  = x - x^3/3! + x^5/5! - x^7/7!+...... +- x^(2n+1)/(2n+1)!
real mn_sin(real x,int n){
    real sen = x;
    for(int i=1; i<n; i++){
        if(i%2==0){
            sen += mn_potencia(x,2*i+1)/mn_factorial(2*i+1);
        }else{
            sen -= mn_potencia(x,2*i+1)/mn_factorial(2*i+1);
        }
    }
    return sen;
}

/// FUNCI�N QUE CALCULA EL DESARROLLO DE TAYLOR DE ln(x)
/// ln(x) = (x-1) - ((x-1)^2)/2 + ((x-1)^3)/3 - ((x-1)^4)/4+...... +- ((x-1)^n)/n
real mn_log(real x,int n){
    real ln = x-1;
    for(int i=2; i<n; i++){
        if(i%2==0){
            ln -= mn_potencia(x-1,i)/i;
        }else{
            ln += mn_potencia(x-1,i)/i;
        }
    }
    return ln;
}

/// FUNCI�N QUE CALCULA y^x DONDE y,x SON N�MERO REALES
/// USAR LAS FUNCIONES IMPLEMENTADAS mn_exp() y mn_log() TENIENDO EN CUENTA y^x=e^(x*log(y))
real mn_pow(real y,real x,int n){
    return mn_exp(x*mn_log(y,n),n);
}

/// FUNCI�N QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=(1.+1./n)^n CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES EL NUMERO e=2.71828182846
/// IMPORTANTE : PARA QUE LAS CONSTANTES LAS TRATE COMO N�MEROS REALES HAY QUE A�ADIR UN .,
/// ES DECIR, POR EJEMPLO  1. (EN LUGAR DE 1). SI HACEMOS 1/2 EL RESULTADO ES CERO PORQUE HACE
/// LA DIVISI�N EN PRECISI�N ENTERA. SIN EMBARGO  1./2.=1./2=1/2.=0.5
real mn_limite1(real tolerancia){
    real thisnum = 2.;
    int n = 2;
    real next = mn_potencia(1.+1./n,n);

    while(fabs(next-thisnum) > tolerancia){
        thisnum = next;
        n++;
        next = mn_potencia(1.+1./n,n);
    }
    return thisnum;
}

/// FUNCI�N QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=sin(1/n)/(1/n) CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES 1.
real mn_limite2(real tolerancia){
    real a = 1.;
    real thisnum = sin(a)/a;
    a = 1./2.;
    real nextnum = sin(a)/a;
    int n = 3;

    while(fabs(nextnum-thisnum) > tolerancia){
        thisnum = nextnum;
        a = 1./n;
        nextnum = sin(a)/a;
        n++;
    }
    return thisnum;
}

