/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class InitCommand implements Command{
    private final ImageLoader imageLoader;
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public InitCommand(ImageLoader imageLoader, List<Image> images, ImageDisplay imageDisplay) {
        this.imageLoader = imageLoader;
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        images.clear();
        images.addAll(imageLoader.load());
        imageDisplay.show(images.get(0));
    }
    
}
