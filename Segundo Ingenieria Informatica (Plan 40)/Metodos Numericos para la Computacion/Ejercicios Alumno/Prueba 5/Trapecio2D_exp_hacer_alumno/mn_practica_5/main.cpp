/* Procedimiento de prueba para el  uso del m�todo de Cholesky  */
#include <stdio.h>
#include "../integracion.h"
#include <stdlib.h>


int main()
{
  real integral=3.141593;
  printf("    integral real :%lf\n",integral);
  printf("  integral alumno :%lf\n",integracion());
  system("pause");

  return 0;
}


