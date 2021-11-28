package control;

import model.Measure;

public class ResetCommand implements Command {

    private final Measure measure;

    public ResetCommand(Measure measure) {
        this.measure = measure;
    }

    @Override
    public void execute() {
        this.measure.reset();
    }
    
}
