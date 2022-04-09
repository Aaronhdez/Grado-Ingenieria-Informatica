/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mock;

import model.MovieData;
import view.MoviesDisplay;

/**
 *
 * @author Usuario
 */
public class CurrentMovieMockPanel implements MoviesDisplay {

    private MovieData movieData;

    public CurrentMovieMockPanel() {
        this.execute();
    }
    
    private void execute() {
        //GraphicalAssets
    }  

    @Override
    public void display(MovieData movieData) {
        this.movieData = movieData;
    }

    @Override
    public void change() {
        System.out.println("Película Actual: " + this.movieData.getCurrentMovie().getTitle());
        System.out.println("--------------------------------------");
    }

    
}
