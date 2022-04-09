/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.helpers;

import es.ulpgc.gs1.app.fx.panels.EventsPanel;
import es.ulpgc.gs1.app.fx.panels.HostagePanel;
import es.ulpgc.gs1.app.fx.panels.MyEventsPanel;
import es.ulpgc.gs1.app.fx.panels.MyHostagesPanel;
import es.ulpgc.gs1.model.Alumno;
import es.ulpgc.gs1.model.Arrendador;
import es.ulpgc.gs1.model.Universidad;
import es.ulpgc.gs1.model.data.Session;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Usuario
 */
public class FXHelper {

    private static final String STRING_EMPTY = ""; 
    
    public static void updateUserFields(Session session, Component[] components) {
        if(session.getUserInstance() == null){
            updateDefault(session, components);
            return;
        }
        switch(session.getType()){
            case "student":
                updateAsStudent(session, components);
                break;
            case "uau":
                updateAsUniversity(session, components);
                break;            
            case "landlord":
                updateAsLandlord(session, components);
                break;    
            default:
                break;
        }
    }

    private static void updateDefault(Session session, Component[] components){
        ((JLabel) components[0]).setText("Nombre:");
        ((JLabel) components[1]).setText(session.getCurrentUserData().getUsername());
        ((JLabel) components[2]).setText("Email:");
        ((JLabel) components[3]).setText(session.getCurrentUserData().getMail());
        ((JLabel) components[4]).setText(STRING_EMPTY);
        ((JLabel) components[5]).setText(STRING_EMPTY);
        ((JLabel) components[6]).setText(STRING_EMPTY);
        ((JLabel) components[7]).setText(STRING_EMPTY);
        ((JLabel) components[8]).setText(STRING_EMPTY);
        ((JLabel) components[9]).setText(STRING_EMPTY);
    }
    
    private static void updateAsStudent(Session session, Component[] components) {
        Alumno student = (Alumno) session.getUserInstance();
        ((JLabel) components[0]).setText("Nombre:");
        ((JLabel) components[1]).setText(student.getUserData().getUsername());
        ((JLabel) components[2]).setText("Pasaporte:");
        ((JLabel) components[3]).setText(student.getPassport());
        ((JLabel) components[4]).setText("Email:");
        ((JLabel) components[5]).setText(student.getUserData().getMail());
        ((JLabel) components[6]).setText("Movilidad");
        ((JLabel) components[7]).setText(student.getMobility().getProgramName());
        ((JLabel) components[8]).setText("Status");
        if (student.isOnMobility()) {
            ((JLabel) components[9]).setText("Activa"); 
        } else {
            ((JLabel) components[9]).setText("Finalizada"); 
        }
    }
    
    private static void updateAsUniversity(Session session, Component[] components) {
        Universidad university = (Universidad) session.getUserInstance();
        ((JLabel) components[0]).setText("Nombre:");
        ((JLabel) components[1]).setText(university.getUserData().getUsername());
        ((JLabel) components[2]).setText("Email:");
        ((JLabel) components[3]).setText(university.getUserData().getMail());
        ((JLabel) components[4]).setText("Código Universidad");
        ((JLabel) components[5]).setText(university.getInternationalCode());
        ((JLabel) components[6]).setText("Status");
        if(university.isPublic()){
            ((JLabel) components[7]).setText("Pública");
        } else {
            ((JLabel) components[7]).setText("Privada");
        }
        ((JLabel) components[8]).setText(STRING_EMPTY);
        ((JLabel) components[9]).setText(STRING_EMPTY);
    }
        
    private static void updateAsLandlord(Session session, Component[] components) {
        Arrendador landlord = (Arrendador) session.getUserInstance();
        ((JLabel) components[0]).setText("Nombre:");
        ((JLabel) components[1]).setText(landlord.getUserData().getUsername());
        ((JLabel) components[2]).setText("Email");
        ((JLabel) components[3]).setText(landlord.getUserData().getMail());
        ((JLabel) components[4]).setText("NIF");
        ((JLabel) components[5]).setText(landlord.getCountry());
        ((JLabel) components[6]).setText(STRING_EMPTY);
        ((JLabel) components[7]).setText(STRING_EMPTY);
        ((JLabel) components[8]).setText(STRING_EMPTY);
        ((JLabel) components[9]).setText(STRING_EMPTY);
    }

    public static void showCompleteDataDialog(Session session, Component[] components) {
        switch(session.getType()){
            case "student":
                ((JDialog) components[0]).setVisible(true);
                break;        
            case "landlord":
                ((JDialog) components[1]).setVisible(true);
                break;     
            case "uau":
                ((JDialog) components[2]).setVisible(true);
                break;           
        }
    }

    public static void updateTabbedPanel(Session session, JTabbedPane tabbedPanel) {
        tabbedPanel.removeAll();
        if(session.getUserInstance() == null){
            return;
        }
        switch(session.getType()){
            case "student":
                setStudentTabs(session, tabbedPanel);
                break;
            case "uau":
                setUniversityTabs(session, tabbedPanel);
                break;            
            case "landlord":
                setLanlordTabs(session, tabbedPanel);
                break;    
            default:
                break;
        }    
    }

    private static void setStudentTabs(Session session, JTabbedPane tabbedPanel) {
        tabbedPanel.add("Eventos", new EventsPanel());
        tabbedPanel.add("Alojamientos", new HostagePanel(session));

    }

    private static void setUniversityTabs(Session session, JTabbedPane tabbedPanel) {
        tabbedPanel.add("Eventos", new EventsPanel());
        tabbedPanel.add("Mis eventos", new MyEventsPanel(session));
    }

    private static void setLanlordTabs(Session session, JTabbedPane tabbedPanel) {
        tabbedPanel.add("Alojamientos", new HostagePanel(session));
        tabbedPanel.add("Mis alojamientos", new MyHostagesPanel(session));
    }
    
}
