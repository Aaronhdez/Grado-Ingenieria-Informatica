public class Film{
     
    private String title;
    private String genre; 
    private int year;
    
    public Film(String title, String genre, int year){
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
    
    /**
     * Devuelve el título de la película.
     * 
     * @return  String  Título de la película.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Devuelve el título de la película.
     * 
     * @return  String  Género de la película. 
     */
    public String getGenre(){
        return this.genre;
    }
    
    /**
     * Devuelve el título de la película.
     * 
     * @return  int  Año de la película.
     */
    public int getYear(){
        return this.year;
    }
    
    /**
     * Devuelve la igualdad entre dos películas.
     * 
     * @param   Film    película que se compara 
     * @return  boolean retorna true si son iguales y false si no lo son.
     */
    @Override 
    public boolean equals(Object obj){
        if(obj instanceof Film){
            Film sample = (Film) obj;
            if(this.hashCode()==sample.hashCode()){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return 19 * this.title.hashCode() * this.genre.hashCode();
    }
    
    /**
     * Devuelve una String con la representación como ristra de caracteres de 
     * una película.
     * 
     * @return  String  Género de la película. 
     */
    @Override
    public String toString(){
        return "";
    }
}