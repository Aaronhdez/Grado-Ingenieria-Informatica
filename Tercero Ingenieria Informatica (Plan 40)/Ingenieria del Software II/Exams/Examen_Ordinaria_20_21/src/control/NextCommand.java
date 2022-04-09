/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.MovieData;

/**
 *
 * @author Usuario
 */
public class NextCommand implements Command {

    private final MovieData moviesList;

    public NextCommand(MovieData moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public void execute() {
        this.moviesList.next();
    }
    
}
