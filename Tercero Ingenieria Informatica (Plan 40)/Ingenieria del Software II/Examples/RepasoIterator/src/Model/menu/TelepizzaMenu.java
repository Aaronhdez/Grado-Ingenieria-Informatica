/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.menu;

import Model.MenuItem;
import Model.iterators.PizzasIterator;
import java.util.Iterator;

/**
 * Esta clase implementará su iterador LLAMANDO A LA INTERFAZ, de forma que
 * se puede recorrer todo su menu usando su iterador propio.
 */
public class TelepizzaMenu implements Menu{
    static final int MAX_ITEMS = 2;
    int numberOfItems=0;
    MenuItem[] menuItems;

    public TelepizzaMenu() {
        this.menuItems = new MenuItem[MAX_ITEMS];
        addItem("Item_1_p", "desc_1_p", true, 1);
        addItem("Item_2_p", "desc_2_p", false, 1);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS) {
            System.err.println("MENÚ LLENO");
        } else{
            menuItems[numberOfItems] = item;
            numberOfItems++;
        }
    }
    
    // NO NECESARIO
    /*
    public MenuItem[] getMenuItems(){
        return menuItems;
    }*/
        
    /**
     * Este método corresponde en el modelo a la implementación del iterador 
     * creado previamente
     */
    public Iterator createIterator(){
        return new PizzasIterator(menuItems);
    }
    
}
