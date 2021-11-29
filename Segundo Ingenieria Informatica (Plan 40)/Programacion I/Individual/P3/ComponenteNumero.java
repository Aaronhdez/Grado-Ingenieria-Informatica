public class ComponenteNumero extends Componente {
    public int numero;
    /**
     * 
     */
    public ComponenteNumero(int num){
        super();
        this.numero = num;
    }
    /**
     * Devuelve un nuevo objeto copia del actual. 
     * El objeto copiado es independiente del original.
     */
    public ComponenteNumero copia(){
        ComponenteNumero res = new ComponenteNumero(this.numero);
        return res;
    }
    
    /**
     * Devuelve una String que representa el componente.
     */ 
    @Override
    public String toString(){
        return Integer.toString(this.numero);
    }
}