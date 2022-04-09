/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mock;

import control.Command;
import control.ExitCommand;
import control.NextCommand;
import control.NullCommand;
import control.PrevCommand;
import control.ReloadCommand;
import control.SortGenreCommand;
import control.SortGradeCommand;
import control.SortNewerCommand;
import control.SortViewCommand;
import control.ViewCommand;
import java.util.HashMap;
import java.util.Scanner;
import model.MovieData;
import view.MoviesDisplay;

/**
 *
 * @author Usuario
 */
public class MovieMockFrame {

    private MoviesDisplay movieMockPanel;
    private MoviesDisplay currentMovieMockPanel;
    private MovieData moviesList;
    private HashMap<String,Command> commands;
    private MoviesMockLoader moviesMockLoader;
    
    public MovieMockFrame() {
        this.execute();
    }

    private void execute() {
        this.currentMovieMockPanel = new CurrentMovieMockPanel();
        this.movieMockPanel = new MovieMockPanel();
        this.moviesMockLoader = new MoviesMockLoader();
        this.moviesList = new MovieData(this.moviesMockLoader.load());
        this.initLogic();
        this.start();
    }

    private void start() {
        this.commands.get("show").execute();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            this.commands.getOrDefault(scanner.next(), NullCommand.Instance).execute();
        }
    }

    private void initLogic() {
        this.moviesList.registerObservers(currentMovieMockPanel);
        this.currentMovieMockPanel.display(moviesList);
        this.moviesList.registerObservers(movieMockPanel);
        this.movieMockPanel.display(moviesList);
        this.createComands();
    }

    private void createComands() {
        this.commands = new HashMap();
        this.commands.put("show", new ReloadCommand(this.moviesList));
        this.commands.put("next", new NextCommand(this.moviesList));
        this.commands.put("prev", new PrevCommand(this.moviesList));
        this.commands.put("by_genre", new SortGenreCommand(this.moviesList));
        this.commands.put("by_grade", new SortGradeCommand(this.moviesList));
        this.commands.put("by_newer", new SortNewerCommand(this.moviesList));
        this.commands.put("by_views", new SortViewCommand(this.moviesList));
        this.commands.put("play", new ViewCommand(this.moviesList));
        this.commands.put("q", new ExitCommand());
    }
    
}
