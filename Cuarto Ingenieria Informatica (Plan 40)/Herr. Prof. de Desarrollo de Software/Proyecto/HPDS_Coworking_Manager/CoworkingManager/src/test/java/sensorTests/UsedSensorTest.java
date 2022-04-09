package sensorTests;

import es.ulpgc.hpds.environment.sensors.UsedSensor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UsedSensorTest {
    private UsedSensor usedSensor;
    @Test
    public void triggers_if_user_sits_on_workbench(){
        usedSensor=new UsedSensor(true);

        boolean check=usedSensor.isTriggered();

        assertTrue(check);
    }
}
