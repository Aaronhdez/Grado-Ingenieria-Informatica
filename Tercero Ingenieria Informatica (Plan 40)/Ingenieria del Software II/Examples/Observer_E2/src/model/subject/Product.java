/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.subject;

import java.util.ArrayList;
import java.util.List;
import model.observer.Observer;

/**
 *
 * @author Usuario
 */
public class Product implements Subject {

    private final String name;
    private int amount;
    private Observer observer;
    private final List<Observer> bidders;

    public Product(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.bidders = new ArrayList<Observer>();
    }

    public List<Observer> currentObservers(){
        return this.bidders;
    }
    
    /**
     * Los métodos register y remove habilitan a los observadores a ser 
     * o no actualizados ante cambios en el sistema.
     * 
     * Notify ejecuta la acción de notificar llamando al update() de cada 
     * observador
     */
    @Override
    public void registerObserver(Observer o) {
        System.out.println(o + " se ha unido a la subasta");
        this.bidders.add(o);
        System.out.println("");
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println(o + " se ha retirado de la subasta");
        this.bidders.add(o);
        System.out.println("");
    }

    @Override
    public void notifyObservers() {
        System.out.println("Nueva Puja para el objeto: " + this.name);
        System.out.println("----------------");
        for (Observer bidder : bidders) {
            bidder.update(observer, name, amount);
        }
        System.out.println("");
    }

    /**
     * Est método registra la interacción con los observadores que están 
     * registrados en el producto. Si el cambio es aceptado, entonces se 
     * produce una notificación general a todos los usuarios.
     */
    @Override
    public void setBidAmount(Observer obs, int newBidAmount) {
        if(((Integer) this.amount).compareTo(newBidAmount)== -1) {
            this.observer=obs;
            this.amount=newBidAmount;
            notifyObservers();
        } else {
            System.out.println("\n" + observer+ ", la nueva oferta " + 
                            "(" + newBidAmount+ "€)" + 
                            " no puede ser menor o igual que "+ 
                            "la oferta actual"+ 
                            " (" + this.amount+ "€)");
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", amount=" + amount + ", observer=" + observer + ", bidders=" + bidders + '}';
    }
    
    
    
}
