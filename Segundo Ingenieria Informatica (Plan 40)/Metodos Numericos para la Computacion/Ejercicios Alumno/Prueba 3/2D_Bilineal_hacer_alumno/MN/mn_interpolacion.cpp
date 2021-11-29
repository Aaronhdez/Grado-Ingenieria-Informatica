/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// FUNCIÓN PARA CALCULAR UN ZOOM DE FACTOR z A UN Array2D< real >
/// USANDO INTERPOLACIÓN BILINEAL
/// SE CONSIDERA QUE LA DISTANCIA ENTRE LOS PIXELS DEL Array2D ES 1
/// DADO UN PUNTO EN LA IMAGEN DE ÍNDICES (i,j) SI AL ACCEDER AL
/// PUNTO (i+1,j) NOS SALIMOS DE LA IMAGEN, TOMAMOS EN SU LUGAR EL PUNTO (i,j)
/// LO MISMO SI NOS SALIMOS AL ACCEDER A (i,j+1) O (i+1,j+1)
/// PARA VALIDAR LOS RESULTADOS DESDE EL main() SE LEE LA IMAGE eiiBW.bmp Y SE GUARDA
/// EL RESULTADO DEL ZOOM OBTENIDO POR EL ALUMNO EN LA IMAGEN  eiiBW_zoom.bmp
/// SE DEBE MIRAR DICHA IMAGEN PARA COMPROBAR SI LOS RESULTADOS SON COHERENTES
Array2D< real > zoom(Array2D< real > &A,real z){
    /// HACER ALUMNO
    int newW=A.dim1()*z;
    int newH=A.dim2()*z;

    ///Comprobamos que los arrays no sean 0
    if(newH <= 0 || newW <= 0){
        return Array2D<real>();
    }

    ///Creamos la nueva matriz
    Array2D<real>newImg(newW,newH);
    for(int i=0; i<newImg.dim1(); i++){
        for(int j=0; j<newImg.dim2(); j++){
            /// Ajustamos los puntos de interpolación a z.
            real x = i/z;
            real y = j/z;
            /// Cortamos su parte entera para verificar posteriormente.
            int ai = x;
            int bi = y;
            /// Creamos nuestras coordenadas para el método lineal.
            /// tomamos el valor minimo entre el punto entero y
            /// su dimensión correspondiente en el original
            int i1 = min(ai+1,A.dim1()-1);
            int j1 = min(bi+1,A.dim2()-1);
            /// Partiendo de arriba, creamos los aproximadores que darán el
            /// color al punto en función a sus adyacentes
            real dx = x-ai;
            real dy = y-bi;
            newImg[i][j] =  (1.-dx)*(1.-dy)*A[ai][bi] + dx*(1.-dy)*A[i1][bi] +
                            dy*(1.-dx)*A[ai][j1] + dx*dy*A[i1][j1];
        }
    }
    return newImg;
}
