package controller;

import model.CompassSample;

public class SamplingCommand implements Command {

    private CompassSample compass;

    public SamplingCommand(CompassSample compass) {
        this.compass = compass;
    }

    @Override
    public void execute() {
        this.compass.setStatus();
    }

}

