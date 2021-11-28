/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.UsersData;

/**
 *
 * @author Usuario
 */
public interface DataListDisplay {
    void on(Touch touch);
    public void reload(UsersData usersData);
    
    public interface Touch {
        void setCurrent(int i);
        //void doAction();
        //void doAction2();
    }
}
