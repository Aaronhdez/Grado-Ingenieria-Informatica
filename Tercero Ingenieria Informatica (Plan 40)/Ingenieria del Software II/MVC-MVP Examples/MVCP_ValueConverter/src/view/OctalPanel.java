/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Value;

/**
 *
 * @author Usuario
 */
public class OctalPanel extends JPanel implements ValueDisplay  {

    private Touch touch;
    private MouseHandler handler;

    public OctalPanel() {
        this.execute();
    }
    
    private void execute() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Octal"));
        this.handler = new MouseHandler();
        this.addMouseListener(this.handler);
    }
    
    @Override
    public void display(Value value) {
    }

    @Override
    public void on(Touch touch) {
        this.touch = touch;
    }

    @Override
    public void reload() {
    }

    @Override
    public void change() {
    }

    private class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            touch.doAction();
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
