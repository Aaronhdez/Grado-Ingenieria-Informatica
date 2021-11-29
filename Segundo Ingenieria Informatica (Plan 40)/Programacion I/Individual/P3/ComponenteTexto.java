public class ComponenteTexto extends Componente {
    public String texto;

    public ComponenteTexto(String newtexto){
        super();
        this.texto = newtexto;
    }
    
    /**
     * Devuelve un nuevo objeto copia del actual. 
     * El objeto copiado es independiente del original.
     */
    public ComponenteTexto copia(){
        ComponenteTexto res = new ComponenteTexto(this.texto);
        return res;
    }
    
    /**
     * Devuelve una String que representa el componente.
     */ 
    @Override
    public String toString(){
        return this.texto;
    }
}