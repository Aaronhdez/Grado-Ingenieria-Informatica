/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.app.helpers;

import es.ulpgc.diu.fx.SaveDialog;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

/**
 *
 * @author Aaron
 */
public class DesktopHelper {
    
    public static void saveImage(JInternalFrame[] allFrames) {
        var openedThresholdFrames = getOpenedThresholdFrames(allFrames);
        SaveDialog saveDialog = new SaveDialog(openedThresholdFrames);
        saveDialog.setVisible(true);
    }
    
    public static ArrayList<JInternalFrame> getOpenedThresholdFrames(JInternalFrame[] arrayOfFrames){
        ArrayList<JInternalFrame> openedThresholdFrames = new ArrayList();
        for (int i = 0; i <= arrayOfFrames.length-1; i++) {
            if(arrayOfFrames[i].getTitle().contains("Factor-de-umbral")){
                openedThresholdFrames.add(arrayOfFrames[i]);
            }
        }
        return openedThresholdFrames;
    }

}
