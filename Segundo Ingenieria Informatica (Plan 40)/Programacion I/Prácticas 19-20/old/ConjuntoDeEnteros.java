/**
 * @author  Aarón Hernández Álvarez
 * @version %I% %G%
 */
public class ConjuntoDeEnteros {
	private int[] elements;
	
	/**
	 * Constructor default
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

	/**
    * Crea el nuevo array que asignará al conjunto.
    * Usa el método is Repeated para verificar que un elemento no esta 
    * 
    * @param    int[]   Vector base de conjunto de elementos
    * @return   int[]   Vector filtrado.
    */
	private int[] createElements(int[] sample){
	     if(sample.length == 0){
	         return new int[0];
	     }
	     int size = 0;
	     int[] mediate = new int[10];
	     for(int i=0; i<sample.length; i++){
            if(size<10 && !isRepeated(mediate, sample[i], size)){
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
	
    /*
    *   Confirma si un elemento esta o no repetido.
    *   
    *   @param  int[]   array de entrada.
    *   @param  int     parametro a revisar.
    *   @return boolean Presencia del elemento.
    */	
	private static boolean isRepeated(int[] mediate, int value, int size){  
	    for(int i=0; i<size; i++){
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
	 * Devuelve true si el numero pasado existe en el conjunto 
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
	 * Devuelve un conjunto de enteros con el rsultante de la intersección de ambos.
	 * 
	 * @param   ConjuntoDeEnteros   Conjunto de entrada.
	 * @return  ConjuntoDeEnteros   Conjunto diferencia resultante.
	 */
	public ConjuntoDeEnteros intersección(ConjuntoDeEnteros sample){
	    int arrayLimit = 0;
	    int j=0;
	    int[] aux = new int[10];
        for (int i=0; i<this.elements.length;i++){
    	    if(sample.pertenece(this.elements[i])){
    	        aux[j] = this.elements[i];
    	        arrayLimit++;
    	        j++;
    	    }
    	}
	    ConjuntoDeEnteros res = new ConjuntoDeEnteros(createArray(aux, arrayLimit));
	    return res;
	}
	
	/**
	 * Devuelve un conjunto de enteros con el resultante de la diferencia.
	 * Dicho conjunto incluye los elementos del caller que no estan en el segundo.
	 * 
	 * @param   ConjuntoDeEnteros   Conjunto de entrada.
	 * @return  ConjuntoDeEnteros   Conjunto diferencia resultante.
	 */
	public ConjuntoDeEnteros diferencia(ConjuntoDeEnteros sample){
	    int arrayLimit = 0;
	    int j=0;
	    int[] aux = new int[10];
	    for (int i=0; i<this.elements.length;i++){
	        if(!sample.pertenece(this.elements[i])){
	            aux[j] = this.elements[i];
	            arrayLimit++;
	            j++;
	        }
	    }
	    ConjuntoDeEnteros res = new ConjuntoDeEnteros(createArray(aux, arrayLimit));
	    return res;
	}
	
	/**
	 * Devuelve un vector de longitud ajustada para crear los conjuntos resultantes 
	 * en los metodos intersección y unión.
	 * 
	 * @param   int[]   Vector de entrada de longitud máxima de 10 elementos.
	 * @param   int     Longitud maxima del vector filtrado.
	 * @return  int[]   Vector ajustado de elementos.
	 */
	private int[] createArray(int[] aux, int arrayLimit){
	    if(arrayLimit == 0){
	        return new int[0];
	    }
	    int[] res = new int[arrayLimit];
	    for (int i=0; i<res.length; i++){
	        res[i] = aux[i];
	    } 
	    return res;
	}
	
	/**
	 * Devuelve un conjunto unión entre dos conjuntos pasados por parámetros.
	 * 
	 * Si la union es entre vacios, retorna vacío.
	 * Si es entre vacío y alguno con elementos, devuelve una copia del que tiene elementos.
	 * Si la union resultante tiene longitud menor que 10, crea el conjunto automaticamente.
	 * Ante caso contrario, crea un vector de posiciones aleatorias sobre el cual genera el
	 * conjunto union resultante.
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
        int longest = (this.elements.length>set1.elements.length) ? this.elements.length:set1.elements.length;
        int elementosunion = longest;
        
        //Comprobamos en base a cual de los dos conjuntos es mayor.
        if(longest > this.elements.length){
            for (int i=0; i<this.elements.length; i++){
                if(!set1.pertenece(this.elements[i])){
                    elementosunion++;
                }
            }            
        } else {
            for (int i=0; i<set1.elements.length; i++){
                if(!this.pertenece(set1.elements[i])){
                    elementosunion++;
                }
            }
        }
        int[] mediate = new int[elementosunion];
        
        //Lo cargamos en el nuevo array.
        for (int i=0; i<this.elements.length; i++){
            mediate[i] = this.elements[i];
        } 
        
        //Cargamos los valores restantes del parametro en el nuevo array.
        int j=0;
        int k=this.elements.length;
        while(k<mediate.length){
            if(!this.pertenece(set1.elements[j])){
                mediate[k] = set1.elements[j];
                k++;
            }
            j++;
        }
        
        if(mediate.length > 9){
            int[] swapped = swapSet(mediate.length);
            int[] auxfinal = new int[10];
            for (int i=0; i<auxfinal.length; i++){
                auxfinal[i] = mediate[swapped[i]];
            } 
            ConjuntoDeEnteros res = new ConjuntoDeEnteros(auxfinal);
            return res;
        }
        ConjuntoDeEnteros res = new ConjuntoDeEnteros(mediate);
        return res; 
    }
	
	/**
	 * Devuelve un vectorde posiciones aleatorias dentro del rango del vector mediate
	 * 
	 * @param   int     Rango de entrada
	 * @return  int[]   Vector de posiciones aleatorias
	 */	
	private static int[] swapSet(int range){
        int[] swapped = new int[10];
        swapped[0] = (int) (Math.random()*range);
        for(int i=1; i<10; i++){
            swapped[i] = (int) (Math.random()*range);
            for(int j = 0;j < i;j++){
                if(swapped[i] == swapped[j]){
                    i--;
                }
            }
        }
        return swapped;
    }
	
	/**
	 * Retorna un conjunto 
	 */
	
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
























