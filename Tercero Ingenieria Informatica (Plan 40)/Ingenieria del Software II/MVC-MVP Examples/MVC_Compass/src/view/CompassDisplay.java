package view;

import model.CompassSample;


public interface CompassDisplay extends CompassSample.Observer {
    public void display(CompassSample compassSample);
    public void reload();
}
