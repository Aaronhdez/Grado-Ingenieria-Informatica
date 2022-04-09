package conditionsTest;

import es.ulpgc.hpds.conditions.CleanCondition;
import es.ulpgc.hpds.conditions.KeepCurrentStateCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeepCurrentStateConditionTest {
    private KeepCurrentStateCondition keepCurrentStateCondition;
    private ArrayList<Sensor> sensorsList;

    @Before
    public void setUp() {
        sensorsList = new ArrayList();
        this.keepCurrentStateCondition = new KeepCurrentStateCondition(sensorsList);
    }

    @Test
    public void return_true_if_Keep_Current_State_1(){
        sensorsList.add(new ApiSensor(false, "aDesk", ""));
        sensorsList.add(new UsedSensor(false));
        sensorsList.add(new ProximitySensor(20, 10));
        sensorsList.add(new WeightSensor(0));
        assertTrue(this.keepCurrentStateCondition.evaluate());
    }
    @Test
    public void return_true_if_Keep_Current_State_2(){
        sensorsList.add(new ApiSensor(false, "aDesk", ""));
        sensorsList.add(new UsedSensor(false));
        sensorsList.add(new ProximitySensor(10, 30));
        sensorsList.add(new WeightSensor(85));
        assertTrue(this.keepCurrentStateCondition.evaluate());
    }
    @Test
    public void return_false_if_not_Keep_Current_State(){
        sensorsList.add(new ApiSensor(false, "aDesk", ""));
        sensorsList.add(new UsedSensor(true));
        sensorsList.add(new ProximitySensor(10, 30));
        sensorsList.add(new WeightSensor(85));
        assertFalse(this.keepCurrentStateCondition.evaluate());
    }
}


