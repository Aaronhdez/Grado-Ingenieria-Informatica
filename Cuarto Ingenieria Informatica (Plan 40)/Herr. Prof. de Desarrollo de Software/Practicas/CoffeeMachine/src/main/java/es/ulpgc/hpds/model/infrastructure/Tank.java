package es.ulpgc.hpds.model.infrastructure;

import es.ulpgc.hpds.persistence.Sensor;

public class Tank {
    private final String nameTank;
    private final int capacity;
    private int quantity;
    private Sensor productLevelSensor;

    public Tank(String nameTank, int capacity) {
        this.nameTank = nameTank;
        this.capacity = capacity;
    }

    public void addQuantity(int amountToAdd){
        this.quantity += amountToAdd;
    };

    public void removeQuantity(int amountToRemove){
        this.quantity -= amountToRemove;
    };

    //STUB del sensor
    public int getQuantityStub() {
        return quantity;
    }

    public int getQuantityMock() {
        return productLevelSensor.getValue();
    }
}
