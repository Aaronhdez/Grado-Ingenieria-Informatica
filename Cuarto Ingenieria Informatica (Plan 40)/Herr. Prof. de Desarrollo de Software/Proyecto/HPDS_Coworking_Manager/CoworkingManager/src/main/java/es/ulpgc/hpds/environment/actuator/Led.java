package es.ulpgc.hpds.environment.actuator;

import java.awt.*;

public class Led {
    private Color currentColor;

    public Led() {
        this.currentColor = Color.GREEN;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }
}
