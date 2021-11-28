package commandexample;

public class SwapWeaponCommand implements Command{
    private final GameActor gameActor;

    public SwapWeaponCommand(GameActor gameActor) {
        this.gameActor = gameActor;
    }
    
    @Override
    public void execute() {
        System.out.println("SwapWeapon");
    }
    
}
