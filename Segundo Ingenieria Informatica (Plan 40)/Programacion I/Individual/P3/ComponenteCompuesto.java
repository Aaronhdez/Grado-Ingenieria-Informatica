public class ComponenteCompuesto extends Componente {
    public Componente[] elementos;
    
    public ComponenteCompuesto(){
        elementos = new Componente[0];
    }
    /**
     * Hace una copia del objeto pasado, almacenándola al final de la secuencia. 
     * Si el ComponenteCompuesto está lleno no hace nada.
     */
    public void añade(Componente sample){
        if(this.elementos.length < 100){
            int pos = this.elementos.length+1;
            Componente[] res = new Componente[pos];
            for (int i=0; i<elementos.length; i++){
                res[i] = elementos[i].copia();
            }
            //OJO, REVISAR EL TIPO DE COMPONENTE, EL FOR TRABAJA CON REFERENCIAS
            res[pos-1] = sample;
            this.elementos = res;
        } else {
            System.out.print("La posición no está en el rango correcto.");
        }
    }

    /**
     * Devuelve el número de objetos almacenados con añade en el objeto compuesto. 
     * Debe devolver un valor entre 0 y 100.
     */    
    public int cardinal(){
        return this.elementos.length;
    }

    /**
     * Los objetos almacenados se encuentran desde la posición 0 a la cardinal()-1. 
     * modifica sustituye el objeto almacenado en la posición pos una copia 
     * del parámetro pasado. Si pos está fuera de rango no hace nada.
     * 
     * Emplea la referencia del objeto para distinguir las acciones a realizar 
     * por parte del método
     * 
     * @param   int posición del array de compuestos.
     * @param   Componente Objeto de alguna subclase de componente pasado como parametro. 
     */
    public void modifica(int pos, Componente muestra){
        //Verificamos a pertenencia al rango.
        if(pos > 0 && pos < this.cardinal()-1){
            //El filtro lo hace desde el abstracto. Copiamos el parámetro (el objeto es el que manda).
            Componente sample = muestra.copia();
            this.elementos[pos] = sample;
        } else {
            System.out.print("La posición no está en el rango correcto.");
        }
    }
    
    /**
     * Devuelve cuántos caracteres, sin contar los espacios, se devuelven en toString().
    */
    @Override
    public int nCaracteres(){
        int res = 0;
        for (int i=0; i<this.elementos.length; i++){
            res += this.elementos[i].nCaracteres();
        } 
        return res;
    }
    
    /**
     * Devuelve la suma del número de palabras de cada objeto que almacena. 
     * Este valor no tiene que coincidir con el cálculo del número de palabras de la ristra devuelta en toString().
    */
    @Override
    public int nPalabras(){
        int res = 0;
        for (int i=0; i<this.elementos.length; i++){
            res += this.elementos[i].nPalabras();
        } 
        return res;        
    }
    /**
     * Devuelve un nuevo objeto que es copia del actual. 
     * El objeto copiado debe ser independiente del original, o sea, no debe compartir datos.
    */
    @Override
    public ComponenteCompuesto copia(){
        ComponenteCompuesto res = new ComponenteCompuesto();
        for (int i=0; i<this.elementos.length; i++){
            res.añade(this.elementos[i].copia());          
        } 
        return res;
    }
    /**
     * Devuelve la concatenación de todas las ristras de los componentes de la secuencia.
    */
    @Override
    public String toString(){
        String res = "";
        for (int i=0; i<this.elementos.length; i++){
            res += this.elementos[i].toString();
        } 
        return res;
    }
}