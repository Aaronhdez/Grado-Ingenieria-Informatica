/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.iterators;

import Model.MenuItem;
import java.util.Iterator;

/**
 * Esta clase implementará la interfaz iterator, permitiendole ser un subtipo de 
 * la propia interfaz, pudiendo con ello ser invocada desde el menú correspondiente
 */
public class PizzasIterator implements Iterator{
    MenuItem[] items;
    int position = 0;

    public PizzasIterator(MenuItem[] items) {
        this.items = items;
    }
    
    /**
     *  Métodos implementados de la interfaz 
     */
    
    /**
     * Verifica que existe o no un elemento siguiente revisando el AL
     */
    @Override
    public boolean hasNext() {
        if (items.length < position || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Devuelve el siguiente elemento de la lista empleando el método 
     * correspondiente en el AL
     */
    @Override
    public Object next() {
        MenuItem item = items[position];
        position=position+1;
        return item;
    }
}
