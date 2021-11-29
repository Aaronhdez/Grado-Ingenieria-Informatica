public class ComponenteCompuesto extends Componente{
    /*-----ATRIBUTOS-----*/
    private Componente[] almacen;
    private int puntero;
    
    /*-----CONSTRUCTOR-----*/
    public ComponenteCompuesto(){
        this.almacen = new Componente[100];
        this.puntero = 0;
    }
    
    /*-----METODOS-----*/
    public void añade(Componente c){
        if(this.puntero < 100){
        Componente copia = c.copia();
        this.almacen[this.puntero] = copia;
        puntero++;
        }
    }
    public int cardinal(){
        return this.puntero;
    }
    public void modifica(int pos, Componente c){
        if(pos<this.puntero&&pos>=0){
            Componente copia = c.copia();
            this.almacen[pos] = copia;
        }
    }
    @Override
    public String toString(){
        String s = "";
        for(int i = 0;i<this.puntero;i++){
            s+=this.almacen[i].toString();
        }
        return s;
    }
    @Override
    public int nPalabras(){
        int n = 0;
        for(int i = 0;i<this.puntero;i++){
            n += this.almacen[i].nPalabras();
        }
        return n;
    }
    @Override
    public Componente copia(){
        ComponenteCompuesto copia = new ComponenteCompuesto();
        copia.puntero = this.puntero;
        for(int i = 0;i<this.puntero;i++){
            copia.almacen[i] = this.almacen[i].copia();
        }
        return copia;
    }
}



