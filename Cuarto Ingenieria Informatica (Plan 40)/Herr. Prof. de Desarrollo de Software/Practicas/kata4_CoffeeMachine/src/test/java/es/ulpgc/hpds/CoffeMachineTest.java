package es.ulpgc.hpds;

import es.ulpgc.hpds.persistence.Product;
import org.junit.Test;

public class CoffeMachineTest {

    private CoffeeMachine coffeeMachine;

    @Test
    public void testPrepareCoffeeExpress(){

        this.coffeeMachine.prepareProduct(Product.COFFEE_EXPRESS);

        assert(true);
    }
}
