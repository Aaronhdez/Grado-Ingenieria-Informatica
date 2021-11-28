/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.observer.Bidder;
import model.observer.Observer;
import model.subject.Product;
import model.subject.Subject;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        Subject productoSubasta = new Product("Silla", 0);
        Subject productoSubasta2 = new Product("Mesa", 0);
        Observer pujador1 = new Bidder("Manolo");
        Observer pujador2 = new Bidder("María");
        Observer pujador3 = new Bidder("Pepe");
        Observer pujador4 = new Bidder("Gemma");

        productoSubasta.registerObserver(pujador1);
        productoSubasta.registerObserver(pujador2);
        productoSubasta.registerObserver(pujador3);

        productoSubasta.setBidAmount(pujador1, 10);
        productoSubasta.notifyObservers();
        productoSubasta.setBidAmount(pujador1, 0);
        productoSubasta.setBidAmount(pujador2, 11);
        productoSubasta.setBidAmount(pujador3, 12);
        productoSubasta.removeObserver(pujador1);

        productoSubasta2.registerObserver(pujador2);
        productoSubasta2.registerObserver(pujador2);
        productoSubasta2.registerObserver(pujador4);
        
        
        
    }
}
