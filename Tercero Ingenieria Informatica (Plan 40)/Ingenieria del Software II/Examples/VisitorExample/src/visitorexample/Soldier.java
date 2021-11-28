package visitorexample;

public abstract class Soldier {
    protected String name;
    protected int health;
    private int positionX, positionY;
    protected String status;

    public Soldier(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    /* Método abstracto que efectúa la labor de Factory Method */
    public abstract Weapon toEquip();
    
    public abstract void toApplyMechanics(Mechanics mechanics);
    
    public void toAct(Soldier soldier){
        Weapon weapon = toEquip();
        weapon.toApply(soldier);
    }
    
    public void setPosition(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
}
