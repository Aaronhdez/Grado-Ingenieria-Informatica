/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Money {

    private float amount;

    public Money() {
    }

    public float getAmount() {
        return amount;
    }
    
    void setAmount(int i) {
        this.amount = (float) i;
    }

    void addAmount(float newAmount) {
        this.amount = this.amount+newAmount;
    }

    void removeAmount(float newAmount) {
        this.amount = this.amount-newAmount;
    }
    
}
