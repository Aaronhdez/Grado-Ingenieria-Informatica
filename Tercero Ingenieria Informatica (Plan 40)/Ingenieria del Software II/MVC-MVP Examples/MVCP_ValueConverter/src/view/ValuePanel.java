/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Value;

/**
 *
 * @author Usuario
 */
public class ValuePanel extends JPanel implements ValueDisplay {

    private Value value;
    private JTextField resultField;

    public ValuePanel() {
        this.execute();
    }
    
    private void execute() {
        JPanel resultPane = new JPanel();
        resultPane.setLayout(new FlowLayout());
        this.resultField = new JTextField(30);
        this.resultField.setEditable(false);
        resultPane.add(new JLabel("Resultado"));
        resultPane.add(this.resultField, BorderLayout.CENTER);
        this.add(resultPane);
    }
    
    @Override
    public void display(Value value) {
        this.resultField.setText("");
        this.value = value;
    }

    @Override
    public void change() {
        this.resultField.setText(this.value.getConvertedValue());
    }

    @Override
    public void on(Touch touch) {
    }

    @Override
    public void reload() {
    }
    
}
