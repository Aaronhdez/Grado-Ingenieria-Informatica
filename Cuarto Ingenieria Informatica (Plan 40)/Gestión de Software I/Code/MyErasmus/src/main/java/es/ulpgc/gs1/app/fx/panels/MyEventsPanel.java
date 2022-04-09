/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.app.fx.panels;


import es.ulpgc.gs1.app.fx.dialogs.EventDialog;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.Usuario;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario
 */
public class MyEventsPanel extends JPanel implements ExternalPanel {
    private Usuario usuario;
    private Session session;
    
    private javax.swing.JButton createEventButton;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JButton editEventButton;
    private javax.swing.JPanel eventDataGridPanel;
    private javax.swing.JPanel eventDataPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JList<String> myEventsList;
    private javax.swing.JScrollPane myEventsScrollPanel;
    private javax.swing.JTextField placeField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;

    public MyEventsPanel(Session session) {
        this.session = session;
        this.initComponents();
    }
    
    private void initComponents(){
        myEventsScrollPanel = new javax.swing.JScrollPane();
        myEventsList = new javax.swing.JList<>();
        eventDataPanel = new javax.swing.JPanel();
        eventDataGridPanel = new javax.swing.JPanel();
        streetLabel = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        placeField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        editEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();
        createEventButton = new javax.swing.JButton();
        this.init();
    }
    
    private void init(){
        this.setLayout(new java.awt.GridLayout(1, 2, 30, 0));
        loadData();
        addListeners();
        myEventsScrollPanel.setViewportView(myEventsList);
        this.add(myEventsScrollPanel);
        this.streetField.setEnabled(false);
        this.placeField.setEnabled(false);
        this.priceField.setEnabled(false);
        eventDataPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eventDataGridPanel.setLayout(new java.awt.GridLayout(4, 2, 10, 10));
        streetLabel.setText("Calle");
        eventDataGridPanel.add(streetLabel);
        eventDataGridPanel.add(streetField);
        titleLabel.setText("Lugar");
        eventDataGridPanel.add(titleLabel);
        eventDataGridPanel.add(placeField);
        priceLabel.setText("Precio");
        eventDataGridPanel.add(priceLabel);
        eventDataGridPanel.add(priceField);
        editEventButton.setText("Editar");
        editEventButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEventButtonActionPerformed(evt);
            }
        });
        eventDataGridPanel.add(editEventButton);
        deleteEventButton.setText("Borrar");
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });
        eventDataGridPanel.add(deleteEventButton);
        createEventButton.setText("Añadir Evento");
        createEventButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventButtonActionPerformed(evt);
            }
        });
        idLabel.setText("Id");
        javax.swing.GroupLayout eventDataPanelLayout = new javax.swing.GroupLayout(eventDataPanel);
        eventDataPanel.setLayout(eventDataPanelLayout);
        eventDataPanelLayout.setHorizontalGroup(
            eventDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventDataGridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(createEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        eventDataPanelLayout.setVerticalGroup(
            eventDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(eventDataGridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        this.add(eventDataPanel);
    }

    private void addListeners() {
        myEventsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                String selectedValue = myEventsList.getSelectedValue();
                if(selectedValue != null){
                    ArrayList<Object> AlojamientoInfo = SQLHelper.getDataFromAdv(selectedValue);
                    titleLabel.setText((String) AlojamientoInfo.get(0));
                    streetField.setText((String) AlojamientoInfo.get(1));
                    placeField.setText((String) AlojamientoInfo.get(2));
                    priceField.setText((String) AlojamientoInfo.get(3));
                    idLabel.setText((String) AlojamientoInfo.get(4));
                }
            }
        });
    }
    
    private void loadData(){
        ArrayList<Object> allAdvFromDatabase = SQLHelper.getMyEventsFromDatabase(session.getCurrentUserData().getId()); 
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Object object : allAdvFromDatabase) {
            model.addElement((String) object);
        }
        this.myEventsList.setModel(model);
    }
    
    @Override
    public void update() {
        this.loadData();
    }

    @Override
    public void setUserInstance(Usuario usuario) {
        this.usuario = usuario;
    }
    
    private void editEventButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedValue = myEventsList.getSelectedValue();
        if(selectedValue == null){
            JOptionPane.showMessageDialog(this, "No hay evento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }      
        ArrayList<Object> dataToTransfer = SQLHelper.GetDataFromUniversityEvent(selectedValue);
        new EventDialog(this, this.session, dataToTransfer);
    }                                               

    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar este evento?", "¿Borrar Evento?", JOptionPane.YES_NO_CANCEL_OPTION);
        // 0=yes, 1=no, 2=cancel
        if(input == 0){
            SQLHelper.deleteAdv(this.idLabel.getText());
            this.update();
        }
    }                                                 

    private void createEventButtonActionPerformed(java.awt.event.ActionEvent evt) {     
        new EventDialog(this, this.session);
    }  
}
