/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app;

import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import model.ZipCompressor;
import persistence.Compressor;

/**
 *
 * @author Usuario
 */
public class App extends javax.swing.JFrame {

    private JFileChooser fileSelectionChooser;
    private JFileChooser fileToSaveChooser;
    private Compressor fileCompressor;
    private String destination;
    /**
     * Creates new form App
     */
    public App() {
        configureFileChoosers();
        initComponents();      
        this.progressBarDialog.setLocationRelativeTo(this);
    }

    private void configureFileChoosers() {
        this.fileSelectionChooser = new JFileChooser();
        fileSelectionChooser.setDialogTitle("Elige los ficheros a comprimir");
        fileSelectionChooser.setMultiSelectionEnabled(true);
        fileSelectionChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        this.fileToSaveChooser = new JFileChooser();
        fileSelectionChooser.setDialogTitle("Elige donde guardar");
        fileToSaveChooser.setMultiSelectionEnabled(false);
        fileToSaveChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBarDialog = new javax.swing.JDialog();
        progressBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        cancelTaskButton = new javax.swing.JButton();
        bufferSelectorGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedFilesList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        selectFilesButton = new javax.swing.JButton();
        compressFileButton = new javax.swing.JButton();
        clearListButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        oneKSelectorButton = new javax.swing.JRadioButton();
        twoKSelectorButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitButton = new javax.swing.JMenuItem();

        progressBarDialog.setTitle("Comprimiendo");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Progreso de la compresi??n");

        cancelTaskButton.setText("Cancelar");
        cancelTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout progressBarDialogLayout = new javax.swing.GroupLayout(progressBarDialog.getContentPane());
        progressBarDialog.getContentPane().setLayout(progressBarDialogLayout);
        progressBarDialogLayout.setHorizontalGroup(
            progressBarDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressBarDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progressBarDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressBarDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        progressBarDialogLayout.setVerticalGroup(
            progressBarDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressBarDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelTaskButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setViewportView(selectedFilesList);

        jPanel2.setLayout(new java.awt.GridLayout(3, 0, 0, 20));

        selectFilesButton.setText("Seleccionar Ficheros");
        selectFilesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFilesButtonActionPerformed(evt);
            }
        });
        jPanel2.add(selectFilesButton);

        compressFileButton.setText("Comprimir");
        compressFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressFileButtonActionPerformed(evt);
            }
        });
        jPanel2.add(compressFileButton);

        clearListButton.setText("Limpiar Lista");
        jPanel2.add(clearListButton);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        bufferSelectorGroup.add(oneKSelectorButton);
        oneKSelectorButton.setSelected(true);
        oneKSelectorButton.setText("1024 Bytes");
        jPanel3.add(oneKSelectorButton);

        bufferSelectorGroup.add(twoKSelectorButton);
        twoKSelectorButton.setText("2048 Bytes");
        jPanel3.add(twoKSelectorButton);

        jLabel2.setText("Tama??o del Bloque");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 173, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jMenu1.add(exitButton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFilesButtonActionPerformed
        ArrayList<String> fileNames = new ArrayList();
        loadFilesToCompress(fileNames);
        this.selectedFilesList.setModel(updateSelectionList(fileNames));
    }//GEN-LAST:event_selectFilesButtonActionPerformed


    private void loadFilesToCompress(ArrayList<String> fileNames) throws HeadlessException {
        if(fileSelectionChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            this.destination = fileSelectionChooser.getCurrentDirectory().getName() + ".zip";
            for (File file : fileSelectionChooser.getSelectedFiles()) {
                fileNames.add(file.getAbsolutePath());
            }
        }
    }

    private DefaultListModel<String> updateSelectionList(ArrayList<String> fileNames) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < fileNames.size(); i++) {
            model.add(i, fileNames.get(i));
        }
        return model;
    }
    
    private void compressFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressFileButtonActionPerformed
        sendFilesToCompressor(getFilesFromList());
    }//GEN-LAST:event_compressFileButtonActionPerformed

    private ArrayList<String> getFilesFromList() {
        ArrayList<String> fileNames = new ArrayList();
        DefaultListModel<String> filesSelected = (DefaultListModel<String>) this.selectedFilesList.getModel();
        for (int i = 0; i < filesSelected.getSize(); i++) {
            fileNames.add(filesSelected.get(i));
        }
        return fileNames;
    }

    private void sendFilesToCompressor(ArrayList<String> fileNames) {
        this.fileCompressor = new ZipCompressor();
        int bufferSize = getBufferSize();
        fileToSaveChooser.setSelectedFile(new File(this.destination));
        if(fileToSaveChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            this.progressBarDialog.pack();
            this.progressBarDialog.setVisible(true);
            this.fileCompressor.compressSelection(bufferSize, fileNames, 
                    this.progressBar, fileToSaveChooser.getSelectedFile().getAbsolutePath(),
                    this.progressBarDialog);
        }
        
    }

    private int getBufferSize() throws NumberFormatException {
        String bufferSizeSelected = (this.oneKSelectorButton.isSelected()) ?
                "1024" :
                "2048" ;
        int bufferSize = Integer.parseInt(bufferSizeSelected);
        return bufferSize;
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.closeApp();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void cancelTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTaskButtonActionPerformed
        ((SwingWorker) this.fileCompressor).cancel(true);
        this.progressBarDialog.setVisible(false);
    }//GEN-LAST:event_cancelTaskButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bufferSelectorGroup;
    private javax.swing.JButton cancelTaskButton;
    private javax.swing.JButton clearListButton;
    private javax.swing.JButton compressFileButton;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton oneKSelectorButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JDialog progressBarDialog;
    private javax.swing.JButton selectFilesButton;
    private javax.swing.JList<String> selectedFilesList;
    private javax.swing.JRadioButton twoKSelectorButton;
    // End of variables declaration//GEN-END:variables

    private void closeApp() {
        System.exit(0);
    }
}
