/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactoryexample;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Compartment {
    private final Map<DIRECTION, Compartment> border = new HashMap<>();
    
    public void setBorder(DIRECTION dir, Compartment comp){
        this.border.put(dir, comp);
    }
    
    public Compartment getBorder(DIRECTION dir){
        return this.border.get(dir);
    }
}
