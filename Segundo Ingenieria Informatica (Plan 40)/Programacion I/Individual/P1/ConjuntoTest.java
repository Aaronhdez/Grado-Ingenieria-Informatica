import org.junit.*; 
import org.junit.runner.JUnitCore; 
import static org.junit.Assert.*;

// Los conjuntos tienen como máximo 10 elementos. 
// El conjunto no admite elementos repetidos.
public class ConjuntoTest{
    private ConjuntoDeEnteros cnine;        //Conjunto nueve
    private ConjuntoDeEnteros c1;           //Conjunto A
    private ConjuntoDeEnteros c2;           //Conjunto B
    private ConjuntoDeEnteros c3;           //Conjunto D (Negativos)
    private ConjuntoDeEnteros c4;           //Conjunto E (+10)
    private ConjuntoDeEnteros cempty;       //Conjunto F1 vacío
    private ConjuntoDeEnteros cemptyrnd1;   //Conjunto F2 vacío random 1
    private ConjuntoDeEnteros cemptyrnd2;   //Conjunto F3 vacío random 2
    private ConjuntoDeEnteros cunique;      //Conjunto G Unico
    private ConjuntoDeEnteros crep;         //Conjunto H1 Repetidos 1
    private ConjuntoDeEnteros crep2;        //Conjunto H2 Repetidos 2
    private ConjuntoDeEnteros crep3;        //Conjunto H3 Repetidos 3
    private ConjuntoDeEnteros crep4;        //Conjunto H3 Repetidos 4
    private ConjuntoDeEnteros sample;       //Conjunto uniones 
    
    private int[] vector_c1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
    private int[] vector_c2 = new int[]{ 1,2,3,4,5,6,9,10 };
    private int[] vector_c3 = new int[]{ 1,-1,2,-3 };
    private int[] vector_c4 = new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 };
    private int[] vector_cunique = new int[]{ 1 };
    private int[] vector_cempty = new int[0];
    private int[] vector_cemptyrnd1 = new int[4];
    private int[] vector_cemptyrnd2 = new int[]{};
    private int[] vector_rep = new int[]{ 1,2,3,3 };
    private int[] vector_rep2 = new int[]{1,1,1,1,1,1,1,1,1,1,1}; 
    private int[] vector_rep3 = new int[]{1,1,1,1,1,2,2,2,2,2};
    private int[] vector_rep4 = new int[]{1,1,1,1,1,2,2,2,2,1}; 
    private int[] vector_nine = new int[]{ 1,2,3,4,5,6,7,8,9 };
    
    /* TEST MÉTODOS BÁSICOS
    */
    
    //Inicialización de valores basicos
    @Before
    public void testConstructors() {
        cempty = new ConjuntoDeEnteros();   
        c1 = new ConjuntoDeEnteros(vector_c1);
        c2 = new ConjuntoDeEnteros(vector_c2);
        c3 = new ConjuntoDeEnteros(vector_c3);
        c4 = new ConjuntoDeEnteros(vector_c4);
        cunique = new ConjuntoDeEnteros(vector_cunique);
        cemptyrnd1 = new ConjuntoDeEnteros(vector_cemptyrnd1);   
        cemptyrnd2 = new ConjuntoDeEnteros(vector_cemptyrnd2);  
        crep = new ConjuntoDeEnteros(vector_rep); 
        crep2 = new ConjuntoDeEnteros(vector_rep2);  
        crep3 = new ConjuntoDeEnteros(vector_rep3); 
        crep4 = new ConjuntoDeEnteros(vector_rep4);
        cnine = new ConjuntoDeEnteros(vector_nine);
    }

   // @Test
   // public void testElements(){
   //     
   //     System.out.println("\n------ PRUEBAS elementos() ------");
   //     
   //     sample = new ConjuntoDeEnteros(c1.elementos());
   //     assertEquals(c1, sample);
   //     
   //     sample = new ConjuntoDeEnteros(cempty.elementos());
   //     assertEquals(cempty, sample);
   //     
   //     sample = new ConjuntoDeEnteros(cnine.elementos());
   //     assertEquals(cnine, sample);
   //     
   //     sample = new ConjuntoDeEnteros(cunique.elementos());
   //     assertEquals(cunique, sample);
   //     
   //     sample = new ConjuntoDeEnteros(c2.elementos());
   //     assertEquals(c2, sample);
   //     
   //     System.out.println("Hecho \n");
   // }
   // 
   // ///Metodos no matemáticos
   // 
   // @Test
   // public void testCardinal(){
   //     
   //     System.out.println("\n------ PRUEBAS constructores ------");
   //     
   //     assertTrue(c1.cardinal()==10);
   //     assertTrue(c2.cardinal()==8);
   //     assertTrue(c3.cardinal()==3);
   //     assertFalse(c4.cardinal()==11);
   //     assertTrue(cnine.cardinal()==9);
   //     assertTrue(cempty.cardinal()==0);
   //     assertFalse(cemptyrnd1.cardinal()==0);
   //     assertTrue(cemptyrnd2.cardinal()==0);
   //     assertEquals(3,crep.cardinal());
   //     assertEquals(1,crep2.cardinal());
   //     assertEquals(2,crep3.cardinal());
   //     assertEquals(2,crep4.cardinal());
   //     
   //     System.out.println("Hecho \n");
   //     
   // }    
   // 
   // @Test
   // public void testEmpty(){
   //     
   //     System.out.println("\n------ PRUEBAS estaVacio() ------");
