/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import control.Command;
import control.SetValueCommand;
import control.ValuePresenter;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Value;
import view.BinaryPanel;
import view.HexPanel;
import view.OctalPanel;
import view.ValueDisplay;
import view.ValuePanel;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame {

    private Value value;
    private ValueDisplay valueDisplay;
    private ValueDisplay octalDisplay;
    private ValueDisplay hexDisplay;
    private ValueDisplay binaryDisplay;
    private ValuePresenter valuePresenter;
    private JTextField input;
    private HashMap<String,Command> commands;
    
    public MainFrame() {
        this.execute();
    }

    private void execute() {
        this.initLogic();
        this.setGraphicalAssets();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300,200));
        this.pack();
        this.setVisible(true);
    }

    private void initLogic() {
        this.value = new Value();
        this.valueDisplay = new ValuePanel();
        this.octalDisplay = new OctalPanel();
        this.hexDisplay = new HexPanel();
        this.binaryDisplay = new BinaryPanel();
        this.valuePresenter = new ValuePresenter(this.value, this.octalDisplay, this.hexDisplay, this.binaryDisplay);
        this.valueDisplay.display(value);
        this.value.registerObservers(valueDisplay);
        this.createCommands();
    }

    private void setGraphicalAssets() {
        this.setLayout(new BorderLayout());
        JPanel centerPane = new JPanel(new GridLayout(2,1));
        JPanel eastPane = new JPanel(new GridLayout(3,1));
        this.input = new JTextField("");
        centerPane.add((Component) this.valueDisplay);
        centerPane.add(input);
        eastPane.add((Component) this.octalDisplay);
        eastPane.add((Component) this.hexDisplay);
        eastPane.add((Component) this.binaryDisplay);
        centerPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        eastPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(centerPane, BorderLayout.CENTER);
        this.add(eastPane, BorderLayout.EAST);
        this.add(button("Nuevo Valor"), BorderLayout.SOUTH);
    }

    private void createCommands() {
        this.commands = new HashMap<>();
        this.commands.put("Set Value", new SetValueCommand(this.value, ""));
    }

    private Component button(String string) {
        JButton res = new JButton(string);
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.put(string, new SetValueCommand(value, input.getText()));
                commands.get(string).execute();
            }
        });
        return res;
    }
    
    
    
}
