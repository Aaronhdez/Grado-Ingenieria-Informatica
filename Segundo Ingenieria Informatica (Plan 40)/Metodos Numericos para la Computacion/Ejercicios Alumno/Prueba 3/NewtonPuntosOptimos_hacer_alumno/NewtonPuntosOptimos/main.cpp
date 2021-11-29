/*==========================================================================
       PRACTICA 3 MÉTODOS NUMÉRICOS. INTERPOLACIÓN
  ==========================================================================*/

// INCLUSION DE LAS LIBRERIAS STANDARD PARA GESTIONAR ENTRADA-SALIDA
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "../mn_aritmeticas.h"
#include "../mn_interpolacion.h"

main()
{
   int N = 7; // Número de puntos de interpolacion tomados

   // DEFINIMOS ARRAYS NECESARIOS
   Array1D< real > F(N); // Valor que toma la funcion para los puntos de interpolación
   Array1D< real > X=mn_puntos_interpolacion_optimos(N,0.,1.); // Puntos de interpolación

   printf("APROXIMACION DE LA FUNCION exp(x) EN EL INTERVALO [0,1] USANDO EL POLINOMIO DE LAGRANGE\n");
   printf("CALCULADO MEDIANTE DIFERENCIAS DIVIDIDAS Y LOS PUNTOS DE INTERPOLACION OPTIMOS\n\n");

   //DEFINIMOS  VALORES DE INTERPOLACION
   for (unsigned int h=0;h<N;h++){
       F[h] = expl ((long double) X[h]);
   }

   // CALCULAMOS POLINOMIO INTERPOLADOR
   Array1D< real > A=mn_construir_polinomio_interpolador(X,F);

   // COMPROBAMOS RESULTADO
   printf("En los siguientes resultados el valor real del polinomio interpolador \ny el valor de P obtenido por el alumno deben coincidir\n");
   for (int i=0;i<N;i++)
   {
       real Res2, Dif;
       Res2 = mn_evaluar_polinomio_interpolador(A,X,X[i]);
       printf ("X=%lf  P_real=%lf  P_alumno=%lf \n", (double) X[i],(double) F[i], (double) Res2);
   }

   // DEFINIMOS PUNTOS PARA VERIFICAR RESULTADOS
   printf ("\nVerificacion  con otros puntos\n");
   real Y[6]={0.,0.5,1.,2.,3.,10.};
   for (int i=0;i<6;i++)
   {
      real F = expl ((long double) Y[i]);
      real P = mn_evaluar_polinomio_interpolador(A,X,Y[i]);
      printf ("Y=%lf  P_real=%lf  P_alumno=%lf \n", (double) Y[i],(double) F, (double) P);
   }

  // HACEMOS UNA PAUSA EN EL PROGRAMA PARA PODER EXAMINAR EL RESULTADO POR CONSOLA
  system("pause");
  return 0;
}



