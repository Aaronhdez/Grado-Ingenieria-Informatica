/*========================================================================
  FUNCIONES PARA EL MANEJO DE ARITMETICAS DE PRECISION FINITA
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "math.h"

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
  A=acos(-1.);
  return(A);
}

// FUNCION PARA CALCULAR EL MENOR NUMERO POSITIVO
int mn_menor_numero_positivo()
{
    real A = 1.;
    int M = 0;
    while (A > 0) {
      A = A/2;
      M=M+1;
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
      A = 2*A;
      B = 2*A;
      M=M+1;
    }
    return (M);
}

// FUNCION PARA CALCULAR LA DISTANCIA ENTRE 2 NUMEROS REALES
real mn_distancia(real A,real B)
{
  real abs_A,abs_B,max,abs_A_B; // declaramos variables
  // CALCULAMOS EL VALOR ABSOLUTO DE A
  if(A>0){
    abs_A=A;
  }
  else{
    abs_A=-A;
  }
  // CALCULAMOS EL VALOR ABSOLUTO DE B
  if(B>0){
    abs_B=B;
  }
  else{
    abs_B=-B;
  }
  // CALCULAMOS EL MAXIMO DEL VALOR ABSOLUTO DE A y B
  if(abs_A>abs_B){
    max=abs_A;
  }
  else{
    max=abs_B;
  }
  // CALCULAMOS EL VALOR ABSOLUTO DE B-A
  if(B>A){
    abs_A_B=B-A;
  }
  else{
    abs_A_B=A-B;
  }
  // CALCULAMOS Y RETORNAMOS EL VALOR DE LA FORMULA DE LA DISTANCIA RELATIVA
  return( abs_A_B/(max+1.) );
}

