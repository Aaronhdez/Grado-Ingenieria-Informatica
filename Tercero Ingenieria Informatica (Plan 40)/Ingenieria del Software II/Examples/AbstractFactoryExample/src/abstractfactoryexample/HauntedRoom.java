package abstractfactoryexample;

public class HauntedRoom extends Room{
    Spell spell;

    public HauntedRoom(Spell spell, int roomNumber) {
        super(roomNumber);
        this.spell = spell;
    }
 
}
