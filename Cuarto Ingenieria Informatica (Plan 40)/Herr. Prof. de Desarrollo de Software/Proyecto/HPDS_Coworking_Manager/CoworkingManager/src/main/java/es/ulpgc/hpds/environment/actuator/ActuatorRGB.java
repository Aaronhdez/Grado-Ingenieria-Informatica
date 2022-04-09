package es.ulpgc.hpds.environment.actuator;

import es.ulpgc.hpds.environment.Actuator;

import java.awt.*;

public class ActuatorRGB implements Actuator {
    private final Led ledToColorize;
    public int red = 0;
    public int blue = 0;
    public int green = 0;

    public ActuatorRGB(Led ledToColorize) {
        this.ledToColorize = ledToColorize;
    }

    @Override
    public void actuate() {
        this.ledToColorize.setCurrentColor(new Color(this.red, this.green, this.blue));
    }

    public void setYellow(){
        green = 255;
        red = 255;
        blue = 0;
    }

    public void setGreen(){
        green = 255;
        red = 0;
        blue =0;
    }

    public void setBlue(){
        blue = 255;
        green = 0;
        red = 0;
    }

    public void setRed(){
        red = 255;
        blue = 0;
        green = 0;
    }
}
