package abstractfactoryexample;

import java.util.ArrayList;

public class Maze {
    private final ArrayList<Compartment> compartments = new ArrayList<>();

    public Maze() {
    }

    public void addCompartment(Compartment compartment) {
        this.compartments.add(compartment);
    }
    

}
