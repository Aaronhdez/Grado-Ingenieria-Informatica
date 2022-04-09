package es.ulpgc.hpds.environment.sensors;

import es.ulpgc.hpds.environment.Sensor;

public class WeightSensor implements Sensor {
    double weight;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public WeightSensor(double weight){
        this.weight = weight;
    }

    @Override
    public boolean isTriggered() {
        return (weight >= 30);
    }
}
