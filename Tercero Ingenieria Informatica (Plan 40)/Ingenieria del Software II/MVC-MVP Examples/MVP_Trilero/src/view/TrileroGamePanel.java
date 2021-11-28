/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import model.Ball;

/**
 *
 * @author Usuario
 */
public class TrileroGamePanel extends JPanel implements TrileroDisplay {

    private Touch touch;    
    private MouseHandler mouseHandler;
    private JTextPane lastSelected;
    
    private JTextPane txtPane1;
    private JTextPane txtPane2;
    private JTextPane txtPane3;
    private JTextField txtField;
    private boolean lock;
    
    public TrileroGamePanel() {
        this.execute();
    }
    
    private void execute() {
        this.setLayout(new BorderLayout());
        this.createAreas();
        this.createField();
    }

    private void createAreas() {
        this.mouseHandler = new MouseHandler();
        JPanel centerPanel = new JPanel(new GridLayout(1,3));
        this.txtPane1 = new JTextPane();
        this.txtPane2 = new JTextPane();
        this.txtPane3 = new JTextPane();
        this.txtPane1.setText("1");
        this.txtPane3.setText("3");
        this.txtPane1.setEditable(false);
        this.txtPane1.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.txtPane1.setFont(new Font("SansSerif", Font.BOLD, 90));
        this.txtPane1.setAlignmentX(SwingConstants.CENTER);
        this.txtPane2.setEditable(false);
        this.txtPane2.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.txtPane2.setFont(new Font("SansSerif", Font.BOLD, 90));
        this.txtPane2.setAlignmentX(SwingConstants.CENTER);
        this.txtPane2.setText("2");
        this.txtPane3.setEditable(false);
        this.txtPane3.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.txtPane3.setFont(new Font("SansSerif", Font.BOLD, 90));
        this.txtPane3.setAlignmentX(SwingConstants.CENTER);
        this.txtPane1.addMouseListener(mouseHandler);
        this.txtPane2.addMouseListener(mouseHandler);
        this.txtPane3.addMouseListener(mouseHandler);
        centerPanel.add(this.txtPane1);
        centerPanel.add(this.txtPane2);
        centerPanel.add(this.txtPane3);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void createField() {
        this.txtField = new JTextField("Choose wisely...");
        this.txtField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(txtField, BorderLayout.SOUTH);
    }

    @Override
    public void on(Touch touch) {
        this.touch = touch;
    }

    @Override
    public void reload(Ball ball) {
        if(ball.getPosition() == Integer.parseInt(this.lastSelected.getText())){
            lastSelected.setBackground(Color.GREEN);
            this.txtField.setText("¡You win!");
        } else {
            lastSelected.setBackground(Color.RED);
            this.txtField.setText("You lose...");
        }
    }

    @Override
    public void lock() {
        this.lock = true;
    }

    @Override
    public void unlock() {
        this.txtField.setText("Choose wisely...");
        this.txtPane1.setBackground(Color.WHITE);
        this.txtPane2.setBackground(Color.WHITE);
        this.txtPane3.setBackground(Color.WHITE);
        this.lock = false;
    }
    
    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            Component component = me.getComponent();
            if(component instanceof JTextPane){
                if(!lock){
                    lastSelected = (JTextPane) component;
                    touch.doAction(Integer.parseInt(((JTextPane) component).getText()));
                }
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
