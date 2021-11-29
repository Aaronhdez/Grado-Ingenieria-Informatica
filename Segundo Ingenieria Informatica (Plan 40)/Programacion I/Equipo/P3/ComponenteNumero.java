public class ComponenteNumero extends Componente{
    /*-----ATRIBUTOS-----*/
    private int numero;
    
    /*-----CONSTRUCTOR-----*/
    public ComponenteNumero(int n){
        this.numero = n;
    }
    
    /*-----METODOS-----*/
    @Override
    public String toString(){
        return Integer.toString(this.numero);
    }
    @Override
    public Componente copia(){
        return new ComponenteNumero(this.numero);
    }
    
}