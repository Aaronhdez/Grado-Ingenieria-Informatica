/* Procedimiento de prueba para el  uso del método de Crout  */
#include <stdio.h>
#include "../crout.h"
#include "../lapack.h"
#include <stdlib.h>

int main()
{
  int N;
  {
    printf("EJEMPLO 1 METODO DE CROUT: \n\n");
    Array1D< real > a,b,c,t,l(3,0.),m(2,0.),u(2,0.);
    N=leer_vector("../datos/a1.txt",a); // vector a de la matriz tridiagonal
    N=leer_vector("../datos/b1.txt",b); // vector b de la matriz tridiagonal
    N=leer_vector("../datos/c1.txt",c); // vector c de la matriz tridiagonal
    N=leer_vector("../datos/t1.txt",t); // vector t de términos independientes del sistema

    printf("Comprobamos la funcion crout_descomposicion()\n");
    int error=crout_descomposicion(a,b,c,l,m,u);
    printf("vector l[] calculado por el alumno : (%lf,%lf,%lf) \n",l[0],l[1],l[2]);
    printf("vector l[] correcto                : (%lf,%lf,%lf) \n\n",2.,1.5,4./3.);
    printf("vector m[] calculado por el alumno : (%lf,%lf) \n",m[0],m[1]);
    printf("vector m[] correcto                : (%lf,%lf) \n\n",-1.,-1.);
    printf("vector u[] calculado por el alumno : (%lf,%lf) \n",u[0],u[1]);
    printf("vector u[] correcto                : (%lf,%lf) \n\n\n",-0.5,-2./3.);

    printf("Comprobamos la funcion crout_descenso()\n");
    Array1D< real > z=crout_descenso (l,m,t);
    if(z.dim()==3){
      printf("vector z[] calculado por el alumno : (%lf,%lf,%lf) \n",z[0],z[1],z[2]);
    }
    else { printf("error dimension vector\n"); }
    printf("vector z[] correcto                : (%lf,%lf,%lf) \n\n\n",0.5,1./3.,1.);

    printf("Comprobamos la funcion crout_metodo_completo()\n");
    Array1D< real > v=crout_metodo_completo(a,b,c,t);
    if(v.dim()==3){
      printf("solucion v[] calculada por el alumno : (%lf,%lf,%lf) \n",v[0],v[1],v[2]);
    }
    else { printf("error dimension vector\n"); }
    printf("solucion v[] correcta                : (%lf,%lf,%lf) \n\n\n",1.,1.,1.);
    system("pause");
  }

  {
    printf("EJEMPLO 2: METODO DE CROUT\n\n");
    Array1D< real > a,b,c,t,l(3,0.),m(2,0.),u(2,0.);
    N=leer_vector("../datos/a2.txt",a); // vector a de la matriz tridiagonal
    N=leer_vector("../datos/b2.txt",b); // vector b de la matriz tridiagonal
    N=leer_vector("../datos/c2.txt",c); // vector c de la matriz tridiagonal
    N=leer_vector("../datos/t2.txt",t); // vector t de términos independientes del sistema

    printf("Comprobamos la funcion crout_descomposicion()\n");
    int error=crout_descomposicion(a,b,c,l,m,u);
    printf("vector l[] calculado por el alumno : (%lf,%lf,%lf) \n",l[0],l[1],l[2]);
    printf("vector l[] correcto                : (%lf,%lf,%lf) \n\n",1.,2.,3.);
    printf("vector m[] calculado por el alumno : (%lf,%lf) \n",m[0],m[1]);
    printf("vector m[] correcto                : (%lf,%lf) \n\n",4.,5.);
    printf("vector u[] calculado por el alumno : (%lf,%lf) \n",u[0],u[1]);
    printf("vector u[] correcto                : (%lf,%lf) \n\n\n",6.,7.);

    printf("Comprobamos la funcion crout_descenso()\n");
    Array1D< real > z=crout_descenso (l,m,t);
    if(z.dim()==3){
      printf("vector z[] calculado por el alumno : (%lf,%lf,%lf) \n",z[0],z[1],z[2]);
    }
    else { printf("error dimension vector\n"); }
    printf("vector z[] correcto                : (%lf,%lf,%lf) \n\n\n",15.,9.,1.);

    printf("Comprobamos la funcion crout_metodo_completo()\n");
    Array1D< real > v=crout_metodo_completo(a,b,c,t);
    if(v.dim()==3){
      printf("solucion v[] calculada por el alumno : (%lf,%lf,%lf) \n",v[0],v[1],v[2]);
    }
    else { printf("error dimension vector\n"); }
    printf("solucion v[] correcta                : (%lf,%lf,%lf) \n\n\n",3.,2.,1.);
    system("pause");
  }

  return 0;
}
