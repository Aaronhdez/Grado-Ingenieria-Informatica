package videoteca.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GenresListDlg extends JDialog {
    private JPanel panel;
    private JTextArea areaTexto;
    
    public GenresListDlg(JFrame f,Videoteca videoteca){
        super(f,"Lista de Generos");
        this.setVisible(true);
        this.setSize(400,400);
        this.setLocation(100,50);
        panel = new JPanel();
        this.getContentPane().add(panel);
        areaTexto = new JTextArea(videoteca.getGenres().toString(),0,30);
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        panel.add(scroll);
    }
}