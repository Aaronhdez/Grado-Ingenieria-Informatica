//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ImagenCuestion.java
//  @ Date : 01/05/2020
//  @ Author : 
//
//


package preguntadosApp;

public class ImagenCuestion extends Imagen {
	/**
         * 
         * @param alto Altura de la imagen (en pixeles)
         * @param ancho Anchura de la imagen (en pixeles)
         * @param nombre nombre de la imagen 
         */
        public ImagenCuestion(int alto, int ancho, String nombre) {
            super(alto, ancho, nombre);
	}
	
        /**
         * Metodo para establecer la resolución de la imagen
         * 
         * @param alto Altura de la imagen (en pixeles)
         * @param ancho Anchura de la imagen (en pixeles)
         */
	public void setResolucion(int alto, int ancho) {
		this.setAlto(alto);
		this.setAncho(ancho);
	}
}
