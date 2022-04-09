/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.app.fx.panels;

import es.ulpgc.gs1.app.fx.dialogs.ViewHostageDialog;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.Usuario;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario
 */
public class HostagePanel extends JPanel implements ExternalPanel {
    private JList list;
    private JScrollPane scrollpane;
    private Usuario usuario;
    private final Session session;
    
    public HostagePanel(Session session) {
        this.session = session;
        this.init();
    }

    private void init() {
        scrollpane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        this.reloadHostages();
        list.addListSelectionListener(getSelectionListener(this, session));
        scrollpane.setViewportView(list);
        javax.swing.GroupLayout eventsPanel2Layout = new javax.swing.GroupLayout(this);
        this.setLayout(eventsPanel2Layout);
        eventsPanel2Layout.setHorizontalGroup(
            eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        eventsPanel2Layout.setVerticalGroup(
            eventsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );
        this.add(scrollpane);
    }

    @Override
    public void setUserInstance(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void update() {
        this.reloadHostages();
    }

    private void reloadHostages() {
        ArrayList<Object> hostagesFromDatabase = SQLHelper.getAllAlojamientosFromDatabase();
        DefaultListModel<String> hostagesList = getModelFrom(hostagesFromDatabase);
        this.list.setModel(hostagesList);
    }

    private DefaultListModel<String> getModelFrom(ArrayList<Object> hostagesFromDatabase) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for(int i = 0; i < hostagesFromDatabase.size(); i++){
            model.addElement(hostagesFromDatabase.get(i).toString());
        }
        return model;
    }

    private ListSelectionListener getSelectionListener(Component component, Session session) {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(list.getSelectedValue() != null){
                    String selectedValue = list.getSelectedValue().toString();
                    ArrayList<Object> dataToTransfer = SQLHelper.GetDataFromAlojamiento(selectedValue);
                    new ViewHostageDialog(component, session, dataToTransfer);
                }
            }
        };
    }
    
}
