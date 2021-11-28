package model;

import java.util.ArrayList;
import java.util.Random;
import presenter.CompassPresenter;


public class CompassSample {
    private long timeStamp;
    private ArrayList<Observer> observers;
    private SamplePosition position;
    private boolean status;

    public CompassSample() {
        this.observers = new ArrayList();
        this.status = false;
    }
        
    private void getRandomPosition(){
        this.timeStamp = System.currentTimeMillis();
        Random random = new Random();
        SamplePosition[] vec = SamplePosition.values();
        this.position = vec[random.nextInt(vec.length-1)];
    }
        
    public SamplePosition getSample(){
        return this.position;
    }
    
    public void generateSample(){
        this.getRandomPosition();
        this.changeStatus();
    }
        
    public void register(CompassPresenter cd) {
        this.observers.add(cd);
    }
        
    private void changeStatus(){
        for (Observer observer : observers) {
            observer.change();
        }
    }

    public void setStatus() {
        this.status = !this.status;
    }
    
    public boolean getStatus() {
        return this.status;
    }
        
    public static interface Observer {
        public void change();
    }
}
