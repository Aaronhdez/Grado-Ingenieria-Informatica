package commandexample;

/**
 * Este es el actor o receptor del modelo command, es quien recibe las acciones 
 * que ejecuta el Invocador sobre él.
 */
public interface GameActor {
    public void jump();
    public void swapGun();
    public void lurch();
    public void fireGun();
}
