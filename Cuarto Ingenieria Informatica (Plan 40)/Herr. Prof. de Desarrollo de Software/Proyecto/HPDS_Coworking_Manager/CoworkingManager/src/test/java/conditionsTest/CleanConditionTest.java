package conditionsTest;

import es.ulpgc.hpds.conditions.CleanCondition;
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

public class CleanConditionTest {
    private CleanCondition conditionToTest;
    private ArrayList<Sensor> sensorsList;
    private Sensor mockProximitySensor;
    private Sensor mockWeightSensor;
    private Sensor mockApiSensor;
    private Sensor mockUsedSensor;

    @Before
    public void setUp() {
        sensorsList = new ArrayList();
        createMocks();
        this.conditionToTest = new CleanCondition(sensorsList);
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
    public void return_true_if_both_users_and_qr_status_are_null(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        assertTrue(this.conditionToTest.evaluate());
    }

    @Test
    public void return_true_if_only_used_status_is_true(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        assertTrue(this.conditionToTest.evaluate());
    }

    @Test
    public void return_true_if_used_status_and_api_are_false(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        assertTrue(this.conditionToTest.evaluate());
    }
}
