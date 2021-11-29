import org.junit.*;
import static org.junit.Assert.*;

public class ConjuntoTest{
    /*Declaracion de objetos a utilizar en los tests*/
    private ConjuntoDeEnteros c0;
    private ConjuntoDeEnteros c1;
    private ConjuntoDeEnteros c2;
    private ConjuntoDeEnteros c3;
    private ConjuntoDeEnteros c4;
    private ConjuntoDeEnteros c5;
    private ConjuntoDeEnteros c6;
    private ConjuntoDeEnteros c7;
    private ConjuntoDeEnteros c8;
    private ConjuntoDeEnteros c9;
    /*Parametros del constructor*/
    int[] n1 = {1};
    int[] n2 = {1,2};
    int[] n3 = {1,2,3};
    int[] n4 = {1,2,3,4,5,6,7,8,9};
    int[] n5 = {1,2,3,4,5,6,7,8,9,10};
    int[] n6 = {1,2,3,4,5,6,7,8,9,10,11};
    int[] n7 = {-1,2,-3,4};
    int[] n8 = {1,1,2,2,1,1,2,2,3};
    int[] n9 = {-2,-2,-3,-3,4};
    
    @Before
    public void inicializa(){
        /*inicializacion de los objetos para los tests*/
        /*Objeto vacio*/
        c0 = new ConjuntoDeEnteros();
        /*Objetos con uno o varios elementos*/
        c1 = new ConjuntoDeEnteros(n1);
        c2 = new ConjuntoDeEnteros(n2);
        c3 = new ConjuntoDeEnteros(n3);
        /*Objeto con nueve elementos*/
        c4 = new ConjuntoDeEnteros(n4);
        /*Objeto con diez elementos*/
        c5 = new ConjuntoDeEnteros(n5);
        /*Objeto con mas de diez elementos*/
        c6 = new ConjuntoDeEnteros(n6);
        /*Objetos particulares, elementos negativos y repetidos*/
        c7 = new ConjuntoDeEnteros(n7);
        c8 = new ConjuntoDeEnteros(n8);
        c9 = new ConjuntoDeEnteros(n9);
    }
    @Test
    public void pruebaCardinal(){
        /*Prueba cardinal, casos estandar*/
        assertTrue("Fallo en cardinal (c0)",c0.cardinal()==0);
        assertTrue("Fallo en cardinal (c1)",c1.cardinal()==1);
        assertTrue("Fallo en cardinal (c2)",c2.cardinal()==2);
        assertTrue("Fallo en cardinal (c4)",c4.cardinal()==9);
        assertTrue("Fallo en cardinal (c5)",c5.cardinal()==10);
        /*Prueba cardinal, conjunto con mas de diez elementos*/
        assertTrue("Fallo en cardinal (c6)",c6.cardinal()==10);
        assertFalse("Fallo en cardinal (c6)",c6.cardinal()==11);
        /*Prueba cardinal, objetos particulares*/
        assertTrue("Fallo en cardinal (c7)",c7.cardinal()==4);
        assertTrue("Fallo en cardinal (c8)",c8.cardinal()==3);
        assertTrue("Fallo en cardinal (c9)",c9.cardinal()==3);
    }
    @Test
    public void pruebaEstaVacio(){
        /*Prueba estaVacio*/
        assertTrue("Fallo en estáVacío (c0)",c0.estáVacío());
        assertFalse("Fallo en estáVacío (c1)",c1.estáVacío());
        assertFalse("Fallo en estáVacío (c2)",c2.estáVacío());
        assertFalse("Fallo en estáVacío (c4)",c4.estáVacío());
        assertFalse("Fallo en estáVacío (c5)",c5.estáVacío());
        assertFalse("Fallo en estáVacío (c6)",c6.estáVacío());
    }
    @Test
    public void pruebaAñade(){
        /*Parametros de los conjuntos auxiliares*/
        int[] naux1 = {1};
        int[] naux2 = {1,2};
        int[] naux3 = {1,2,3};
        int[] naux4 = {1,2,3,4,5,6,7,8,9,10};
        /*Conjuntos auxiliares, resultado esperado*/
        ConjuntoDeEnteros aux1 = new ConjuntoDeEnteros(naux1);
        ConjuntoDeEnteros aux2 = new ConjuntoDeEnteros(naux2);
        ConjuntoDeEnteros aux3 = new ConjuntoDeEnteros(naux3);
        ConjuntoDeEnteros aux4 = new ConjuntoDeEnteros(naux4);
        /*Prueba añadir un elemento que no se encuentra en el conjunto inicial*/
        assertTrue("Fallo en añade (c0)",c0.añade(1));
        assertTrue("Fallo en añade (c1)",c1.añade(2));
        assertTrue("Fallo en añade (c2)",c2.añade(3));
        assertTrue("Fallo en añade (c4)",c4.añade(10));
        /*Prueba añadir un elemento que se encontraba en el conjunto inicial*/
        assertFalse("Fallo en añade un elemento existente (c1)",c1.añade(2));
        /*Prueba añadir un elemento a un conjunto lleno*/
        assertFalse("Fallo en añade a conjunto lleno (c5)",c5.añade(11));
        /*Comprobacion mediante equals, el resultado es el esperado*/
        assertEquals("Fallo en la comprobacion, metodo añade (c0)",aux1,c0);
        assertEquals("Fallo en la comprobacion, metodo añade (c1)",aux2,c1);
        assertEquals("Fallo en la comprobacion, metodo añade (c2)",aux3,c2);
        assertEquals("Fallo en la comprobacion, metodo añade (c4)",aux4,c4);
        assertEquals("Fallo en la comprobacion, metodo añade (c5)",aux4,c5);
    }
    @Test
    public void pruebaPertenece(){
        /*Prueba pertenece a conjunto vacio*/
        assertFalse("Fallo en pertenece (c0)",c0.pertenece(0));
        /*Prueba pertenece, casos estandar*/
        assertTrue("Fallo en pertenece (c1)",c1.pertenece(1));
        assertTrue("Fallo en pertenece (c2)",c2.pertenece(2));
        assertTrue("Fallo en pertenece (c4)",c4.pertenece(9));
        assertTrue("Fallo en pertenece (c5)",c5.pertenece(10));
        assertFalse("Fallo en pertenece (c5)",c5.pertenece(11));
        /*Prueba pertenece a conjunto lleno*/
        assertFalse("Fallo en pertenece (c6)",c6.pertenece(11));
    }
    @Test
    public void pruebaUnion(){
        /*Parametro del conjunto auxiliar*/
        int[] naux = {1,2,3,4,-1,-3};
        /*Conjunto auxiliar, resultado esperado*/
        ConjuntoDeEnteros aux = new ConjuntoDeEnteros(naux);
        ConjuntoDeEnteros auxVacío = new ConjuntoDeEnteros();
        /*Prueba union*/
        assertEquals("Fallo en unión (c0)(c0)",c0,c0.unión(c0));
        assertEquals("Fallo en unión (c0)(c0)",auxVacío,auxVacío.unión(c0));
        assertEquals("Fallo en unión (c0)(c0)",c2,c2.unión(c0));
        assertEquals("Fallo en unión (c0)(c0)",c2,c0.unión(c2));
        assertEquals("Fallo en unión (c1)(c2)",c2,c1.unión(c2));
        assertEquals("Fallo en unión (c4)(c3)",c4,c4.unión(c3));
        assertEquals("Fallo en unión (c4)(c3)",c4,c3.unión(c4));
        assertEquals("Fallo en unión (c5)(c4)",c5,c5.unión(c4));
        assertEquals("Fallo en unión (c7)(c8)",aux,c7.unión(c8));
    } 
    @Test
    public void pruebaInterseccion(){
        /*Parametro del conjunto auxiliar*/
        int[] naux = {-3,4};
        /*Conjunto auxiliar, resultado esperado*/
        ConjuntoDeEnteros aux = new ConjuntoDeEnteros(naux);
        /*Prueba interseccion*/
        assertEquals("Fallo en intersección (c0)(c1)",c0,c0.intersección(c1));
        assertEquals("Fallo en intersección (c1)(c2)",c1,c1.intersección(c2));
        assertEquals("Fallo en intersección (c2)(c1)",c1,c2.intersección(c1));
        assertEquals("Fallo en intersección (c4)(c3)",c3,c4.intersección(c3));
        assertEquals("Fallo en intersección (c5)(c4)",c4,c5.intersección(c4));
        assertEquals("Fallo en intersección (c9)(c7)",aux,c9.intersección(c7));
    }
    @Test
    public void pruebaDiferencia(){
        /*Parametros de los conjuntos auxiliares*/
        int[] naux0 = {2};
        int[] naux1 = {2,3};
        int[] naux2 = {3,4,5,6,7,8,9};
        int[] naux3 = {4,5,6,7,8,9,10};
        int[] naux4 = {-1,-3,4};
        int[] naux5 = {-2};
        /*Conjuntos auxiliares, resultado esperado*/
        ConjuntoDeEnteros aux0 = new ConjuntoDeEnteros(naux0);
        ConjuntoDeEnteros aux1 = new ConjuntoDeEnteros(naux1);
        ConjuntoDeEnteros aux2 = new ConjuntoDeEnteros(naux2);
        ConjuntoDeEnteros aux3 = new ConjuntoDeEnteros(naux3);
        ConjuntoDeEnteros aux4 = new ConjuntoDeEnteros(naux4);
        ConjuntoDeEnteros aux5 = new ConjuntoDeEnteros(naux5);
        /*Prueba diferencia*/
        assertEquals("Fallo en diferencia (c0)(c1)",c0,c0.diferencia(c1));
        assertEquals("Fallo en diferencia (c1)(c1)",c0,c1.diferencia(c1));
        assertEquals("Fallo en diferencia (c1)(c2)",c0,c1.diferencia(c2));
        assertEquals("Fallo en diferencia (c2)(c1)",aux0,c2.diferencia(c1));
        assertEquals("Fallo en diferencia (c3)(c1)",aux1,c3.diferencia(c1));
        assertEquals("Fallo en diferencia (c4)(c2)",aux2,c4.diferencia(c2));
        assertEquals("Fallo en diferencia (c5)(c3)",aux3,c5.diferencia(c3));
        assertEquals("Fallo en diferencia (c7)(c8)",aux4,c7.diferencia(c8));
        assertEquals("Fallo en diferencia (c9)(c7)",aux5,c9.diferencia(c7));
    }
    @Test
    public void pruebaEquals(){
        /*Prueba equals*/
        assertTrue("Fallo en equals (c0)(c0) ",c0.equals(c0));
        assertTrue("Fallo en equals (c6)(c5)",c6.equals(c5));
        assertFalse("Fallo en equals (c1)(c0)",c1.equals(c0));
        assertFalse("Fallo en equals (c2)(c1)",c2.equals(c1));
        assertFalse("Fallo en equals (c4)(c2))",c4.equals(c2));
    }
    @Test
    public void pruebaContenido(){
        int[] naux = {-1,1,2,-2,-3,4,};
        /*Conjunto auxiliar, constructor sin parametros*/
        ConjuntoDeEnteros aux0 = new ConjuntoDeEnteros();
        ConjuntoDeEnteros aux = new ConjuntoDeEnteros(naux);
        /*Prueba contenido*/
        assertTrue("Fallo en contenido (c0)(aux0)",c0.contenido(aux0));
        assertTrue("Fallo en contenido (c1)(aux0)",c1.contenido(aux0));
        assertTrue("Fallo en contenido (c4)(c1)",c4.contenido(c1));
        assertTrue("Fallo en contenido (c5)(c4)",c5.contenido(c4));
        assertTrue("Fallo en contenido (c6)(c5)",c6.contenido(c5));/*FALSE?*/
        assertTrue("Fallo en contenido (aux)(c7)",aux.contenido(c7));
        assertFalse("Fallo en contenido (c7)(aux)",c7.contenido(aux));
        assertFalse("Fallo en contenido (c1)(c2)",c1.contenido(c2));
        assertFalse("Fallo en contenido (c2)(c3)",c2.contenido(c3));
    }
    @Test
    public void pruebaConstructoresElementos(){
        /*Conjuntos auxiliares, prueba de constructores*/
        ConjuntoDeEnteros aux0 = new ConjuntoDeEnteros(c0.elementos());
        ConjuntoDeEnteros aux1 = new ConjuntoDeEnteros(c1.elementos());
        ConjuntoDeEnteros aux2 = new ConjuntoDeEnteros(c2.elementos());
        ConjuntoDeEnteros aux4 = new ConjuntoDeEnteros(c4.elementos());
        ConjuntoDeEnteros aux5 = new ConjuntoDeEnteros(c5.elementos());
        ConjuntoDeEnteros aux6 = new ConjuntoDeEnteros(c6.elementos());
        /*Prueba elementos a partir de los constructores*/
        assertEquals("Fallo en elementos (aux0)(c0))",aux0,c0);
        assertEquals("Fallo en elementos (aux1)(c1))",aux1,c1);
        assertEquals("Fallo en elementos (aux2)(c2))",aux2,c2);
        assertEquals("Fallo en elementos (aux4)(c4))",aux4,c4);
        assertEquals("Fallo en elementos (aux5)(c5))",aux5,c5);
        assertEquals("Fallo en elementos (aux6)(c6))",aux6,c6);
    }
}