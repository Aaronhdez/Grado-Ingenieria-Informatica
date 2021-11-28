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
public class User {
    
    private String name;
    private String surname;
    private String nid;
    private String birthDate;

    public User(String name, String surname, String nid, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.nid = nid;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNid() {
        return nid;
    }

    public String getBirthDate() {
        return birthDate;
    }
    
    
    
}
