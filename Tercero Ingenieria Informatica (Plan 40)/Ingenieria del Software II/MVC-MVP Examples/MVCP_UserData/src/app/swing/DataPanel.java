/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.UsersData;
import view.DataDisplay;

/**
 *
 * @author Usuario
 */
public class DataPanel extends JPanel implements DataDisplay {

    private UsersData UsersData;
    private JPanel centerPanel;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtNid;
    private JTextField txtBirthDate; 
    
    public DataPanel() {
        this.execute();
    }
    private void execute() {
        this.setLayout(new BorderLayout());
        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new GridLayout(8,1));
        this.txtName = new JTextField();
        this.txtSurname = new JTextField();
        this.txtNid = new JTextField();
        this.txtBirthDate = new JTextField();
        this.txtName.setEditable(false);
        this.txtSurname.setEditable(false);
        this.txtNid.setEditable(false);
        this.txtBirthDate.setEditable(false);
        this.centerPanel.add(new JLabel("DNI"));
        this.centerPanel.add(this.txtNid);
        this.centerPanel.add(new JLabel("Nombre"));
        this.centerPanel.add(this.txtName);
        this.centerPanel.add(new JLabel("Apellidos"));
        this.centerPanel.add(this.txtSurname);
        this.centerPanel.add(new JLabel("Fecha de Nacimiento"));
        this.centerPanel.add(this.txtBirthDate);
        this.centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(this.centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void display(UsersData usersData) {
        this.UsersData = usersData;
        this.txtName.setText(this.UsersData.getCurrentUser().getName());
        this.txtSurname.setText(this.UsersData.getCurrentUser().getSurname());
        this.txtBirthDate.setText(this.UsersData.getCurrentUser().getBirthDate());
        this.txtNid.setText(this.UsersData.getCurrentUser().getNid());
    }

    @Override
    public void change() {
        this.txtName.setText(this.UsersData.getCurrentUser().getName());
        this.txtSurname.setText(this.UsersData.getCurrentUser().getSurname());
        this.txtBirthDate.setText(this.UsersData.getCurrentUser().getBirthDate());
        this.txtNid.setText(this.UsersData.getCurrentUser().getNid());
    }

    
}
