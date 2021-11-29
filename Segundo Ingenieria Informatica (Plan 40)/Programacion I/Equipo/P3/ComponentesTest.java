import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class ComponentesTest {
    
    //-----------------------Atributos para usar en el test---------------//
    //ComponenteTexto
    private ComponenteTexto text1;
    private ComponenteTexto text2;
    private ComponenteTexto text3;
    private ComponenteTexto text4;
    
    //ComponenteNumero
    private ComponenteNumero num1;
    private ComponenteNumero num2;
    private ComponenteNumero num3;
    private ComponenteNumero num4;
    
    //ComponenteFecha
    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4; 
    
    private ComponenteFecha fecha1;
    private ComponenteFecha fecha2;
    private ComponenteFecha fecha3;
    private ComponenteFecha fecha4;
    
    //ComponenteCompuesto
    private ComponenteCompuesto compuesto1;
    private ComponenteCompuesto compuesto2;    

    //Inicializador
    @Before
    public void StartTest(){
        text1 = new ComponenteTexto("Prueba de texto");
        text2 = new ComponenteTexto("hola");
        text3 = new ComponenteTexto("\n");
        text4 = new ComponenteTexto("");
        
        num1 = new ComponenteNumero(0);
        num2 = new ComponenteNumero(5);
        num3 = new ComponenteNumero(23);
        num4 = new ComponenteNumero(532);
        
        long segundosDía = 60*60*24; 
        
        date1 = new Date();
        date2 = new Date(date1.getTime()-(segundosDía*1000)); 
        date3 = new Date(date1.getTime()-(segundosDía*30*1000));
        date4 = new Date(date1.getTime()-(segundosDía*30*1000));
        
        fecha1 = new ComponenteFecha(date1);
        fecha2 = new ComponenteFecha(date2);
        fecha3 = new ComponenteFecha(date3);
        fecha4 = new ComponenteFecha(date4);
    }
    
    //------------------------PRUEBA CONSTRUCTORES--------------------//
    @Test
    public void testConstructores() {
        //Pruebas mismo objeto
        assertTrue("Fallo en construcion text1->text1",text1==text1);
        assertTrue("Fallo en construcion text2->text2",text2==text2);
        assertTrue("Fallo en construcion text3->text3",text3==text3);
        assertTrue("Fallo en construcion text1->text1",text1==text1);

        assertTrue("Fallo en construcion num1->num1",num1==num1);
        assertTrue("Fallo en construcion num2->num2",num2==num2);
        assertTrue("Fallo en construcion num3->num3",num3==num3);
    
        System.out.println("Pruebas 1 constructores pasadas \n");    
        
        //Pruebas objetos misma subclase
        assertFalse("Fallo en construcion text1->text2",text1==text2);
        assertFalse("Fallo en construcion text2->text1",text2==text1);
        assertFalse("Fallo en construcion num1->num2",num1==num2);
        assertFalse("Fallo en construcion num2->num1",num2==num1);
    
        System.out.println("Pruebas 2 constructores pasadas \n");
        
        //Pruebas fecha
        assertTrue("Fallo en construcion fecha1->fecha1",fecha1==fecha1);
        assertTrue("Fallo en construcion fecha2->fecha2",fecha2==fecha2);
        assertFalse("Fallo en construcion fecha1->fecha2",fecha1==fecha2);
        assertFalse("Fallo en construcion fecha2->fecha1",fecha2==fecha1);
        
        System.out.println("Pruebas 3 constructores pasadas \n");
        
    }
    
    //------------------------PRUEBAS NCARACTERES()--------------------//
    @Test
    public void testnCaracteres() {
        //Pruebas texto
        assertEquals("Fallo en prueba texto1: 'Prueba de texto' = 13",13,text1.nCaracteres());
        assertEquals("Fallo en prueba texto2: 'hola' = 4",4,text2.nCaracteres());
        assertEquals("Fallo en prueba texto3: '\n' = 1",1,text3.nCaracteres());
        assertEquals("Fallo en prueba texto4: '' = 0",0,text4.nCaracteres());
    
        System.out.println("Pruebas sobre texto nCaracteres() pasadas \n");    
        
        //Pruebas numeros
        assertEquals("Fallo en prueba numero1: '0' = 1",1,num1.nCaracteres());
        assertEquals("Fallo en prueba numero2: '5 = 1",1,num2.nCaracteres());
        assertEquals("Fallo en prueba numero3: '23' = 2",2,num3.nCaracteres());
        assertEquals("Fallo en prueba numero4: '532' = 3",3,num4.nCaracteres());
    
        System.out.println("Pruebas sobre numero nCaracteres() pasadas \n");
        
        //Pruebas fecha: INFO: hay que modificar los valores de caracteres debido a que Date() SE ACTUALIZA
        assertEquals("Fallo en prueba fecha1: '11/11/2019' = 10",10,fecha1.nCaracteres());
        assertEquals("Fallo en prueba fecha2: '10/11/2019 = 10",10,fecha2.nCaracteres());
        assertEquals("Fallo en prueba fecha3: '12/10/2019' = 10",10,fecha3.nCaracteres());
        assertEquals("Fallo en prueba fecha4: '12/10/2019' = 10",10,fecha4.nCaracteres());
    
        System.out.println("Pruebas sobre fecha nCaracteres() pasadas \n");
    }
    
    //------------------------PRUEBAS NPALABRAS()--------------------//
    @Test
    public void testnPalabras() {
        //Pruebas texto
        assertEquals("Fallo en prueba texto1: 'Prueba de texto' = 3",3,text1.nPalabras());
        assertEquals("Fallo en prueba texto2: 'hola' = 1",1,text2.nPalabras());
        assertEquals("Fallo en prueba texto3: '\n' = 1",1,text3.nPalabras());
        assertEquals("Fallo en prueba texto4: '' = 0",0,text4.nPalabras());
    
        System.out.println("Pruebas sobre texto nPalabras() pasadas \n");    
        
        //Pruebas numero
        assertEquals("Fallo en prueba numero1: '0' = 1",1,num1.nPalabras());
        assertEquals("Fallo en prueba numero2: '5 = 1",1,num2.nPalabras());
        assertEquals("Fallo en prueba numero3: '23' = 1",1,num3.nPalabras());
        assertEquals("Fallo en prueba numero4: '532' = 1",1,num4.nPalabras());
    
        System.out.println("Pruebas sobre numero nPalabras() pasadas \n");
        
        //Pruebas fecha: INFO: hay que modificar los valores de caracteres debido a que Date() SE ACTUALIZA
        assertEquals("Fallo en prueba fecha1: '11/11/2019' = 1",1,fecha1.nPalabras());
        assertEquals("Fallo en prueba fecha2: '10/11/2019 = 1",1,fecha2.nPalabras());
        assertEquals("Fallo en prueba fecha3: '12/10/2019' = 1",1,fecha3.nPalabras());
        assertEquals("Fallo en prueba fecha4: '12/10/2019' = 1",1,fecha4.nPalabras());
    
        System.out.println("Pruebas sobre fecha nPalabras() pasadas \n");        
    }

    //------------------------PRUEBAS TOSTRING()--------------------//
    @Test
    public void testtoString() {
        //Pruebas texto
        String textop1 = "Prueba de texto";
        String textop2 = "hola";
        String textop3 = "\n";
        String textop4 = "";
        
        assertTrue("Fallo en prueba texto1",textop1.equals(text1.toString()));
        assertTrue("Fallo en prueba texto2: 'hola' = 1",textop2.equals(text2.toString()));
        assertTrue("Fallo en prueba texto3: '\n' = 1",textop3.equals(text3.toString()));
        assertTrue("Fallo en prueba texto4: '' = 0",textop4.equals(text4.toString()));
        assertFalse("Fallo en prueba texto1",textop4.equals(text1.toString()));
        assertFalse("Fallo en prueba texto2: 'hola' = 1",textop3.equals(text2.toString()));
        assertFalse("Fallo en prueba texto3: '\n' = 1",textop2.equals(text3.toString()));
        assertFalse("Fallo en prueba texto4: '' = 0",textop1.equals(text4.toString()));
        
        System.out.println("Pruebas sobre texto toString() pasadas \n");    
        
        //Pruebas numero
        String nump1 = "0";
        String nump2 = "5";
        String nump3 = "23";
        String nump4 = "532";
        
        assertTrue("Fallo en prueba numero1: '0' = 1",nump1.equals(num1.toString()));
        assertTrue("Fallo en prueba numero2: '5 = 1",nump2.equals(num2.toString()));
        assertTrue("Fallo en prueba numero3: '23' = 1",nump3.equals(num3.toString()));
        assertTrue("Fallo en prueba numero4: '532' = 1",nump4.equals(num4.toString()));
        assertFalse("Fallo en prueba numero1: '0' = 1",nump4.equals(num1.toString()));
        assertFalse("Fallo en prueba numero2: '5 = 1",nump3.equals(num2.toString()));
        assertFalse("Fallo en prueba numero3: '23' = 1",nump2.equals(num3.toString()));
        assertFalse("Fallo en prueba numero4: '532' = 1",nump1.equals(num4.toString()));
    
        System.out.println("Pruebas sobre numero toString() pasadas \n");
    }
    
    //------------------------PRUEBAS COPIA()--------------------//
    @Test
    public void testCopia() {
        ComponenteTexto copiaText;
        ComponenteNumero copiaNum;
        ComponenteFecha copiaFecha;
        ComponenteCompuesto copiaCompuesto;
        
        //Pruebas texto;
        copiaText = (ComponenteTexto) text1.copia();
        String texto = text1.toString();
        assertTrue("Fallo en copia text1: distinto texto",texto.equals(copiaText.toString()));
        assertFalse("Fallo en copia text1: misma referencia",copiaText==text1);
    
        copiaText = (ComponenteTexto) text2.copia();
        texto = text2.toString();
        assertTrue("Fallo en copia text2: distinto texto",texto.equals(copiaText.toString()));
        assertFalse("Fallo en copia text2: misma referencia",copiaText==text2);

        copiaText = (ComponenteTexto) text3.copia();
        texto = text3.toString();
        assertTrue("Fallo en copia text3: distinto texto",texto.equals(copiaText.toString()));
        assertFalse("Fallo en copia text3: misma referencia",copiaText==text3);
        
        System.out.println("Pruebas toString() texto pasadas \n");
        
        //Pruebas numero;
        copiaNum = (ComponenteNumero) num1.copia();
        String numero = num1.toString();
        assertTrue("Fallo en copia text1: distinto texto",numero.equals(copiaNum.toString()));
        assertFalse("Fallo en copia text1: misma referencia",copiaNum==num1);
    
        System.out.println("Pruebas toString() texto pasadas \n");

        //Pruebas fecha;
        copiaFecha = (ComponenteFecha) fecha3.copia();
        String fecha = fecha3.toString();
        assertTrue("Fallo en copia fecha1: distinto texto",fecha.equals(copiaFecha.toString()));
        assertFalse("Fallo en copia fecha1: misma referencia",copiaFecha==fecha3);
        
        //System.out.println("Pruebas toString() texto pasadas \n");
        
    }
        
    //------------------------PRUEBAS COMPUESTOS--------------------//
    @Test
    public void testCompuestos() {
        
        compuesto1 = new ComponenteCompuesto();
        compuesto2 = new ComponenteCompuesto();
        
        
        ///Pruebas añade, nPalabras, nCaracteres, cardinal y toString
        compuesto1.añade(text1);
        String texto = "Prueba de texto";
        assertTrue("Fallo en compuesto1: ", texto.equals(compuesto1.toString()));
        assertEquals("Fallo cardinal compuesto1:",1,compuesto1.cardinal());
        assertEquals("Fallo numero palabras compuesto1:",3,compuesto1.nPalabras());
        
        compuesto1.añade(num4);
        texto += "532";
        assertTrue("Fallo en compuesto1: ", texto.equals(compuesto1.toString()));
        assertEquals("Fallo cardinal compuesto1:",2,compuesto1.cardinal());
        assertEquals("Fallo numero palabras compuesto1:",4,compuesto1.nPalabras());
        
        compuesto1.añade(text3);
        texto += "\n";
        assertTrue("Fallo en compuesto1: ", texto.equals(compuesto1.toString()));
        assertEquals("Fallo cardinal compuesto1:",3,compuesto1.cardinal());
        assertEquals("Fallo numero palabras compuesto1:",5,compuesto1.nPalabras());
        
        System.out.println("Pruebas comparacion añade, nPalabras, nCaracteres, cardinal y toString pasadas \n");    
        
        ///Pruebas copia
        compuesto2 = (ComponenteCompuesto) compuesto1.copia();
        assertFalse("Fallo en copia de compuestos", compuesto2 == compuesto1);
        String comparar = compuesto1.toString();
        assertTrue("Fallo en copia de compuestos", comparar.equals(compuesto2.toString()));
    
        System.out.println("Pruebas comparacion compuestos pasadas \n");
        
        ///Pruebas modifica
        compuesto1.modifica(2, text1);
        texto = "Prueba de texto" + "532" + "Prueba de texto";
        assertTrue("Fallo en compuesto1 (mod):", texto.equals(compuesto1.toString()));
        assertEquals("Fallo cardinal compuesto1 (mod):",3,compuesto1.cardinal());
        assertEquals("Fallo numero palabras compuesto1 (mod):",7,compuesto1.nPalabras());
        
        compuesto2 = compuesto1;
        compuesto2.modifica(3, text1);
        assertEquals("Fallo en modificacion con posicion fuera de rango", compuesto2, compuesto1);
        System.out.println("Pruebas modificacion compuestos pasadas \n");    
    }













}