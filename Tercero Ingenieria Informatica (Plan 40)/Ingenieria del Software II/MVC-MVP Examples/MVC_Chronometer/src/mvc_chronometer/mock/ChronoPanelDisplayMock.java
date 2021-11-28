/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_chronometer.mock;

import java.sql.Timestamp;
import model.Measure;
import view.ChronoDisplay;

public class ChronoPanelDisplayMock implements ChronoDisplay {

    private Measure measure;

    @Override
    public void display(Measure measure) {
        this.measure = measure;
    }

    @Override
    public void change() {
        System.out.println(new Timestamp(this.measure.getCount()).toString());
    }
    
}
