/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model.data;

/**
 *
 * @author Usuario
 */
public class RegisterDataAdv {
    private String title;
    private String description;
    private String street;
    private String destinarion;
    private int price;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStreet() {
        return street;
    }

    public String getDestinarion() {
        return destinarion;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDestinarion(String destinarion) {
        this.destinarion = destinarion;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
