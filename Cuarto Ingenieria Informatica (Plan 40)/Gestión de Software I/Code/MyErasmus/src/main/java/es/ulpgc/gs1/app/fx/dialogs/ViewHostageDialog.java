package es.ulpgc.gs1.app.fx.dialogs;

import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.ExternalDialog;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JDialog;

public class ViewHostageDialog extends JDialog implements ExternalDialog{
    private final Component parent;
    private final Session session;

    private javax.swing.JPanel buttonsPanel1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel dialogTitleField1;
    private javax.swing.JPanel dialogTitlePanel1;
    private javax.swing.JTextField durationField;
    private javax.swing.JPanel fieldsPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JTextField rentField;
    private javax.swing.JLabel rentLabel;
    private javax.swing.JTextField roomsField;
    private javax.swing.JLabel roomsLabel;
    private javax.swing.JTextField streetField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JButton subscribeButton;
    private javax.swing.JTextField surfaceField;
    private javax.swing.JLabel surfaceLabel;
    private final ArrayList<Object> hostageData;
    
    public ViewHostageDialog(Component parent, Session session, ArrayList<Object> hostageData) {
        this.parent = parent;
        this.session = session;
        this.hostageData = hostageData;
        this.initComponents();
    }
    
    private void initComponents(){
        mainPanel = new javax.swing.JPanel();
        fieldsPanel = new javax.swing.JPanel();
        roomsLabel = new javax.swing.JLabel();
        roomsField = new javax.swing.JTextField();
        surfaceLabel = new javax.swing.JLabel();
        surfaceField = new javax.swing.JTextField();
        periodLabel = new javax.swing.JLabel();
        durationField = new javax.swing.JTextField();
        rentLabel = new javax.swing.JLabel();
        rentField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        buttonsPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        subscribeButton = new javax.swing.JButton();
        dialogTitlePanel1 = new javax.swing.JPanel();
        dialogTitleField1 = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();
        this.init();
        this.updateFields();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.pack();
    }
    
    private void init(){
        this.setMaximumSize(new java.awt.Dimension(740, 600));
        this.setMinimumSize(new java.awt.Dimension(740, 600));
        this.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.setPreferredSize(new java.awt.Dimension(740, 600));
        this.setResizable(false);

        mainPanel.setBackground(new java.awt.Color(46, 103, 212));
        mainPanel.setMaximumSize(new java.awt.Dimension(717, 556));
        mainPanel.setMinimumSize(new java.awt.Dimension(717, 556));

        fieldsPanel.setOpaque(false);
        fieldsPanel.setLayout(new java.awt.GridLayout(6, 3, 10, 10));

        roomsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        roomsLabel.setForeground(new java.awt.Color(255, 255, 255));
        roomsLabel.setText("Habitaciones");
        fieldsPanel.add(roomsLabel);

        roomsField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        roomsField.setEnabled(false);
        fieldsPanel.add(roomsField);

        surfaceLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        surfaceLabel.setForeground(new java.awt.Color(255, 255, 255));
        surfaceLabel.setText("Superficie Total");
        fieldsPanel.add(surfaceLabel);

        surfaceField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        surfaceField.setEnabled(false);
        fieldsPanel.add(surfaceField);

        periodLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        periodLabel.setForeground(new java.awt.Color(255, 255, 255));
        periodLabel.setText("Período Máximo");
        fieldsPanel.add(periodLabel);

        durationField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        durationField.setEnabled(false);
        fieldsPanel.add(durationField);

        rentLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rentLabel.setForeground(new java.awt.Color(255, 255, 255));
        rentLabel.setText("Alquiler Mensual (€)");
        fieldsPanel.add(rentLabel);

        rentField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rentField.setEnabled(false);
        fieldsPanel.add(rentField);

        cityLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cityLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityLabel.setText("Ciudad");
        fieldsPanel.add(cityLabel);

        cityField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cityField.setEnabled(false);
        fieldsPanel.add(cityField);

        streetLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        streetLabel.setForeground(new java.awt.Color(255, 255, 255));
        streetLabel.setText("Calle");
        fieldsPanel.add(streetLabel);

        streetField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        streetField.setEnabled(false);
        fieldsPanel.add(streetField);

        buttonsPanel1.setOpaque(false);
        buttonsPanel1.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel1.add(cancelButton);

        subscribeButton.setText("Suscribirse");
        subscribeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeButtonActionPerformed(evt);
            }
        });
        buttonsPanel1.add(subscribeButton);

        dialogTitlePanel1.setOpaque(false);

        dialogTitleField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dialogTitleField1.setForeground(new java.awt.Color(255, 255, 255));
        dialogTitleField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dialogTitleField1.setText("Titulo");

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
            .addComponent(dialogTitleField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descriptionTextArea.setEnabled(false);
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
                    .addComponent(fieldsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addComponent(dialogTitlePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dialogTitlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void updateFields() {
        this.surfaceField.setText((String) hostageData.get(3));
        this.dialogTitleField1.setText((String) hostageData.get(0));
        this.roomsField.setText((String) this.hostageData.get(2));
        this.surfaceField.setText((String) hostageData.get(3));
        this.descriptionTextArea.setText((String) hostageData.get(5));
        this.rentField.setText((String) hostageData.get(6));
        this.cityField.setText((String) hostageData.get(7));
        this.streetField.setText((String) hostageData.get(8));
    }
    
    private void subscribeButtonActionPerformed(java.awt.event.ActionEvent evt) {                      
    }                                               

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        this.dispose();
    }  
}
