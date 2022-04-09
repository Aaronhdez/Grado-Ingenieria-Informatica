package es.ulpgc.hpds;

import es.ulpgc.hpds.model.infrastructure.ArrayOfValves;
import es.ulpgc.hpds.model.infrastructure.MixingTank;
import es.ulpgc.hpds.model.infrastructure.SugarSelector;
import es.ulpgc.hpds.model.infrastructure.Tank;
import es.ulpgc.hpds.persistence.Product;

public class CoffeeMachine {
    private Tank tank1 = new Tank("waterTank", 200);
    private Tank tank2 = new Tank("coffeeTank", 200);
    private Tank tank3 = new Tank("sugarTank", 500);
    private Tank tank4 = new Tank("milkTank", 200);

    public Tank getTank1() {
        return tank1;
    }

    public Tank getTank3() {
        return tank3;
    }

    public Tank getTank4() {
        return tank4;
    }

    public Tank getTank2() {
        return tank2;
    }

    public SugarSelector getSugarSelector() {
        return sugarSelector;
    }

    private MixingTank MixingTank1 = new MixingTank("coolTank", 0);
    private MixingTank mixingTank2 = new MixingTank("heatTank", 0);

    private ArrayOfValves arrayValves = new ArrayOfValves();
    private SugarSelector sugarSelector = new SugarSelector();
    
    public void prepareProduct(Product product){
        if(product == product.COFFEE_EXPRESS){
            prepareProductCoffeeExpress();
        }
    }

    private void prepareProductCoffeeExpress() {
        int availableWater = tank1.getQuantityStub();
        int availableCoffee = tank2.getQuantityStub();
        int availableSugar = tank3.getQuantityStub();
        int sugarSelected = sugarSelector.getLevelSelected();

        if(availableCoffee >= 1 && availableWater >= 1 && availableSugar >= sugarSelected){

            mixingTank2.ejectContent();
        }
    }
}
