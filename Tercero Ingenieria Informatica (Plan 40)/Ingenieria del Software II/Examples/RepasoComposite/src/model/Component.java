/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public interface Component {
    default void add(Component c) {};
    default void remove(Component c) {};
    default Component getChild(int i) {
        return null;
    };
    void operation();
}
