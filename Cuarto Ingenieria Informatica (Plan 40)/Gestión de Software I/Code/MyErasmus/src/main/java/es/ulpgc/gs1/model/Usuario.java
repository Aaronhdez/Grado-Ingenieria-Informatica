/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class Usuario {
    
    private UserData userData;

    public Usuario(UserData userData) {
        this.userData = userData;
    }
    
    public UserData getUserData(){
        return this.userData;
    }
    
    @Override 
    public boolean equals(Object obj){
        if(obj instanceof Usuario){
            Usuario userToCompare = (Usuario) obj;
            return this.userData.getMail().equals(userToCompare.getUserData().getMail());
        }
        return false;
    }
}
