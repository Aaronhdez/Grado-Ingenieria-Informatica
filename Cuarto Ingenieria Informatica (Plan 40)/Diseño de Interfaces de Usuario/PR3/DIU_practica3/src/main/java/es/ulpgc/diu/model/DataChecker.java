/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model;

/**
 *
 * @author Usuario
 */
public class DataChecker {
    
    public boolean checkFormat(String valueToBeChecked){
        try {
            Integer.parseInt(valueToBeChecked);
            return true;
        } catch (NumberFormatException e){
            return false;   
        }
    }
    
    public boolean checkBounds(int lower, int upper){
        return upper > lower;
    }
    
    public String checkValues(int lower, int upper) {
        String result = "";
        result += (lower < 0) ? "(Lim. Inf. valores negativos no aceptados)\n" : "";
        result += (upper < 0) ? "(Lim. Sup. valores negativos no aceptados)\n" : "";
        return result;
    }
}
