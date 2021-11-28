/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import control.TrileroPresenter;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import view.TrileroDisplay;
import view.TrileroGamePanel;
import view.TrileroResetPanel;

/**
 *
 * @author Usuario
 */
public class Trilero_MVP extends JFrame {

    private TrileroDisplay trileroGamePanel;
    private TrileroDisplay trileroResetPanel;
    private TrileroPresenter trileroPresenter;
    
    public static void main(String[] args) {
        new Trilero_MVP();
    }

    public Trilero_MVP() {
        this.execute();
    }

    private void execute() {
        this.trileroGamePanel = new TrileroGamePanel();
        this.trileroResetPanel = new TrileroResetPanel();
        this.trileroPresenter = new TrileroPresenter(this.trileroGamePanel, this.trileroResetPanel);
        
        this.setTitle("Trilero MVP");
        this.setLayout(new BorderLayout());
        this.add((Component) this.trileroGamePanel, BorderLayout.CENTER);
        this.add((Component) this.trileroResetPanel, BorderLayout.SOUTH);
        this.setSize(250,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
}
