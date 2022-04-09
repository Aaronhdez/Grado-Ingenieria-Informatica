/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model.data;

import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.Alumno;
import es.ulpgc.gs1.model.Arrendador;
import es.ulpgc.gs1.model.Mobility;
import es.ulpgc.gs1.model.Universidad;
import es.ulpgc.gs1.model.UserData;
import es.ulpgc.gs1.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Session {
    private UserData currentUserData;
    private Usuario userInstance;

    public Session(UserData currentUserData) {
        this.currentUserData = currentUserData;
    }

    public Session() {
    }

    public UserData getCurrentUserData() {
        return currentUserData;
    }

    public void setCurrentUserData(UserData currentUserData) {
        this.currentUserData = currentUserData;
    }

    public String getUsername() {
        return (this.currentUserData == null) ? null : this.currentUserData.getUsername();
    }
    
    public String getType() {
        return (this.getCurrentUserData() == null) ? null: this.currentUserData.getType();
    }
    
    public String getDestino(){
        return (this.getCurrentUserData() == null) ? null: this.currentUserData.getCity();
    }

    public Usuario getUserInstance() {
        return userInstance;
    }
    
    public void setUserInstance(String type, UserData userData) {
        switch(userData.getType()){
            case "student":
                setAlumnoInstance(userData);
                break;
            case "landlord":
                setLandLordInstance(userData);
                break;
            case "uau":
                setUniversityInstance(userData);
                break;
            default:
                this.userInstance =  null;
                break;
        }
    }

    private void setLandLordInstance(UserData userData) {
        this.userInstance = new Arrendador(userData);
        ArrayList<Object> landlordData = SQLHelper.GetDataFromLandlord(userInstance.getUserData().getId());
        if(landlordData.isEmpty()){
            this.userInstance = null;
            return;
        } 
        ((Arrendador) this.userInstance).setCountry((String) landlordData.get(0));
        ((Arrendador) this.userInstance).setEmail((String) landlordData.get(0));
    }

    private void setAlumnoInstance(UserData userData) {
        this.userInstance = new Alumno(userData);
        ArrayList<Object> alumnoData = SQLHelper.GetDataFromStudent(userInstance.getUserData().getId());
        if(alumnoData.isEmpty()){
            this.userInstance = null;
            return;
        } 
        ((Alumno) this.userInstance).setPassport((String) alumnoData.get(0));
        ((Alumno) this.userInstance).setMobility(getMobilityData(alumnoData));
    }

    private Mobility getMobilityData(ArrayList<Object> alumnoData) {
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) alumnoData.get(1));
        } catch (ParseException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {  
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) alumnoData.get(2));
        } catch (ParseException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Mobility(startDate, endDate, "erasmus");
    }

    private void setUniversityInstance(UserData userData) {
        this.userInstance = new Universidad(userData);
        ArrayList<Object> universityData = SQLHelper.GetDataFromUniversity(userInstance.getUserData().getId());
        if(universityData.isEmpty()){
            this.userInstance = null;
            return;
        } 
        ((Universidad) this.userInstance).setInternationalCode((String) universityData.get(0));
        ((Universidad) this.userInstance).setStatus((Boolean) universityData.get(1));
    }
    
    
    
    
}
