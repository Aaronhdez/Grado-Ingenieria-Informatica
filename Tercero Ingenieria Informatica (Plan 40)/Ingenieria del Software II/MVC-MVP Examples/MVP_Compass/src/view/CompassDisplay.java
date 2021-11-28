package view;

import model.CompassSample;
import model.SamplePosition;


public interface CompassDisplay {
    public void on(Touch touch);
    public void reload(SamplePosition sample);
    interface Touch {
        void newCoordinate();
    }
}
