package es.ulpgc.gs1.app.fx.dialogs;

import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalDialog;
import es.ulpgc.gs1.persistence.ExternalPanel;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class EventDialog extends JDialog implements ExternalDialog {
    private Component parent;
    private Session session;
    private ArrayList<Object> dataToTransfer;
              
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField descField;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel dialogTitleField;
    private javax.swing.JPanel dialogTitlePanel;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    
    public EventDialog(Component parent, Session session, ArrayList<Object> dataToTransfer) {
        this.parent = parent;
        this.session = session;
        this.dataToTransfer = dataToTransfer;
        this.initComponents();
    }

    public EventDialog(Component parent, Session session) {
        this.parent = parent;
        this.session = session;
        this.initComponents();
    }
    
    private void initComponents(){
        mainPanel = new javax.swing.JPanel();
        fieldsPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        descLabel = new javax.swing.JLabel();
        descField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        dialogTitlePanel = new javax.swing.JPanel();
        dialogTitleField = new javax.swing.JLabel();
        this.init();
        if(this.dataToTransfer != null){
            this.loadData();
        }
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
    
    private void init(){
        this.setMaximumSize(new java.awt.Dimension(420, 320));
        this.setMinimumSize(new java.awt.Dimension(420, 320));
        this.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.setPreferredSize(new java.awt.Dimension(400, 320));
        this.setResizable(false);
        
        mainPanel.setBackground(new java.awt.Color(46, 103, 212));
        mainPanel.setMaximumSize(new java.awt.Dimension(400, 300));
        mainPanel.setMinimumSize(new java.awt.Dimension(400, 300));
        
        fieldsPanel.setOpaque(false);
        fieldsPanel.setLayout(new java.awt.GridLayout(5, 3, 10, 10));

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Titulo");
        fieldsPanel.add(titleLabel);
        fieldsPanel.add(titleField);

        descLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        descLabel.setForeground(new java.awt.Color(255, 255, 255));
        descLabel.setText("Descripción");
        fieldsPanel.add(descLabel);
        fieldsPanel.add(descField);

        addressLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Dirección");
        fieldsPanel.add(addressLabel);
        fieldsPanel.add(addressField);

        cityLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        cityLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityLabel.setText("Ciudad");
        fieldsPanel.add(cityLabel);
        fieldsPanel.add(cityField);

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("Precio");
        fieldsPanel.add(priceLabel);
        fieldsPanel.add(priceField);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        cancelButton.setText("Cancelar");
        buttonsPanel.add(cancelButton);
        if (dataToTransfer == null) {
            acceptButton.setText("Crear");
            dialogTitleField.setText("Nuevo Evento");
        } else {
            acceptButton.setText("Guardar");
            dialogTitleField.setText("Editar Evento");
        }
        buttonsPanel.add(acceptButton);

        dialogTitlePanel.setOpaque(false);

        dialogTitleField.setFont(new java.awt.Font("Tahoma", 1, 18));
        dialogTitleField.setForeground(new java.awt.Color(255, 255, 255));
        dialogTitleField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        javax.swing.GroupLayout dialogTitlePanelLayout = new javax.swing.GroupLayout(dialogTitlePanel);
        dialogTitlePanel.setLayout(dialogTitlePanelLayout);
        dialogTitlePanelLayout.setHorizontalGroup(
            dialogTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogTitlePanelLayout.setVerticalGroup(
            dialogTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(fieldsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dialogTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        mainPanel.add(this.dialogTitlePanel);
        mainPanel.add(this.fieldsPanel);
        mainPanel.add(this.buttonsPanel);
        this.add(mainPanel);
        this.addListeners();
    }
    
    private void loadData() {
        this.titleField.setText((String) this.dataToTransfer.get(1));
        this.descField.setText((String) this.dataToTransfer.get(2));
        this.addressField.setText((String) this.dataToTransfer.get(3));
        this.cityField.setText((String) this.dataToTransfer.get(4));
        this.priceField.setText((String) this.dataToTransfer.get(5));
    }
    
    private void addListeners(){
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (dataToTransfer == null) {
                    acceptButtonActionPerformed(evt);
                } else {
                    editButtonActionPerformed(evt);
                }
            }
        });
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {  
        this.dispose();
    }                                        

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String userId = this.session.getCurrentUserData().getId();
        RegisterDataAdv dataToInsert = new RegisterDataAdv();
        dataToInsert.setTitle(this.titleField.getText());
        dataToInsert.setDescription(this.descField.getText());
        dataToInsert.setDestinarion(this.addressLabel.getText());
        dataToInsert.setPrice(Integer.parseInt(this.priceField.getText()));
        dataToInsert.setStreet(this.cityField.getText());
        
        SQLHelper.registerNewUniversityEvent(dataToInsert, userId);
        JOptionPane.showMessageDialog(this, "Evento añadido con éxito");
        ((ExternalPanel) this.parent).update();
        this.dispose();
    }                                   

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String userId = this.session.getCurrentUserData().getId();
        ArrayList<Object> dataToUpdate = new ArrayList<>(); 
        dataToUpdate.add((String) this.dataToTransfer.get(0)); //id
        dataToUpdate.add(this.titleField.getText()); //TITLE
        dataToUpdate.add(this.descField.getText()); //description
        dataToUpdate.add(this.addressField.getText()); //calle
        dataToUpdate.add(this.cityField.getText()); //calle
        dataToUpdate.add(this.priceField.getText()); //precio
        SQLHelper.updateUniversityEvent(dataToUpdate, userId);
        
        JOptionPane.showMessageDialog(this, "Evento editado con éxito");
        ((ExternalPanel) this.parent).update();
        this.dispose();
    }  
}
