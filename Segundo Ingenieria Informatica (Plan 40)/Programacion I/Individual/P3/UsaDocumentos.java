import java.util.Date;
import java.util.GregorianCalendar;
public class UsaDocumentos {
    public static void main (String[] args) {
        //org.junit.runner.JUnitCore.main("ComponentesTest");
        ComponenteFecha f1;
        ComponenteFecha f2;
        ComponenteFecha f3;
        long segundosDía = 60 * 60 * 24;
//        ComponenteCompuesto p,d;
        Date hoy = new Date();
        Date hoy2 = new 
//        p = new ComponenteCompuesto();
//        p.añade(new ComponenteTexto("Ristra "));
//        p.añade(new ComponenteNumero(1));
//        p.añade(new ComponenteTexto("\n"));
//        p.añade(new ComponenteTexto("Fecha de hoy "));
        f1 = new ComponenteFecha(hoy);
//        p.añade(new ComponenteTexto("\n"));
//        p.añade(new ComponenteTexto("Fecha de ayer "));
        f2 = new ComponenteFecha(new Date(hoy.getTime() - segundosDía*1*1000));
//        p.añade(new ComponenteTexto("\n"));
//        p.añade(new ComponenteTexto("Fecha de hace 30 días ("));
//        p.añade(new ComponenteNumero(86400 * 30));
//        p.añade(new ComponenteTexto(" seg) "));
        f3 = new ComponenteFecha(new Date(hoy.getTime() - (segundosDía*30*1000)));
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println("Printeo de P \n");
//        System.out.println("Printeo de P \n");
//        p.añade(new ComponenteTexto("\n"));
//        System.out.println("Printeo de P \n");
//        System.out.print(p);
//        System.out.println("\n");
//        d = new ComponenteCompuesto();
//        d.añade(new ComponenteTexto("Componente de prueba"));
//        d.añade(new ComponenteTexto("\n"));
//        d.añade(new ComponenteTexto("\n"));
//        d.añade(p);
//        d.añade(new ComponenteTexto("Fin componente de prueba"));
//        
//        //System.out.println("1er Printeo de d \n");
//        //System.out.println(d);
//        System.out.println("Número de caracteres " + d.nCaracteres());
//        System.out.println("Número de palabras " + d.nPalabras());
//        System.out.println("\n");
//        d.modifica(0, new ComponenteTexto("Inicio modificado"));
//        
//        System.out.println("2do Printeo de d \n");
//        System.out.println(d);
//        System.out.println("\n");
//        System.out.println("Número de caracteres " + d.nCaracteres());
//        System.out.println("Número de palabras " + d.nPalabras());
    }
}