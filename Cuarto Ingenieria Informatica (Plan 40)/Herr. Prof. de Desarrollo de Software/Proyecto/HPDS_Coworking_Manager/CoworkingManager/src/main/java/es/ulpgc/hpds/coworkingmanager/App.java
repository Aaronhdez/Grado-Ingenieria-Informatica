package es.ulpgc.hpds.coworkingmanager;

import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.sensors.ApiSensor;
import es.ulpgc.hpds.environment.sensors.ProximitySensor;
import es.ulpgc.hpds.environment.sensors.UsedSensor;
import es.ulpgc.hpds.environment.sensors.WeightSensor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    static Random apiRng;
    static Random weightRng;
    static Random usedRng;
    static Random proximityRng;

    public static void main(String[] args) {
        final ArrayList<Desk> desksToTest = getDesks();
        final CoworkingManager coworkingManager = new CoworkingManager(desksToTest);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Comprobando mesas");
                coworkingManager.reload(desksToTest);
                System.out.println("Comprobación finalizada");
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 2000);
    }

    private static ArrayList<Desk> getDesks() {
        ArrayList<Desk> desksToTest = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ArrayList<Sensor> sensorsOfNewDesk = new ArrayList<>();
            sensorsOfNewDesk.add(new ApiSensor());
            sensorsOfNewDesk.add(new WeightSensor(0));
            sensorsOfNewDesk.add(new UsedSensor(false));
            sensorsOfNewDesk.add(new ProximitySensor(20,-1));
            Desk newDesk = new Desk(sensorsOfNewDesk);
            desksToTest.add(newDesk);
        }
        return desksToTest;
    }


}
