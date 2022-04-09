package es.ulpgc.hpds.action;

import es.ulpgc.hpds.environment.actuator.ActuatorRGB;
import es.ulpgc.hpds.environment.actuator.Led;
import es.ulpgc.hpds.persistence.Action;

public class LedAction implements Action {
    private ActuatorRGB actuator;

    public LedAction(ActuatorRGB actuator) {
        this.actuator = actuator;
    }

    public void switchTo(String color){
        switch(color){
            case "red":
                this.actuator.setRed();
                break;
            case "green":
                this.actuator.setGreen();
                break;
            case "yellow":
                this.actuator.setYellow();
                break;
            case "blue":
                this.actuator.setBlue();
                break;
        };
    }

    @Override
    public void trigger(Object color) {
        this.switchTo((String) color);
        this.actuator.actuate();
    }
}
