/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.observer;

/**
 * El subject implementa las funciones de obsservacion que se aplicaran
 * sobre los obsevers
 */
public interface Observer {
    void update(Observer obs, String name, int bidAmount);
}
