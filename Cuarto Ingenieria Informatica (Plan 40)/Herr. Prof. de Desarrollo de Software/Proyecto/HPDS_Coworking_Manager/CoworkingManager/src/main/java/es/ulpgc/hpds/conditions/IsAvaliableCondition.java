package es.ulpgc.hpds.conditions;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

public class IsAvaliableCondition implements Condition {
    ArrayList<Sensor> sensorsAssociated;

    public IsAvaliableCondition(ArrayList<Sensor> sensorsAssociated){
        this.sensorsAssociated=sensorsAssociated;
    }
    @Override
    public boolean evaluate(){
        for (Sensor sensor: sensorsAssociated){
            if(sensor.isTriggered()){
                return false;
            }
        }
        return true;
    }
}

