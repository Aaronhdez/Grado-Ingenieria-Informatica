/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author santa
 */
public class ImagePanel extends JPanel {
    private BufferedImage picture;
    private BufferedImage currentPicture;
    private String currentPictureName;
    public ImagePanel() {
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(currentPicture != null){
            g.drawImage(currentPicture, 0, 0, null);
        }
    }

    void reloadCanvas(File fileSelected) throws MalformedURLException, IOException {
        Graphics g = this.getGraphics();  
        this.paintComponent(g);
    }

    public void setPicture(File fileSelected) throws IOException {
        picture = ImageIO.read(fileSelected);
        currentPicture = picture;
        this.currentPictureName = fileSelected.getName();
        this.repaint();
    }
    
    void setPicture(BufferedImage thresholdedPicture, String pictureName) {
        picture = thresholdedPicture;
        currentPicture = picture;
        this.currentPictureName = pictureName;
        this.repaint();
    }
    
    public BufferedImage getCurrentPicture(){
        return this.currentPicture;
    }
    
    public String getCurrentPictureName() {
        return currentPictureName.substring(0, currentPictureName.lastIndexOf("."));
    }

    public String getCurrentPictureFormat(){
        return currentPictureName.substring(currentPictureName.lastIndexOf("."));
    }
}
