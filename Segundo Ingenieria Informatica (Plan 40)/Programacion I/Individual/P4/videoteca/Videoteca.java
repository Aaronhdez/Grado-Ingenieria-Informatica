import java.util.*;

public class Videoteca{
    
    private String name;
    private HashSet<Film> elements;
    private int order;
    
    /**
     * 
     */
    private class OrdenPorDefecto implements Comparator<Film> {
        public int compare(Film f1, Film f2){
            int compTitle = (f1.getTitle()).compareTo(f2.getTitle());
            int compGenre = (f1.getGenre()).compareTo(f2.getGenre());
            if(compTitle < 0){
                return -1;
            }
            if(compGenre < 0){
                return -1;
            }
            if(f1.getYear() > f2.getYear()){
                return -1;
            }
            return 0;
        }
    }
    
    /**
     * 
     */
    private class OrdenModificado implements Comparator<Film> {
        public int compare(Film f1, Film f2){
            int compTitle = (f1.getTitle()).compareTo(f2.getTitle());
            int compGenre = (f1.getGenre()).compareTo(f2.getGenre());
            if(f1.getYear() > f2.getYear()){
                return -1;
            }
            if(compTitle < 0){
                return -1;
            }
            if(compGenre < 0){
                return -1;
            }
            return 0;
        }
    }
    
    public Videoteca(String name){
        this.elements = new HashSet<Film>();
        this.order = 0;
        this.name = name;
    }
    
    /**
     * Añade una nueva película no repetida y devuelve verdadero, o no la añade 
     * y devuelve falso si la película ya existe.
     * 
     * @param   Film    Película a añadir.
     * @return  boolean Retorna si se ha añadido o no.
     */
    public boolean add(Film f){
        return this.elements.add(f);
    }
    
    /**
     * Establece el orden en que se genera el listado de películas con getFilms():
     * - ord = 0: Por título, género y año (opción por defecto)
     * - ord = 1: Por año, título y género
     * 
     * @param   int Configuración del orden.
     */
    public void setOrder(int ord){
        if(ord == 0 || ord == 1){
            this.order = ord;
        }
    }
    
    /**
     * Devuelve el conjunto de películas en el orden establecido por setOrder(), 
     * o null si no hay películas registradas.
     * 
     * @return  Set<Film>   Conjunto de películas a devolver.
     */
    public Set<Film> getFilms(){
        
        // Si el array está vacío, retorna una set vacío.
        if(this.elements.size() == 0){
            return null;
        }
        // Si el orden no es el 0, ejecutamos orden inverso. En caso contrario, 
        // ejecutamos el original
        if(this.order == 1){
            Set<Film> res = new TreeSet<Film>(new OrdenModificado());
            for (Film e : this.elements) {
                res.add(e);
            }
            return res;
        }
        
        Set<Film> res = new TreeSet<Film>(new OrdenPorDefecto());
        for (Film e : this.elements) {
            res.add(e);
        }
        return res;
    }
    
    /**
     * Devuelve una lista de ristras en orden alfabético. Cada ristra se obtiene 
     * concatenando el género de la película seguido del carácter dos puntos y un 
     * espacio en blanco (": ") y seguido del número de películas de cada género.
     * 
     * @return  List<String>   Lista de películas a devolver.
     */
    public List<String> getGenres(){
        SortedMap<String, Integer> mapa = new TreeMap<String,Integer>();
        List<String> listaFinal = new ArrayList<String>();
        
        // Añadimos al set ordenado
        for(Film f: this.elements){
            if(mapa.containsKey(f.getGenre())){
                int valor = mapa.get(f.getGenre());
                mapa.put(f.getGenre(), valor+1);
                continue;
            }
            mapa.put(f.getGenre(),1);
        }
        //Recorremos el Map final y vamos añadiendo a los objetos
        for(Map.Entry<String,Integer> e: mapa.entrySet()){
            listaFinal.add(e.getKey() + ": " + e.getValue());
        }
        return listaFinal;
    }
    
    /**
     * Devuelve una String con el listado numerado de películas registradas en el 
     * orden establecido, empezando en uno (después del número va un cierra paréntesis 
     * y un espacio en blanco) separadas por saltos de línea ("\n") y precedidas 
     * por el nombre de la videoteca seguido de dos puntos y un salto de línea (":\n").
     * 
     * @return  String  Concatenación de los Strings resultantes.
     */
    @Override
    public String toString(){
        String res = this.name + ":\n";
        return res;
    }
}