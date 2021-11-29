/* Procedimiento de prueba para el  uso del método de integración de Simpson */
#include <stdio.h>
#include <stdlib.h>
#include "../mn_integrales.h"


int main()
{
    real x=-20.;
    printf("distribucion normal  (real)  para x = %lf es %lf \n",x,0.);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=-10.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=-2.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.022750);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=-1.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.158655);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=0.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.5);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=1.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.841345);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=2.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,0.977250);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

    x=10.;
    printf("\ndistribucion normal  (real)  para x = %lf es %lf \n",x,1.);
    printf("distribucion normal (alumno) para x = %lf es %lf \n",x,distribucion_normal(x));

}
