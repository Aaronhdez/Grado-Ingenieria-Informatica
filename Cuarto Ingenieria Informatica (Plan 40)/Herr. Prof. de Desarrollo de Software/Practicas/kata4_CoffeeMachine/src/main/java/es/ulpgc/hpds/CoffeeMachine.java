package es.ulpgc.hpds;

import es.ulpgc.hpds.model.infrastructure.ArrayValve;
import es.ulpgc.hpds.model.infrastructure.MixTank;
import es.ulpgc.hpds.model.infrastructure.Tank;
import es.ulpgc.hpds.persistence.Product;

public class CoffeeMachine {
    private Tank tank1 = new Tank("waterTank", 200);
    private Tank tank2 = new Tank("coffeeTank", 200);
    private Tank tank3 = new Tank("sugarTank", 200);
    private Tank tank4 = new Tank("milkTank", 200);

    private MixTank MixingTank1 = new MixTank("coolTank", 0);
    private MixTank mixingTank2 = new MixTank("hotTank", 0);

    private ArrayValve arrayValves = new ArrayValve();
    
    public void prepareProduct(Product product){
        if(product == product.COFFEE_EXPRESS){
            prepareProductExpress();
        }
    }

    private void prepareProductExpress() {
    }
}
