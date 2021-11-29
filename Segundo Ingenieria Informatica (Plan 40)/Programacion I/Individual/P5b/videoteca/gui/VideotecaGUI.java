package videoteca.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase VideotecaGUI que representa la ventana principal de la videoteca
 */
public class VideotecaGUI extends JFrame {
    
    
    // Listener que valida los datos de la nueva película
    private ActionListener addHandler= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    };

    // Listener que descarta los datos de la nueva película
    private ActionListener genreHandler= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    };
    
    // Listener que descarta los datos de la nueva película
    private ActionListener orderByTitle= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    };
    
    // Listener que descarta los datos de la nueva película
    private ActionListener orderByYear= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    };
    
    public VideotecaGUI(String t){
        super(t);

        setSize(500,315);
        setMinimumSize(new Dimension(200,100));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = new JPanel(new BorderLayout());
        contentPane = getContentPane();
        
        // Se crean los botones de interacción con el diálogo
        JButton addBtn = new JButton("Añadir Película");
        addBtn.addActionListener(addHandler);
        JButton genresBtn = new JButton("Géneros de Películas");
        genresBtn.addActionListener(genreHandler);
        
        // Interfaz del panel principal al que se le añaden los componentes visuales
        contentPane.add(addBtn);
        contentPane.add(genresBtn);
        
        //Panel izquierdo
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.add(addBtn);
        buttons.add(genresBtn);
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        genresBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(buttons, BorderLayout.WEST);
        
        //Panel derecho
        //Meterlo dentro de un JtextPanel
        JTextPane movies = new JTextPane();
        JTextArea moviesTxa = new JTextArea("This is an editable JTextArea. " +
                                            "A text area is a \"plain\" text component, " +
                                            "which means that although it can display text " +
                                            "in any font, all of the text is in the same font.");
        movies.add(moviesTxa);
        JScrollPane scrollPane = new JScrollPane(movies); 
        moviesTxa.setEditable(false);
        movies.setEditable(false);
        contentPane.add(movies);
        
        // Zona de botones inferior
        JPanel lowerButtons = new JPanel();
        
        // Creamos los radio
        JRadioButton byTitle = new JRadioButton("Por título", true);
        JRadioButton byYear = new JRadioButton("Por año");
        
        // Asignamos las funciones a los radio
        byTitle.addActionListener(orderByTitle);
        byYear.addActionListener(orderByYear);
        
        //Creamos el grupo de botones y añadimos radio 1 y radio 2
        ButtonGroup radioPanel = new ButtonGroup();
        radioPanel.add(byTitle);
        radioPanel.add(byYear);
        
        //Añadimos los botones uno por uno al panel (el BG no es un componente)
        lowerButtons.add(byTitle);
        lowerButtons.add(byYear);
        
        //Añadimos el nuevo panel de botones a la aplicación.
        contentPane.add(lowerButtons, BorderLayout.SOUTH);

    }

// DESCOMENTAR PARA INICIALIZAR LA VIDEOTECA
    /**
     * Inicializa la videoteca con películas de varios géneros
     */ 
//    private void initVideoteca(Videoteca videoteca){
//        videoteca.setOrder(0);
//        
//        videoteca.add(new Film("Los miserables", "Musical", 2012));
//        videoteca.add(new Film("El fantasma de la ópera", "Musical", 2004));
//        videoteca.add(new Film("Cantando bajo la lluvia", "Musical", 1952));
//        videoteca.add(new Film("Forrest Gump", "Comedia", 1994));
//        videoteca.add(new Film("Star Wars: Episodio IV - Una nueva esperanza", "Ciencia ficción", 1977));
//        videoteca.add(new Film("Star Wars: Episodio V - El Imperio contraataca", "Ciencia ficción", 1980));
//        videoteca.add(new Film("Star Wars: Episodio VI - El regreso del Jedi", "Ciencia ficción", 1983));
//        videoteca.add(new Film("Star Wars: Episodio I - La amenaza fantasma", "Ciencia ficción", 1999));
//        videoteca.add(new Film("Star Wars: Episodio II - El ataque de los clones", "Ciencia ficción", 2002));
//        videoteca.add(new Film("Star Wars: Episodio III - La venganza de los Sith", "Ciencia ficción", 2005));
//        videoteca.add(new Film("Star Wars: Episodio VII - El despertar de la Fuerza", "Ciencia ficción", 2015));
//        videoteca.add(new Film("Rogue One: Una historia de Star Wars", "Ciencia ficción", 2016));
//        videoteca.add(new Film("Lo que el viento se llevó", "Épica", 1939));
//        videoteca.add(new Film("Lawrence de Arabia", "Épica", 1962));
//        videoteca.add(new Film("La lista de Schindler", "Épica", 1993));
//        videoteca.add(new Film("El rey león", "Animación", 1994));
//        videoteca.add(new Film("La bella y la bestia", "Animación", 1991));
//        videoteca.add(new Film("Buscando a Nemo", "Animación", 2004));
//        videoteca.add(new Film("Buscando a Nemo", "Dibujos", 2004));
//    }



    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            
        }
        new VideotecaGUI("Mi videoteca");
    }
}
