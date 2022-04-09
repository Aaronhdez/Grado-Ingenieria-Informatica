/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Movie;

/**
 *
 * @author Usuario
 */
public interface MoviesLoader {
    ArrayList<Movie> load();
}
