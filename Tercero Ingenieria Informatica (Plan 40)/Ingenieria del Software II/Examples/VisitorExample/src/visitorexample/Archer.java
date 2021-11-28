package visitorexample;

public class Archer extends Soldier {

    public Archer(String name, int health) {
        super(name, health);
    }
  
    @Override
    public void toApplyMechanics(Mechanics mechanics) {
        mechanics.toApplyMovement(this);
    }    
    
    // Apliación jerárquica del Factory Methos en la clase hijo
    @Override
    public Weapon toEquip() {
        return new Bow();
    }
    
}
