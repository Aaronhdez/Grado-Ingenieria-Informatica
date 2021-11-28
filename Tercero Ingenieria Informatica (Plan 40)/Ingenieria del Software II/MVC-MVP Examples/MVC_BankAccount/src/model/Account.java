/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Account {
    
    private ArrayList<Observer> observers;
    private final Money money;

    public Account() {
        this.observers = new ArrayList<>();
        this.money = new Money();
        this.money.setAmount(0);
    }
    
    public void deposit(float newAmount){
        this.money.addAmount(newAmount);
        this.changeStatus();
    } 
    
    public void extract(float newAmount){
        this.money.removeAmount(newAmount);
        this.changeStatus();
    }
    
    public float getCurrentPosition(){
        return this.money.getAmount();
    }
    
    public void registerObserver(Observer obs){
        this.observers.add(obs);
    }
    
    private void changeStatus(){
        for (Observer observer : observers) {
            observer.change();
        }
    }
    
    public static interface Observer{
        void change();
    }
}
