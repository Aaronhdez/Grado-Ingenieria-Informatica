/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoComposite;

import java.util.ArrayList;
import model.Component;
import model.Menu;
import model.MenuItem;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        Component mainMenu = new Menu(new ArrayList<Component>(), "Menu Principal");
        Component mcdMenu = new Menu(new ArrayList<Component>(), "Menu McDonalds");
        Component stbMenu = new Menu(new ArrayList<Component>(), "Menu StarBucks");
        Component kfcMenu = new Menu(new ArrayList<Component>(), "Menu KFC");
        
        Component hamburger = new MenuItem("Producto 1: Hamburguesa", "Descripción");
        Component hamburger1 = new MenuItem("Producto 2: Hamburguesa2", "Descripción");
        Component hamburger2 = new MenuItem("Producto 3: Hamburguesa3", "Descripción");
        Component hamburger3 = new MenuItem("Producto 4: Hamburguesa4", "Descripción");
        mcdMenu.add(hamburger);
        mcdMenu.add(hamburger1);
        mcdMenu.add(hamburger2);
        mcdMenu.add(hamburger3);
        
        Component chicken = new MenuItem("Producto 1: Pollo", "Descripción");
        Component chicken1 = new MenuItem("Producto 2: Pollo2", "Descripción");
        Component chicken2 = new MenuItem("Producto 3: Pollo3", "Descripción");
        Component chicken3 = new MenuItem("Producto 4: Pollo4", "Descripción");
        kfcMenu.add(chicken);
        kfcMenu.add(chicken1);
        kfcMenu.add(chicken2);
        kfcMenu.add(chicken3);
        
        Component coffe = new MenuItem("Producto 1: Café", "Descripción");
        Component coffe1 = new MenuItem("Producto 2: Café2", "Descripción");
        Component coffe2 = new MenuItem("Producto 3: Café3", "Descripción");
        Component coffe3 = new MenuItem("Producto 4: Café4", "Descripción");
        stbMenu.add(coffe);
        stbMenu.add(coffe1);
        stbMenu.add(coffe2);
        stbMenu.add(coffe3);
        
        mainMenu.add(mcdMenu);
        mainMenu.add(stbMenu);
        mainMenu.add(kfcMenu);
        
        //mainMenu.operation();
        mainMenu.getChild(1).operation();
    }
}
