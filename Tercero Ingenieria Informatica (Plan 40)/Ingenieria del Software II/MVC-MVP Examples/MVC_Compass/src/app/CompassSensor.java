package app;

import controller.Command;
import java.util.Timer;
import java.util.TimerTask;
import model.CompassSample;
import controller.GenerateCommand;


public class CompassSensor {
    
    private Timer timer;
    private Command command;

    public CompassSensor(CompassSample compass) {
        this.command = new GenerateCommand(compass);
        this.setTimer();
    }
    
    private void setTimer() {
        this.timer = new Timer();
        this.timer.schedule(task(), 1000, 500);	
    }
    
    private TimerTask task(){
        return new TimerTask(){
            @Override
            public void run(){
                command.execute();
            }
        };
    }
}
