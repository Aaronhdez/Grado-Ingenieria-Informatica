/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import control.Command;
import control.DepositCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Account;
import view.AccountDisplay;
import view.AccountPanel;

/**
 *
 * @author Usuario
 */
public class BankAccountFrame extends JFrame{

    private Account account;
    private AccountDisplay accountDisplay;
    private HashMap<String,Command> commands;
    private JLabel titleLabel;
    
    public BankAccountFrame() {
        this.execute();
    }
    
    private void execute(){
        this.account = new Account();
        this.accountDisplay = new AccountPanel();
        this.account.registerObserver(accountDisplay);
        this.accountDisplay.display(account);
        this.createCommands();
        this.loadGraphicAssets();
    }

    private void createCommands() {
        this.commands = new HashMap<>();
        this.commands.put("Ingresar", new DepositCommand(this.account));
    }

    private void loadGraphicAssets() {
        this.setLayout(new BorderLayout());
        this.titleLabel = new JLabel("Cuenta Bancaria");
        this.add(this.titleLabel, BorderLayout.NORTH);
        this.add((Component) this.accountDisplay, BorderLayout.CENTER);
        this.setGraphicalStyles();
    }

    private void setGraphicalStyles() {
        Font standardFont = new Font("SansSerif", Font.BOLD, 20);
        this.titleLabel.setFont(standardFont);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(600,400);
    }
}
