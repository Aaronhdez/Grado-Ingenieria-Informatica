package es.ulpgc.hpds.environment.sensors;

import es.ulpgc.hpds.environment.Sensor;

public class ApiSensor implements Sensor {
    boolean qr = false;

    public ApiSensor(){
    }

    public ApiSensor(boolean qr, String desk, String user) {
        this.qr = qr;
    }

    public boolean isQr() {
        return qr;
    }

    public void setQr(boolean qr) {
        this.qr = qr;
    }

    @Override
    public boolean isTriggered() {
        return this.qr;
    }
}
