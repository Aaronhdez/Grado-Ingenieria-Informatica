/// INCLUSION DE LIBRERIAS NECESARIAS
#include <stdio.h>
#include "EjerciciosBasicos.h"

/// FUNCIÓN QUE CALCULA LA MEDIA DE UN VECTOR
real mn_media(Array1D< real > &u){
  real media = u[0];
  for(int i=1;i<u.dim();i++){
    media+=u[i];
  }
  return media/u.dim();
}

/// FUNCIÓN QUE CALCULA EL MAXIMO DE UN VECTOR
real mn_max(Array1D< real > &u){
  real max = u[0];
  for(int i=1;i<u.dim();i++){
    if(u[i]>max) max=u[i];
  }
  return max;
}

/// FUNCIÓN QUE CALCULA EL MINIMO DE UN VECTOR
real mn_min(Array1D< real > &u){
 real min = u[0];
  for(int i=1;i<u.dim();i++){
    if(u[i]<min) min=u[i];
  }
  return min;
}

/// FUNCIÓN QUE ORDENA UN VECTOR DE MENOR A MAYOR
void mn_ordenar(Array1D< real > &u){
  for(int i=0;i<u.dim();i++){
    for(int j=i+1;j<u.dim();j++){
      if(u[i]>u[j]){
        real temp =u[i];
        u[i] = u[j];
        u[j] = temp;
      }
    }
  }
}

/// FUNCIÓN PARA MULTIPLICAR UNA MATRIZ POR UN VECTOR
Array1D< real > mn_multiplicacion_matriz_vector(Array2D< real > &A,Array1D< real > &u){
  Array1D< real > v(A.dim1(),0.);
  for(int i=0;i<A.dim1();i++){
    for(int j=0;j<A.dim2();j++){
      v[i] += A[i][j]*u[j];
    }
  }
  return v;
}

/// FUNCIÓN QUE DETERMINA SI UN NÚMERO ENTERO ES PRIMO
bool mn_es_primo(int i){
  for(int k=2;k<i;k++){
    if(i%k==0) return false;
  }
  return true;
}

/// FUNCIÓN QUE CALCULA EL FACTORIAL DE UN NÚMERO NATURAL
real mn_factorial(int n){
  if(n==1) return 1.;
  return n*mn_factorial(n-1);
}


/// FUNCIÓN QUE CALCULA UNA POTENCIA CON UN NÚMERO NATURAL
real mn_potencia(real x,int n){
 if(n==0) return 1.;
 return x*mn_potencia(x,n-1);
}

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE e^x
/// e^x = 1 + x + x^2/2! + ...... +x^n/n!
real mn_exp(real x,int n){
  real exponencial=1.;
  real xn=1;
  real factorial=1;
  for(int i=1;i<n;i++){
    factorial *= i;
    xn *= x;
    exponencial += xn/factorial;
  }
  return exponencial;
}

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)
///  = 1 - x^2/2! + x^4/4! - x^6/6!+...... +- x^(2n)/(2n)!
real mn_cos(real x,int n){
  real coseno=1.;
  real xn=1;
  real x2=x*x;
  real factorial=1;
  for(int i=1;i<n;i++){
    factorial *= (2*i-1)*2*i;
    xn *= -x2;
    coseno += xn/factorial;
  }
  return coseno;
}

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE sin(x)
///  = x - x^3/3! + x^5/5! - x^7/7!+...... +- x^(2n+1)/(2n+1)!
real mn_sin(real x,int n){
  real seno=x;
  real xn=x;
  real x2=x*x;
  real factorial=1;
  for(int i=1;i<n;i++){
    factorial *= (2*i+1)*2*i;
    xn *= -x2;
    seno += xn/factorial;
  }
  return seno;
}

/// FUNCIÓN QUE CALCULA EL DESARROLLO DE TAYLOR DE ln(x)
/// ln(x) = (x-1) - ((x-1)^2)/2 + ((x-1)^3)/3 - ((x-1)^4)/4+...... +- ((x-1)^n)/n
real mn_log(real x,int n){
  x=x-1;
  real log=x;
  for(int i=2;i<=n;i++){
    if(i%2==0) log-=mn_potencia(x,i)/i;
    else log+=mn_potencia(x,i)/i;
  }
  return log;
}

/// FUNCIÓN QUE CALCULA y^x DONDE y,x SON NÚMERO REALES
/// USAR LAS FUNCIONES IMPLEMENTADAS mn_exp() y mn_log() TENIENDO EN CUENTA y^x=e^(x*log(y))
real mn_pow(real y,real x,int n){
  return mn_exp(x*mn_log(y,n),n);
}

/// FUNCIÓN QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=(1.+1./n).^n CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES EL NUMERO e=2.71828182846
/// IMPORTANTE : PARA QUE LAS CONSTANTES LAS TRATE COMO NÚMEROS REALES HAY QUE AÑADIR UN .,
/// ES DECIR, POR EJEMPLO  1. (EN LUGAR DE 1). SI HACEMOS 1/2 EL RESULTADO ES CERO PORQUE HACE
/// LA DIVISIÓN EN PRECISIÓN ENTERA. SIN EMBARGO  1./2.=1./2=1/2.=0.5
real mn_limite1(real tolerancia){
  real anterior = 2;
  int n=2;
  real actual = mn_potencia(1.+1./n,n);
  while( fabs(actual-anterior) > tolerancia){
   anterior = actual;
   n++;
   actual = mn_potencia(1.+1./n,n);
  }
  return actual;
}

/// FUNCIÓN QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=sin(1/n)/(1/n) CUANDO n TIENDE A INFINITO
/// EL ALGORITMO PARA CUANDO LA DIFERENCIA EN VALOR ABSOLUTO DE LA DIFERENCIA
/// ENTRE UN VALOR DE LA SECUENCIA Y EL ANTERIOR ES INFERIOR AL PARAMETRO tolerancia
/// EL LIMITE DE LA SECUENCIA ES 1.
real mn_limite2(real tolerancia){
  real x = 1.;
  real anterior = sin(x)/x;
  x = 1./2.;
  real actual = sin(x)/(x);
  int n=3;
  while( fabs(actual-anterior) > tolerancia){
   anterior = actual;
   x = 1./n;
   actual = sin(x)/x;
   n++;
  }
  return actual;
}

