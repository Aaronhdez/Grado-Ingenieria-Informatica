package collaborator;

import model.Coin;

import java.util.ArrayList;
import java.util.List;

public class PurchaseManager {

    private final AmountSystem AmountSystem;
    private final ProductManager ProductManager;
    private double currentAmount;

    public PurchaseManager() {
        this.ProductManager = new ProductManager();
        this.AmountSystem = new AmountSystem();
        this.currentAmount = 0.00;
    }

    public PurchaseManager(double currentAmount, ProductManager productManager, AmountSystem amountSystem) {
        this.ProductManager = productManager;
        this.AmountSystem = amountSystem;
        this.currentAmount = currentAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public boolean purchaseProduct(String productToPurchase) {
        if(!this.ProductManager.isRegistered(productToPurchase)){
            return false;
        }
        if(this.currentAmount < this.AmountSystem.getCurrentAmount()){
            return false;
        }
        this.currentAmount -= this.ProductManager.getPriceOf(productToPurchase);
        return true;
    }

    public void insertCoins(List<Coin> coins) {
        for (Coin coin : coins) {
            this.AmountSystem.addAmountFrom(coin);
        }
        this.currentAmount = this.AmountSystem.getCurrentAmount();
    }
}
