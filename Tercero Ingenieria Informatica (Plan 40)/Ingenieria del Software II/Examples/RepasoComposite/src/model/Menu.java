/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Menu implements Component {
    private final ArrayList<Component> components;
    private final String name;

    public Menu(ArrayList<Component> components, String name) {
        this.components = components;
        this.name = name;
    }

    //Métodos default de la interfaz implementados
    @Override
    public void add(Component c) {
        this.components.add(c);
    }

    @Override
    public void remove(Component c) {
        this.components.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return this.components.get(i);
    }

    public String getName() {
        return name;
    }

    @Override
    public void operation() {
        System.out.println(this.getName());
        for (Component component : components) {
            component.operation();
        }
    }
}
