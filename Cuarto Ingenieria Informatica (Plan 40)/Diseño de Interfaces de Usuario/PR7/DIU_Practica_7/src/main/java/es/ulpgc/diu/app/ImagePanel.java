/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

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
        if( this.currentPicture != null ) {
            this.setPreferredSize(new Dimension(this.currentPicture.getWidth(), this.currentPicture.getHeight()));
        }
        super.paintComponent(g);
        if(currentPicture != null){
            g.drawImage(currentPicture, 0, 0, null);
        }
    }

    void reloadCanvas(File fileSelected) throws MalformedURLException, IOException {
        setPicture(fileSelected);
        Graphics g = this.getGraphics();  
        this.paintComponent(g);
    }

    private void setPicture(File fileSelected) throws IOException {
        picture = ImageIO.read(fileSelected);
        currentPicture = picture;
        this.currentPictureName = fileSelected.getName();
    }
    
    public BufferedImage getCurrentPicture(){
        return this.currentPicture;
    }
    
    public Mat BufferedImageToMat(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
    }
    
    public String getCurrentPictureName() {
        return currentPictureName.substring(0, currentPictureName.lastIndexOf("."));
    }

    public String getCurrentPictureFormat(){
        return currentPictureName.substring(currentPictureName.lastIndexOf("."));
    }

    public Mat getMat() throws IOException {    
        return this.BufferedImageToMat(this.currentPicture);
    }
    
    
}
