import java.util.Random;
public class ConjuntoDeEnteros {
	private int[] elements;
	
	/**
	 * Constructor desfault
	 */
	public ConjuntoDeEnteros(){
		elements = new int[0];
	}
	
	/**
	 * Constructor con parámetro
	 * 
	 * @param   int[] Vector base de conjunto de elementos
	 */
	public ConjuntoDeEnteros(int[] sample){
		elements = createElements(sample);
	}

	/* Método createElements()
    *    
    *   Crea el nuevo array que asignará al conjunto.
    *   Usa el método is Repeated para verificar que un elemento no esta repetido
    */
	private int[] createElements(int[] sample){
	     if(sample.length == 0){
	         return new int[0];
	     }
	     int size = 0;
	     int[] mediate = new int[10];
	     for(int i=0; i<sample.length; i++){
	        if(size < 10 && !isRepeated(mediate, sample[i]) || size == 0){
	            mediate[size] = sample[i];
	            size++;
	        }
	     }
	     int[] res = new int[size];
	     for(int k=0; k<size; k++){
	         res[k] = mediate[k];
	     }
	     return res;
	}
	
    /* Método isRepeated(int[] a, int b)
    *  
    *   Confirma si un elemento esta o no repetido.
    *   
    *   @param  int[]   array de entrada.
    *   @param  int     parametro a revisar.
    *   @return boolean Presencia del elemento.
    */	
	private static boolean isRepeated(int[] mediate, int value){  
	    for(int i=0; i<mediate.length; i++){
	        if(mediate[i] == value){
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Devuelve true si el conjunto caller esta vacío y false si no lo está.
	 * 
	 * @return   boolean Estado del conjuto.
	*/
	public boolean estáVacío(){
	    return this.elements.length == 0;
	}

	/**
	 * Devuelve el cardinal del conjunto caller.
	 * 
	 * @return   int Cardinal del conjuto.
	*/
	public int cardinal(){
	    return this.elements.length;
	}

	/**
	 * Retorna el array de enteros que componen el conjuto 
	 * 
	 * @return  int[] vector de elementos
	*/
	public int[] elementos(){
	    return this.elements;
	}
	
	/**
	 * Devuelve true si el numero pasado existe en el conjunto, 
	 * y false en caso contrario.
	 * 
	 * @param   int     Número a evaluar
	 * @return  boolean Pertenencia del numero pasado al conjunto.
	*/
	public boolean pertenece(int value){
	    for(int i=0; i<this.elements.length; i++){
	        if(value == this.elements[i]){
	            return true;
	        }
	    }
	    return false;
	}
    
    
	/** 
	 * Añade el numero a conjunto y retorna true o false si se ha realizado o no.
	 * Descarta el elemento si la longitud base es 10 o el propio numero ya pertenece
	 * al conjunto.
	 * 
	 * @param   int     Numero a añadir.
	 * @return  boolean Estado de finalización de la operación
	*/
	public boolean añade(int value){
	    if(pertenece(value) || this.elements.length > 9){
	        return false;
	    }
	    
	    int[] res = new int[this.elements.length+1];
	    for(int i=0; i<this.elements.length; i++){
	        res[i] = this.elements[i];
	    }
	    
	    res[res.length-1] = value;
	    
	    this.elements = res;
	    return true;
	}
	
	/** 
	 * Devuelve true o false si un conjunto está o no contenido en el caller
	 *
	 * @param   ConjuntoDeEnteros   Conjunto a verificar
	 * @return  boolean             Existencia de el conjunto parámetro en éste.
	*/
	public boolean contenido(ConjuntoDeEnteros sample){
	    for (int i=0; i<sample.elements.length; i++){
            if(!this.pertenece(sample.elements[i])){
                return false;
            }
	    } 
	    return true;
	}
	
	/**
	 * Devuelve un conjunto unión entre dos conjuntos pasados por parámetros.
	 * 
	 * @param   ConjuntoDeEnteros Conjunto 2
	 * @return  ConjuntoDeEnteros Conjunto unión resultante
	 */
    public ConjuntoDeEnteros unión(ConjuntoDeEnteros set1){
        if(this.estáVacío()){
           return new ConjuntoDeEnteros(set1.elements); 
        }
        if(set1.estáVacío()){
           return new ConjuntoDeEnteros(this.elements); 
        }
        if(this.estáVacío() && set1.estáVacío()){
           return new ConjuntoDeEnteros(); 
        }
        
        //Creamos un vector de salida suma de ambos sin repetidos.
        int elementosunion = this.elements.length;
        for (int i=0; i<this.elements.length; i++){
            if(!this.pertenece(set1.elements[i])){
                elementosunion++;
            }
        }
        int[] mediate = new int[elementosunion];
        
        //Lo cargamos en el nuevo array.
        for (int i=0; i<this.elements.length; i++){
            mediate[i] = this.elements[i];
        } 
        
        //Cargamos los valores restantes del parametro en el nuevo array.
        for (int i=this.elements.length; i<mediate.length; i++){
            if(!this.pertenece(set1.elements[i])){
                mediate[i] = set1.elements[i];
            }
        }
        
        if(mediate.length > 10){
            int[] resvector = swapSet(mediate);
            ConjuntoDeEnteros res = new ConjuntoDeEnteros(resvector);
            return res;
        }
        ConjuntoDeEnteros res = new ConjuntoDeEnteros(mediate);
        return res; 
    }
	
	/**
	 * Intercambia los valores del vector pasado por parámetros
	 * 
	 * @param   int[] Vector de entrada
	 */	
	private static int[] swapSet(int[] vector){
	    Random generator = new Random();
	    int[] res = new int[10];
	    for (int i=0; i<res.length; i++){ 
	        int pos = generator.nextInt(vector.length-1);
	        if(isRepeated(res,pos)){
	            i--;
	        } else {
	            res[i] = pos;
	        }
	    }
	    return res;
	}
	
    //TESTED
    @Override
    public boolean equals(Object sample){
        if(sample instanceof ConjuntoDeEnteros){
            ConjuntoDeEnteros c = (ConjuntoDeEnteros) sample;
            if(this.elements.length != c.elements.length){
                return false;
            }
            for(int i=0; i<this.elements.length; i++){
                if(!pertenece(c.elements[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}


