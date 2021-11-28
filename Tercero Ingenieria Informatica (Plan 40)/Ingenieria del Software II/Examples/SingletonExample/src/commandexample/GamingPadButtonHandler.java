package commandexample;

public class GamingPadButtonHandler implements GamingPadButton {

    private final String buttonID;

    public GamingPadButtonHandler(String buttonID) {
        this.buttonID = buttonID;
    }
    
    @Override
    public boolean isPressed() {
        return true;
    }
    
}
