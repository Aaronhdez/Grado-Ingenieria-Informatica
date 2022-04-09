package sensorTests;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProximitySensorTest {
    private ProximitySensor proximitySensor;

    @Before
    public void setUp(){
        proximitySensor = new ProximitySensor(20,-1);
    }

    @Test
    public void triggers_if_distance_is_lower_than_distanceToTrigger(){
        this.proximitySensor.setActualDistance(14);

        boolean sensorStatus=proximitySensor.isTriggered();

        assertTrue(sensorStatus);
    }
    @Test
    public void triggers_false_if_distance_is_equal_to_distanceToTrigger(){
        this.proximitySensor.setActualDistance(20);

        boolean sensorStatus=proximitySensor.isTriggered();

        assertFalse(sensorStatus);
    }
}
