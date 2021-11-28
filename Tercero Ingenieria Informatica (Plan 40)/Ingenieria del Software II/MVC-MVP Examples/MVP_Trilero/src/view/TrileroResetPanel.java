/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Ball;

/**
 *
 * @author Usuario
 */
public class TrileroResetPanel extends JPanel implements TrileroDisplay {

    private Touch touch;
    private boolean lock;
    private JTextField txtField;
    private MouseHandler mouseHandler;

    public TrileroResetPanel() {
        this.lock = true;
        this.setLayout(new BorderLayout());
        this.createPanel();
    }

    private void createPanel() {
        this.mouseHandler = new MouseHandler();
        this.txtField = new JTextField("Reset");
        this.txtField.setHorizontalAlignment(SwingConstants.CENTER);
        this.txtField.setBackground(Color.GRAY);
        this.txtField.setEditable(false);
        this.add(this.txtField, BorderLayout.CENTER);
        this.txtField.addMouseListener(mouseHandler);
        this.addMouseListener(mouseHandler);
    }
    
    @Override
    public void on(Touch touch) {
        this.touch = touch;
    }

    @Override
    public void reload(Ball ball) {
        
    }

    @Override
    public void lock() {
        this.txtField.setBackground(Color.GRAY);
        this.lock = true;
    }

    @Override
    public void unlock() {
        this.txtField.setBackground(Color.YELLOW);
        this.lock = false;
    }
    
    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if(!lock){
                touch.doAction(3);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    
    }

    
}
