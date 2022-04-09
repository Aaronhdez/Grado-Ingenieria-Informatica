/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.persistence;

import es.ulpgc.gs1.model.UserData;

/**
 *
 * @author Usuario
 */
public interface LoginSystem {
    public boolean login(String username, String password);
    public void logout();
}
