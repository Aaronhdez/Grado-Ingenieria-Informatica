/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Value {
    
    private int value;
    private String convertedValue;
    private ArrayList<Observer> observers;

    public Value() {
        this.convertedValue = "0";
        this.value = 0;
        this.observers = new ArrayList<>();
    }

    public void setValue(int value){
        this.value = value;
        this.convertedValue = value+"";
        this.changeStatus();
    }

    public int getValue() {
        return value;
    }
    
    public String getConvertedValue() {
        return convertedValue;
    }
    
    public void toBinary(){
        this.convertedValue = Integer.toBinaryString(this.value);
        this.changeStatus();
    }
    
    public void toOctal(){
        this.convertedValue = Integer.toOctalString(this.value);
        this.changeStatus();
    }
    
    public void toHex(){
        this.convertedValue = Integer.toHexString(this.value);
        this.changeStatus();
    }
    
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }
    
    private void changeStatus(){
        for (Observer observer : observers) {
            observer.change();
        }
    }
    
    public static interface Observer{
        public void change();
    }
}
