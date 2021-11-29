/*========================================================================
  FUNCIONES PARA EL MANEJO DE ARITMETICAS DE PRECISION FINITA
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"

// FUNCION PARA CALCULAR LA PRECISION (UNIDAD DE REDONDEO) DE LA ARITMETICA
real mn_precision_aritmetica()
{
  real A=1.;
  real B=2.;
  int M=1; 
  while(B>1.){
    A=A/2; 
    B=1.+A;
    M=M+1;
  }
  return(A); 
}

// FUNCION PARA CALCULAR EL MENOR NUMERO POSITIVO
int mn_menor_numero_positivo()
{
    real A = 1.;
    int M = 0;
    while (A > 0) {
      A /= 2;
      M ++;
    }
    return (M);
}

// FUNCION PARA CALCULAR EL MAYOR NUMERO POSITIVO
int mn_mayor_numero_positivo()
{
    real A = 1.;
    real B = 2.;
    int M = 0;
    while (B > A) {
      A *= 2;
      B = 2*A;
      M ++;
    }
    return (M);
}

// FUNCION PARA CALCULAR LA DISTANCIA ENTRE 2 NUMEROS REALES 
real mn_distancia(real A,real B)
{
  real abs_A=A>0?A:-A;
  real abs_B=B>0?B:-B;  
  real max=abs_A>abs_B?abs_A:abs_B;
  real abs_A_B=A>B?(A-B):(B-A); 
  
  return( abs_A_B/(max+1.) );   
}

