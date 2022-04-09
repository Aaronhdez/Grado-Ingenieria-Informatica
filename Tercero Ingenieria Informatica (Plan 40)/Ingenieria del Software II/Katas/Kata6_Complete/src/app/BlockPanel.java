/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import model.Block;
import view.BlockDisplay;

/**
 *
 * @author Usuario
 */
class BlockPanel extends JPanel implements BlockDisplay{
    
    private static final int SIZE = 100;
    private Block block;
    
    @Override 
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        int m = Block.MAX*SIZE;
        for (int i = 0; i <= 7; i++) {
            int d = i*100;
            g.drawLine(0, d, m, d);
            g.drawLine(d, 0, d, m);
        }
        
        if(block == null) return;
        g.setColor(Color.RED);
        g.fillRect((block.x()-1)*SIZE, (block.MAX - block.y())*SIZE, SIZE, SIZE);
        
    }

    @Override
    public void display(Block block) {
        this.block = block;
        this.repaint();
    }

    /** 
     * Como el BlockPanel implementa la interza observer, indicamos lo que ocurre
     * cuando se experiemnta algún cambio. De esta manera, sabemos que todos los 
     * BlockPanels generados actualizarán al mismo tiempo.
     */
    @Override
    public void changed() {
        this.repaint();
    }
    
}
