package videoteca.gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 * Clase VideotecaGUI que representa la ventana principal de la videoteca
 * @author Victor, Aaron, Javier
 * NOTA: Al ejecutarse se produce lo que creemos un error de visualizacion
 * que se soluciona aumentando el tamaño de la ventana
 */
public class VideotecaGUI extends JFrame {
    
    private Videoteca videoteca; // Clase Videoteca y Film ya implementadas
    private JTextArea moviesTxt; // Panel de componente area texto
    //------------------------------------------------------------------------//
    //-----------------------CONSTRUCTOR DE LA VENTANA------------------------//
    
    public VideotecaGUI(String t){
        super(t); // Constructor de JFrame
        videoteca = new Videoteca("Mi videoteca"); // Creamos una videoteca
        initVideoteca(videoteca); // La inicializamos con el metodo desarrollado abajo
        
        setLocation(100,50); // Localización
        setSize(550,315);    // Tamaño
        setMinimumSize(new Dimension(200,100)); // Tamaño minimo
        setVisible(true); // Se muestra en pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fin de operacion
        
        Container panel = getContentPane(); // PANEL PRINCIPAL
       
        //--------Botones izquierda---------------------//
        JPanel botones = new JPanel(); // Panel de los botones Añadir y Generos
        // Creamos botones y les asignamos ActionListener
        JButton addbtn = new JButton("Añadir película"); // Boton añadir
        
        //Listener para meter dialogo de añadir pelicula. Clase NewFilmDlg
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                NewFilmDlg dlg = new NewFilmDlg(VideotecaGUI.this); //Instancia de clase
                dlg.setVisible(true); // Se muestra en pantalla
                //Si se pulsa el boton...
                if(dlg.isOk() == true) {
                    //Se añade pelicula con titulo,genero y año especificados por usuario
                    videoteca.add(new Film(dlg.getFilmTitle(),dlg.getGenre(),Integer.parseInt(dlg.getYear())));
                    // Se recarga la videoteca
                    moviesTxt.setText(videoteca.toString());
                }
            }
        });
        
        JButton genrebtn = new JButton("Géneros de películas");//Boton Generos de peliculas
        
        //Listener para meter dialogo de ver peliculas por generos. Clase GenresListDlg
        genrebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new GenresListDlg(VideotecaGUI.this,videoteca);
            }
        });
        
        // Añadimos a panel de botones los botones con ubicacion de BoxLayout
        botones.setLayout(new BoxLayout(botones,BoxLayout.Y_AXIS));
        botones.add(addbtn);
        botones.add(genrebtn);
        //Establecemos Alineacion de los botones en panel botones
        addbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        genrebtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Añadimos botones izquierda a panel principal, indicando su ubicacion
        panel.add(botones,BorderLayout.WEST);
        
        
        //-------Area de Texto---------------------// 
        //Creamos area de texto con las peliculas y localizacion
        moviesTxt = new JTextArea(videoteca.toString(),10,10);
        // Hacemos que no sea editable por usuario y que sea visible
        moviesTxt.setEditable(false);
        moviesTxt.setVisible(true);
        JScrollPane areaScrollPane = new JScrollPane(moviesTxt);//Panel de las barras
        //Scrollbars -> Posiciones Vertical y Horizontal y Tamaño
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //areaScrollPane.setPreferredSize(new Dimension(250, 250));
        //Añadimos area de texto a panel principal, 
        //teniendo por omision ubicacion central 
        panel.add(areaScrollPane);

        
        //-------Botones abajo----------------------//
        JPanel lowerbtn = new JPanel(); // Panel de botones de abajo
        // Creamos botones y les asignamos ActionListener
        JRadioButton titlebtn = new JRadioButton("Por Título",true);//Por defecto seleccionado
        JRadioButton yearbtn = new JRadioButton("Por año");
        
        // Asignamos las funciones a los radio
        // Listener que cambia el orden de las películas al por defecto
        titlebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                videoteca.setOrder(0);
                moviesTxt.setText(videoteca.toString());
                //Recargar la presentación de las películas
            }
        });
        // Listener que cambia el orden de las películas al modificado
        yearbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               videoteca.setOrder(1);
                moviesTxt.setText(videoteca.toString());
            }
        });
        JLabel etiqueta = new JLabel("Orden: "); //Etiqueta previa a botones abajo
        lowerbtn.add(etiqueta); // La añadimos al panel de botones de abajo
        //Grupo de botones donde añadir los Radio Button para que funcionen
        ButtonGroup bg = new ButtonGroup();
        bg.add(titlebtn);
        bg.add(yearbtn);
        //Añadimos a panel botones inferior los botones individualmente, sin el bg
        lowerbtn.add(titlebtn);
        lowerbtn.add(yearbtn);
        // Añadimos botones inferior a panel principal, indicando su ubicacion
        panel.add(lowerbtn,BorderLayout.SOUTH); 
    }
        
    

// DESCOMENTAR PARA INICIALIZAR LA VIDEOTECA
    /**
     * Inicializa la videoteca con películas de varios géneros
     */    private void initVideoteca(Videoteca videoteca){
       videoteca.setOrder(0);
       
       videoteca.add(new Film("Los miserables", "Musical", 2012));
       videoteca.add(new Film("El fantasma de la ópera", "Musical", 2004));
       videoteca.add(new Film("Cantando bajo la lluvia", "Musical", 1952));
       videoteca.add(new Film("Forrest Gump", "Comedia", 1994));
       videoteca.add(new Film("Star Wars: Episodio IV - Una nueva esperanza", "Ciencia ficción", 1977));
       videoteca.add(new Film("Star Wars: Episodio V - El Imperio contraataca", "Ciencia ficción", 1980));
       videoteca.add(new Film("Star Wars: Episodio VI - El regreso del Jedi", "Ciencia ficción", 1983));
       videoteca.add(new Film("Star Wars: Episodio I - La amenaza fantasma", "Ciencia ficción", 1999));
       videoteca.add(new Film("Star Wars: Episodio II - El ataque de los clones", "Ciencia ficción", 2002));
       videoteca.add(new Film("Star Wars: Episodio III - La venganza de los Sith", "Ciencia ficción", 2005));
       videoteca.add(new Film("Star Wars: Episodio VII - El despertar de la Fuerza", "Ciencia ficción", 2015));
       videoteca.add(new Film("Rogue One: Una historia de Star Wars", "Ciencia ficción", 2016));
       videoteca.add(new Film("Lo que el viento se llevó", "Épica", 1939));
       videoteca.add(new Film("Lawrence de Arabia", "Épica", 1962));
       videoteca.add(new Film("La lista de Schindler", "Épica", 1993));
       videoteca.add(new Film("El rey león", "Animación", 1994));
       videoteca.add(new Film("La bella y la bestia", "Animación", 1991));
       videoteca.add(new Film("Buscando a Nemo", "Animación", 2004));
       videoteca.add(new Film("Buscando a Nemo", "Dibujos", 2004));
   }



    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            
        }
        new VideotecaGUI("Mi videoteca");
    }
}