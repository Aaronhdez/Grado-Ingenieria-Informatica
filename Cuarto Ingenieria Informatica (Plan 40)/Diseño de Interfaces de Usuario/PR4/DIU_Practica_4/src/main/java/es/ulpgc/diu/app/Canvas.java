/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app;

import es.ulpgc.diu.model.Trail;
import es.ulpgc.diu.view.TrailDisplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Canvas extends JPanel implements TrailDisplay {
    
    private Trail observedTrail;
    private Graphics graphics;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public double euclideanLength(int x, int y){
        Point lastRegisteredPoint = this.observedTrail.lastRegisteredPoint();
        int xAxis =  x - (int)lastRegisteredPoint.getX();
        int yAxis =  y - (int)lastRegisteredPoint.getY();
        return Math.sqrt((yAxis*yAxis)+(xAxis*xAxis));
    }

    boolean isEmpty() {
        return this.observedTrail.getCoordinatesCollection().isEmpty();
    }
    
    public void setColors(Color background, Color foreground) {
        this.setBackground(background);
        this.setForeground(foreground);
    }

    public void drawPointsStream() {
        ArrayList<Point> pointsCollection = getPointsToDisplay();
        for (Point point : pointsCollection) {
            this.drawPointOnCoordinates((int) point.getX(), (int) point.getY());
            try {
                Thread.sleep(8);
            } catch (InterruptedException ex) {
                Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private ArrayList<Point> getPointsToDisplay() {
        ArrayList<Point> result = this.observedTrail.getCoordinatesCollection();
        Collections.reverse(result);
        return (result.size() > 5) ? new ArrayList<Point>(result.subList(0,4)) : result;
    }
    
    public void drawPointOnCoordinates(int x, int y){
        this.getGraphics().fillOval(x, y, 10, 10);
    }
    
    @Override
    public void change() {
        //drawPointsStream();
    }
     //dummy
    @Override
    public void display(Trail trail) {
        this.observedTrail = trail;
    }

    void reloadTrail() {
        this.observedTrail.reload();
    }

}
