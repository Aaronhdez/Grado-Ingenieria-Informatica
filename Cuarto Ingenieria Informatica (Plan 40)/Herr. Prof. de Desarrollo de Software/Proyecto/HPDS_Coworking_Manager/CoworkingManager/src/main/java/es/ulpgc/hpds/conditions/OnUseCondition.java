package es.ulpgc.hpds.conditions;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

public class OnUseCondition implements Condition {
    ArrayList<Sensor> sensorsAssociated;
    private boolean apiStatus;
    private boolean weightStatus;
    private boolean proximityStatus;
    private boolean usedStatus;

    public OnUseCondition(ArrayList<Sensor> sensorsAssociated) {
        this.sensorsAssociated = sensorsAssociated;
    }

    @Override
    public boolean evaluate() {
        setDefaultStatuses();
        verifySensors();
        return sensorStatusesAreMet();
    }

    private void setDefaultStatuses() {
        apiStatus = false;
        weightStatus = false;
        proximityStatus = false;
        usedStatus = false;
    }

    private boolean sensorStatusesAreMet() {
        return (weightStatus && apiStatus && proximityStatus && usedStatus) ||
                (weightStatus && apiStatus && proximityStatus && !usedStatus);
    }

    private void verifySensors() {
        for (Sensor sensor : this.sensorsAssociated) {
            if (sensor instanceof WeightSensor) {
                weightStatus = sensor.isTriggered();
                continue;
            }
            if (sensor instanceof ApiSensor) {
                apiStatus = sensor.isTriggered();
                continue;
            }
            if (sensor instanceof ProximitySensor) {
                proximityStatus = sensor.isTriggered();
                continue;
            }
            if (sensor instanceof UsedSensor) {
                usedStatus = sensor.isTriggered();
                continue;
            }
        }
    }

}
