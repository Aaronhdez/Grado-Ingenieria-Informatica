/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app;

import java.util.HashMap;

/**
 *
 * @author santa
 */
public class LanguageSelector {
    
    private HashMap<String, String[]> languageMap;
    private HashMap<String, String[]> bgColorsMap;
    private HashMap<String, String[]> fgColorsMap;

    public LanguageSelector() {
        this.languageMap = new HashMap<>();
        this.bgColorsMap = new HashMap<>();
        this.fgColorsMap = new HashMap<>();
        this.setLanguages();
        this.loadBackgroundColors();
        this.loadForegroundColors();
    }
    
    public String[] setLangTo(String lang){
        return this.languageMap.get(lang);
    }
    
    private void setLanguages(){
        String[] es = { 
                        // Panels
                        "Selector de Colores",
                        "Color de fondo",
                        "Color de la estela",
                        "Lienzo"
                        };
        this.languageMap.put("ES", es);
        
        String[] en = { 
                        // Panels
                        "Color Selector",
                        "Background Color",
                        "Trail color",
                        "Canvas"
                        };
        this.languageMap.put("EN", en);
        
        String[] pl = { 
                        // Panels
                        "Selektor Kolorów",
                        "Kolor Tła",
                        "Kolor Szlaku",
                        "Płótno",
                        };
        this.languageMap.put("PL", pl);
    }
    
    public void loadBackgroundColors(){
        String[] es = { 
                        // Panels
                        "Blanco",
                        "Rojo",
                        "Amarillo",
                        "Azul",
                        "Verde",
                        };
        this.bgColorsMap.put("ES", es);
        
        String[] en = { 
                        // Panels
                        "White",
                        "Red",
                        "Yellow",
                        "Blue",
                        "Green",
                        };
        this.bgColorsMap.put("EN", en);
        
        String[] pl = { 
                        // Panels
                        "Biały",
                        "Czerwony",
                        "Żółty",
                        "Niebieski",
                        "Zielony ",
                        };
        this.bgColorsMap.put("PL", pl);
    }
    
    public void loadForegroundColors(){
        String[] es = { 
                        // Panels
                        "Negro",
                        "Magenta",
                        "Naranja",
                        "Tuquesa",
                        "Cyan",
                        };
        this.fgColorsMap.put("ES", es);
        
        String[] en = { 
                        // Panels
                        "Black",
                        "Magenta",
                        "Orange",
                        "Turquoise",
                        "Cyan",
                        };
        this.fgColorsMap.put("EN", en);
        
        String[] pl = { 
                        // Panels
                        "Czarny",
                        "Magenta",
                        "Pomarańczowy",
                        "Turkus",
                        "Cyjan ",
                        };
        this.fgColorsMap.put("PL", pl);
    }    

    public String[] getBackgroundColorNames(String language) {
        return this.bgColorsMap.get(language);
    }

    public String[] getForegroundColorNames(String language) {
        return this.fgColorsMap.get(language);
    }

    public String[] getLanguageSet(String language) {
        return this.languageMap.get(language);
    }
}
