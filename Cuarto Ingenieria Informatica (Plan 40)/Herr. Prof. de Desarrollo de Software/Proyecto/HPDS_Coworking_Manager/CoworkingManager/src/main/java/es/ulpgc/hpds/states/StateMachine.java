package es.ulpgc.hpds.states;

import es.ulpgc.hpds.action.ApiAction;
import es.ulpgc.hpds.action.LedAction;
import es.ulpgc.hpds.conditions.OnUseCondition;
import es.ulpgc.hpds.environment.Actuator;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.environment.actuator.ActuatorAPI;
import es.ulpgc.hpds.environment.actuator.ActuatorRGB;
import es.ulpgc.hpds.environment.actuator.Led;
import es.ulpgc.hpds.persistence.Action;
import es.ulpgc.hpds.persistence.Rule;
import es.ulpgc.hpds.rules.*;
import java.util.ArrayList;

import static es.ulpgc.hpds.states.CurrentState.*;

public class StateMachine {

    CurrentState currentStatus;
    ArrayList<Sensor> sensors;
    ArrayList<Actuator> actuators;

    Rule greenToRedRule;
    Rule blueToYellowRule;
    Rule blueToRedRule;
    Rule yellowToGreenRule;
    Rule redToYellowRule;
    Rule redToBlueRule;
    Action ledAction;
    Action apiAction;

    public void setCurrentStatus(CurrentState newStatus){
        this.currentStatus = newStatus;
    }

    public StateMachine(ArrayList<Sensor> sensorsList){
        this.sensors = sensorsList;
        this.currentStatus = GREEN;
        greenToRedRule = new GreenToRedRule(sensors);
        blueToYellowRule = new BlueToYellowRule(sensors);
        blueToRedRule = new BlueToRedRule(sensors);
        yellowToGreenRule = new YellowToGreenRule(sensors);
        redToYellowRule = new RedToYellowRule(sensors);
        redToBlueRule = new RedToBlueRule(sensors);
    }

    public StateMachine(ArrayList<Sensor> sensorsList, ArrayList<Actuator> actuatorsList){
        this.sensors = sensorsList;
        this.actuators= actuatorsList;
        this.currentStatus = GREEN;

        greenToRedRule = new GreenToRedRule(sensors);
        blueToYellowRule = new BlueToYellowRule(sensors);
        blueToRedRule = new BlueToRedRule(sensors);
        yellowToGreenRule = new YellowToGreenRule(sensors);
        redToYellowRule = new RedToYellowRule(sensors);
        redToBlueRule = new RedToBlueRule(sensors);

        this.ledAction = new LedAction((ActuatorRGB) actuators.get(0));
        this.apiAction = new ApiAction((ActuatorAPI) actuators.get(1));
    }

    public void checkStatus(){
        CurrentState state = this.currentStatus;
        switch(this.currentStatus){
            default:
                break;
            case RED:
                verifyRedRules();
                break;
            case YELLOW:
                verifyYellowRules();
                break;
            case BLUE:
                verifyBlueRules();
                break;
            case GREEN:
                verifyGreenRule();
                break;
        }
        if(state.equals(this.currentStatus)){
            System.out.println("La mesa: " + this + " se mantiene en " + this.currentStatus.toString());
        }
    }

    private void verifyRedRules() {
        if(redToBlueRule.check()) {
            switchFromRedToBlue();
        }
        if (redToYellowRule.check()) {
            switchFromRedToYellow();
        }
    }

    private void verifyYellowRules() {
        if(yellowToGreenRule.check()){
            switchFromYellowToGreen();
        }
    }

    private void verifyBlueRules() {
        if(blueToRedRule.check()){
            switchFromBlueToRed();
        }
        if(blueToYellowRule.check()){
            switchFromBlueToYellow();
        }
    }

    private void verifyGreenRule() {
        if(this.greenToRedRule.check()){
            switchFromGreenToRed();
        }
    }

    private void switchFromGreenToRed() {
        this.currentStatus = RED;
        this.ledAction.trigger("red");
        System.out.println("La mesa: " + this + " ha pasado de Verde a Rojo");
    }

    private void switchFromRedToYellow() {
        this.currentStatus = YELLOW;
        this.ledAction.trigger("yellow");
        System.out.println("La mesa: " + this + " ha pasado de Rojo a Amarillo");
    }

    private void switchFromRedToBlue() {
        this.currentStatus = BLUE;
        this.ledAction.trigger("blue");
        System.out.println("La mesa: " + this + " ha pasado de Rojo a Azul");
    }

    private void switchFromYellowToGreen() {
        this.currentStatus = GREEN;
        this.ledAction.trigger("green");
        System.out.println("La mesa: " + this + " ha pasado de Amarillo a Verde");
    }

    private void switchFromBlueToYellow() {
        this.currentStatus = YELLOW;
        this.ledAction.trigger("yellow");
        System.out.println("La mesa: " + this + " ha pasado de Azul a Amarillo");
    }

    private void switchFromBlueToRed() {
        this.currentStatus = RED;
        this.ledAction.trigger("red");
        System.out.println("La mesa: " + this + " ha pasado de Azul a Rojo");
    }


}
