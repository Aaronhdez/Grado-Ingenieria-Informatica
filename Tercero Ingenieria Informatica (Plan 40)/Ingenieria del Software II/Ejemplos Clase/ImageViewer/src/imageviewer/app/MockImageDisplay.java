package imageviewer.app;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;

public class MockImageDisplay implements ImageDisplay {

    private Image image;
    
    @Override
    public void show(Image image) {
        this.image = image;
        System.out.println(image.getName());
    }
    
    public Image image() {
        return image;
    }

    @Override
    public void on(Shift shift) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
