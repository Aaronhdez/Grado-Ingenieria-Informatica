package conditionsTest;

import es.ulpgc.hpds.conditions.TemporarilyAwayCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TemporarilyAwayConditionTest {

    private ArrayList<Sensor> sensorsAssociated;
    private Sensor mockApiSensor;
    private Sensor mockWeightSensor;
    private Sensor mockUsedSensor;
    private Sensor mockProximitySensor;
    private TemporarilyAwayCondition tempAwayCondition;

    @Before
    public void setUp(){
        sensorsAssociated = new ArrayList<Sensor>();
        createMocks();
        this.tempAwayCondition = new TemporarilyAwayCondition(sensorsAssociated);
    }

    private void createMocks() {
        mockApiSensor = mock(ApiSensor.class);
        mockWeightSensor = mock(WeightSensor.class);
        mockUsedSensor = mock(UsedSensor.class);
        mockProximitySensor = mock(ProximitySensor.class);
        sensorsAssociated.add(mockApiSensor);
        sensorsAssociated.add(mockWeightSensor);
        sensorsAssociated.add(mockUsedSensor);
        sensorsAssociated.add(mockProximitySensor);
    }

    @Test
    public void result_is_false_if_all_sensors_are_up() {
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        boolean expectedResult = this.tempAwayCondition.evaluate();

        assertFalse(expectedResult);
    }

    @Test
    public void result_is_true_if_only_weightSensor_is_down() {
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        boolean expectedResult = this.tempAwayCondition.evaluate();

        assertTrue(expectedResult);
    }

    @Test
    public void result_is_true_if_both_weightSensor_and_proximitySensor_are_down() {
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        boolean expectedResult = this.tempAwayCondition.evaluate();

        assertTrue(expectedResult);
    }
}
