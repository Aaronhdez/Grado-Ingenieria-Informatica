package videoteca.test;
import videoteca.source.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class VideotecaTest {

    //TESTS
    @Test
    public void test1(){
        //Prueba de pelicula
        Film f1 = new Film("Forrest Gump", "Comedia", 1994);
        assertEquals(f1.getTitle(), "Forrest Gump");
        assertEquals(f1.getGenre(), "Comedia");
        assertEquals(f1.getYear(), 1994);
        assertEquals(f1.toString(), "Forrest Gump | Comedia | 1994");
        //Prueba de videoteca
        Videoteca videoteca = new Videoteca("Mi videoteca");
        videoteca.setOrder(1); // Se establece el orden por año+título+género
        videoteca.add(new Film("Los miserables", "Musical", 2012));
        videoteca.add(new Film("El fantasma de la ópera", "Musical", 2004));
        videoteca.add(new Film("Cantando bajo la lluvia", "Musical", 1952));
        videoteca.add(new Film("Forrest Gump", "Comedia", 1994));
        videoteca.add(new Film("Star Wars: Episodio IV - Una nueva esperanza", "Ciencia ficción", 1977));
        videoteca.add(new Film("Star Wars: Episodio V - El Imperio contraataca", "Ciencia ficción", 1980));
        videoteca.add(new Film("Star Wars: Episodio VI - El regreso del Jedi", "Ciencia ficción", 1983));
        videoteca.add(new Film("Star Wars: Episodio I - La amenaza fantasma", "Ciencia ficción", 1999));
        videoteca.add(new Film("Star Wars: Episodio II - El ataque de los clones", "Ciencia ficción", 2002));
        videoteca.add(new Film("Star Wars: Episodio III - La venganza de los Sith", "Ciencia ficción", 2005));
        videoteca.add(new Film("Star Wars: Episodio VII - El despertar de la Fuerza", "Ciencia ficción", 2015));
        videoteca.add(new Film("Rogue One: Una historia de Star Wars", "Ciencia ficción", 2016));
        videoteca.add(new Film("Lo que el viento se llevó", "Épica", 1939));
        videoteca.add(new Film("Lawrence de Arabia", "Épica", 1962));
        videoteca.add(new Film("La lista de Schindler", "Épica", 1993));
        videoteca.add(new Film("El rey león", "Animación", 1994));
        videoteca.add(new Film("La bella y la bestia", "Animación", 1991));
        videoteca.add(new Film("Buscando a Nemo", "Animación", 2004));
        videoteca.add(new Film("Buscando a Nemo", "Dibujos", 2004));
        assertEquals(videoteca.toString(),
        "Mi videoteca:\n"+
        "1) Lo que el viento se llevó | Épica | 1939\n"+
        "2) Cantando bajo la lluvia | Musical | 1952\n"+
        "3) Lawrence de Arabia | Épica | 1962\n"+
        "4) Star Wars: Episodio IV - Una nueva esperanza | Ciencia ficción | 1977\n"+
        "5) Star Wars: Episodio V - El Imperio contraataca | Ciencia ficción | 1980\n"+
        "6) Star Wars: Episodio VI - El regreso del Jedi | Ciencia ficción | 1983\n"+
        "7) La bella y la bestia | Animación | 1991\n"+
        "8) La lista de Schindler | Épica | 1993\n"+
        "9) El rey león | Animación | 1994\n"+
        "10) Forrest Gump | Comedia | 1994\n"+
        "11) Star Wars: Episodio I - La amenaza fantasma | Ciencia ficción | 1999\n"+
        "12) Star Wars: Episodio II - El ataque de los clones | Ciencia ficción | 2002\n"+
        "13) Buscando a Nemo | Animación | 2004\n"+
        "14) El fantasma de la ópera | Musical | 2004\n"+
        "15) Star Wars: Episodio III - La venganza de los Sith | Ciencia ficción | 2005\n"+
        "16) Los miserables | Musical | 2012\n"+
        "17) Star Wars: Episodio VII - El despertar de la Fuerza | Ciencia ficción | 2015\n"+
        "18) Rogue One: Una historia de Star Wars | Ciencia ficción | 2016\n");
        //Cambio a orden 0
        videoteca.setOrder(0);
        assertEquals(videoteca.toString(),
        "Mi videoteca:\n"+
        "1) Buscando a Nemo | Animación | 2004\n"+
        "2) Cantando bajo la lluvia | Musical | 1952\n"+
        "3) El fantasma de la ópera | Musical | 2004\n"+
        "4) El rey león | Animación | 1994\n"+
        "5) Forrest Gump | Comedia | 1994\n"+
        "6) La bella y la bestia | Animación | 1991\n"+
        "7) La lista de Schindler | Épica | 1993\n"+
        "8) Lawrence de Arabia | Épica | 1962\n"+
        "9) Lo que el viento se llevó | Épica | 1939\n"+
        "10) Los miserables | Musical | 2012\n"+
        "11) Rogue One: Una historia de Star Wars | Ciencia ficción | 2016\n"+
        "12) Star Wars: Episodio I - La amenaza fantasma | Ciencia ficción | 1999\n"+
        "13) Star Wars: Episodio II - El ataque de los clones | Ciencia ficción | 2002\n"+
        "14) Star Wars: Episodio III - La venganza de los Sith | Ciencia ficción | 2005\n"+
        "15) Star Wars: Episodio IV - Una nueva esperanza | Ciencia ficción | 1977\n"+
        "16) Star Wars: Episodio V - El Imperio contraataca | Ciencia ficción | 1980\n"+
        "17) Star Wars: Episodio VI - El regreso del Jedi | Ciencia ficción | 1983\n"+
        "18) Star Wars: Episodio VII - El despertar de la Fuerza | Ciencia ficción | 2015\n");
        //Imprimir los generos
        ArrayList<String> array1 = new ArrayList<>();
        array1.add("Animación: 3");
        array1.add("Ciencia ficción: 8");
        array1.add("Comedia: 1");
        array1.add("Musical: 3");
        array1.add("Épica: 3");
        assertEquals(videoteca.getGenres(),array1);
    }
}
