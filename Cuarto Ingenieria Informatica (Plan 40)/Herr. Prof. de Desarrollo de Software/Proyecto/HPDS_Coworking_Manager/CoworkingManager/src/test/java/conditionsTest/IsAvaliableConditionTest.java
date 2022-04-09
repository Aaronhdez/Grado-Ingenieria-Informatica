package conditionsTest;

import es.ulpgc.hpds.conditions.IsAvaliableCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class IsAvaliableConditionTest {
    private Condition IsAvaliableCondition;
    private ArrayList<Sensor> sensorsAssociated;
    private ApiSensor mockApiSensor;
    private ProximitySensor mockProximitySensor;
    private UsedSensor mockUsedSensor;
    private WeightSensor mockWeightSensor;


    @Before
    public void setUp(){
        sensorsAssociated = new ArrayList<Sensor>();

        mockApiSensor=mock(ApiSensor.class);
        mockProximitySensor=mock(ProximitySensor.class);
        mockUsedSensor=mock(UsedSensor.class);
        mockWeightSensor=mock(WeightSensor.class);

        sensorsAssociated.add(mockApiSensor);
        sensorsAssociated.add(mockProximitySensor);
        sensorsAssociated.add(mockUsedSensor);
        sensorsAssociated.add(mockWeightSensor);

        this.IsAvaliableCondition = new IsAvaliableCondition(sensorsAssociated);

    }

    @Test
    public void result_is_true_when_all_sensors_are_off(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();
        doReturn(false).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();

        assertTrue(this.IsAvaliableCondition.evaluate());
    }

}
