package es.ulpgc.hpds.conditions;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

public class TemporarilyAwayCondition implements Condition {
    ArrayList<Sensor> sensorsAssociated;
    private boolean usedStatus;
    private boolean proximityStatus;
    private boolean weightStatus;
    private boolean apiStatus;

    public TemporarilyAwayCondition(ArrayList<Sensor> sensorsAssociated) {
        this.sensorsAssociated = sensorsAssociated;
    }

    @Override
    public boolean evaluate() {
        setDefaultStatuses();
        verifySensors();
        return sensorStatusesAreMet();
    }

    private void setDefaultStatuses() {
        usedStatus = false;
        proximityStatus = false;
        weightStatus = false;
        apiStatus = false;
    }

    private void verifySensors() {
        for (Sensor sensor : this.sensorsAssociated) {
            if (sensor instanceof WeightSensor) {
                weightStatus = sensor.isTriggered();
            }
            if (sensor instanceof ApiSensor) {
                apiStatus = sensor.isTriggered();
            }
            if (sensor instanceof ProximitySensor) {
                proximityStatus = sensor.isTriggered();
            }
            if (sensor instanceof UsedSensor) {
                usedStatus = sensor.isTriggered();
            }
        }
    }

    private boolean sensorStatusesAreMet() {
        return (usedStatus && proximityStatus && !weightStatus && apiStatus)
                || (usedStatus && !proximityStatus && !weightStatus && apiStatus);
    }

}
