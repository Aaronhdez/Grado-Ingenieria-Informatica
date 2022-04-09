/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.app.fx.panels;

import es.ulpgc.gs1.app.fx.dialogs.HostageDialog;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.Usuario;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario
 */
public class MyHostagesPanel extends JPanel implements ExternalPanel {
    private Usuario usuario;
    private final Session session;             
    
    private javax.swing.JButton createHostageButton;
    private javax.swing.JButton deleteHostageButton;
    private javax.swing.JTextField durationField;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JButton editHostageButton;
    private javax.swing.JPanel hostageDataPanel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JList<String> myHostageList;
    private javax.swing.JScrollPane myHostagesScrollPane;
    private javax.swing.JTextField roomsField;
    private javax.swing.JLabel roomsLabel;
    private javax.swing.JTextField surfaceField;
    private javax.swing.JLabel surfaceLabel;
    private javax.swing.JLabel titleLabel;

    public MyHostagesPanel(Session session) {
        this.session = session;
        this.initComponents();
        this.loadData();
    }
    
    private void loadData(){
        ArrayList<Object> allAdvFromDatabase = SQLHelper.getMyAlojamientosFromDatabase(session.getCurrentUserData().getId());
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Object object : allAdvFromDatabase) {
            model.addElement((String) object);
        }
        this.myHostageList.setModel(model);
    }

    private void initComponents(){
        jPanel9 = new javax.swing.JPanel();
        myHostagesScrollPane = new javax.swing.JScrollPane();
        myHostageList = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        hostageDataPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        roomsLabel = new javax.swing.JLabel();
        roomsField = new javax.swing.JTextField();
        surfaceLabel = new javax.swing.JLabel();
        surfaceField = new javax.swing.JTextField();
        durationLabel = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        editHostageButton = new javax.swing.JButton();
        deleteHostageButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        createHostageButton = new javax.swing.JButton();
        this.init();
    }
    
    private void init() { 
        
        roomsField.setEnabled(false);
        surfaceField.setEnabled(false);
        durationField.setEnabled(false);
        idField.setEnabled(false);
        
        
        myHostageList.setSelectionMode( SINGLE_SELECTION );
        
        jPanel9.setLayout(new java.awt.GridLayout(1, 2, 5, 0));
        loadData();
        
        //Action listener para saber que se selecciona
        myHostageList.addListSelectionListener(getSelectionListener());
                
        myHostagesScrollPane.setViewportView(myHostageList);

        jPanel9.add(myHostagesScrollPane);

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hostageDataPanel.setLayout(new java.awt.GridLayout(5, 2, 10, 10));

        idLabel.setText("id");
        hostageDataPanel.add(idLabel);
        hostageDataPanel.add(idField);

        roomsLabel.setText("Rooms");
        hostageDataPanel.add(roomsLabel);
        hostageDataPanel.add(roomsField);

        surfaceLabel.setText("Surface");
        hostageDataPanel.add(surfaceLabel);
        hostageDataPanel.add(surfaceField);

        durationLabel.setText("Duration");
        hostageDataPanel.add(durationLabel);
        hostageDataPanel.add(durationField);

        editHostageButton.setText("Editar");
        editHostageButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHostageButtonActionPerformed(evt);
            }
        });
        
        hostageDataPanel.add(editHostageButton);

        deleteHostageButton.setText("Borrar");
        deleteHostageButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHostageButtonActionPerformed(evt);
            }
        });
        hostageDataPanel.add(deleteHostageButton);

        titleLabel.setText("Title");

        createHostageButton.setText("Añadir");
        createHostageButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createHostageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createHostageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hostageDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostageDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createHostageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10);

        javax.swing.GroupLayout MyEventsPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(MyEventsPanelLayout);
        MyEventsPanelLayout.setHorizontalGroup(
            MyEventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyEventsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MyEventsPanelLayout.setVerticalGroup(
            MyEventsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyEventsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        this.add(jPanel9);
    }
    
        
    @Override
    public void update() {
        loadData();
    }

    @Override
    public void setUserInstance(Usuario usuario) {
        this.usuario = usuario;
    }
    
    private ListSelectionListener getSelectionListener(){
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if(myHostageList.getSelectedValue()!=null){
                    String selectedValue = myHostageList.getSelectedValue();
                    ArrayList<Object> alojamientoInfo = SQLHelper.GetDataFromAlojamiento(selectedValue);
                    if(alojamientoInfo.size() > 0){
                        titleLabel.setText((String)alojamientoInfo.get(0));
                        idField.setText((String)alojamientoInfo.get(1));
                        roomsField.setText((String)alojamientoInfo.get(2));
                        surfaceField.setText((String)alojamientoInfo.get(3));
                        durationField.setText((String)alojamientoInfo.get(4));
                    }
                }
            }
        };
    }
    
    private void editHostageButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        String selectedValue = myHostageList.getSelectedValue();
        if(selectedValue == null){
            JOptionPane.showMessageDialog(this, "No hay alojamiento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Object> dataToTransfer = SQLHelper.GetDataFromAlojamiento(selectedValue);
        new HostageDialog(this, this.session, dataToTransfer);
    }                                                 

    private void deleteHostageButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        String selectedValue = myHostageList.getSelectedValue();
        if(selectedValue == null){
            JOptionPane.showMessageDialog(this, "No hay alojamiento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Object> AlojamientoInfo = SQLHelper.GetDataFromAlojamiento(selectedValue);
        int input = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar este alojamiento?", "Borrar Alojamiento", YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        // 0=yes, 1=no, 2=cancel
        if(input == 0){
            SQLHelper.deleteAlojamiento(AlojamientoInfo.get(1).toString());
            JOptionPane.showMessageDialog(this, "Alojamiento Borrado con éxito");
            this.update();
        }
    }                                                   

    private void createHostageButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        new HostageDialog(this, this.session);
    }   
    
}
