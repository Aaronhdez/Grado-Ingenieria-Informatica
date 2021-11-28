/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.colleccion;

import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public interface Coleccion {
    public Iterator createIterator();
    public void imprimir();
}
