package es.ulpgc.hpds.conditions;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

public class KeepCurrentStateCondition implements Condition {

    ArrayList<Sensor> sensors;

    public KeepCurrentStateCondition(ArrayList<Sensor> sensorsList) {
        this.sensors=sensorsList;
    }

    @Override
    public boolean evaluate() {
        boolean apiStatus=false;
        boolean weightStatus=false;
        boolean proximityStatus=false;
        boolean usedStatus=false;
        for (Sensor sensor : this.sensors){
            if(sensor instanceof WeightSensor){
                weightStatus=weightIsTriggered((WeightSensor) sensor);
            }
            if(sensor instanceof ApiSensor){
                apiStatus=apiIsTriggered((ApiSensor) sensor);
            }
            if(sensor instanceof ProximitySensor){
                proximityStatus=proximityIsTriggered((ProximitySensor) sensor);
            }
            if(sensor instanceof UsedSensor){
                usedStatus=usedIsTriggered((UsedSensor) sensor);
            }
        }
        if(!usedStatus && proximityStatus && !weightStatus && !apiStatus){
            return true;
        }
        if(!usedStatus && !proximityStatus && weightStatus && !apiStatus){
            return true;
        }

        return false;
    }


    private boolean usedIsTriggered(UsedSensor sensor) {return sensor.isTriggered();}

    private boolean proximityIsTriggered(ProximitySensor sensor) {return sensor.isTriggered();}

    private boolean apiIsTriggered(ApiSensor sensor) {
        return sensor.isTriggered();
    }

    private boolean weightIsTriggered(WeightSensor sensor){
        return sensor.isTriggered();
    }
}
