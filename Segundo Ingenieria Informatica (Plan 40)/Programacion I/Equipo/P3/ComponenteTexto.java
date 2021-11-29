public class ComponenteTexto extends Componente{
    /*-----ATRIBUTOS-----*/
    private String texto;
    
    /*-----CONSTRUCTOR-----*/
    public ComponenteTexto(String s){
        this.texto = s;
    }
    
    /*-----METODOS-----*/
    @Override
    public String toString(){
        return this.texto;
    }
    @Override
    public Componente copia(){
        return new ComponenteTexto(this.texto);
    }
}