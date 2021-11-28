/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer_e2;

import model.observer.Bidder;
import model.observer.Observer;
import model.subject.Product;

/**
 *
 * @author Usuario
 */
public class Observer_E2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product productoSubasta = new Product("Silla", 1);
        Observer pujador1 = new Bidder("Manolo");
        Observer pujador2 = new Bidder("María");
        Observer pujador3 = new Bidder("Pepe");
        Observer pujador4 = new Bidder("Gemma");

        productoSubasta.registerObserver(pujador1);
        productoSubasta.registerObserver(pujador2);
        productoSubasta.registerObserver(pujador3);
        BidFrame bf = new BidFrame(productoSubasta);
        bf.execute();
    }
    
}
