/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.swing;

import view.DataListDisplay;
import control.DataPresenter;
import control.Command;
import control.NextCommand;
import control.PrevCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.User;
import model.UsersData;
import view.DataDisplay;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame {

    private DataDisplay dataDisplay;
    private UsersData usersData;
    private HashMap<String,Command> commands;
    
    private DataListDisplay dataListDisplay;
    private DataPresenter dataPresenter;
    
    public MainFrame() {
        this.execute();
    }

    private void execute() {
        this.initMvcLogic();
        this.initMvpLogic();
        this.setLayout(new BorderLayout());
        this.add((Component) this.dataListDisplay, BorderLayout.EAST);
        this.add((Component) this.dataDisplay, BorderLayout.CENTER);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initMvcLogic() {
        this.loadData();
        this.dataDisplay = new DataPanel();
        this.dataDisplay.display(usersData);
        this.usersData.registerObservers(dataDisplay);
        this.createCommands();
    }
    
    private void initMvpLogic() {
        this.dataListDisplay = new DataListPanel(this.usersData.getUsers());
        this.dataPresenter = new DataPresenter(this.dataListDisplay, this.usersData);
    }
    
    private void loadData() {
        this.usersData = new UsersData();
        this.usersData.addUser(new User("Javier","Suarez Suarez","12345678L","07/08/2000"));
        this.usersData.addUser(new User("Irene María","Rodríguez Morales","98765432K","12/02/1999"));
        this.usersData.addUser(new User("Aarón","Hernández Álvarez","54134452L","24/03/1996"));
    }
    
    private Component createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(button("<<"));
        buttonsPanel.add(button(">>"));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return buttonsPanel;
    }
    
    private void createCommands(){
        this.commands = new HashMap<>();
        this.commands.put(">>", new NextCommand(this.usersData));
        this.commands.put("<<", new PrevCommand(this.usersData));
    }

    private JButton button(String string) {
        JButton res = new JButton(string);
        res.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(string).execute();
            }
        });
        return res;
    }


    
}
