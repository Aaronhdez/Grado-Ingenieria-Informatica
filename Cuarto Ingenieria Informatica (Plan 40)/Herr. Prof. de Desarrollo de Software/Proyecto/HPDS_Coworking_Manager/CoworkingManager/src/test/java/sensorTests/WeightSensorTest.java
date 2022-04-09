package sensorTests;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeightSensorTest {

    @Test
    public void resultIsTrueIfWeightIsEqualToThirty(){
        Sensor weightSensor = new WeightSensor(30);

        boolean result = weightSensor.isTriggered();

        assertTrue(result);
    }

    @Test
    public void resultIsTrueIfWeightIsGreaterThanThirty() {
        Sensor weightSensor = new WeightSensor(31);

        boolean result = weightSensor.isTriggered();

        assertTrue(result);
    }
}
