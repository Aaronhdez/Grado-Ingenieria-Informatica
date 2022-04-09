/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Movie {
    private String title;
    private String year;
    private String genre;
    private String image;
    private String actors;
    private float grade;
    private int views;

    public Movie(String title, String year, String genre, String image, String actors, int views) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.image = image;
        this.actors = actors;
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getImage() {
        return image;
    }

    public String getActors() {
        return actors;
    }

    public float getGrade() {
        return grade;
    }

    public int getViews() {
        return views;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void view() {
        this.views += 1;
    }
    
    @Override
    public String toString() {
        return this.getTitle() +" | "+ this.getYear() +" | "+ this.getGenre() 
                +" | "+ this.getImage() +" | "+ this.getActors() 
                + " | " + this.views + " Visualizaciones" + " | "+this.grade;
    }
    
    
}
