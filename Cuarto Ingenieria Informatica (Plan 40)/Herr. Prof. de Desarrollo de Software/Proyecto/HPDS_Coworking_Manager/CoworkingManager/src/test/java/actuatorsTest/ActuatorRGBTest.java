package actuatorsTest;
import es.ulpgc.hpds.environment.actuator.ActuatorRGB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActuatorRGBTest {
    public ActuatorRGB actuatorRGB;

    @Before
    public void setUp(){
        this.actuatorRGB = new ActuatorRGB(null);
    }
    @Test
    public void setRed_Test(){
        actuatorRGB.setRed();
        Assert.assertEquals(actuatorRGB.red, 255);
        Assert.assertEquals(actuatorRGB.blue, 0);
        Assert.assertEquals(actuatorRGB.green, 0);
    }
    @Test
    public void setBlue_Test(){
        actuatorRGB.setBlue();
        Assert.assertEquals(actuatorRGB.red, 0);
        Assert.assertEquals(actuatorRGB.blue, 255);
        Assert.assertEquals(actuatorRGB.green, 0);
    }
    @Test
    public void setYellow_Test(){
        actuatorRGB.setYellow();
        Assert.assertEquals(actuatorRGB.red, 255);
        Assert.assertEquals(actuatorRGB.blue, 0);
        Assert.assertEquals(actuatorRGB.green, 255);
    }
}
