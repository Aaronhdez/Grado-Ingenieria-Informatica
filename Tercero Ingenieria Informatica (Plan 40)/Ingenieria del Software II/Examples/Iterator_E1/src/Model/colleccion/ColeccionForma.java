/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.colleccion;

import Model.Forma;
import Model.iterator.FormaIterator;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class ColeccionForma implements Coleccion{

    private static int MAX_ITEMS = 2;
    private int numItems = 0;
    private Forma[] formas;

    public ColeccionForma() {
        this.formas = new Forma[MAX_ITEMS];
        addForma("1","Cuadrado");
        addForma("2","Triangulo");
    }
    
    public void addForma(String id, String name){
        Forma item = new Forma(id, name);
        if(numItems < formas.length) {
            formas[numItems] = item;
            numItems++;
        } 
    }
    
    public void imprimir(){
        Iterator selfIter = createIterator();
        Forma item = null;
        while(selfIter.hasNext()){
            item = (Forma) selfIter.next();
            System.out.println("Forma -> " + item.getId() + ": " + item.getName());
        }
    }
            
    @Override
    public Iterator createIterator() {
        return new FormaIterator(formas);
    }
    
}
