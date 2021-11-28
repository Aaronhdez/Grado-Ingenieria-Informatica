/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Ball;

/**
 *
 * @author Usuario
 */
public interface TrileroDisplay {
    void on(Touch touch);
    void reload(Ball ball);

    public void lock();
    public void unlock();

    interface Touch {
        void doAction(int i);
    }
}
