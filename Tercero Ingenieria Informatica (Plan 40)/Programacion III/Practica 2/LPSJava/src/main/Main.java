package main;

import algorithm.Memoization;
import algorithm.Tabulation;
import model.data.PalindromeFileReader;
import model.Palindrome;
import model.HelpMenu;
import persistence.algorithm.ProgramingStrategy;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Main {
    
    public static void main(String[] args) {
        manageArgs(args);
        process();
    }
    
    //Gestiona los argumentos
    private static void manageArgs(String[] args){
        List<String> arguments = new ArrayList<>();
        arguments.addAll(Arrays.asList(args));
        
        //Verificamos si el fichero o el directorio existen
        if(arguments.contains("-f")){
            Path path = Paths.get(arguments.get(arguments.lastIndexOf("-f")+1));
            if (Files.exists(path)){
                Globals.FILE_SOURCE = arguments.get(arguments.lastIndexOf("-f")+1);
                Globals.FILE_MODE=true;
            }
        }
        
        if(arguments.contains("-d")){
            Path path = Paths.get(arguments.get(arguments.lastIndexOf("-d")+1));
            if (Files.isDirectory(path)){
                Globals.DIR_SOURCE = arguments.get(arguments.lastIndexOf("-d")+1);
                Globals.DIR_MODE=true;
            }
        }
        
        boolean flag = false;
        //Comprobamos qu� parametros est�n especificados y los asignamos a las constantes
        if(arguments.contains("-st")){
            Globals.TABULATION = true;       //Opci�n de tabulacion
            flag = true;
        }
        if(arguments.contains("-sm")){
            Globals.MEMOIZATION = true;     //Opci�n de memoization
            flag = true;
        }
                
        Globals.CHECK = arguments.contains("--check");       
        Globals.DISPLAY_HELP = arguments.contains("-h");    //Men� de ayuda
        Globals.SHOW_TIME = arguments.contains("-t");       //Opción de tiempo
    }
    
    //Procesa los argumentos gestionados
    private static void process(){
        
        //Si se puls� la ayuda, salimos de la aplicaci�n mostrando la ayuda
        if(Globals.DISPLAY_HELP){
            new HelpMenu().display();
            return;
        }
        
        //Si se epecific� la opci�n -d
        if(Globals.DIR_MODE){
            File folder = new File(Globals.DIR_SOURCE);
            List<File> fileList = Arrays.asList(folder.listFiles());
            for (File f : fileList) {
                Globals.COMPUTING_TIME = System.currentTimeMillis();
                System.out.println("=============================");
                System.out.println("ARCHIVO: "+ f.getName());
                System.out.println("*****************************");
                startFileProcess(f.getPath());
            }
            System.out.println("=============================");
        }
        
        //Si el fichero es uno, disparamos el 
        
        if(Globals.FILE_MODE){
            startFileProcess(Globals.FILE_SOURCE);
        }  
    }
    
    //Inicia los c�lculos seg�n los argumentos procesados
    private static void startFileProcess(String file){
            Palindrome candidate = new PalindromeFileReader(file).load();
            ProgramingStrategy ps;
            StringBuilder sb = new StringBuilder(candidate.getText());
            if(Globals.MEMOIZATION){
                ps = new Memoization(candidate.getText(), 0, candidate.getText().length()-1);
            } else {
                ps = new Tabulation(candidate.getText(), sb.reverse().toString(), 
                        candidate.getText().length(), candidate.getText().length());
            }
            ps.process();
            
            display(ps, candidate);
    }
    
    private static void display(ProgramingStrategy ps, Palindrome candidate){
            System.out.println("Para el candidato: " + candidate.getText() + "\nSe encuentran los siguientes resultados:\n");
            System.out.println("Maxima Longitud: " + ps.getLongest());
            System.out.println("Palindromo resultante: " + ps.getPalindrome());
            
            if (Globals.CHECK) { 
                if(ps instanceof Memoization){
                    StringBuilder sb = new StringBuilder(candidate.getText());
                    ProgramingStrategy ps2 = new Tabulation(candidate.getText(), sb.reverse().toString(), 
                        candidate.getText().length(), candidate.getText().length());
                    ps2.process();
                    System.out.println("\nVerificación con Tabulation");
                    System.out.println("Máximo: " + ps2.getLongest());
                    System.out.println("Palíndromo escogido: " + ps2.getPalindrome());
                } else {
                    ProgramingStrategy ps2 = new Memoization(candidate.getText(), 0, candidate.getText().length()-1);
                    ps2.process();
                    System.out.println("\nVerificación con Memoization");
                    System.out.println("Máximo: " + ps2.getLongest());
                    System.out.println("Palíndromo escogido: " + ps2.getPalindrome());
                }
            }  
            
            if (Globals.SHOW_TIME) { 
                System.out.println("Tiempo de ejecución completo (microsegundos): " + ((float)(System.currentTimeMillis() - Globals.COMPUTING_TIME)/1000));
            }
            System.out.println("");
    }
}
