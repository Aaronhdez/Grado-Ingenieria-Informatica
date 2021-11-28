/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoiterator;

import Model.Camarero;
import Model.menu.McDonaldsMenu;
import Model.menu.TelepizzaMenu;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        McDonaldsMenu mcdMenu = new McDonaldsMenu();
        TelepizzaMenu tlpMenu = new TelepizzaMenu();
        Camarero camarero = new Camarero(mcdMenu, tlpMenu);
        
        camarero.imprimeMenu();
    }
    
}
