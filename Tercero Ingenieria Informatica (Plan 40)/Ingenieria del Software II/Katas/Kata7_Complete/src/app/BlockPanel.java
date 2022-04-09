/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import model.Block;
import view.BlockDisplay;

/**
 *
 * @author Usuario
 */
class BlockPanel extends JPanel implements BlockDisplay{
    private final MouseHandler handler;
    private final int max;
    private Moved moved;

    public BlockPanel(int max) {
        this.handler = new MouseHandler();
        this.max = max;
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }
    private int x, y;

    @Override
    public void paintBlock(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }
    
    @Override 
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        int m = Block.MAX*SIZE;
        for (int i = 0; i <= max; i++) {
            int d = i*SIZE;
            g.drawLine(0, d, m, d);
            g.drawLine(d, 0, d, m);
        }
        
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE);
   
    }

    @Override
    public void on(Moved moved) {
        this.moved = moved;
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener {

        private boolean grabbed;

        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if((me.getX() < x) || me.getX() > x+ BlockDisplay.SIZE) return;
            if((me.getX() < y) || me.getX() > y+ BlockDisplay.SIZE) return;
            grabbed = true;
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            grabbed = false;
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            moved.to(me.getX(), me.getY());
        }

        @Override
        public void mouseMoved(MouseEvent me) {
        }
    
        
        
    }
    
}
