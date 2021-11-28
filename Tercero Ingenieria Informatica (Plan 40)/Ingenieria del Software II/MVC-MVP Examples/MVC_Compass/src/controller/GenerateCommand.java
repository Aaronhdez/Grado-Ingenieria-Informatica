package controller;

import model.CompassSample;

public class GenerateCommand implements Command {
        
    private CompassSample compass;

    public GenerateCommand(CompassSample compass) {
        this.compass = compass;
    }
            
    public void execute() {
        if(this.compass.getStatus()){
            this.compass.generateSample();
        }
    }
}
