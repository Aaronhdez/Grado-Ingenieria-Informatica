package control;

import model.Measure;

public class StartCommand implements Command {

    private final Measure measure;

    public StartCommand(Measure measure) {
        this.measure = measure;
    }

    @Override
    public void execute() {
        this.measure.start();
    }
    
}
