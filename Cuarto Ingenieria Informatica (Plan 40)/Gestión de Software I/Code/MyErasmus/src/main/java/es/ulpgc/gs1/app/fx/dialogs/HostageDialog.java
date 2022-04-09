/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.app.fx.dialogs;

import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.model.data.RegisterDataAlojamiento;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalDialog;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HostageDialog extends JDialog implements ExternalDialog {
    private final Session session;
    private ArrayList<Object> hostageData;
    private final Component parent;
    private String title;
                  
    private javax.swing.JPanel buttonsPanel1;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel dialogTitleField1;
    private javax.swing.JPanel dialogTitlePanel1;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JComboBox<String> priceComboBox;
    private javax.swing.JComboBox<String> roomsComboBox;
    private javax.swing.JLabel roomsLabel;
    private javax.swing.JTextField surfaceField;
    private javax.swing.JLabel surfaceLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField rentField;
    private javax.swing.JLabel rentLabel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    
    public HostageDialog(Component parent, Session session, ArrayList<Object> hostageData) {
        this.parent = parent;
        this.session = session;
        this.hostageData = hostageData;
        this.initComponents();
    }

    public HostageDialog(Component parent, Session session) {
        this.parent = parent;
        this.session = session;
        this.initComponents();
    }
    
    private void initComponents(){
        mainPanel = new javax.swing.JPanel();
        fieldsPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        roomsLabel = new javax.swing.JLabel();
        roomsComboBox = new javax.swing.JComboBox<>();
        surfaceLabel = new javax.swing.JLabel();
        surfaceField = new javax.swing.JTextField();
        periodLabel = new javax.swing.JLabel();
        priceComboBox = new javax.swing.JComboBox<>();
        rentLabel = new javax.swing.JLabel();
        rentField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        buttonsPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        dialogTitlePanel1 = new javax.swing.JPanel();
        dialogTitleField1 = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        this.init();
        if(this.hostageData != null){
            updateFields();
        }
        this.addListeners();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.pack();
    }
    
    private void init(){
        this.setMaximumSize(new java.awt.Dimension(400, 550));
        this.setMinimumSize(new java.awt.Dimension(400, 550));
        this.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.setPreferredSize(new java.awt.Dimension(400, 550));
        this.setResizable(false);

        mainPanel.setBackground(new java.awt.Color(46, 103, 212));

        fieldsPanel.setOpaque(false);
        fieldsPanel.setLayout(new java.awt.GridLayout(7, 3, 10, 10));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Titulo");
        fieldsPanel.add(titleLabel);
        fieldsPanel.add(titleField);

        roomsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roomsLabel.setForeground(new java.awt.Color(255, 255, 255));
        roomsLabel.setText("Habitaciones");
        fieldsPanel.add(roomsLabel);

        roomsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        fieldsPanel.add(roomsComboBox);

        surfaceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        surfaceLabel.setForeground(new java.awt.Color(255, 255, 255));
        surfaceLabel.setText("Superficie Total");
        fieldsPanel.add(surfaceLabel);
        fieldsPanel.add(surfaceField);

        periodLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        periodLabel.setForeground(new java.awt.Color(255, 255, 255));
        periodLabel.setText("Período Máximo");
        fieldsPanel.add(periodLabel);

        priceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4 meses", "6 meses", "1 año", "Indefinido" }));
        fieldsPanel.add(priceComboBox);

        rentLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rentLabel.setForeground(new java.awt.Color(255, 255, 255));
        rentLabel.setText("Alquiler Mensual (€)");
        fieldsPanel.add(rentLabel);
        fieldsPanel.add(rentField);

        cityLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cityLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityLabel.setText("Ciudad");
        fieldsPanel.add(cityLabel);
        fieldsPanel.add(cityField);

        streetLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        streetLabel.setForeground(new java.awt.Color(255, 255, 255));
        streetLabel.setText("Calle");
        fieldsPanel.add(streetLabel);
        fieldsPanel.add(streetField);

        buttonsPanel1.setOpaque(false);
        buttonsPanel1.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        dialogTitlePanel1.setOpaque(false);

        dialogTitleField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dialogTitleField1.setForeground(new java.awt.Color(255, 255, 255));
        dialogTitleField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        cancelButton.setText("Cancelar");
        buttonsPanel1.add(cancelButton);
        if (hostageData == null) {
            dialogTitleField1.setText("Nuevo Alojamiento");
            saveButton.setText("Crear");
        } else {
            dialogTitleField1.setText("Editar Alojamiento");
            saveButton.setText("Guardar");
        }
        buttonsPanel1.add(saveButton);
        
        javax.swing.GroupLayout dialogTitlePanel1Layout = new javax.swing.GroupLayout(dialogTitlePanel1);
        dialogTitlePanel1.setLayout(dialogTitlePanel1Layout);
        dialogTitlePanel1Layout.setHorizontalGroup(
            dialogTitlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTitlePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitleField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogTitlePanel1Layout.setVerticalGroup(
            dialogTitlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTitlePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitleField1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        descriptionLabel.setText("Descripción");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descriptionScrollPane)
                    .addComponent(buttonsPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(fieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dialogTitlePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        mainPanel.add(this.dialogTitlePanel1);
        mainPanel.add(this.fieldsPanel);
        mainPanel.add(this.buttonsPanel1);
        this.add(mainPanel);
    }

    private void addListeners(){
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (hostageData == null) {
                    acceptButtonActionPerformed(evt);
                } else {
                    editButtonActionPerformed(evt);
                }
            }
        });
    }    
    
    private void updateFields() {
        this.surfaceField.setText((String) hostageData.get(3));
        this.titleField.setText((String) hostageData.get(0));
        this.roomsComboBox.setSelectedIndex(getBoxIndex(this.roomsComboBox, (String) this.hostageData.get(2)));
        this.surfaceField.setText((String) hostageData.get(3));
        this.priceComboBox.setSelectedIndex(getBoxIndex(this.priceComboBox, (String) this.hostageData.get(4)));
        this.descriptionTextArea.setText((String) hostageData.get(5));
        this.rentField.setText((String) hostageData.get(6));
        this.cityField.setText((String) hostageData.get(7));
        this.streetField.setText((String) hostageData.get(8));
    }

    private int getBoxIndex(JComboBox comboBoxToCheck, String itemToSelect) {
        ComboBoxModel<String> model = comboBoxToCheck.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            if((model.getElementAt(i)).equals(itemToSelect)){
                return i;
            }
        }
        return 0;
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        ArrayList<String> dataToTransfer = new ArrayList();
        dataToTransfer.add(this.titleField.getText());
        dataToTransfer.add((String) this.hostageData.get(1));
        dataToTransfer.add(this.roomsComboBox.getSelectedItem().toString());
        dataToTransfer.add(this.surfaceField.getText());
        dataToTransfer.add(this.priceComboBox.getSelectedItem().toString());
        dataToTransfer.add(this.descriptionTextArea.getText());
        dataToTransfer.add(this.rentField.getText());
        dataToTransfer.add(this.cityField.getText());
        dataToTransfer.add(this.streetField.getText());
        dataToTransfer.add(""+SQLHelper.getLanlordIdFromUserId(this.session.getCurrentUserData().getId()));
        SQLHelper.editAlojamiento(dataToTransfer);
        JOptionPane.showMessageDialog(this, "Alojamiento Editado con éxito");
        ((ExternalPanel) this.parent).update();
        this.dispose();
    }                                               

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        //Insertar el anuncio
        RegisterDataAdv dataAdvToTransfer = new RegisterDataAdv(); 
        dataAdvToTransfer.setTitle(this.titleField.getText()); 
        dataAdvToTransfer.setStreet(this.streetField.getText()); 
        dataAdvToTransfer.setPrice(Integer.parseInt(this.rentField.getText())); 
        dataAdvToTransfer.setDestinarion(this.cityField.getText()); 
        dataAdvToTransfer.setDescription(this.descriptionTextArea.getText());
        SQLHelper.registerNewAdv(dataAdvToTransfer);
        
        String advId = (String) SQLHelper.getDataFromAdv(this.titleField.getText()).get(4);
        String landlordId = ""+SQLHelper.getLanlordIdFromUserId(this.session.getCurrentUserData().getId());
        
        RegisterDataAlojamiento dataToTransfer = new RegisterDataAlojamiento();
        dataToTransfer.setAdv_id(Integer.parseInt(advId));
        dataToTransfer.setLandlord_id(Integer.parseInt(landlordId));
        dataToTransfer.setAvailable_surface(this.surfaceField.getText());
        dataToTransfer.setDuration(this.priceComboBox.getSelectedItem().toString());
        dataToTransfer.setRooms(Integer.parseInt(this.roomsComboBox.getSelectedItem().toString()));
        SQLHelper.registerNewAlojamiento(dataToTransfer);
        
        JOptionPane.showMessageDialog(this, "Alojamiento Añadido con éxito");
        ((ExternalPanel) this.parent).update();
        this.dispose();
    }                                                 

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        this.dispose();
    }  

}
