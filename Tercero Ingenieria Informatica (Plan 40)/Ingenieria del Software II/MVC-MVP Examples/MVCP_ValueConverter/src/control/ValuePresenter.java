/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Value;
import view.ValueDisplay;
import view.ValueDisplay.Touch;

/**
 *
 * @author Usuario
 */
public class ValuePresenter implements Value.Observer{

    private final Value value;
    private final ValueDisplay octalPanel;
    private final ValueDisplay hexPanel;
    private final ValueDisplay binaryPanel;

    public ValuePresenter(Value value, ValueDisplay octalPanel, ValueDisplay hexPanel, ValueDisplay binaryPanel) {
        this.value = value;
        this.octalPanel = octalPanel;
        this.hexPanel = hexPanel;
        this.binaryPanel = binaryPanel;
        this.execute();
    }
    
    private void execute() {
        this.value.registerObservers(this);
        this.octalPanel.on(new Touch(){
            @Override
            public void doAction() {
                value.toOctal();
            }
        });
        this.hexPanel.on(new Touch(){
            @Override
            public void doAction() {
                value.toHex();
            }
        });
        this.binaryPanel.on(new Touch(){
            @Override
            public void doAction() {
                value.toBinary();
            }
        });
        
    }
    
    @Override
    public void change() {
        this.refresh();
    }

    private void refresh() {
        this.octalPanel.reload();
        this.binaryPanel.reload();
        this.hexPanel.reload();
    }
    
}
