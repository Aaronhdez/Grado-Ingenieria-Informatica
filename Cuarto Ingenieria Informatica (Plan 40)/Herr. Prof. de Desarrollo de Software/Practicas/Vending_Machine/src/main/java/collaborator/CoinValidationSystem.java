package collaborator;

import model.Coin;

import java.util.HashMap;

public class CoinValidationSystem {

    private final HashMap<Double,Double> coinsDictionary;

    public CoinValidationSystem() {
        this.coinsDictionary = loadAcceptedPairs();
    }

    public boolean validate(Coin coinToCheck) {
        return (coinIsValid(coinToCheck));
    }

    private boolean coinIsValid(Coin coinToCheck) {
        if(this.coinsDictionary.get(coinToCheck.getDiameter()) != null){
            return this.coinsDictionary.get(coinToCheck.getDiameter()) == coinToCheck.getWeight();
        }
        return false;
    }

    private HashMap<Double, Double> loadAcceptedPairs() {
        HashMap<Double, Double> coinsDictionary = new HashMap<>();
        coinsDictionary.put(21.25,3.9);
        coinsDictionary.put(19.75,4.1);
        coinsDictionary.put(22.25,5.7);
        coinsDictionary.put(24.25,7.8);
        coinsDictionary.put(23.25,7.5);
        coinsDictionary.put(25.25,8.5);
        return coinsDictionary;
    }
}
