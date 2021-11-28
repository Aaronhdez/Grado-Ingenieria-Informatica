/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.observer;

import model.subject.Subject;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Bidder implements Observer {

    private final String name;

    public Bidder(String name) {
        this.name = name;
    }
    
    @Override
    public void update(Observer obs, String name, int bidAmount) {
        if((obs.toString()).compareTo(this.name) == 0){
            System.out.println("Tu oferta ha sido aceptada, " + this.name 
                                + ". Ahora el objeto " + name + " vale " + bidAmount 
                                + "€");
        } else {
            System.out.println(this.name + ": la subasta ha cambiado, " +
                                "ahora el objeto " + name + " vale " + + bidAmount 
                                + "€. La oferta ha sido efectuada por " 
                                + obs.toString());            
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    

    
}
