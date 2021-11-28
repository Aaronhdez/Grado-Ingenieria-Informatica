package commandexample;

public class Main {
    
    /**
     * Los eventos (Commands), son extraidos de la clase Handler (Manipulador)
     * y creados en clases que implementan la interfaz Command (uno por cada
     * funci�n). Se declaran por fuera y se env�an al manejador.
     */
    public static void main(String[] args) {
        
        // Implementaci�n local del actor. el ser� el receptor del resultado de 
        // la orden 
        GameActor archer = new GameActor(){
            @Override
            public void jump() {
            }
            @Override
            public void swapGun() {
            }
            @Override
            public void lurch() {
            }
            @Override
            public void fireGun() {
            }
        };
        
        Command jumpCommand = new JumpCommand(archer);
        Command fireGunComand = new FireGunCommand(archer);
        Command swapWeaponComand = new SwapWeaponCommand(archer);
        Command lurchComand = new LurchCommand(archer);
        
        GamingPadHandler gamingPadHandler = new GamingPadHandler(swapWeaponComand, lurchComand, fireGunComand,jumpCommand);

        while(true) {
            gamingPadHandler.handlerInput();
        }
    }
}
