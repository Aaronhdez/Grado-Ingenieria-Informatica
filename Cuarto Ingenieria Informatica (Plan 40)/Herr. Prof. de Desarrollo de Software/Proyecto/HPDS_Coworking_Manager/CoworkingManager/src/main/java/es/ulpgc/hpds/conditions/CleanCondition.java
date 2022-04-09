package es.ulpgc.hpds.conditions;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

public class CleanCondition implements Condition {
    ArrayList<Sensor>sensors;
    private boolean apiStatus;
    private boolean weightStatus;
    private boolean proximityStatus;
    private boolean usedStatus;

    public CleanCondition(ArrayList<Sensor> sensorsList) {
        this.sensors=sensorsList;
    }

    @Override
    public boolean evaluate() {
        setDefaultStatuses();
        verifySensors();
        return sensorsStatusesAreMet();
    }

    private boolean sensorsStatusesAreMet() {
        return (usedStatus && weightStatus && proximityStatus && !apiStatus) ||
                (usedStatus && !weightStatus && !proximityStatus && !apiStatus) ||
                (!usedStatus && weightStatus && proximityStatus && !apiStatus);
    }

    private void verifySensors() {
        for (Sensor sensor : this.sensors){
            if(sensor instanceof WeightSensor){
                weightStatus=sensor.isTriggered();;
            }
            if(sensor instanceof ApiSensor){
                apiStatus=sensor.isTriggered();;
            }
            if(sensor instanceof ProximitySensor){
                proximityStatus=sensor.isTriggered();;
            }
            if(sensor instanceof UsedSensor){
                usedStatus=sensor.isTriggered();;
            }
        }
    }

    private void setDefaultStatuses() {
        apiStatus=false;
        weightStatus=false;
        proximityStatus=false;
        usedStatus=false;
    }
}
