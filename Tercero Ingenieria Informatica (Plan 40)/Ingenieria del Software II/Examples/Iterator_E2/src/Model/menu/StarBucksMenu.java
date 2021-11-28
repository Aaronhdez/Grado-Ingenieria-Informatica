/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.menu;

import Model.MenuItem;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class StarBucksMenu implements Menu {
    private Hashtable<Integer, MenuItem> menuItems;
    private static int product = 0;

    public StarBucksMenu() {
        this.menuItems = new Hashtable();
        addItem("1", "desc_1", true, 30);
        addItem("2", "desc_2", true, 31);
    }
    
    @Override
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.put(product, item);
        product = product+1;
    }

    @Override
    public Iterator createIterator() {
        return this.menuItems.values().iterator();
    }
    
}
