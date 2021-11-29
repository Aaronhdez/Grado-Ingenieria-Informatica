#include <stdio.h>
#include "../EjerciciosBasicos.h"
#include <stdlib.h>


int main()
{
   Array1D< real > u(4);
   u[0]=5.25; u[1]=3.25; u[2]=2.25; u[3]=1.25;

   Array2D< real > A(3,2);
   A[0][0]=1.; A[0][1]=2.;
   A[1][0]=4.; A[1][1]=5.;
   A[2][0]=3.; A[2][1]=7.;

   Array1D< real > u2(2,1.5);

  int aciertos=0;
  int fallos=0;
  printf("FUNCION QUE CALCULA LA MEDIA DE UN VECTOR\n");
  real x=mn_media(u);
  printf("media real = 3.00,   mn_media(u) = %1.2lf\n",x);
  if(x==3.) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL MAXIMO DE UN VECTOR\n");
  x=mn_max(u);
  printf("maximo real = 5.25,  mn_max(u) = %1.2lf\n",x);
  if(x==5.25) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL MINIMO DE UN VECTOR\n");
  x=mn_min(u);
  printf("minimo real = 1.25,  mn_min(u) = %1.2lf\n",x);
  if(x==1.25) aciertos++;
  else fallos++;

  printf("FUNCION QUE ORDENA UN VECTOR DE MENOR A MAYOR\n");
  printf("vector antes de ordenar   : u[0]=%1.2lf u[1]=%1.2lf u[2]=%1.2lf u[3]=%1.2lf \n",u[0],u[1],u[2],u[3]);
  mn_ordenar(u);
  printf("vector despues de ordenar : u[0]=%1.2lf u[1]=%1.2lf u[2]=%1.2lf u[3]=%1.2lf  \n",u[0],u[1],u[2],u[3]);
  if(u[0]==1.25 && u[1]==2.25 && u[2]==3.25 && u[3]==5.25) aciertos++;
  else fallos++;

  printf("FUNCION PARA MULTIPLICAR UNA MATRIZ POR UN VECTOR\n");
  Array1D< real > v=mn_multiplicacion_matriz_vector(A,u2);
  if(v.dim()!=3){
    printf("mal dimension vector devuelto\n");
    fallos++;
  }
  else{
    printf("resultado real v[0]=4.50 v[1]=13.50 v[2]=15.00, resultado alumno v[0]=%1.2lf v[1]=%1.2lf v[2]=%1.2lf\n",v[0],v[1],v[2]);
    if(v[0]==4.50 && v[1]==13.50 && v[2]==15.00) aciertos++;
    else fallos++;
  }

  printf("FUNCION QUE DETERMINA SI UN NUMERO ENTERO ES PRIMO\n");
  int primos[16]={1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
  printf("Los primos entre 1 y 50 son : ");
  bool PrimosBien=true;
  int Nprimos=0;
  for(int k=1;k<=50;k++){
    if(mn_es_primo(k)==true) {
      printf("%d ",k);
      if(k!=primos[Nprimos]){
        PrimosBien=false;
        break;
      }
      Nprimos++;
    }
  }
  if(Nprimos!=16) PrimosBien=false;
  if(PrimosBien==true) aciertos++;
  else fallos++;
  printf("\n");

  printf("FUNCION QUE CALCULA EL FACTORIAL DE UN NUMERO NATURAL\n");
  x=mn_factorial(10);
  printf("10!=%e (valor real),  mn_factorial(10)=%e\n",3.6288e6 ,x);
  if( fabs(x-3.6288e6)<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA UNA POTENCIA CON UN NUMERO NATURAL\n");
  x=mn_potencia(1.5,10);
  printf("1.5^10=%lf,  mn_potencia(1.5,10)=%lf\n",57.665039,x);
  if( fabs(x-57.665039)<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL DESARROLLO DE TAYLOR DE e^x\n");
  /// e^x = 1 + x + (x^2)/2! + ...... +(x^n)/n!
  x=mn_exp(2.,20);
  printf("exp(2.)=%lf,  mn_exp(2.,20)=%lf\n",exp(2.),x);
  if( fabs(x-exp(2.))<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL DESARROLLO DE TAYLOR DE cos(x)\n");
  /// cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6!+...... +- (x^(2n))/(2n)!
  x=mn_cos(2.,10);
  printf("cos(2.)=%lf,  mn_cos(2.,10)=%lf\n",cos(2.),x);
  if( fabs(x-cos(2.))<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL DESARROLLO DE TAYLOR DE sin(x)\n");
  /// sin(x) = x - (x^3)/3! + (x^5)/5! - (x^7)/7!+...... +- (x^(2n+1))/(2n+1)!
  x=mn_sin(2.,10);
  printf("sin(2.)=%lf,  mn_sin(2.,10)=%lf\n",sin(2.),x);
  if( fabs(x-sin(2.))<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL DESARROLLO DE TAYLOR DE log(x)\n");
  /// log(x) = (x-1) - ((x-1)^2)/2 + ((x-1)^3)/3 - ((x-1)^4)/4+...... +- ((x-1)^n)/n
  x=mn_log(1.5,20);
  printf("log(1.5)=%lf,  mn_log(1.5,20)=%lf\n",log(1.5),x);
  if( fabs(x-log(1.5))<1e-4) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA y^x\n");
  x=mn_pow(1.5,3.5,20);
  printf("pow(1.5,3.5)=%lf,  mn_pow(1.5,3.5,20)=%lf\n",pow(1.5,3.5),x);
  if( fabs(x-pow(1.5,3.5))<1e-4 ) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=(1+1/n)^n CUANDO n TIENDE A INFINITO\n");
  printf("mn_limite1(1e-2)=%lf\n",mn_limite1(1e-2));
  x=mn_limite1(1e-8);
  printf("mn_limite1(1e-8)=%lf exp(1.)=%lf\n",x,exp(1.));
  if( fabs(x-exp(1.))<3e-4 ) aciertos++;
  else fallos++;

  printf("FUNCION QUE CALCULA EL LIMITE DE LA SECUENCIA  yn=sin(1/n)/(1/n) CUANDO n TIENDE A INFINITO\n");
  printf("mn_limite2(1e-2)=%lf\n",mn_limite2(1e-2));
  x=mn_limite2(1e-8);
  printf("mn_limite2(1e-8)=%lf\n",x);
  if( fabs(x-1.)<1e-4 ) aciertos++;
  else fallos++;

  printf("\naciertos=%d fallos=%d  nota sobre 10 = %1.1lf (esta nota es solo orientativa)\n",aciertos,fallos,10.*aciertos/(aciertos+fallos));

  return 0;
}


