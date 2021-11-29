/* ================================================================
  MACROS Y DECLARACION DE TIPOS PARA GESTIONAR OPERACIONES CON 
  MATRICES Y VECTORES 
  ================================================================= */
  
#ifndef MN_LAPACK_H
#define MN_LAPACK_H

#include <math.h>
#include "mn_aritmeticas.h"
#include "tnt_array/tnt.h"
using namespace TNT;


// MACRO PARA CALCULAR LA NORMA DE UN VECTOR 
#define mn_norma_vector(x,norma,dim) {int ml; norma=0; \
          for(ml=0;ml<dim;ml++) norma+=x[ml]*x[ml]; \
          if(norma>0) norma=sqrt((double) norma); \
        }
        
// MACRO PARA CALCULAR LA MULTIPLICACION DE UNA MATRIZ  
#define mn_matriz_vector(A,x,v,Nfil,Ncol) {int ml,mk;\
          for(ml=0;ml<Nfil;ml++){ v[ml]=A[ml][0]*x[0]; \
            for(mk=1;mk<Ncol;mk++) v[ml]+=A[ml][mk]*x[mk];}\
        }
        
// MACRO PARA CALCULAR LA MULTIPLICACION DE UNA MATRIZ TRASPUESTA POR UN VECTOR
#define mn_matriz_traspuesta_vector(A,x,v,NfilT,NcolT) {int ml,mk;\
          for(ml=0;ml<NfilT;ml++){ v[ml]=A[0][ml]*x[0]; \
            for(mk=1;mk<NcolT;mk++) v[ml]+=A[mk][ml]*x[mk];}\
        }

// MACRO PARA CALCULAR UNA MATRIZ TRASPUESTA
#define mn_matriz_traspuesta(A,At,NfilA,NcolA) {int ml,mk;\
          for(ml=0;ml<NfilA;ml++){ \
            for(mk=0;mk<NcolA;mk++) At[mk][ml]=A[ml][mk];}\
        }

// MACRO PARA COPIAR UNA MATRIZ
#define mn_matriz_copia(A,B,NfilA,NcolA) {int ml,mk;\
          for(ml=0;ml<NfilA;ml++){ \
            for(mk=0;mk<NcolA;mk++) B[ml][mk]=A[ml][mk];}\
        }
        
// MACRO PARA CALCULAR LA MULTIPLICACION DE UN ESCALAR POR UNA MATRIZ
#define mn_escalar_matriz(l,A,B,NfilA,NcolA) {int ml,mk;\
          for(ml=0;ml<NfilA;ml++){ \
            for(mk=0;mk<NcolA;mk++) B[ml][mk]=l*A[ml][mk];}\
        }

// MACRO PARA COPIAR UN VECTOR
#define mn_vector_copia(u,v,N) {int ml;\
          for(ml=0;ml<N;ml++){ \
            v[ml]=u[ml];}\
        }
        
// MACRO PARA CALCULAR EL PRODUCTO ESCALAR DE 2 VECTORES
#define mn_vector_vector(x,v,a,dim) {int ml; a=x[0]*v[0];\
          for(ml=1;ml<dim;ml++) a+=x[ml]*v[ml];\
        }

// MACRO PARA CALCULAR LA RESTA DE 2 VECTORES
#define mn_vector_resta_vector(x,v,a,dim) {int ml; a=x[0]-v[0];\
          for(ml=1;ml<dim;ml++) a+=x[ml]-v[ml];\
        }

// MACRO PARA CALCULAR LA SUMA DE 2 VECTORES
#define mn_vector_suma_vector(x,v,a,dim) {int ml; a=x[0]+v[0];\
          for(ml=1;ml<dim;ml++) a+=x[ml]+v[ml];\
        }

// MACRO PARA CALCULAR EL PRODUCTO DE UN ESCALAR POR UN VECTOR
#define mn_escalar_vector(x,a,v,dim) {int ml; \
          for(ml=0;ml<dim;ml++) v[ml]=x[ml]*a;\
        }

// MACRO PARA CALCULAR EL PRODUCTO DE 2 MATRICES
#define mn_matriz_matriz(A,B,C,NfilA,NcolA,NcolB) {int ml,mk,mu;\
          for(mu=0;mu<NfilA;mu++) \
            for(mk=0;mk<NcolB;mk++){\
              C[mu][mk]=A[mu][0]*B[0][mk];\
              for(ml=1;ml<NcolA;ml++) C[mu][mk]+=A[mu][ml]*B[ml][mk];}\
        }
        
// MACRO PARA CALCULAR EL PRODUCTO DE UNA MATRIZ TRASPUESTA POR UNA MATRIZ
#define mn_matriz_traspuesta_matriz(A,B,C,NfilA,NcolA,NcolB) {int ml,mk,mu;\
          for(mu=0;mu<NfilA;mu++) \
            for(mk=0;mk<NcolB;mk++){\
              C[mu][mk]=A[0][mu]*B[0][mk];\
              for(ml=1;ml<NcolA;ml++) C[mu][mk]+=A[ml][mu]*B[ml][mk];}\
        }

// DECLARACION DE TIPOS PARA LAS FUNCIONES DE mn_LAPACK

// FUNCION PARA CALCULAR LA INVERSA DE UNA MATRIZ
Array2D< real > mn_inversa(const Array2D< real > &A ) ;

// FUNCION PARA RESOLVER SISTEMAS POR EL METODO DE GAUSS
Array1D< real > mn_gauss(const Array2D< real > &A, const Array1D< real > &b);

// FUNCION PARA CALCULAR EL ERROR AL RESOLVER UN SISTEMA DE ECUACIONES 
real mn_error_sistema(const Array2D< real > &A, const Array1D< real > &u, const Array1D< real >  &b);

/* FUNCION PARA LEER UN VECTOR DE DISCO. RETORNA LA DIMENSION DEL VECTOR */
int mn_leer_vector(char *nombrefichero, Array1D< real > &vector);

/* FUNCION PARA ESCRIBIR UN VECTOR DE DISCO DE DIMENSION dimension Y LO ALMACENA EN vector */
int mn_escribir_vector(char *nombrefichero, Array1D< real > &vector);

/* FUNCION PARA LEER UNA MATRIZ DE DISCO DE DIMENSION dimension Y LO ALMACENA EN LA MATRIZ matriz  */
int mn_leer_matriz( char *nombrefichero,  Array2D< real > &matriz);

/* FUNCION PARA ESCRIBIR UNA MATRIZ DE DISCO DE DIMENSION dimension */
int mn_escribir_matriz( char *nombrefichero,  Array2D< real > &vmatriz); 

#endif
