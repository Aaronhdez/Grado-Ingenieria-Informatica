/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Ball {
    
    private int position;
    private ArrayList<Observer> observers;
    private boolean check;

    public Ball() {
        this.randomize();
        this.observers = new ArrayList<>();
    }
    
    public int getPosition(){
        return this.position;
    }

    public void shuffle(int i){
        this.randomize();
        //changeStatus();
    }

    public boolean isCheck() {
        return check;
    }
    
    private void randomize() {
        Random rng = new Random();
        this.position = rng.nextInt(3)+1;
    }
    
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }    
    
    private void changeStatus(){
        for (Observer observer : observers) {
            observer.changed();
        }
    }

    public void checkPosition(int i) {
        if(this.position == i){
            this.check = true;
        } else {
            this.check = false;
        }
        this.changeStatus();
    }
    
    public static interface Observer{
        void changed();
    }
}
