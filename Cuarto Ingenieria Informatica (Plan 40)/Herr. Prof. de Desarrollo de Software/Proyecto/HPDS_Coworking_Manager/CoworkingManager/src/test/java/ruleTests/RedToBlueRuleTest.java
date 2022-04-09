package ruleTests;

import es.ulpgc.hpds.conditions.CleanCondition;
import es.ulpgc.hpds.conditions.TemporarilyAwayCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;
import es.ulpgc.hpds.persistence.Rule;
import es.ulpgc.hpds.rules.RedToBlueRule;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class RedToBlueRuleTest {

    ArrayList<Sensor> sensors = new ArrayList<>();
    ArrayList<Condition> conditions = new ArrayList<>();
    private Sensor mockProximitySensor;
    private Sensor mockWeightSensor;
    private Sensor mockApiSensor;
    private Sensor mockUsedSensor;
    private Condition temporalityAwayCondition;
    private Condition cleanCondition;
    private Rule ruleToTest;

    @Before
    public void setUp(){
        mockApiSensor = mock(ApiSensor.class);
        mockWeightSensor = mock(WeightSensor.class);
        mockUsedSensor = mock(UsedSensor.class);
        mockProximitySensor = mock(ProximitySensor.class);
        sensors.add(mockApiSensor);
        sensors.add(mockWeightSensor);
        sensors.add(mockUsedSensor);
        sensors.add(mockProximitySensor);
        ruleToTest = new RedToBlueRule(sensors);
    }

    @Test
    public void test_temporarily_away_condition_is_on_and_clean_condition_is_off(){
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        assertTrue(ruleToTest.check());

    }

}