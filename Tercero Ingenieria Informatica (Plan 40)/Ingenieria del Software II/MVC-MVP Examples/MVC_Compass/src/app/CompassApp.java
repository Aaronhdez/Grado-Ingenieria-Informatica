package app;

import controller.Command;
import controller.SamplingCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.CompassSample;
import view.CompassDisplay;


public class CompassApp extends JFrame {
    
    public static void main(String[] args) {
        new CompassApp();
    }
    
    private CompassSample compass;
    private CompassSensor sensor;
    private CompassDisplay compassDisplay;
    private HashMap<String,Command> commands;

    public CompassApp() {
        this.execute();
    }
    
    public void execute() {
        this.compass = new CompassSample();
        this.compassDisplay = new CompassPanel();
        this.compass.register(compassDisplay);
        this.compassDisplay.display(compass);
        this.sensor = new CompassSensor(this.compass);
        this.createCommands();
        this.design();
    }
    
    private void createCommands() {
        this.commands = new HashMap<>();
        this.commands.put("Sample", new SamplingCommand(this.compass));
    }

    private void design() {
        this.setLayout(new BorderLayout());
        this.upperPanel();
        this.lowerPanel();
        this.setSize(200,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void upperPanel() {
        this.add((Component) compassDisplay, BorderLayout.CENTER);
    }

    private void lowerPanel() {
        JButton btn = button("Start!");
        this.add(btn, BorderLayout.SOUTH);
    }

    private JButton button(String str) {
        JButton res = new JButton(str);
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(compass.getStatus()){
                    res.setText("Start");
                    compassDisplay.reload();
                    compass.setStatus();
                } else {
                    res.setText("Stop");
                    compass.setStatus();
                }
            }
        });
        return res;
    }
}
