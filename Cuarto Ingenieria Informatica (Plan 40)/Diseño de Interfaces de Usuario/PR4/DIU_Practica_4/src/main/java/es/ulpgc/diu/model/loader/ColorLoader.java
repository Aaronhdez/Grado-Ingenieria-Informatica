/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model.loader;

import es.ulpgc.diu.app.LanguageSelector;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class ColorLoader {
    
    private ArrayList<Color> foregroundColors;
    private ArrayList<Color> backgroundColors;
    private HashMap<String, Color> foregroundMapColor;
    private HashMap<String, Color> backgroundMapColor;
    private LanguageSelector languageSelector;
    
    public ColorLoader() {
        loadColorMaps("ES");
    }

    public void loadColorMaps(String language) {
        this.languageSelector = new LanguageSelector();
        this.backgroundMapColor = loadBgColorMap(language);
        this.foregroundMapColor = loadFgColorMap(language);
    }

    private HashMap<String, Color> loadBgColorMap(String language) {
        this.backgroundColors = loadBackgroundColorsList();
        String[] names = languageSelector.getBackgroundColorNames(language);
        return loadMap(this.backgroundColors, names);
    }

    private HashMap<String, Color> loadFgColorMap(String language) {
        this.foregroundColors = loadForegroundColorsList();
        String[] names = languageSelector.getForegroundColorNames(language);
        return loadMap(this.foregroundColors, names);
    }

    private HashMap<String, Color> loadMap(ArrayList<Color> listColors, String[] names) {
        HashMap<String, Color> newMap = new HashMap();
        for (int i = 0; i < names.length; i++) {
            newMap.put(names[i], listColors.get(i));
        }
        return newMap;
    }

    public String[] getForegroundColorsNames() {
        return toStringArray(this.foregroundMapColor.keySet());
    }

    public String[] getBackgroundColorsNames() {
        return toStringArray(this.backgroundMapColor.keySet());
    }
    
    public Color getBackgroundColor(String name){
        return this.backgroundMapColor.get(name);
    }

    public Color getForegroundColor(String name){
        return this.foregroundMapColor.get(name);
    }
    
    private String[] toStringArray(Set<String> keySet) {
        String result[] = new String[keySet.size()];
        int i = 0;
        for (String name : keySet) {
            result[i] = name;
            i++;
        }
        return result;
    }
    
    public ArrayList<Color> getForegroundColors() {
        return foregroundColors;
    }
    
    public ArrayList<Color> getBackgroundColors() {
        return backgroundColors;
    }
    
    private ArrayList<Color> loadBackgroundColorsList() {
        ArrayList<Color> result = new ArrayList();
        result.add(Color.WHITE);
        result.add(Color.RED);
        result.add(Color.YELLOW);
        result.add(Color.BLUE);
        result.add(Color.GREEN);
        return result;
    }

    private ArrayList<Color> loadForegroundColorsList() {
        ArrayList<Color> result = new ArrayList();
        result.add(Color.BLACK);
        result.add(Color.MAGENTA);
        result.add(Color.ORANGE);
        result.add(new Color(64,224,208)); //Turquoise
        result.add(Color.CYAN);
        return result;
    }
    
    
    
    
}
