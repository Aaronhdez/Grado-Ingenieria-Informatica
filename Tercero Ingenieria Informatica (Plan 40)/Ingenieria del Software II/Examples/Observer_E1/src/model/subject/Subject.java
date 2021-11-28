/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.subject;

import model.observer.Observer;

/**
 *
 * @author Usuario
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void setBidAmount(Observer obs, int newBidAmount);
}
