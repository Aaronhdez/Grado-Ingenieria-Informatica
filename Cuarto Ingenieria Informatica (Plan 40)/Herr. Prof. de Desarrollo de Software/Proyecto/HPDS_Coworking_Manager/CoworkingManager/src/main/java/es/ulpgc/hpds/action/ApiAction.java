/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.hpds.action;

import es.ulpgc.hpds.environment.actuator.ActuatorAPI;
import es.ulpgc.hpds.persistence.Action;
import es.ulpgc.hpds.persistence.Condition;

import java.util.ArrayList;

/**
 *
 * @author Entrar
 */
public class ApiAction implements Action {

    private ActuatorAPI actuatorApi;

    public ApiAction(ActuatorAPI actuatorAPI) {
        this.actuatorApi = actuatorAPI;
    }

    @Override
    public void trigger(Object httpRequest) {
    }
    
}