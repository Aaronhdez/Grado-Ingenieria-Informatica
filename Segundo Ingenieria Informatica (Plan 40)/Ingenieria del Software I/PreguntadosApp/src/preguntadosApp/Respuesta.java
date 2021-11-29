package preguntadosApp;

public class Respuesta implements Comparable<Respuesta>{
	private int codResp;
	private String texto;
        
        /**
         * Constructor con parámetro de entrada.
         * @param texto Texto que se va insertar en la respuesta.
         */
        public Respuesta(String texto){
            this.texto = texto;
            this.codResp = this.setId();
        }

        /**
         * Constructor sin parámetro de entrada.
         */
        public Respuesta(){
            this.texto = null;
            this.codResp = this.setId();
        }
        
        /**
         * Método para generar autmáticamente el id de la respuesta.
         * 
         * @return el id generado automáticamente para  
         */
        private int setId(){
            return this.hashCode() * 13;
        }

        /**
         * Retorna el id de la respuesta. Necesario para la comparación
         * 
         * @return el código de la Respuesta
         */
        public int getId(){
            return this.codResp;
        }
        
        /**
         * Asigna texto a la respuesta en particular.
         * 
         * @param txt Texto que se quiere asignar a la respuesta 
         */
	public void setTexto(String txt) {
            this.texto = txt;
	}
	
        /**
         * Retorna el texto de la respuesta
         * 
         * @return texto de la respueta
         */
	public String getTexto() {
            return this.texto;
	}
        
        /**
         * Sobreescritura del método compareTo
         * 
         * @param R Respuesta con la que se realizará la comparación
         * @return o si los Id son el mismo o en su defecto, -1 o 1 según la 
         * comparación entre ambos
         */
        @Override
        public int compareTo(Respuesta R){
            if(this.codResp == R.getId()){
                return 0;
            } else {
                return ((Integer)this.codResp).compareTo((Integer)R.getId());
            }
        }
        
}
