/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Value;

/**
 *
 * @author Usuario
 */
public interface ValueDisplay extends Value.Observer {
    void display(Value value);
    void on(Touch touch);
    void reload();
    interface Touch {
        void doAction();
    }
}
