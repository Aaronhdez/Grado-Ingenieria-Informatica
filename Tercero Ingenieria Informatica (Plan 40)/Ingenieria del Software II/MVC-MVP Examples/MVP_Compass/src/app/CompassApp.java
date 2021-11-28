package app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.CompassSample;
import presenter.CompassPresenter;
import view.CompassDisplay;
import view.CompassPanel;


public class CompassApp extends JFrame {
    
    public static void main(String[] args) {
        new CompassApp();
    }
    
    private CompassDisplay compassDisplay;
    private CompassPresenter compassPresenter;

    public CompassApp() {
        this.execute();
    }
    
    public void execute() {
        //this.compass = new CompassSample();
        this.compassDisplay = new CompassPanel();
        this.compassPresenter = new CompassPresenter(new CompassSample(), this.compassDisplay);
        //this.compass.register(compassDisplay);
        //this.compassDisplay.display(compass);
        //this.sensor = new CompassSensor(this.compass);
        this.design();
    }

    private void design() {
        this.setTitle("Trilero MVP");
        this.setLayout(new BorderLayout());
        this.upperPanel();
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void upperPanel() {
        this.add((Component) compassDisplay, BorderLayout.CENTER);
    }
}
