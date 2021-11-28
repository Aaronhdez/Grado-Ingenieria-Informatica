/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandexample;

/**
 *  Este es el Invocador del pàtrón command, es quien ejecuta las ordenes hacia 
 *  el receptor.
 */
public class GamingPadHandler {
    private final GamingPadButton buttonA = new GamingPadButtonHandler("A");
    private final GamingPadButton buttonB = new GamingPadButtonHandler("B");
    private final GamingPadButton buttonY = new GamingPadButtonHandler("Y");
    private final GamingPadButton buttonX = new GamingPadButtonHandler("X");
    Command buttonAComand, buttonBComand, buttonYComand, buttonXComand;
    
    public GamingPadHandler(Command buttonAComand, Command buttonBComand, Command buttonYComand, Command buttonXComand) {
        this.buttonAComand = buttonAComand;
        this.buttonBComand = buttonBComand;
        this.buttonYComand = buttonYComand;
        this.buttonXComand = buttonXComand;
    }
    
    public void handlerInput(){
        if(this.buttonA.isPressed()) buttonAComand.execute();
        else if (this.buttonB.isPressed()) buttonBComand.execute();
        else if (this.buttonY.isPressed()) buttonYComand.execute();
        else if (this.buttonX.isPressed()) buttonXComand.execute();
    }

    private void swapWeapon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void lurch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void fireGun() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void jump() {

    }
}
