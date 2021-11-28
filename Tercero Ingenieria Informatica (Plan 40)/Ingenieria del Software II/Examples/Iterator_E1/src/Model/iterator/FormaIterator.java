/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.iterator;

import Model.Forma;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class FormaIterator implements Iterator {

    private Forma[] formas;
    private int position=0;

    public FormaIterator(Forma[] formas) {
        this.formas = formas;
    }
    
    @Override
    public boolean hasNext() {
        return (position < formas.length && formas[position] != null);
    }

    @Override
    public Object next() {
        Forma item = formas[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if (position > 0){
            if (formas[position-1] != null){
                for (int i = position-1; i < formas.length-1; i++) {
                    formas[i] = formas[i+1];
                }
            }
            formas[formas.length-1] = null;
        }
    }
    
}
