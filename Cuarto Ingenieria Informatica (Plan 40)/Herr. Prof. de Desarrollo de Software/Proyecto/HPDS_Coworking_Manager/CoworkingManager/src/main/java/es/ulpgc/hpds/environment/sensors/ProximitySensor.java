package es.ulpgc.hpds.environment.sensors;

import es.ulpgc.hpds.environment.Sensor;

public class ProximitySensor implements Sensor {

    private int actualDistance;
    private final int distanceToTrigger;

    public ProximitySensor(int distanceToTrigger, int actualDistance) {
        this.distanceToTrigger = distanceToTrigger;
        this.actualDistance = actualDistance;
    }

    public void setActualDistance(int actualDistance) {
        this.actualDistance = actualDistance;
    }

    @Override
    public boolean isTriggered() {
        return actualDistance < distanceToTrigger;
    }

}
