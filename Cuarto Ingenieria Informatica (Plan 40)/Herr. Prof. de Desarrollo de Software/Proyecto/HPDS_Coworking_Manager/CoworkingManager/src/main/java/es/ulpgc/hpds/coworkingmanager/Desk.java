package es.ulpgc.hpds.coworkingmanager;

import es.ulpgc.hpds.environment.Actuator;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.states.StateMachine;
import java.util.ArrayList;

public class Desk {
    private ArrayList<Sensor> sensors;
    private StateMachine stateMachine;
    private String name;

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public Desk(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
        this.stateMachine = new StateMachine(sensors);
    }

    public Desk(ArrayList<Sensor> sensors, ArrayList<Actuator> actuators) {
        this.sensors = sensors;
        this.stateMachine = new StateMachine(sensors, actuators);
    }

    public void update(){
        this.stateMachine.checkStatus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
