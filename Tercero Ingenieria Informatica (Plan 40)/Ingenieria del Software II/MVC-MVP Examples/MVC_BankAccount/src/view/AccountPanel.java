/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import model.Account;

/**
 *
 * @author Usuario
 */
public class AccountPanel extends JPanel implements AccountDisplay {

    private Account account;
    private JPanel panel;
    private JTextPane positionPane;

    public AccountPanel() {
        this.execute(); 
    }

    private void execute() {
        this.setLayout(new BorderLayout());
        this.panel = new JPanel(new BorderLayout());
        this.panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(panel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.loadAssets();
    }

    private void loadAssets() {
        Font positionFont = new Font("SansSerif", Font.BOLD, 50);
        this.positionPane = new JTextPane();
        this.positionPane.setFont(positionFont);
        this.positionPane.setEditable(false);
        this.panel.add(positionPane, BorderLayout.CENTER);
    }
    
    @Override
    public void display(Account account) {
        this.account = account;
        this.positionPane.setText(this.account.getCurrentPosition()+"");
    }

    @Override
    public void change() {
        System.out.println(this.account.getCurrentPosition()+"");
    }

}
