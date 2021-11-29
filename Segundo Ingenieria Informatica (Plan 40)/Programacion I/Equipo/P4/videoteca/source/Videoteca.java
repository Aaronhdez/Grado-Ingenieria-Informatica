package videoteca.source;
import java.util.*;
/**
 * Clase Videoteca que implementa la inserción de películas 
 * 
 * @author Victor, Javier, Aarón
 * @version 04.12.2019.0.0.2
 * 
 */
public class Videoteca {
    /**
     * Clase Filtro que ordena por el primer criterio general
     */
    private class ComparadorOrden0 implements Comparator<Film>{
        @Override
        public int compare(Film film1,Film film2){
            int criterio1 = 0;
            int criterio2 = 0;
            int criterio3 = 0;
            criterio1 = film1.getTitle().compareTo(film2.getTitle());
            if(criterio1 == 0){
                criterio2 = film1.getGenre().compareTo(film2.getGenre());
                if(criterio2 == 0){
                    criterio3 = ((Integer)film1.getYear()).compareTo(film2.getYear());
                    return criterio3; 
                }
                return criterio2;
            }
            return criterio1;
        }
    }
    /**
     * Clase Filtro que ordena por el segundo criterio general
     */
    private class ComparadorOrden1 implements Comparator<Film>{
        @Override
        public int compare(Film film1,Film film2){
            int criterio1 = 0;
            int criterio2 = 0;
            int criterio3 = 0;
            criterio1 = ((Integer)film1.getYear()).compareTo(film2.getYear());
            if(criterio1 == 0){
                criterio2 = film1.getTitle().compareTo(film2.getTitle());
                if(criterio2 == 0){
                    criterio3 = film1.getGenre().compareTo(film2.getGenre());
                    return criterio3;
                }
                return criterio2;
            }
            return criterio1;
        }
    }
    /*Atributos*/
    private String nombre;
    private int orden;
    public SortedSet <Film> contenedor;
    /*Constructor*/
    public Videoteca(String nombre){
        this.nombre = nombre;
        this.orden = 0;
        this.contenedor = new TreeSet<Film>();
    }
    /**
     * Añade una nueva película no repetida y devuelve verdadero, o no la añade 
     * y devuelve falso si la película ya existe.
     * 
     * @param   Film    Película a añadir.
     * @return  boolean Retorna si se ha añadido o no.
     */
    public boolean add(Film f){
        return this.contenedor.add(f);
    }
    /**
     * Establece el orden en que se genera el listado de películas con getFilms():
     * - ord = 0: Por título, género y año (opción por defecto)
     * - ord = 1: Por año, título y género
     * 
     * @param   int Configuración del orden.
     */
    public void setOrder(int ord){
        if(ord!=0&&ord!=1){
            return;
        }
        this.orden = ord;
    }
    /**
     * Devuelve el conjunto de películas en el orden establecido por setOrder(), 
     * o null si no hay películas registradas.
     * 
     * @return  Set<Film>   Conjunto de películas a devolver.
     */
    public Set<Film> getFilms(){
        if(this.contenedor.size()==0){
            return null;
        }
        if(this.orden == 0){
            TreeSet<Film> res= new TreeSet<>(new ComparadorOrden0());
            for(Film f:this.contenedor){
                res.add(f);
            }
            return res;
        }
        TreeSet<Film> res= new TreeSet<>(new ComparadorOrden1());
        for(Film f:this.contenedor){
                res.add(f);
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
        SortedMap<String,Integer> mapa = new TreeMap<String,Integer>();
        List<String> lista = new ArrayList<String>();
        for(Film f:this.contenedor){
            if(mapa.containsKey(f.getGenre())){
                int valor = mapa.get(f.getGenre());
                mapa.put(f.getGenre(),valor+1);
                continue;
            }
            mapa.put(f.getGenre(),1);
        }
        for(Map.Entry<String,Integer> e:mapa.entrySet()){
            lista.add(e.getKey()+": "+e.getValue());
        }
        return lista;
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
        int i =0;
        String res= this.nombre+":\n";
        Videoteca aux = new Videoteca("Ejemplo");
        aux.contenedor = (TreeSet)this.getFilms();
        for(Film f:aux.contenedor){
            i++;
            res+=i+") "+f+"\n";
        }
        return res;
    }
}