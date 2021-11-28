/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.swing;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import model.UsersData;
import view.DataListDisplay;

/**
 *
 * @author Usuario
 */
public class DataListPanel extends JPanel implements DataListDisplay {

    private JList userList; 
    private Touch touch;
    private MouseHandler mouseHandler;
    
    public DataListPanel(String[] users) {
        this.execute(users);
    }

    private void execute(String[] users) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios"));
        this.loadList(users);
        this.add(userList);
    }

    private void loadList(String[] users) {
        this.userList = new JList();
        this.userList.setListData(users);
        this.mouseHandler = new MouseHandler();
        this.userList.addMouseListener(mouseHandler);
    }

    @Override
    public void on(Touch touch) {
        this.touch = touch;
    }

    @Override
    public void reload(UsersData usersData) {
        this.userList.setListData(usersData.getUsers());
    }
    
    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            touch.setCurrent(userList.getSelectedIndex());
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
    }
    
}
