package model;

public class Coin {
    private final double diameter;
    private final double weight;

    public Coin(double diameter, double weight) {
        this.diameter = diameter;
        this.weight = weight;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Coin){
            Coin coinToCompare = (Coin) obj;
            return coinToCompare.getDiameter() == this.diameter &&
                    coinToCompare.getWeight() == this.weight;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
