/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactoryexample;

/**
 *
 * @author Usuario
 */

/* La clase habitación se extiende de la clase padre compartimento */
public class Room extends Compartment{
    private final int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    
}
