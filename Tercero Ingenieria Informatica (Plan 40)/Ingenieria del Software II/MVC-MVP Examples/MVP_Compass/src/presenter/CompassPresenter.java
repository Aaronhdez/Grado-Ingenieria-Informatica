/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.CompassSample;
import view.CompassDisplay;
import view.CompassDisplay.Touch;

/**
 *
 * @author Usuario
 */
public class CompassPresenter implements CompassSample.Observer{

    private CompassSample compass;
    private CompassDisplay compassDisplay;

    public CompassPresenter(CompassSample compass, CompassDisplay compassDisplay) {
        this.compass = compass;
        this.compassDisplay = compassDisplay;
        this.compass.register(this);
        this.compassDisplay.on(new Touch() {
            @Override
            public void newCoordinate() {
                compass.generateSample();
            }
        });
    }
    
    @Override
    public void change() {
        this.refresh();
    }

    private void refresh() {
        this.compassDisplay.reload(this.compass.getSample());
    }
    
}
