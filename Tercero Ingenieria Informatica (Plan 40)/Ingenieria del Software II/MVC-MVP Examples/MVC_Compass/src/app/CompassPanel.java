package app;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import model.CompassSample;
import view.CompassDisplay;


public class CompassPanel extends JPanel implements CompassDisplay {

    private CompassSample compassSample;
    private JTextPane txt;
     
    public CompassPanel() {
    }
    
    public void initialize() {
        this.txt = new JTextPane();
        this.txt.setText("--");
        this.txt.setEditable(false);
        this.txt.setComponentOrientation(ComponentOrientation.UNKNOWN);
        this.txt.setFont(new Font("Segoe Script", Font.BOLD, 90));
        this.add(this.txt);
        this.setBackground(Color.WHITE);
    }

    @Override
    public void display(CompassSample compassSample) {
        this.compassSample = compassSample;
        this.initialize();
    }

    @Override
    public void change() {
        //System.out.println(this.compassSample.getSample());
        this.txt.setText(this.compassSample.getSample()+"");
    }

    @Override
    public void reload() {
        this.txt.setText("--");
    }
}
