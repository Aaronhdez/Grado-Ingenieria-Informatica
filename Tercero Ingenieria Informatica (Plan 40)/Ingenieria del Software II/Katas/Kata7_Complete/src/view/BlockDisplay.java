/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Block;

/**
 *
 * @author Usuario
 */
public interface BlockDisplay{
    public static final int SIZE = 100;
    void paintBlock(int x, int y);
    void on(Moved moved);
    
    public interface Moved {
        void to(int x, int y);
    }
    
}
