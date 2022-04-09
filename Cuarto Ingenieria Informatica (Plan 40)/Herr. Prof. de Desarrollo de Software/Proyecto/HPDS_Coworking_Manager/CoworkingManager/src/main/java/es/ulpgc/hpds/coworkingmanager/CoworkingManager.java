/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.hpds.coworkingmanager;

import static es.ulpgc.hpds.coworkingmanager.CoworkingInterface_02.apiRng;
import static es.ulpgc.hpds.coworkingmanager.CoworkingInterface_02.proximityRng;
import static es.ulpgc.hpds.coworkingmanager.CoworkingInterface_02.usedRng;
import static es.ulpgc.hpds.coworkingmanager.CoworkingInterface_02.weightRng;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;
import java.util.ArrayList;
import java.util.Random;

public class CoworkingManager {
    ArrayList<Desk> desks;

    public CoworkingManager(ArrayList<Desk> desks) {
        this.desks = desks;
    }

    void reload(ArrayList<Desk> desksToUpdate) {
        for (Desk desk : this.desks) {
            reloadSensorValues(desksToUpdate);
            desk.update();
        }
    }

    void reloadSensorValues(ArrayList<Desk> desksToUpdate) {
        for (Desk desk : desksToUpdate) {
            reloadRandoms();
            ArrayList<Sensor> sensors = desk.getSensors();
            ((ApiSensor) sensors.get(0)).setQr(apiRng.nextBoolean());
            ((WeightSensor) sensors.get(1)).setWeight(weightRng.nextInt(90));
            ((UsedSensor) sensors.get(2)).setUsedSit(usedRng.nextBoolean());
            ((ProximitySensor) sensors.get(3)).setActualDistance(proximityRng.nextInt(100));
        }
    }
    
    void reloadRandoms() {
        apiRng = new Random();
        proximityRng = new Random();
        usedRng = new Random();
        weightRng = new Random();
    }
}
