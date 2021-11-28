/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Trail {
    
    private ArrayList<Point> coordinatesCollection;
    private ArrayList<TrailObserver> observers;

    public Trail() {
        this.coordinatesCollection = new ArrayList<>();
        this.observers = new ArrayList();
    }

    public void reload() {
        this.coordinatesCollection = new ArrayList<>();
    }
    
    public void addNewPoint(int x, int y){
        this.coordinatesCollection.add(new Point(x,y));
    }

    public ArrayList<Point> getCoordinatesCollection() {
        return coordinatesCollection;
    }
    
    public Point lastRegisteredPoint(){
        return this.coordinatesCollection.get(this.coordinatesCollection.size()-1);
    }
    
    public void subscribeTrailObserver(TrailObserver obs){
        this.observers.add(obs);
    }

    public void unSubscribeTrailObserver(TrailObserver obs){
        this.observers.add(obs);
    }
    
    private void notifyTrailObserver(){
        for (TrailObserver trailObserver : observers) {
            trailObserver.change();
        }
    }
    
    public interface TrailObserver{
        void change();
    }
    
}
