/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Value;

/**
 *
 * @author Usuario
 */
public class SetValueCommand implements Command {

    private final Value value;
    private final String text;

    public SetValueCommand(Value value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public void execute() {
        try {
            this.value.setValue(Integer.parseInt(text));
        } catch (Exception e){
            
        }
    }
    
}
