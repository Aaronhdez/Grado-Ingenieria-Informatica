
package commandexample;

public class FireGunCommand implements Command {
    private final GameActor gameActor;

    public FireGunCommand(GameActor gameActor) {
        this.gameActor = gameActor;
    }
    
    @Override
    public void execute() {
        System.out.println("fireGun");
    }
    
}
