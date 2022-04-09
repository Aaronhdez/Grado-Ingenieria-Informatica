package collaborator;

import model.Coin;

import java.util.HashMap;

public class AmountSystem {

    private double currentAmount;
    private final CoinValidationSystem coinValidationSystem;
    private HashMap<Coin, Double> amountDictionary;

    public AmountSystem() {
        this.currentAmount = 0.0;
        this.coinValidationSystem = new CoinValidationSystem();
        this.amountDictionary = loadAmountDictionary();
    }

    private HashMap<Coin, Double> loadAmountDictionary() {
        amountDictionary = new HashMap<>();
        amountDictionary.put(new Coin(21.25, 3.9), 0.05);
        amountDictionary.put(new Coin(19.75, 4.1), 0.10);
        amountDictionary.put(new Coin(22.25, 5.7), 0.20);
        amountDictionary.put(new Coin(24.25, 7.8), 0.50);
        amountDictionary.put(new Coin(23.25, 7.5), 1.00);
        amountDictionary.put(new Coin(25.25, 8.5), 2.00);
        return amountDictionary;
    }

    public void addAmountFrom(Coin insertedCoin) {
        if(coinValidationSystem.validate(insertedCoin)){
            this.currentAmount += getAmountFrom(insertedCoin);
        }
    }

    private double getAmountFrom(Coin insertedCoin) {
        return amountDictionaryContains(insertedCoin) ?
                this.amountDictionary.get(insertedCoin) : 0.00;
    }

    private boolean amountDictionaryContains(Coin insertedCoin) {
        return this.amountDictionary.get(insertedCoin) != null;
    }

    public double getCurrentAmount() {
        return this.currentAmount;
    }
}
