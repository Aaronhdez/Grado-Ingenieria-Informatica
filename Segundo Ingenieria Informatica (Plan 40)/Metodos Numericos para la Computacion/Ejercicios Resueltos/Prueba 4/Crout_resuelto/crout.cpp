/* Funciones para la resolución de un sistema matricial por el método de Crout */

#include "crout.h"
#include "lapack.h"
#include <stdlib.h>
#include <stdio.h>

/** la función crout_descomposicion() calcula los vectores l[],m[] y u[] del
metodo de Crout visto en Clase a partir de una matriz tridiagonal dada por los
vectores a[] (la diagonal de la matriz) y  b[] y c[] (las codiagonales de la matriz)
la función devuelve 0 si termina correctamente y un número negativo en caso
contrario */
int crout_descomposicion(Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,Array1D< real > &l,Array1D< real > &m,Array1D< real > &u)
{
  /// COMPROBAMOS DIMENSIONES
  if(l.dim()!=a.dim() || l.dim()!=(m.dim()+1) || u.dim()!=m.dim() || u.dim()!=b.dim() || u.dim()!=c.dim()) return(-1);

  /// ALGORITMO CROUT
  l[0]=a[0];
  if(l[0]==0) return(-2); /// comprobamos division por cero
  u[0]=b[0]/l[0];
  for(int i=1;i<(a.dim()-1);i++){
    m[i-1]=c[i-1];
    l[i]=a[i]-m[i-1]*u[i-1];
    if(l[i]==0) return(-2); // comprobamos division por cero
    u[i]=b[i]/l[i];
  }
  m[m.dim()-1]=c[c.dim()-1];
  l[a.dim()-1]=a[a.dim()-1]-m[a.dim()-2]*u[a.dim()-2];
  return(0);

}

/** la función crout_descenso() resuelve un sistema triangular inferior usando
una matriz triangular como la que sale al descomponer la matriz por el método de Crout
el vector t[] es el término independiente del sistema. La función devuelve el vector solución */
Array1D< real > crout_descenso (Array1D< real > &l,Array1D< real > &m,Array1D< real > &t)
{
   // COMPROBAMOS DIMENSIONES
  if(t.dim()!=l.dim() || t.dim()!=(m.dim()+1)) return(Array1D< real >());

  // ALGORITMO DESCENSO
  Array1D< real > z(l.dim()); // declaramos array de salida
  if(l[0]==0) return(Array1D< real >()); // comprobamos division por cero
  z[0]=t[0]/l[0];
  for(int i=1;i<z.dim();i++){
    if(l[i]==0) return(Array1D< real >()); // comprobamos division por cero
    z[i]=(t[i]-z[i-1]*m[i-1])/l[i];
  }
  return(z);
}

/** la función crout_remonte() resuelve un sistema triangular superior usando
una matriz triangular como la que sale al descomponer la matriz por el método de Crout
el vector z[] es el término independiente del sistema. La función devuelve el vector solución */
Array1D< real > crout_remonte(Array1D< real > &u,Array1D< real > &z){
  // COMPROBAMOS DIMENSIONES
  if(z.dim()!=(u.dim()+1)) return(Array1D< real >());

  // ALGORITMO REMONTE
  Array1D< real > v(z.dim()); // declaramos array de salida
  v[z.dim()-1]=z[z.dim()-1];
  for(int i=z.dim()-2;i>=0;i--){
    v[i]=(z[i]-v[i+1]*u[i]);
  }
  return(v);
}

/** la función crout_metodo_completo() resuelve un sistema tridiagonal usando el método de Crout
el vector t[] es el término independiente del sistema. La función devuelve el vector solución */
Array1D< real > crout_metodo_completo(Array1D< real > &a,Array1D< real > &b,Array1D< real > &c,Array1D< real > &t)
{
  // DECLARAMOS LOS VECTORES DE LA DESCOMPOSICION DE CROUT
  Array1D< real > l(a.dim());
  Array1D< real > m(c.dim());
  Array1D< real > u(b.dim());

  // DESCOMPONEMOS LA MATRIZ POR EL METODO DE CROUT Y COMPROBAMOS EL RESULTADO
  int error=crout_descomposicion(a,b,c,l,m,u);
  if(error<0) return(Array1D<real>());

  // RESOLVEMOS EL SISTEMA TRIANGULAR INFERIOR ASOCIADO Y COMPROBAMOS EL RESULTADO
  Array1D< real > z=crout_descenso (l,m,t);
  if(z.dim()==0) return(Array1D<real>());

  // RESOLVEMOS EL SISTEMA TRIANGULAR SUPERIOR ASOCIADO Y DEVOLVEMOS LA SOLUCION
  Array1D< real > v=crout_remonte (u,z);
  return(v);
}

