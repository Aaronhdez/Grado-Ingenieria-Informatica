/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app;

import es.ulpgc.diu.model.UtilsPractica5;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Canvas extends JPanel{
    private BufferedImage picture = null;
    private BufferedImage logo = null;
    private int xPositionLogo;
    private int yPositionLogo;
    
    public Canvas(){
        try {
            //https://images.hdqwalls.com/download/cute-cat-2-4k-1024x768.jpg
            logo = ImageIO.read(new File("src\\files\\logo.png"));            
            picture = ImageIO.read(new File("src\\files\\picture.jpg"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.xPositionLogo = this.picture.getWidth()-logo.getWidth();
        this.yPositionLogo = 0;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(picture.getHeight()>768||picture.getWidth()>1024){
            System.out.println("imagen muy grande");
            System.out.println(picture.getHeight());
            System.out.println(picture.getWidth());
            
        }else{
            g.drawImage(picture, 0, 0, null);            
            g.drawImage(logo, xPositionLogo, yPositionLogo, null);
        }
    }
    
    public Dimension getCurrentImageDimensions(){
        return new Dimension(this.picture.getWidth(), this.picture.getHeight());
    }
    
    public Dimension getCurrentLogoDimensions(){
        return new Dimension(this.logo.getWidth(), this.logo.getHeight());
    }
    
    public void setColor(boolean red, boolean green, boolean blue){
        reloadPicture();
        this.picture = UtilsPractica5.seleccionarComponentes(picture, red, green, blue);
        reloadCanvas();
    }

    public void redrawLogo(int x, int y){
        this.xPositionLogo = x;
        this.yPositionLogo = y;
        this.reloadCanvas();;
    };
    
    void reloadPicture() {
        try {
            this.picture = ImageIO.read(new File("src\\files\\picture.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        reloadCanvas();
    }

    private void reloadCanvas() {
        Graphics g = this.getGraphics();
        this.paintComponent(g);
    }
}
