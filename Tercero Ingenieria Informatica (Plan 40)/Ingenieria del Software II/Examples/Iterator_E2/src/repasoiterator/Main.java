/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoiterator;

import Model.Camarero;
import Model.menu.McDonaldsMenu;
import Model.menu.Menu;
import Model.menu.StarBucksMenu;
import Model.menu.TelepizzaMenu;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Menu mcdMenu = new McDonaldsMenu();
        Menu tlpMenu = new TelepizzaMenu();
        Menu stbMenu = new StarBucksMenu();
        Camarero camarero = new Camarero(mcdMenu, tlpMenu, stbMenu);
        
        camarero.imprimeMenu();
    }
    
}
