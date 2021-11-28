package control;

import model.Measure;

public class StopCommand implements Command{

    private final Measure measure;

    public StopCommand(Measure measure) {
        this.measure = measure;
    }

    @Override
    public void execute() {
        this.measure.stop();
    }
    
}
