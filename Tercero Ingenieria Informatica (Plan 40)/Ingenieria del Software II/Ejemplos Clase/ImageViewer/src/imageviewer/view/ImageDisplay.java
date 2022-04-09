
package imageviewer.view;

import imageviewer.model.Image;

public interface ImageDisplay {
    public void show(Image image);
    public Image image();
    
    void on(Shift shift);
    interface Shift {
        public Image right();
        public Image left();
    }
}
