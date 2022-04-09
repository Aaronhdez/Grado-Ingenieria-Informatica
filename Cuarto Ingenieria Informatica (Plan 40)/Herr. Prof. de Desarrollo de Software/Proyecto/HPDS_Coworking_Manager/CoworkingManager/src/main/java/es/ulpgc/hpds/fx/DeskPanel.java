/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.hpds.fx;

import es.ulpgc.hpds.coworkingmanager.Desk;
import es.ulpgc.hpds.environment.actuator.Led;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class DeskPanel extends JPanel {
    private Desk deskAssociated;
    private Led ledAssociated;

    public DeskPanel(Desk deskAssociated) {
        this.deskAssociated = deskAssociated;
        this.setBackground(Color.GREEN);
    }

    public DeskPanel(Desk deskAssociated, Led ledAssociated) {
        this.deskAssociated = deskAssociated;
        this.ledAssociated = ledAssociated;
        this.setBackground(Color.GREEN);
        this.loadComponents();
    }

    public void reloadBackgroundColor(){
        this.setBackground(ledAssociated.getCurrentColor());
    }

    private void loadComponents() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(new JLabel(this.deskAssociated.getName()));
    }
}
