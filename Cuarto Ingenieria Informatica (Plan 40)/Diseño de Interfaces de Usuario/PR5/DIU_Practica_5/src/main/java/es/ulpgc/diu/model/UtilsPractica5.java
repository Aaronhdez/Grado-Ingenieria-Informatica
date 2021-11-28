
package es.ulpgc.diu.model;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class UtilsPractica5 {
    private static BufferedImage clonarImagen(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    
    public static BufferedImage seleccionarComponentes(BufferedImage img, boolean c_red, boolean c_green, boolean c_blue){
        int mask = 0x000000;
        if (c_red) mask = mask | 0xFF0000;
        if (c_green) mask = mask | 0x00FF00;
        if (c_blue) mask = mask | 0x0000FF;
        
        BufferedImage img_copy = clonarImagen(img);
        for (int j=0;j<img.getHeight();j++){
            for (int i=0;i<img.getWidth();i++){
                img_copy.setRGB(i, j, mask & img.getRGB(i, j));
            }
        }
        return img_copy;
    }
    
    
}
