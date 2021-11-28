/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MatrixFilter {
    private ArrayList<Observer> observers;
    private Matrix intMatrix;
    private String filteredMatrix;

    public MatrixFilter() {
        this.intMatrix = new Matrix();
        this.observers = new ArrayList();
        
    }
    
    /**
     * Methods
     */

    public void loadDefaultMatrix(){
        this.intMatrix.loadNewMatrix(0, 10);
        this.filterMatrix(0);
        this.notifyObservers();
    }
    
    public void reloadMatrix(int lower, int upper){
        this.intMatrix.loadNewMatrix(lower, upper);
        this.filterMatrix(lower);
        this.notifyObservers();
    }
    
    public void filterCurrentMatrix(int bound){
        this.filterMatrix(bound);
        this.notifyObservers();
    }
    
    public void filterMatrix(int bound){
        int[][] currentMatrix = this.intMatrix.getIntMatrix();
        this.filteredMatrix = new String();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(currentMatrix[i][j] < bound){
                    filteredMatrix += " - ";
                } else {
                    filteredMatrix += " " + currentMatrix[i][j]+" ";
                }
            }
            filteredMatrix += "\n";
        }
    }
    
    public String getFilteredMatrix(){
        return this.filteredMatrix;
    }
    
    /**
     * MVC functions
     */
    
    public void subscribe(Observer obs){
        this.observers.add(obs);
    }
    
    public void unsusbscribe(Observer obs){
        this.observers.remove(obs);
    }
    
    private void notifyObservers(){
        for (Observer observer : observers) {
            observer.change();
        }
    }
    
    public interface Observer{
        void change();
    }
    
}
