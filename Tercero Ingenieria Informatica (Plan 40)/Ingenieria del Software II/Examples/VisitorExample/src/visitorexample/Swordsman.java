
package visitorexample;

public class Swordsman extends Soldier {

    public Swordsman(String name, int health) {
        super(name, health);
    }

    @Override
    public void toApplyMechanics(Mechanics mechanics) {
        mechanics.toApplyMovement(this);
    }
    
    // Apliación jerárquica del Factory Method en la clase hijo
    @Override
    public Weapon toEquip() {
        return new Sword();
    }
    
}
