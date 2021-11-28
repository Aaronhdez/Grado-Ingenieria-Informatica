/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.menu;

import Model.MenuItem;
import Model.iterators.HamburguesasIterator;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase implementará su iterador LLAMANDO A LA INTERFAZ, de forma que
 * se puede recorrer todo su menu usando su iterador propio.
 */
public class McDonaldsMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public McDonaldsMenu() {
        this.menuItems = new ArrayList();
        addItem("Item_1", "desc_1", true, 1);
        addItem("Item_2", "desc_2", false, 1);
    }
    
    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.add(item);
    }
    
    /**
     * Retorna el objeto conjunto de los menus.
     */
    /*public ArrayList<MenuItem> getMenuItems(){
        return menuItems;
    }*/
    
    /**
     * Este método corresponde en el modelo a la implementación del iterador 
     * creado previamente
     */
    public Iterator createIterator(){
        //return new HamburguesasIterator(menuItems);
        return this.menuItems.iterator();
    }
}