//
   //     assertFalse(c1.estáVacío());
   //     assertFalse(cunique.estáVacío());
   //     assertFalse(cnine.estáVacío());
   //     assertFalse(c2.estáVacío());
   //     assertTrue(cempty.estáVacío());
   //     
   //     System.out.println("Hecho \n");
   // }
   // 
   // @Test
   // public void testBelongsTo(){
   //     
   //     System.out.println("\n------ PRUEBAS pertenece() ------");
   //     
   //     assertTrue(c1.pertenece(2));
   //     assertFalse(c1.pertenece(52));
   //     assertTrue(c2.pertenece(2));
   //     assertTrue(cnine.pertenece(9));
   //     assertTrue(cunique.pertenece(1));
   //     assertFalse(cunique.pertenece(2));
   //     assertFalse(c2.pertenece(7));
   //     assertFalse(cempty.pertenece(7));
   //     
   //     System.out.println("Hecho \n");
   // }
   // 
   // @Test
   // public void testEquals(){
   //     
   //     System.out.println("\n------ PRUEBAS equals() ------");
//
   //     assertTrue(c2.equals(c2));
   //     assertTrue(cempty.equals(cempty));
   //     assertTrue(cunique.equals(cunique));
   //     assertFalse(cunique.equals(cempty));
   //     assertFalse(cempty.equals(c2));
   //     assertTrue(cnine.equals(cnine));
   //     assertFalse(cnine.equals(c2));
   //     assertFalse(c1.equals(c2));
   //     assertTrue(cempty.equals(cemptyrnd2));
   //     assertFalse(cempty.equals(c2));
   //     
   //     System.out.println("Hecho \n");
   // }
   // 
   // @Test
   // public void testIsContained(){
   //     
   //     System.out.println("\n------ PRUEBAS contenido() ------");
   //     
   //     assertFalse(cempty.contenido(crep));
   //     assertTrue(cempty.contenido(cemptyrnd2));
   //     assertTrue(cunique.contenido(cunique));
   //     assertTrue(cunique.contenido(cempty));
   //     assertFalse(cnine.contenido(c2));
   //     assertTrue(cnine.contenido(cempty));
   //     assertTrue(c1.contenido(c2));
   //     assertFalse(c2.contenido(c1));
   //     assertTrue(c1.contenido(crep));
   //     assertFalse(crep4.contenido(c1));
   //     assertTrue(c1.contenido(c4));
