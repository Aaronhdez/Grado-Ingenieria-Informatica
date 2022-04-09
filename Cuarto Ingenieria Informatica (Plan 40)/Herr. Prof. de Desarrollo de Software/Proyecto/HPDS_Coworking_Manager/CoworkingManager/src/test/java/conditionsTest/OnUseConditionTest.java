package conditionsTest;

import es.ulpgc.hpds.conditions.OnUseCondition;
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
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class OnUseConditionTest {
    private OnUseCondition conditionToTest;
    private ArrayList<Sensor> sensorsList;
    private Sensor mockProximitySensor;
    private Sensor mockWeightSensor;
    private Sensor mockApiSensor;
    private Sensor mockUsedSensor;

    @Before
    public void setUp(){
        sensorsList = new ArrayList();
        createMocks();
        this.conditionToTest = new OnUseCondition(sensorsList);
    }

    private void createMocks() {
        mockApiSensor = mock(ApiSensor.class);
        mockWeightSensor = mock(WeightSensor.class);
        mockUsedSensor = mock(UsedSensor.class);
        mockProximitySensor = mock(ProximitySensor.class);
        sensorsList.add(mockApiSensor);
        sensorsList.add(mockWeightSensor);
        sensorsList.add(mockUsedSensor);
        sensorsList.add(mockProximitySensor);
    }

    @Test
    public void result_is_true_if_all_sensors_are_up() {
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        assertTrue(conditionToTest.evaluate());
    }

    @Test
    public void result_is_true_if_usedSensor_is_down_and_the_rest_of_sensors_are_up(){
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(false).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        assertTrue(conditionToTest.evaluate());
    }
}
