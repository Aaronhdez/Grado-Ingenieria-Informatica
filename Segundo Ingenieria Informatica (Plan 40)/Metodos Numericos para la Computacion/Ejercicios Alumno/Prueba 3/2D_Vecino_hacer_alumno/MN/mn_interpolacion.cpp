/*========================================================================
  FUNCIONES PARA LA INTERPOLACION DE FUNCIONES
  ======================================================================== */

// INCLUSION DE LA LIBRERIA PARA GESTIONAR LA ARITMETICA
#include "mn_aritmeticas.h"
#include "mn_interpolacion.h"

/// FUNCIÓN PARA CALCULAR UN ZOOM DE FACTOR z A UN Array2D< real >
/// USANDO INTERPOLACIÓN POR EL VECINO MÁS CERCANO
/// SE CONSIDERA QUE LA DISTANCIA ENTRE LOS PIXELS DEL Array2D ES 1
/// DADO UN PUNTO EN LA IMAGEN DE ÍNDICES (i,j) SI AL ACCEDER AL
/// PUNTO (i+1,j) NOS SALIMOS DE LA IMAGEN, TOMAMOS EN SU LUGAR EL PUNTO (i,j)
/// LO MISMO SI NOS SALIMOS AL ACCEDER A (i,j+1) O (i+1,j+1)
/// PARA VALIDAR LOS RESULTADOS DESDE EL main() SE LEE LA IMAGE eiiBW.bmp Y SE GUARDA
/// EL RESULTADO DEL ZOOM OBTENIDO POR EL ALUMNO EN LA IMAGEN  eiiBW_zoom.bmp
/// SE DEBE MIRAR DICHA IMAGEN PARA COMPROBAR SI LOS RESULTADOS SON COHERENTES
Array2D< real > zoom(Array2D< real > &A,real z){
  /// HACER ALUMNO
    /// Creamos dos dimensiones que serán la nueva matriz (nueva imagen). Mutiplicadas por z
    int newWidth = A.dim1()*z;
    int newHeight = A.dim2()*z;

    ///Comprobamos que AMBAS sean mayores de 0
    if(newHeight <= 0 || newWidth <= 0){
        return Array2D< real > ();
    }

    ///Si lo son conformamos un nuevo 2D, que será la nueva imagen
    Array2D< real > newImg(newWidth,newHeight);

    ///Creamos la estructura iterativa y la seguimos
    for(int i=0; i<newImg.dim1(); i++){
        for(int k=0; k<newImg.dim2(); k++){
            ///Calculamos las interpolación para cada punto.
            real x=i/z;
            real y=k/z;
            int ai=x;
            int bi=y;
            ///Aplicamos la interpolación del vecino mas cercano a cada punto
            ///Si la resta entre el real y nuestro entero creado a partir del real esmenos de 0,5
            if((x-ai)>0.5 && (ai+1)<A.dim1()){
                ai = ai+1;
            }
            if((y-bi)>0.5 && (bi+1)<A.dim2()){
                bi = bi+1;
            }
            newImg[i][k] = A[ai][bi];
        }
    }
    return newImg;
}
