/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyConverter.FileManager;

import CurrencyConverter.utils.Currency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class CurrencyFileManager {
    
    List<Currency> currenciesFromCSV;
    
    public CurrencyFileManager(){
        this.currenciesFromCSV = new ArrayList<Currency>();
        try {
            init(this.currenciesFromCSV);
        } catch (Exception ex) {
            Logger.getLogger(CurrencyFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param currenciesFromCSV
     * @throws Exception 
     */
    private static void init(List<Currency> currenciesFromCSV) throws Exception{
        File file = new File("./files/assets/currencies.txt");
        FileInputStream fsr = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fsr, "cp1252");
        BufferedReader buffer = new BufferedReader(isr);
        try{
            String line = buffer.readLine();
            while(line != null){
                String tag = line.substring(0, line.indexOf(";"));
                line = line.substring(line.indexOf(";")+1, line.length());
                String name = line.substring(0,line.indexOf(";"));
                
                Currency newCurrency = new Currency(name, tag);
                currenciesFromCSV.add(newCurrency);
                line = buffer.readLine();
            }
        }catch(Exception e1){
            System.out.print(e1);
        } finally {
            try {
                fsr.close();
            } catch(Exception e2) {
                System.out.print(e2);
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    public List<Currency> returnCurrencies(){
        return this.currenciesFromCSV;
    }
}
