package mvc_chronometer.swing;

import control.Command;
import control.ResetCommand;
import control.StartCommand;
import control.StopCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Measure;
import view.ChronoDisplay;

public class ChronoMainFrame extends JFrame {
    
    private ChronoDisplay timerDisplay;
    private HashMap<String,Command> commands;
    private Measure measure;
    
    private JButton startBtn;
    private JButton stopBtn;
    private JButton resetBtn;

    public ChronoMainFrame() {
        this.execute();
    }

    private void execute() {
        this.timerDisplay = new ChronoPanelDisplay();
        this.measure = new Measure();
        this.measure.registerObservers(timerDisplay);
        this.timerDisplay.display(measure);
        this.createCommands();
        this.design();
    }

    private void createCommands(){
        this.commands = new HashMap<>();
        this.commands.put("Start", new StartCommand(this.measure));
        this.commands.put("Stop", new StopCommand(this.measure));
        this.commands.put("Reset", new ResetCommand(this.measure));
    }

    private void design() {
        this.setLayout(new BorderLayout());
        this.add((Component) this.timerDisplay, BorderLayout.CENTER);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);
        this.setSize(100,200);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel createButtonsPanel() {
        JPanel pane = new JPanel(new BorderLayout());
        this.startBtn = button("Start");
        this.resetBtn = button("Reset");
        this.stopBtn = button("Stop");
        pane.add(startBtn, BorderLayout.NORTH);
        pane.add(stopBtn, BorderLayout.CENTER);
        pane.add(resetBtn, BorderLayout.SOUTH);
        return pane;
    }

    private JButton button(String text) {
        JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch(text){
                    case "Start":
                        startBtn.setEnabled(false);
                        stopBtn.setEnabled(true);
                        resetBtn.setEnabled(false);
                    break;
                    case "Stop":
                        startBtn.setEnabled(true);
                        stopBtn.setEnabled(false);
                        resetBtn.setEnabled(true);
                    break;
                    case "Reset":
                        startBtn.setEnabled(true);
                        stopBtn.setEnabled(false);
                        resetBtn.setEnabled(false);
                    break;
                }
                commands.get(text).execute();
            }
        });
        return btn;
    }
}
