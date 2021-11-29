// INCLUSION DE LA LIBRERIA STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


#include "../mn_aritmeticas.h"
#include "../mn_mascara3x3.h"


main()
{
 Array2D< real > I("eiiBW.png");
 Array2D<real> F1(5,4,1.);
 Array2D<real> m1;
 Array2D<real> F2;

 printf("GESTION SALIDAS POR PARAMETROS INADECUADOS\n");
 printf("EJEMPLO 1 (FUNCION DEBE FALLAR)\n");
 Array2D<real> M1=mn_mascara3x3(F1,m1);
 if(M1.dim1()==0 || M1.dim2()==0){
    printf("Error al aplicar la mascara (ALUMNO) \n");
 }
 else{
   printf("ALUMNO NO CONTROLA BIEN LOS PARAMETROS \n");
 }

 printf("EJEMPLO 2 (FUNCION DEBE FALLAR)\n");
 m1=Array2D<real>(3,3,1./9.);

 M1=mn_mascara3x3(F2,m1);
 if(M1.dim1()==0 || M1.dim2()==0){
    printf("Error al aplicar la mascara (ALUMNO)\n\n");
 }
 else{
   printf("ALUMNO NO CONTROLA BIEN LOS PARAMETROS \n");
 }

 /// GESTION SALIDAS CON PARÁMETROS CORRECTOS
 printf("Funcion tabulada\n");
 F1.print("F");

 M1=mn_mascara3x3(F1,m1);
 if(M1.dim1()==0 || M1.dim2()==0){
    printf("Error al aplicar la mascara\n");
 }
 else{
   printf("Resultado aplicar mascara media (debe dar lo mismo que la funcion tabulada)\n");
   M1.print("M");
 }

 Array2D<real> M=mn_mascara3x3(I,m1);
 if(M.dim1()==0 || M.dim2()==0){
    printf("Error al aplicar la mascara\n");
 }
 else{
   M.write_bmp("eiiBW_mascara_media_alumno.png");
 }

 m1=0.;
 m1[0][0]=-(2.-sqrt(2.))/4.;
 m1[1][0]=-2.*(sqrt(2.)-1.)/4.;
 m1[2][0]=m1[0][0];
 m1[0][2]=(2.-sqrt(2.))/4.;
 m1[1][2]=2.*(sqrt(2.)-1.)/4.;
 m1[2][2]=m1[0][2];
 //m1.print("m");

 Array2D<real> Mx=mn_mascara3x3(I,m1);
 Array2D<real> Fx=mn_mascara3x3(F1,m1);
 printf("Resultado aplicar mascara derivada x (debe dar todo 0)\n");
 Fx.print("Fx");


 m1=0.;
 m1[0][0]=-(2.-sqrt(2.))/4.;
 m1[0][1]=-2.*(sqrt(2.)-1.)/4.;
 m1[0][2]=m1[0][0];
 m1[2][0]=(2.-sqrt(2.))/4.;
 m1[2][1]=2.*(sqrt(2.)-1.)/4.;
 m1[2][2]=m1[2][0];
 //m1.print("m");

 Array2D<real> My=mn_mascara3x3(I,m1);
 Array2D<real> Fy=mn_mascara3x3(F1,m1);
 printf("Resultado aplicar mascara derivada y (debe dar todo 0)\n");
 Fy.print("Fy");

 Array2D<real> F(4,5);

 F[0][0]=1.000;  F[0][1]=-1.000;  F[0][2]=2.000;  F[0][3]=-2.000;  F[0][4]=3.000;
 F[1][0]=-3.000;  F[1][1]=4.000;  F[1][2]=-4.000;  F[1][3]=-5.000;  F[1][4]=5.000;
 F[2][0]=6.000;  F[2][1]=-6.000;  F[2][2]=7.000;  F[2][3]=-7.000;  F[2][4]=8.000;
 F[3][0]=-8.000;  F[3][1]=9.000;  F[3][2]=-9.000;  F[3][3]=13.000;  F[3][4]=-10.000;
 printf("Funcion tabulada\n");
 F.print("F");

 printf("mascara\n");
 m1[0][0]=1.000;  m1[0][1]=4.000;  m1[0][2]=7.000;
 m1[1][0]=2.000;  m1[1][1]=-10.000;  m1[1][2]=8.000;
 m1[2][0]=3.000;  m1[2][1]=6.000;  m1[2][2]=9.000;
 m1.print("m");

 M=Array2D<real> (4,5);
 printf("Resultado real de m*F\n");
 M[0][0]=-9.000;  M[0][1]=18.000;  M[0][2]=-102.000;  M[0][3]=66.000;  M[0][4]=81.000;
 M[1][0]=54.000;  M[1][1]=-22.000;  M[1][2]=-38.000;  M[1][3]=148.000;  M[1][4]=110.000;
 M[2][0]=-74.000;  M[2][1]=62.000;  M[2][2]=-95.000;  M[2][3]=120.000;  M[2][4]=-91.000;
 M[3][0]=133.000;  M[3][1]=-198.000;  M[3][2]=275.000;  M[3][3]=-232.000;  M[3][4]=16.000 ;
 M.print("m*F");

 M=mn_mascara3x3(F,m1);
 printf("Resultado alumno de m*F\n");
 M.print("m*F");

 real Gmax=0.;
 Array2D<real> G(I.dim1(),I.dim2());
 for(int i=0;i<I.dim1();i++){
   for(int j=0;j<I.dim2();j++){
       G[i][j]=sqrt(Mx[i][j]*Mx[i][j]+My[i][j]*My[i][j]);
       if(G[i][j]>Gmax) Gmax=G[i][j];
   }
 }

 for(int i=0;i<I.dim1();i++){
   for(int j=0;j<I.dim2();j++){
       G[i][j]=255.*G[i][j]/Gmax;
   }
 }

 G.write_bmp("eiiBW_grad_norm_alumno.png");

 printf("Comprobaciones al aplicar las mascaras a una imagen real\n");
 printf("las imagenes que genera el programa principal son \n");
 printf("  eiiBW_mascara_media_alumno.png\n");
 printf("  eiiBW_grad_norm_alumno.png\n");
 printf("primero hay que visualizar las imagenes resultado para ver si tienen sentido \n");

  Array2D< real > M2("eiiBW_mascara_media.png");
  Array2D< real > G2("eiiBW_grad_norm.png");

  real error_media=0;
  real error_gradient=0;
  for(int i=0;i<M.dim1();i++){
    for(int j=0;j<M.dim2();j++){
        if(fabs(((int) M[i][j])-M2[i][j])>error_media)
          error_media=fabs(M[i][j]-M2[i][j]);
        if(fabs(((int) G[i][j])-G2[i][j])>error_gradient)
          error_gradient=fabs(M[i][j]-M2[i][j]);
    }
  }


  printf("\nError al comparar con el resultado real al aplicar\n");
  printf("las mascaras de la media y el gradiente (el error debe dar 0)\n");
  printf("Error en la imagen de la media = %d\n",error_media);
  printf("Error en la imagen del gradiente = %d\n",error_gradient);

}



