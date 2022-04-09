/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class MovieData {
    
    private ArrayList<Movie> moviesList; 
    private ArrayList<Observer> observers;
    private Movie currentMovie;
    private int index;

    public MovieData(ArrayList<Movie> load) {
        this.observers = new ArrayList();
        this.moviesList = load;
        this.index = 0;
        this.currentMovie = this.moviesList.get(0);
    }
    
    public void add(Movie movie){
        this.moviesList.add(movie);
    }
    
    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }
    
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    //Ordenaciones
    private void sortByGenre() {
        this.moviesList.sort(new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Movie m1 = (Movie) t;
                Movie m2 = (Movie) t1;
                return m1.getGenre().compareTo(m2.getGenre());
            }
        });
    }

    private void sortByNewer() {
        this.moviesList.sort(new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Movie m1 = (Movie) t;
                Movie m2 = (Movie) t1;
                return -(Integer) m1.getYear().compareTo(m2.getYear());
            }
        });
    }
    
    private void sortByViews() {
        this.moviesList.sort(new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Movie m1 = (Movie) t;
                Movie m2 = (Movie) t1;
                return -((Integer) m1.getViews()).compareTo((Integer)m2.getViews());
            }
        });
    }
    
    private void sortByGrade() {
        this.moviesList.sort(new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                Movie m1 = (Movie) t;
                Movie m2 = (Movie) t1;
                return -((Float) m1.getGrade()).compareTo((Float) m2.getGrade());
            }
        });
    }
    
    //Commands
    public void reload(){
        this.changeStatus();
    }
    
    public void viewCurrentMovie() {
        System.out.println("Reproduciendo la película: "+this.currentMovie.getTitle());
        this.currentMovie.view();
        this.reload();
    }
    
    public void next(){
        if(this.index == this.moviesList.size()-1){
            this.index = 0;
        } else {
            this.index = this.index+1;
        }
        this.currentMovie = this.moviesList.get(index);
        this.changeStatus();
    }

    public void prev(){
        if(this.index == 0){
            this.index = this.moviesList.size()-1;
        } else {
            this.index = this.index-1;
        }
        this.currentMovie = this.moviesList.get(index);
        this.changeStatus();
    }
    
    public void autoSort(String field) {
        System.out.println("\n");
        switch(field){
            case "genre":
                this.sortByGenre();
                System.out.println("ORDEN: Género");
                break;
            case "newer":
                this.sortByNewer();
                System.out.println("ORDEN: Más nuevas");
                break;
            case "views":
                this.sortByViews();
                System.out.println("ORDEN: Más vistas");
                break;
            case "grade":
                this.sortByGrade();
                System.out.println("ORDEN: Calificación");
                break;
            default:
                break;
        }
        this.index = this.moviesList.indexOf(this.currentMovie);
        this.changeStatus();
    }

    //Others
    @Override
    public String toString() {
        String res="";
        for (Movie movie : moviesList) {
            res+="\n"+movie.toString();
        }
        return res;
    }
    
    //MVC
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }
 
    private void changeStatus(){
        for (Observer observer : this.observers) {
            observer.change();
        }
    }
    
    public static interface Observer{
        void change();
    }
    
}
