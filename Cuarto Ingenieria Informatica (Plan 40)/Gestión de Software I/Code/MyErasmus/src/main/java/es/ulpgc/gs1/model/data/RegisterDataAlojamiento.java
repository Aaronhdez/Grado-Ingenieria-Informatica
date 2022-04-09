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
public class RegisterDataAlojamiento {
    Session session;
    
    private int rooms;
    private String available_surface;
    private String duration;
    private int adv_id;
    private int landlord_id;

    public int getRooms() {
        return rooms;
    }

    public String getAvailable_surface() {
        return available_surface;
    }

    public String getDuration() {
        return duration;
    }

    public int getAdv_id() {
        return adv_id;
    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setAvailable_surface(String available_surface) {
        this.available_surface = available_surface;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAdv_id(int adv_id) {
        this.adv_id = adv_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
    }

    
}
