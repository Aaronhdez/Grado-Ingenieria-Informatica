package actionsTest;

import es.ulpgc.hpds.environment.Actuator;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.actuator.ActuatorAPI;
import es.ulpgc.hpds.environment.actuator.ActuatorRGB;
import es.ulpgc.hpds.environment.actuator.Led;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import es.ulpgc.hpds.states.CurrentState;
import es.ulpgc.hpds.states.StateMachine;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RedToYellowActionTest {
    private StateMachine stateMachine;
    private ArrayList<Sensor> sensorsList;
    private ArrayList<Actuator> actuatorsList;
    private Sensor mockProximitySensor;
    private Sensor mockWeightSensor;
    private Sensor mockApiSensor;
    private Sensor mockUsedSensor;
    private Actuator mockActuatorApi;
    private Actuator mockActuatorRGB;
    private Led ledToTest;

    @Before
    public void setUp(){
        loadSensors();
        loadActuators();
        this.stateMachine = new StateMachine(sensorsList,actuatorsList);
        this.stateMachine.setCurrentStatus(CurrentState.RED);
    }

    private void loadSensors() {
        this.sensorsList = new ArrayList<>();
        mockApiSensor = mock(ApiSensor.class);
        mockWeightSensor = mock(WeightSensor.class);
        mockUsedSensor = mock(UsedSensor.class);
        mockProximitySensor = mock(ProximitySensor.class);
        sensorsList.add(mockApiSensor);
        sensorsList.add(mockWeightSensor);
        sensorsList.add(mockUsedSensor);
        sensorsList.add(mockProximitySensor);
    }

    private void loadActuators() {
        this.actuatorsList = new ArrayList<>();
        this.ledToTest = new Led();
        mockActuatorRGB = new ActuatorRGB(ledToTest);
        mockActuatorApi = mock(ActuatorAPI.class);
        actuatorsList.add(mockActuatorRGB);
        actuatorsList.add(mockActuatorApi);
    }

    @Test
    public void test_if_led_is_turned_from_red_to_yellow_when_conditions_are_met_A(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(false).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        this.stateMachine.checkStatus();

        assertEquals(Color.YELLOW, ledToTest.getCurrentColor());
    }

    @Test
    public void test_if_led_is_turned_from_red_to_yellow_when_conditions_are_met_B(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(false).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(false).when(mockProximitySensor).isTriggered();

        this.stateMachine.checkStatus();

        assertEquals(Color.YELLOW, ledToTest.getCurrentColor());
    }

    @Test
    public void test_if_led_is_turned_from_red_to_yellow_when_conditions_are_met_C(){
        doReturn(false).when(mockApiSensor).isTriggered();
        doReturn(true).when(mockWeightSensor).isTriggered();
        doReturn(true).when(mockUsedSensor).isTriggered();
        doReturn(true).when(mockProximitySensor).isTriggered();

        this.stateMachine.checkStatus();

        assertEquals(Color.YELLOW, ledToTest.getCurrentColor());
    }
}
