/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NextCommand implements Command {
    
    private final List<Image> images;
    private final ImageDisplay imagesDisplay;

    public NextCommand(List<Image> images, ImageDisplay imagesDisplay) {
        this.images = images;
        this.imagesDisplay = imagesDisplay;
    }
    
    @Override
    public void execute() {
        imagesDisplay.show(next());
    }
    
    private Image next(){
        int index = images.indexOf(imagesDisplay.image());
        return images.get((index+1) % images.size());
    }
    
}
