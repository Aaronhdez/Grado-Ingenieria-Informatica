/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;
    
    public MenuItem(String name,String description,boolean vegetarian,double price){
        this.name = name;
        this.description= description;
        this.vegetarian= vegetarian;
        this.price= price;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    } 
    public double getPrice() {
        return price;
    } 
    public boolean isVegetarian() {
        return vegetarian;
    }
}
