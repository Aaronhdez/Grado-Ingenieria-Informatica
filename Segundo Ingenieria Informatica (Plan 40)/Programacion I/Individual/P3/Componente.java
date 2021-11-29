public abstract class Componente{
    
    /**
     * Devuelve un nuevo objeto copia del actual. 
     * El objeto copiado es independiente del original.
     */
    public abstract Componente copia();
    
    /**
     * Devuelve cuántos caracteres, sin contar los espacios, se devuelven en toString().
     */
    public int nPalabras(){
        String sample = this.toString();
        int contador = 0;
        boolean b = false;
        for (int i = 0; i<sample.length(); i++){
            if(!(sample.charAt(i)==' ') && b == false){
                contador++;
                b = true;
            }
            if(sample.charAt(i)==' '){
                b = false;
            }
        }
        return contador;
    }
    
    /**
     * Devuelve cuántas palabras se devuelven en toString() siempre que no se indique lo contrario. 
     * Una palabra es una secuencia contigua de caracteres separadas por uno o más espacios. 
     * Si se comienza o termina con un carácter no espacio entonces ahí comienza o termina una 
     * palabra, respectivamente.
     */
    public int nCaracteres(){
        int caracteres = 0;
        String sample = this.toString();
        for (int i=0; i<sample.length(); i++){
            if(sample.charAt(i) != ' '){
                caracteres++;
            }
        }
        return caracteres;
    }
    
    /**
     * Devuelve una String que representa el componente.
     */ 
    @Override
    public abstract String toString();
}