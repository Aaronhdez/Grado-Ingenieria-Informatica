/*==========================================================================
       PRACTICA 3 METODOS NUMERICOS. INTERPOLACION
  ==========================================================================*/

// INCLUSION DE LA LIBRERIA STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>
#include <math.h>



#include "../mn_aritmeticas.h"
#include "../mn_interpolacion.h"


main()
{
  Array2D<real> Z(8,6);
  Z[0][0]=1.0;   Z[0][1]=0.5;   Z[0][2]=0.0;   Z[0][3]=0.5;   Z[0][4]=1.0;   Z[0][5]=1.0;
  Z[1][0]=1.0;   Z[1][1]=0.5;   Z[1][2]=0.0;   Z[1][3]=0.5;   Z[1][4]=1.0;   Z[1][5]=1.0;
  Z[2][0]=1.0;   Z[2][1]=0.5;   Z[2][2]=0.0;   Z[2][3]=0.5;   Z[2][4]=1.0;   Z[2][5]=1.0;
  Z[3][0]=0.5;   Z[3][1]=0.25;  Z[3][2]=0.0;   Z[3][3]=0.25;  Z[3][4]=0.5;   Z[3][5]=0.5;
  Z[4][0]=0.0;   Z[4][1]=0.0;   Z[4][2]=0.0;   Z[4][3]=0.0;   Z[4][4]=0.0;   Z[4][5]=0.0;
  Z[5][0]=0.5;   Z[5][1]=0.25;  Z[5][2]=0.0;   Z[5][3]=0.25;  Z[5][4]=0.5;   Z[5][5]=0.5;
  Z[6][0]=1.0;   Z[6][1]=0.5;   Z[6][2]=0.0;   Z[6][3]=0.5;   Z[6][4]=1.0;   Z[6][5]=1.0;
  Z[7][0]=1.0;   Z[7][1]=0.5;   Z[7][2]=0.0;   Z[7][3]=0.5;   Z[7][4]=1.0;   Z[7][5]=1.0;

 Array2D< real > F(4,3,1.);
 for(int k=0;k<F.dim2();k++) F[2][k]=0.;
 for(int k=0;k<F.dim1();k++) F[k][1]=0.;
 printf("Array2D inicial\n");
 F.print("F");

 printf("Array2D despues de hacer zoom (valores que tienen que salir)\n");
 Z.print("Z");

 printf("Array2D despues de hacer zoom (valores obtenidos alumno)\n");
 Array2D< real > Fz=zoom(F,2.);
 Fz.print("Z");

 printf("\nPruebas con imagenes reales\n");
 Array2D< real > I("eiiBW.png");
 Z=zoom(I,3.);
 Z.write_bmp("eiiBW_zoom.png");

 Array2D< real > A("eiiBW_zoom_test.png");

 if( A.dim1()!=Z.dim1() || A.dim2()!=Z.dim2() ){
    printf("las dimensiones de la imagen zoom is incorrecta\n");
    printf("Dimensiones reales : %d x %d\n",A.dim1(),A.dim2());
    printf("Dimensiones alumno : %d x %d\n",Z.dim1(),Z.dim2());
    system("pause");
    exit(1);
 }

 printf("Calculo maximo error al calcular la interpolacion bilineal\n");
 real error=0.;
 for(int i=0;i<Z.dim1();i++){
    for(int j=0;j<Z.dim2();j++){
      real temp=fabs(A[i][j]-(int) Z[i][j]);
      if(temp>error) error=temp;
    }
 }
 printf("error maximo = %lf\n",error);

}



