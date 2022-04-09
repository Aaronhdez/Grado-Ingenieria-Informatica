/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoneyCalculator_13112020.main;

import MoneyCalculator_13112020.control.Command;
import MoneyCalculator_13112020.model.Currency;
import MoneyCalculator_13112020.ui.MoneyDialog;
import MoneyCalculator_13112020.ui.MoneyDisplay;
import MoneyCalculator_13112020.ui.swing.SwingMoneyDialog;
import MoneyCalculator_13112020.ui.swing.SwingMoneyDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class MoneyCalculatorFrame extends JFrame{
    private final List<Currency> currencies;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private final Map<String,Command> commands = new HashMap<>();

    public MoneyCalculatorFrame(List<Currency> currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400,400);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(toolbar(), BorderLayout.CENTER);
        this.add(moneyDisplay(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    private Component moneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        this.moneyDialog = swingMoneyDialog;
        return swingMoneyDialog;
    }

    private Component toolbar() {
        JPanel toolBarPanel = new JPanel();
        toolBarPanel.add(calculateButton());
        return toolBarPanel;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        this.moneyDisplay= swingMoneyDisplay;
        return swingMoneyDisplay;
    }

    private Component calculateButton() {
        JButton button = new JButton ("calculate");
        button.addActionListener(calculate());
        return button;
    }

    public void add(Command command){
        commands.put(command.name(), command);
    }
    
    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get("calculate").execute();
            }
        };
    }
    
    
}