//
   //     System.out.println("Hecho \n");
   // }
   // 
   // @After
   // public void resetEmpty(){
   //     int[] vector_cempty = new int[0];
   //     cempty = new ConjuntoDeEnteros(); 
   // }
   // 
    @Test
    public void testJoin(){
        
        System.out.println("\n------ PRUEBAS unión() ------");
        
        
        System.out.println(c3.cardinal());
        sample = cempty.unión(cempty);
        assertTrue(sample.cardinal()==0);
        //sample = cempty.unión(c1);
        //assertTrue(sample.cardinal()==10);
        //sample = cempty.unión(cnine);
        //assertTrue(sample.cardinal()==9);
        //sample = cempty.unión(cunique);
        //assertTrue(sample.cardinal()==1);
        //
        int[] samplearray = {1};
        sample = new ConjuntoDeEnteros(samplearray);
        assertEquals(cunique,cunique.unión(sample));
        //sample = cunique.unión(cempty);
        //assertTrue(sample.cardinal()==1);
        //sample = cunique.unión(cnine);
        //assertTrue(sample.cardinal()==9);
        //sample = cunique.unión(c4);
        //assertTrue(sample.cardinal()==10);
        //sample = cunique.unión(c2);
        //assertTrue(sample.cardinal()==8);
        //
        sample = c1.unión(c4);
        assertTrue(sample.cardinal()==10);
        //sample = c1.unión(c2);
        //assertTrue(sample.cardinal()==10);
        //sample = c1.unión(cunique);
        //assertTrue(sample.cardinal()==10);
        //sample = c1.unión(cempty);
        //assertTrue(sample.cardinal()==10);
        //sample = c1.unión(cnine);
        //assertTrue(sample.cardinal()==10);
        //
        sample = c2.unión(c2);
        assertTrue(sample.cardinal()==8);
        //sample = c2.unión(c1);
        //assertTrue(sample.cardinal()==10);
        //sample = c2.unión(cunique);
        //assertTrue(sample.cardinal()==8);
        //sample = c2.unión(cempty);
        //assertTrue(sample.cardinal()==8);        
        //sample = c2.unión(cnine);
        //assertTrue(sample.cardinal()==10);
        //
        sample = cnine.unión(cnine);
        assertTrue(sample.cardinal()==9);
        //sample = cnine.unión(cempty);
        //assertTrue(sample.cardinal()==9);
        //sample = cnine.unión(c1);
        //assertTrue(sample.cardinal()==10);
        //sample = cnine.unión(c2);
        //assertTrue(sample.cardinal()==10);
        //sample = cnine.unión(cunique);
        //assertTrue(sample.cardinal()==9);

        System.out.println("Hecho \n");
    }
   // 
   // @Test
   // public void testIntersection(){
   //     
   //     System.out.println("\n------ PRUEBAS intersección() ------");
   //     
   //     sample = cempty.intersección(crep);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cempty.intersección(cnine);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cempty.intersección(cunique);
   //     assertTrue(sample.cardinal()==0);
   //     
   //     sample = cunique.intersección(cempty);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cunique.intersección(cunique);
   //     assertTrue(sample.cardinal()==1);
   //     sample = cunique.intersección(c1);
   //     assertTrue(sample.cardinal()==1); 
   //     
   //     sample = c1.intersección(c2);
   //     assertTrue(sample.cardinal()==8);
   //     sample = c1.intersección(cunique);
   //     assertTrue(sample.cardinal()==1);
   //     sample = c1.intersección(cempty);
   //     assertTrue(sample.cardinal()==0);  
   //     
   //     sample = c2.intersección(c1);
   //     assertTrue(sample.cardinal()==8);
   //     sample = c2.intersección(cunique);
   //     assertTrue(sample.cardinal()==1);
   //     sample = c2.intersección(cempty);
   //     assertTrue(sample.cardinal()==0);       
   //     
   //     sample = cnine.intersección(cempty);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cnine.intersección(c1);
   //     assertTrue(sample.cardinal()==9);
   //     sample = cnine.intersección(cunique);
   //     assertTrue(sample.cardinal()==1);
   //     
   //     
   //     System.out.println("Hecho \n");
   // }
//
   // @Test
   // public void testDifference(){
   //     
   //     System.out.println("\n------ PRUEBAS diferencia() ------");
   //     
   //     sample = cempty.diferencia(c1);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cempty.diferencia(cnine);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cempty.diferencia(cunique);
   //     assertTrue(sample.cardinal()==0);
   //     
   //     sample = cunique.diferencia(cempty);
   //     assertTrue(sample.cardinal()==1);
   //     sample = cunique.diferencia(cunique);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cunique.diferencia(c1);
   //     assertTrue(sample.cardinal()==0); 
   //     
   //     sample = c1.diferencia(c1);
   //     assertTrue(sample.cardinal()==0);
   //     sample = c1.diferencia(cunique);
   //     assertTrue(sample.cardinal()==9);
   //     sample = c1.diferencia(cempty);
   //     assertTrue(sample.cardinal()==10);  
//
   //     sample = c2.diferencia(c1);
   //     assertTrue(sample.cardinal()==0);
   //     sample = c2.diferencia(cunique);
   //     assertTrue(sample.cardinal()==7);
   //     sample = c2.diferencia(cempty);
   //     assertTrue(sample.cardinal()==8);       
//
   //     sample = cnine.diferencia(cempty);
   //     assertTrue(sample.cardinal()==9);
   //     sample = cnine.diferencia(c1);
   //     assertTrue(sample.cardinal()==0);
   //     sample = cnine.diferencia(cunique);
   //     assertTrue(sample.cardinal()==8);   
   //     
   //     System.out.println("Hecho \n");
   // }
//
//
//
   // @Test
   // public void testAdd(){
   //     
   //     System.out.println("\n------ PRUEBAS añade() ------");
//
   //     assertFalse(c2.añade(1));
   //     assertTrue(c2.añade(7));
   //     assertTrue(cempty.añade(7));
   //     assertFalse(cempty.añade(7));
   //     assertFalse(c1.añade(11));
   //     assertTrue(cnine.añade(12));
   //     assertFalse(cnine.añade(1));
   //     
   //     System.out.println("Hecho \n");
   // }
    

}
