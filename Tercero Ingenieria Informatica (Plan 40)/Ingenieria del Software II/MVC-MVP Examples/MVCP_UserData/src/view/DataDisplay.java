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
public interface DataDisplay extends UsersData.Observer {
    void display(UsersData userData);
}
