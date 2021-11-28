package commandexample;

public class JumpCommand implements Command{
    private final GameActor gameActor;

    public JumpCommand(GameActor gameActor) {
        this.gameActor = gameActor;
    }

    @Override
    public void execute() {
        System.out.println("Jump");
    }
    
}
