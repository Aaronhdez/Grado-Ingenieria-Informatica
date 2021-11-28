
package model;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import persistence.Compressor;

/**
 *
 * @author Usuario
 */
public class ZipCompressor extends SwingWorker<Void, Void> implements Compressor {
    List<String> files; 
    private int BUFFER_SIZE;
    private JProgressBar progressBar;
    private int filesDone;
    private int filesToDo;
    private String destination;
    private JDialog dialog;
    
    @Override
    public void compressSelection(int BUFFER_SIZE, List<String> files, JProgressBar progressBar, String destination, JDialog dialog) {
        loadFields(files, BUFFER_SIZE, progressBar, destination, dialog);
        this.execute();
    }

    private void loadFields(List<String> files1, int BUFFER_SIZE1, JProgressBar progressBar1, String destination, JDialog dialog) {
        this.dialog = dialog;
        this.files = files1;
        this.BUFFER_SIZE = BUFFER_SIZE1;
        this.progressBar = progressBar1;
        this.filesDone = 0;
        this.filesToDo = files1.size();
        this.destination = destination;
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(filesToDo);
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        try {
            BufferedInputStream origin = null;
            
            FileOutputStream destination_file = null;
                try {
                    destination_file = new FileOutputStream(this.destination);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ZipCompressor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            try (ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(destination_file))) {
                byte[] data = new byte[BUFFER_SIZE];
                for (String filename : files) {
                    FileInputStream fi = new FileInputStream(filename);
                    
                    origin = new BufferedInputStream(fi, BUFFER_SIZE);
                    ZipEntry entry = new ZipEntry( new File(filename).getName() );
                    out.putNextEntry( entry );
                    int count;
                    while((count = origin.read(data, 0, BUFFER_SIZE)) != -1){
                        out.write(data, 0, count);
                    }
                    origin.close();
                    this.filesDone += 1;
                    
                    Thread.sleep(100);
                    this.progressBar.setValue(filesDone);
                }
                this.progressBar.setValue(100);
            }
        } catch( IOException e ){
        }
        return null;
    }
    
    @Override
    public void done(){
        this.dialog.setVisible(false);
    }
}
