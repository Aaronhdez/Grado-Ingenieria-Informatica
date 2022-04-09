package es.ulpgc.hpds;

import es.ulpgc.hpds.model.sensors.ProductLevelSensor;
import es.ulpgc.hpds.persistence.Product;
import es.ulpgc.hpds.persistence.Sensor;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CoffeMachineTest {

    private CoffeeMachine coffeeMachine;

    @Test
    public void testPrepareCoffeeExpressStub(){
        this.coffeeMachine = new CoffeeMachine();
        int levelWaterBefore = this.coffeeMachine.getTank1().getQuantityStub();
        int levelCoffeeBefore = this.coffeeMachine.getTank2().getQuantityStub();
        int levelSugarBefore = this.coffeeMachine.getTank3().getQuantityStub();
        int sugarSelected = this.coffeeMachine.getSugarSelector().getLevelSelected();

        this.coffeeMachine.prepareProduct(Product.COFFEE_EXPRESS);

        int levelWaterAfter = this.coffeeMachine.getTank1().getQuantityStub();
        int levelCoffeAfter = this.coffeeMachine.getTank2().getQuantityStub();
        int levelSugarAfter = this.coffeeMachine.getTank3().getQuantityStub();

        assertTrue(levelWaterBefore - levelWaterAfter == 1);
        assertTrue(levelCoffeeBefore - levelCoffeAfter == 1);
        assertTrue(levelSugarBefore - levelSugarAfter == sugarSelected);
    }

    @Test
    public void testPrepareCoffeeExpressMock(){
        this.coffeeMachine = new CoffeeMachine();
        Sensor sensorWaterLevelMock = mock(ProductLevelSensor.class);
        Sensor sensorCoffeeLevelMock = mock(ProductLevelSensor.class);
        Sensor sensorSugarLevelMock = mock(ProductLevelSensor.class);

        doReturn(100).when(sensorWaterLevelMock).getValue();
        doReturn(100).when(sensorCoffeeLevelMock).getValue();
        doReturn(100).when(sensorSugarLevelMock).getValue();

        int levelWaterBefore = sensorWaterLevelMock.getValue();
        int levelCoffeeBefore = sensorCoffeeLevelMock.getValue();
        int levelSugarBefore = sensorSugarLevelMock.getValue();

        int sugarSelected = this.coffeeMachine.getSugarSelector().getLevelSelected();

        this.coffeeMachine.prepareProduct(Product.COFFEE_EXPRESS);

        doReturn(99).when(sensorWaterLevelMock).getValue();
        doReturn(99).when(sensorCoffeeLevelMock).getValue();
        doReturn(99).when(sensorSugarLevelMock).getValue();

        int levelWaterAfter = sensorWaterLevelMock.getValue();
        int levelCoffeeAfter = sensorCoffeeLevelMock.getValue();
        int levelSugarAfter = sensorSugarLevelMock.getValue();

        assertTrue(levelWaterBefore - levelWaterAfter == 1);
        assertTrue(levelCoffeeBefore - levelCoffeeAfter == 1);
        assertTrue(levelSugarBefore - levelSugarAfter == sugarSelected);
    }
}
