package imageviewer.control;

public class NullCommand implements Command {

    public static final Command Instance = new NullCommand();
    
    @Override
    public void execute() {
    }  
}
