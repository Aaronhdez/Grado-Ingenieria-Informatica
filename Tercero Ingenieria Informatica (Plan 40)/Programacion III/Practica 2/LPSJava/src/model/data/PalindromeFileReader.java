package model.data;

import model.Palindrome;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PalindromeFileReader {
    private final String file;

    public PalindromeFileReader(String file) {
        this.file = file;
    }
   
    public Palindrome load(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(file)));
            String aux = "";
            return new Palindrome(reader.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PalindromeFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PalindromeFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
