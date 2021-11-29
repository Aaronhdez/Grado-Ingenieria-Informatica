/*==========================================================================
       CREACION Y ESCRITURA EN DISCO DE LAS MATRICES QUE SE UTILIZAN EN 
       LAS PRACTICA DE AN
  ==========================================================================*/

// INCLUSION DE LA LIBRERIA STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "../an_aritmeticas.h"
#include "../an_lapack.h"

main(){
  
  // CONSTRUCCION SISTEMA MATRIZ DIMENSION 10 
  int N=10; 
  Array2D< real > A(N,N,-1.); 
  Array1D< real > b(N,0.); 
   
  for(int i=1;i<N-1;i++){ A[i][i]=(real) N-1.;}
  A[0][0]=A[N-1][N-1]=(real)N;
  b[0]=b[N-1]=(real) 1.; 
  
  // ESCRIBIMOS EN DISCO LA MATRIZ Y EL VECTOR 
  an_escribir_vector("b_10.txt",b);
  an_escribir_matriz("A_10.txt",A); 
  
  // RESOLVEMOS EL SISTEMA PARA VERIFICAR QUE LA SOLUCION ES U[i]=1
  Array1D< real > u=an_gauss(A,b);
  for(int i=0;i<N;i++) u[i]-=1.; 
  u.print("u"); 
  
  // HACEMOS UNA PAUSA EN EL PROGRAMA PARA PODER EXAMINAR EL RESULTADO POR CONSOLA
  system("pause");

  // CONSTRUCCION SISTEMA MATRIZ DIMENSION 100 
  N=100;
  
  Array2D< real > A2(N,N,-1.); 
  Array1D< real > b2(N,0.); 
  for(int i=1;i<N-1;i++){ A2[i][i]=(real) N-1.;}
  A2[0][0]=A2[N-1][N-1]=(real)N;
  b2[0]=b2[N-1]=(real) 1.; 
  
  // ESCRIBIMOS EN DISCO LA MATRIZ Y EL VECTOR 
  an_escribir_vector("b_100.txt",b2);
  an_escribir_matriz("A_100.txt",A2); 
  
  // RESOLVEMOS EL SISTEMA PARA VERIFICAR QUE LA SOLUCION ES U[i]=1
  u=an_gauss(A2,b2);
  for(int i=0;i<N;i++) u[i]-=1.; 
  u.print("u"); 
  
  // HACEMOS UNA PAUSA EN EL PROGRAMA PARA PODER EXAMINAR EL RESULTADO POR CONSOLA
  system("pause");
  
  
  // CONSTRUCCION SISTEMA MATRIZ DIMENSION 1000 
  N=1000;
  
  Array2D< real > A3(N,N,-1.); 
  Array1D< real > b3(N,0.); 
  for(int i=1;i<N-1;i++){ A3[i][i]=(real) N-1.;}
  A3[0][0]=A3[N-1][N-1]=(real)N;
  b3[0]=b3[N-1]=(real) 1.; 
  
  // ESCRIBIMOS EN DISCO LA MATRIZ Y EL VECTOR 
  an_escribir_vector("b_1000.txt",b3);
  an_escribir_matriz("A_1000.txt",A3); 
  
  // RESOLVEMOS EL SISTEMA PARA VERIFICAR QUE LA SOLUCION ES U[i]=1
  u=an_gauss(A3,b3);
  for(int i=0;i<N;i++) u[i]-=1.; 
  u.print("u"); 
  
  // HACEMOS UNA PAUSA EN EL PROGRAMA PARA PODER EXAMINAR EL RESULTADO POR CONSOLA
  system("pause");
  
  
}


