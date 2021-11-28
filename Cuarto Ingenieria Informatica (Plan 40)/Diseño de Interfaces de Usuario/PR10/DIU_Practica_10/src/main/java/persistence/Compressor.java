/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JProgressBar;

/**
 *
 * @author Usuario
 */
public interface Compressor {
    void compressSelection(int BUFFER_SIZE, List<String> files, JProgressBar progressBar, String destination, JDialog Dialog);
}
