/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasosingleton;

import model.Sesion;
import model.User;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sesion sesion1 = Sesion.getInstance();
        User user1 = new User("Manolo", "12345");
        sesion1.setUser(user1);
        
        Sesion sesion2 = Sesion.getInstance();
        System.out.println("Sesion 2: " + sesion2.getUser().getName() + " "+ sesion2);
        Sesion sesion3 = Sesion.getInstance();
        System.out.println("Sesion 3: " + sesion3.getUser().getName() + " "+ sesion3);
        Sesion sesion4 = Sesion.getInstance();
        System.out.println("Sesion 4: " +sesion4.getUser().getName() + " "+ sesion4);
        
        System.out.println("Cambio de Usuario");
        User user2 = new User("Pepe", "12345");
        sesion1.setUser(user2);
        System.out.println("Sesion 2: " + sesion2.getUser().getName() + " "+ sesion2);
        System.out.println("Sesion 3: " +sesion3.getUser().getName() + " "+ sesion3);
        System.out.println("Sesion 4: " +sesion4.getUser().getName() + " "+ sesion4);
        
        
    }
    
}
