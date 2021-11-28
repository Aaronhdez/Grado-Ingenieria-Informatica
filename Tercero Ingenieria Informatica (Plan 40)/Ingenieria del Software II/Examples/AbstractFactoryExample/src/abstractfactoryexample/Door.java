package abstractfactoryexample;

public class Door extends Compartment{
    private final Compartment compartment1,compartmen2;
    private DOOR_STATUS status;

    public Door( DOOR_STATUS status, Compartment comp1, Compartment comp2) {
        this.compartment1 = comp1;
        this.compartmen2 = comp2;
        this.status = status;
    }
    
    public Compartment atOtherSide(Compartment compartment){
        return compartment1 == compartment? compartmen2:(compartmen2 == compartment? compartment1:null);
    }

    public DOOR_STATUS getStatus() {
        return status;
    }
    
    
}
