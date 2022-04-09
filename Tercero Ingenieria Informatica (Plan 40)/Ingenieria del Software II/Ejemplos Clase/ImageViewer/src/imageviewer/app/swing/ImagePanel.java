/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.app.swing;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class ImagePanel extends JPanel implements ImageDisplay {

    private Image image;
    private BufferedImage bitmap;
    private BufferedImage bitmap2;
    private int offset;
    private Shift shift;

    public ImagePanel() throws IOException {
        //this.image = ImageIO.read(new File("foto"));
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }
    
    @Override
    public void paint(Graphics g){
        //Box box = new Box(data.getWidth(), data.getHeight(), this.getWidth(), this.getHeight());
        //g.drawImage(data, box.x, box.y, box.width, box.height , null);
        if(bitmap != null) g.drawImage(bitmap,offset,0,null);
        if(bitmap2 != null && offset != 0) g.drawImage(bitmap2,offset < 0 ? bitmap.getWidth()+offset:offset-bitmap2.getWidth(),0,null);
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.bitmap = loadBitmap(image);
        repaint();
    }

    @Override
    public Image image() {
        return this.image;
    }

    private BufferedImage read(File name) {
        try {
            return ImageIO.read(name);
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }
    
    private static BufferedImage loadBitmap(Image image){
        try{
            return ImageIO.read(new File(image.getName()));
        } catch (IOException ioe) {
            return null;
        }
    }
    
    private Image imageAt(int shift){
        if(shift > 0) return this.shift.left();
        if(shift < 0) return this.shift.right();
        return null;
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener{

        private int initial;

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mousePressed(MouseEvent event) {
            this.initial = event.getX();
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            int shift = event.getX();
            if (Math.abs(shift) > getWidth()/2) { 
                image = imageAt(shift);
                bitmap = loadBitmap(image);
            }
            offset = 0;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent event) {
        }

        @Override
        public void mouseExited(MouseEvent event) {
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            int shift = shift(event.getX());
            if (shift == 0) bitmap2 = null;
            else if (ImagePanel.this.offset/shift < 0) bitmap2 = loadBitmap(imageAt(shift));
            ImagePanel.this.offset = shift;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent event) {
        }

        private int shift(int x) {
            return x-initial;
        }

        
    }
    
    /*
    private static class Box {
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        private Box(int imageWidth, int imageHeight, int panelWidth, int panelHeight) {
            double imageRatio = imageWidth/imageHeight;
            double panelRatio = panelWidth/panelHeight;
            this.width = (int) (imageRatio > panelRatio ? panelWidth : panelWidth*panelHeight/imageHeight);
            this.height = (int) (imageRatio <= panelRatio ? panelHeight : panelHeight*panelWidth/imageWidth);
            this.x = (int)((panelWidth - this.width) / 2);
            this.y = (int)((panelHeight - this.height) / 2);
        }
    }*/
    
    
    
}
