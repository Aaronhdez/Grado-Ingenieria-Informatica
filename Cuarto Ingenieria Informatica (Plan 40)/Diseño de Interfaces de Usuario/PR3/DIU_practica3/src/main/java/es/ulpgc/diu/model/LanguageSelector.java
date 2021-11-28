/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.model;

import es.ulpgc.diu.app.fx.Practica3;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author santa
 */
public class LanguageSelector {
    
    private HashMap<String, String[]> languageMap;

    public LanguageSelector() {
        this.languageMap = new HashMap<>();
        this.setLanguages();
    }
    
    public String[] setLangTo(String lang){
        return this.languageMap.get(lang);
    }
    
    private void setLanguages(){
        String[] es = { 
                        // Panels
                        "Configuración",
                        "Resultado de la Matriz",
                        "Selector",
                        // Labels
                        "Límite superior",
                        "Límite inferior",
                        "Errores",
                        // Tooltips
                        "Entero de 0 a 100 (por defecto es 100)",
                        "Entero de 0 a 100 (por defecto es 100)",
                        "Seleccione el entero mínimo a mostrar (Por defecto es el Limite inferior)",
                        // Errors
                        "Lim. Inferior.: Debe ser entero\n",
                        "Lim. Superior.: Debe ser entero",
                        "Lím. Superior menor que Lim. Inferior",
                        "Lím. Superior mayor que 100",
                        "Lím. Inferior menor que 0",
                        };
        this.languageMap.put("ES", es);
        
        String[] en = { 
                        // Panels
                        "Configuration",
                        "Matrix Result",
                        "Selector",
                        // Labels
                        "Upper Bound",
                        "Lower Bound",
                        "Errors",
                        // Tooltips
                        "Integer from 0 to 100 (0 by default)",
                        "Integer from 0 to 100 (10 by default)",
                        "Select minimum integer to be displayed (Lower bound by default)",
                        // Errors
                        "Lower Bound: Must be an integer",
                        "Upper Bound: Must be an integer",
                        "Lower Bound bigger than Upper Bound",
                        "Upper Bound cannot be greater than 100",
                        "Lower Bound can not be negative"
                        };
        this.languageMap.put("EN", en);
        
        String[] pl = { 
                        // Panels
                        "Ustawienie",
                        "Wynik Macierczy",
                        "Selektor",
                        // Labels
                        "Górna granica",
                        "Dolna granica",
                        "Błedy",
                        // Tooltips
                        "Liczba całcowita od 0 do 100 (Domyślnie 0)",
                        "Liczba całcowita od 0 do 100 (Domyślnie 10)",
                        "Wybierz minimalną liczbę so wyświetlenia (Domyślnie dolny limit)",
                        // Errors
                        "Dolna granica: musi być liczbą całkowitą\n",
                        "Górna granica: musi być liczbą całkowitą",
                        "Límite Superior menor que Limite Inferior",
                        "Górna granica nie może być większa niż 100",
                        "Dolna granica nie może być ujemna",
                        };
        this.languageMap.put("PL", pl);
    }
}
