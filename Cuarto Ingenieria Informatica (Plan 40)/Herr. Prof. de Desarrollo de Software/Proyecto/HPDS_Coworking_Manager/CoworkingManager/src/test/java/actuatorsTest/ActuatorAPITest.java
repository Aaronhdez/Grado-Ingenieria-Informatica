package actuatorsTest;

import es.ulpgc.hpds.environment.actuator.ActuatorAPI;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActuatorAPITest {
    public ActuatorAPI actuatorAPI;
    @Before
    public void instanceAPI(){
        this.actuatorAPI=new ActuatorAPI();
    }
    @Test
    public void check_if_api_is_on_now(){
        actuatorAPI.setTime(0);
        actuatorAPI.actuate();
        assertEquals(actuatorAPI.checkApiStatus(),true);
    }
    @Test
    public void check_if_api_is_down_after_cooldown_is_over_the_time_limit(){
        actuatorAPI.setTime(16);
        actuatorAPI.actuate();
        assertEquals(actuatorAPI.checkApiStatus(),false);
    }
    @Test
    public void check_if_api_is_down_after_user_logged_out_and_time_is_not_on_limit(){
        actuatorAPI.setTime(5);
        actuatorAPI.actuate();
        actuatorAPI.setApiFalse();
        assertEquals(actuatorAPI.checkApiStatus(),false);
    }

}
