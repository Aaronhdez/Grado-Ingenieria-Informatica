package sensorTests;

import es.ulpgc.hpds.environment.sensors.ApiSensor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApiSensorTest {
    private ApiSensor apiSensor;

    @Before
    public void SetUp(){
        this.apiSensor = new ApiSensor();
    }

    @Test
    public void result_is_false_if_QR_is_not_used(){
        assertFalse(apiSensor.isTriggered());
    }

    @Test
    public void result_is_false_if_no_desk_data_is_provided(){
        apiSensor.setQr(true);

        assertTrue(apiSensor.isTriggered());
    }

}
