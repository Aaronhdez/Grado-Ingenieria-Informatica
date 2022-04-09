/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

import java.util.Objects;

/**
 *
 * @author Andres
 */
public abstract class Anuncio {
    private final String id;
    private String title;
    private String descrption;
    
    private final Lugar advLocation;

    public Anuncio(String id, String title, String descrption, Lugar lugar) {
        this.id = id;
        this.title = title;
        this.descrption = descrption;
        this.advLocation = lugar;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrption() {
        return descrption;
    }

    public Lugar getAdvLocation() {
        return advLocation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    /**
     * Compare if two adv are equals by their title
     * @param obj of type adv
     * @return true: if they are the same; false in other case
     */
    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Anuncio ){
            Anuncio anuncioToCompare = (Anuncio) obj;
            return this.getTitle().equals(anuncioToCompare.getTitle());
        }
        return false;
    }
}
