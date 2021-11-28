/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Matrix {
    private Random rndSeed;
    private int[][] intMatrix;
    private int minimum;
    private int maximum;
    
    public Matrix() {
        this.rndSeed = new Random();
    }

    public void loadNewMatrix(int lower, int upper){
        this.intMatrix = new int[10][10];
        this.minimum = lower;
        this.maximum = upper;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.intMatrix[i][j] = this.rndSeed.nextInt(upper + 1 - lower)+lower;
            }
        }
    }
    
    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
    
    public int[][] getIntMatrix() {
        return intMatrix;
    }
    
}
