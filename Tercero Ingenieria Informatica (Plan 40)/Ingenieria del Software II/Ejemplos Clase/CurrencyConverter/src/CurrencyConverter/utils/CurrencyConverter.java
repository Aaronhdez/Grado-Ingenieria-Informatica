/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyConverter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CurrencyConverter implements CurrencyConvert{
    /**
     * Pasive Atributes
     */
    
    private final double fromValue;
    private final String from;
    private final String to;

    /**
     * Default constructor
     */
    public CurrencyConverter(){
        this.fromValue = 0;
        this.from = "";
        this.to = "";
    }    

    /**
     * Constructor with parameters
     * @param from
     * @param to
     * @param fromValue
     */
    public CurrencyConverter(String from, String to, double fromValue){
        this.fromValue = fromValue;
        this.from = from;
        this.to = to;
    }
    
    public double getFromValue(){
        return this.fromValue;
    }
    
    /**
     * En interfaz gráfica
     * @return 
     * @throws java.io.IOException 
     */
    @Override
    public double convert() throws IOException{
        try {
            URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    this.from + "_" + this.to + "&compact=y");
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return this.fromValue*(Double.parseDouble(line1));
        }   catch (IOException | NumberFormatException ex) {
            Logger.getLogger(CurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
        
        }
        return 0;
    }
    
}
