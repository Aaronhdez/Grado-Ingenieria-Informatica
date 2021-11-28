/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import model.SamplePosition;

/**
 *
 * @author Usuario
 */
public class CompassPanel extends JPanel implements CompassDisplay {

    private final MouseHandler mouseHandler;
    private Touch touch;
    private JTextPane txt;
     
    public CompassPanel() {
        this.mouseHandler = new MouseHandler();
        this.initialize();
    }
    
    public void initialize() {
        this.txt = new JTextPane();
        this.txt.setText("--");
        this.txt.setEditable(false);
        this.txt.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.txt.setFont(new Font("SansSerif", Font.BOLD, 90));
        this.txt.addMouseListener(mouseHandler);
        this.addMouseListener(mouseHandler);
        this.add(this.txt);
        this.setBackground(Color.WHITE);
    }
    
    @Override
    public void on(Touch touch) {
        this.touch = touch;
    }

    @Override
    public void reload(SamplePosition sample) {
        this.txt.setText(sample+"");
    }
    
    private class MouseHandler implements MouseListener {

        public MouseHandler() {
        }

        @Override
        public void mouseClicked(MouseEvent me){
            //se ha de generar una nueva coordenada
            touch.newCoordinate();
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
