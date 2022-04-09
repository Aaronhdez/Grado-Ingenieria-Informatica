package es.ulpgc.hpds.environment.sensors;

import es.ulpgc.hpds.environment.Sensor;

public class UsedSensor implements Sensor {
    private boolean usedSit;

    public UsedSensor(boolean usedSit) {
        this.usedSit = usedSit;
    }

    public void setUsedSit(boolean usedSit) {
        this.usedSit = usedSit;
    }

    @Override
    public boolean isTriggered() {
        return usedSit;
    }
}
                                                                                                          