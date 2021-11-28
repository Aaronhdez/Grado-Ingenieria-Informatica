/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class Measure {

    private ArrayList<Observer> observers;
    private long count;
    private Timer timer;

    public Measure() {
        this.observers = new ArrayList();
        this.count = 0;
        this.timer = new Timer();
    }
    
    public long getCount(){
        return this.count;
    }
    
    public void start() {
        this.timer = new Timer();
        this.timer.schedule(task(), 0, 10);
    }
    
    public void stop(){
        this.timer.cancel();
    }
    
    public void reset(){
        this.count = 0;
        this.changeStatus();
    }
    
    private void increment() {
        this.count = count+15;
        this.changeStatus();
    }
    
    private void changeStatus(){
        for (Observer observer : observers) {
            observer.change();
        }
    }
    
    private TimerTask task(){
        return new TimerTask(){
            @Override
            public void run(){
                increment();
            }
        };
    }
    
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }
    
    public interface Observer{
        void change();
    }
}
