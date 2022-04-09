/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

/**
 *
 * @author carlo
 */
public class Arrendador extends Usuario {
    private String country;
    private String email;
    
    public Arrendador(UserData userData) {
        super(userData);
    }
    
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
