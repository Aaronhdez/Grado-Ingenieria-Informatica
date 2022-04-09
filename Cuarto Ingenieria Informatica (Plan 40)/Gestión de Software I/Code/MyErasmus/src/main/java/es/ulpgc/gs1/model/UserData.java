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
public class UserData {

    private String id;

    private String password;
    private String city;
    private String username;
    private String mail;
    private ArrayList<String> concreteData;
    private String type;

    
    public UserData(String username, String mail, String password, String city, String type) {
        this.password = password;
        this.city = city;
        this.username = username;
        this.mail = mail;
        this.type = type;
        this.concreteData = new ArrayList<>();
    }

    public UserData(String[] dataToArrayFormat) {
        this.username = dataToArrayFormat[0];
        this.mail = dataToArrayFormat[1];
        this.password = dataToArrayFormat[2];
        this.city = dataToArrayFormat[3];
        this.type = dataToArrayFormat[4];
        this.concreteData = new ArrayList<>();
    }

    public UserData() {
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setConcreteData(ArrayList<String> concreteData){
        this.concreteData = concreteData;
    }

    public ArrayList<String> getConcreteData() {
        return concreteData;
    }

    public String[] getDataAsString(){
        return new String[] { this.username,this.mail,this.password,this.city }; 
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
