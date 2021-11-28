package model;

/**
 *
 * @author Usuario
 */
public class HelpMenu {

    public HelpMenu() {
    }
    
    public void display(){
        System.out.println("Bienvenido al menu de ayuda de la subsecuencia palindrómica más larga");
        System.out.println("Estos son los argumentos opcionales: ");
        System.out.println("-f Especificar el nombre de un fichero con los datos "
                           + "de entrada del algoritmo");
        System.out.println("-d Especificar un directorio con el conjunto de ficheros a procesar");
        System.out.println("-sm Especificar que los cálculos se resuelvan usando Memoization"
                + "");
        System.out.println("-st Especificar que los cálculos se resuelvan usando Tabulation");
        System.out.println("--check Dispara el método contrario al elegido y verifica que sus resultados son iguales");
        System.out.println("-t Mostrar el tiempo en segundos de ejecucion");
        System.out.println("-h Menu de ayuda");
    }
}
