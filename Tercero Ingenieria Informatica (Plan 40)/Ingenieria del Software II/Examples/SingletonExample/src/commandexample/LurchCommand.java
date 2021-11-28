package commandexample;

public class LurchCommand implements Command {
    private final GameActor gameActor;

    public LurchCommand(GameActor gameActor) {
        this.gameActor = gameActor;
    }

    @Override
    public void execute() {
        System.out.println("Lurch");
    }
    
}
