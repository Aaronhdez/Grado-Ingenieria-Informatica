/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyConverter.utils;

/**
 *
 * @author Usuario
 */
public class Currency {
    String name;
    String tag;
    
    public Currency(String name, String tag){
        this.name = name;        
        this.tag = tag;
    }
    
    public String getName(){
        return this.name;
    }
    public String getTag(){
        return this.tag;
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
}
