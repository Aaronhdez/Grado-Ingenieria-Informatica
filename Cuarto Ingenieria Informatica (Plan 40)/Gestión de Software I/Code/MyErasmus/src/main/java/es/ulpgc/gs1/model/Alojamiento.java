/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

/**
 *
 * @author Andres
 */
public class Alojamiento extends Anuncio {
    private final Arrendador arrendador;
    private final int rooms;
    private final String availableSurface;
    private String duration;

    public Alojamiento(String id, String title, String descrption, Arrendador arrendador, int rooms, String availableSurface, Lugar lugar) {
        super(id, title, descrption, lugar);
        this.arrendador = arrendador;
        this.rooms = rooms;
        this.availableSurface = availableSurface;
    }

    public Alojamiento(String id, String title, String descrption, Arrendador arrendador, int rooms, String availableSurface, String duration, Lugar lugar) {
        super(id, title, descrption, lugar);
        this.arrendador = arrendador;
        this.rooms = rooms;
        this.availableSurface = availableSurface;
        this.duration = duration;
    }

    public Arrendador getArrendador() {
        return arrendador;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration(){
        return this.duration;
    }

    /**
     * Gets the basic info from an alocation
     * @return 
     */
    public String getInfoAlojamiento(){
        String res = "";
        res += "Habitaciones: " + Integer.toString(rooms);
        res += " Superficie: " + availableSurface;
        res += " Duracion del contrato: " + duration;
        return res;
    }

    
}
