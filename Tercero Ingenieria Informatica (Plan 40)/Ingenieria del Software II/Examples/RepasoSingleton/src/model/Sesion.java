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
public class Sesion {

    private User user;
    
    private Sesion() {
    }
    
    /**
     * Como el atributo static es final, se 
     */
    private static class SesionHelper {
        private static final Sesion INSTANCE = new Sesion();
    }
    
    public static Sesion getInstance(){
        return SesionHelper.INSTANCE;
    }
    
    public void setUser(User user){
        Sesion aux = getInstance();
        aux.user = user;
    }
    
    public User getUser(){
        return getInstance().user;
    }
    
}
