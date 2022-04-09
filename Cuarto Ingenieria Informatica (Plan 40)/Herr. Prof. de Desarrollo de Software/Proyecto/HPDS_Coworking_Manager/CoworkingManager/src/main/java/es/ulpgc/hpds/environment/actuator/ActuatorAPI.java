package es.ulpgc.hpds.environment.actuator;

import es.ulpgc.hpds.environment.Actuator;

public class ActuatorAPI implements Actuator {
    boolean api=false;
    int time=0;
    @Override
    public void actuate() {
        setApiTrue();
        if (time >= 15){
            setApiFalse();
        }
        checkApiStatus();
    }

    public boolean checkApiStatus(){
        return api;
    }

    public void setApiTrue(){
        this.api=true;
    }

    public void setApiFalse(){
        this.api=false;
    }

    public void setTime(int time){
        this.time=time;
    }

}
