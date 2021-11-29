package videoteca.source;

public class Film implements Comparable<Film>{
    //Atributos
    private String titulo;
    private String genero;
    private int año;
    //Constructor
    public Film(String titulo,String genero,int año){
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
    }
    //Metodos
    public String getTitle(){
        return this.titulo;
    }
    public String getGenre(){
        return this.genero;
    } 
    public int getYear(){
        return this.año;
    }
    @Override
    public String toString(){
        return this.titulo+" | "+this.genero+" | "+this.año;
    }
    @Override
    public int compareTo(Film f){
        int aux = 0;
        aux = this.titulo.compareTo(f.titulo);
        if(aux == 0){
            return ((Integer)this.año).compareTo(f.año);
        }
        return aux;
    }
}
