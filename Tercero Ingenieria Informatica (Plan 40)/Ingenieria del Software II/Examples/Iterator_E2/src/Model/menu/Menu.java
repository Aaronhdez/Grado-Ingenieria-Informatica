/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.menu;

import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public interface Menu {
    public void addItem(String name, String description, boolean vegetarian, double price);
    public Iterator createIterator();
}
