/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Measure;

/**
 *
 * @author Usuario
 */
public interface ChronoDisplay extends Measure.Observer {
    public void display(Measure measure);
}
