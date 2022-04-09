package ruleTests;

import es.ulpgc.hpds.conditions.CleanCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.persistence.Condition;
import es.ulpgc.hpds.persistence.Rule;
import es.ulpgc.hpds.rules.YellowToGreenRule;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class YellowToGreenRuleTest {

    ArrayList<Sensor> sensors = new ArrayList<>();
    ArrayList<Condition> conditions = new ArrayList<>();
    private Sensor mockProximitySensor;
    private Sensor mockWeightSensor;
    private Sensor mockApiSensor;
    private Sensor mockUsedSensor;
    private Condition cleanCondtion;
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
        ruleToTest = new YellowToGreenRule(sensors);
    }

    @Test
    public void test_if_rule_is_triggered_when_conditions_are_met(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        assertTrue(ruleToTest.check());

    }

    @Test
    public void test_if_rule_is_triggered_when_conditions_are_met_B(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        assertTrue(ruleToTest.check());

    }
    @Test
    public void test_if_rule_is_triggered_when_any_conditions_are_not_met(){
        doReturn(true).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        assertFalse(ruleToTest.check());
    }

}