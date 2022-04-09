/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mock;

import java.util.ArrayList;
import java.util.Random;
import model.Movie;
import view.MoviesLoader;

/**
 *
 * @author Usuario
 */
public class MoviesMockLoader implements MoviesLoader{

    @Override
    public ArrayList<Movie> load() {
        ArrayList<Movie> res = new ArrayList();
        res.add(new Movie("Silecio de Los Corderos","1999", "Terror", "Imagen1","Actores",3));
        res.add(new Movie("Hannibal Lecter","1992","Terror", "Imagen2","Actores2",2));
        res.add(new Movie("La Roca","1992","Acción","Imagen3","Actores3",4));
        res.add(new Movie("Lo que el Viento se llevó","1995","Drama","Imagen3","Actores3",27));
        res.add(new Movie("Invictus","1995","Drama","Imagen3","Actores3",18));
        res.add(new Movie("Gol II","2003","Deporte","Imagen3","Actores3",12));
        res.add(new Movie("Star Wars: Una nueva Esperanza","1977","Drama","Imagen3","Actores7",7));
        Random rng = new Random();
        for (Movie re : res) {
            re.setGrade((float) rng.nextInt(10));
        }
        return res;
    }
    
}
