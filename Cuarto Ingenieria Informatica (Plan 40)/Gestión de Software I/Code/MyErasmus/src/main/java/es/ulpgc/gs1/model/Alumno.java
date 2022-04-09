/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

import es.ulpgc.gs1.helpers.FormatsHelper;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Alumno extends Usuario {

    private Mobility mobility;
    private String passport;
    
    public Alumno(UserData userData){
        super(userData);
        this.passport = "";
        this.mobility = null;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public boolean passportIsOnCorrectFormat() {
        return FormatsHelper.checkPassportFormat(this.passport.toLowerCase());
    }
    
    public boolean isOnMobility() {
        return this.mobility.mobilityIsActive();
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility(Mobility mobility) {
        this.mobility = mobility;
    }

    public boolean mobiltyProgramIsValid() {
        return this.mobility.checkProgram();
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
