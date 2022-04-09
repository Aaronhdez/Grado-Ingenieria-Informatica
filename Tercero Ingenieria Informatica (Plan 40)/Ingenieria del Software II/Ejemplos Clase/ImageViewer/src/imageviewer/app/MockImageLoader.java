
package imageviewer.app;

import java.util.ArrayList;
import java.util.List;
import imageviewer.model.Image;
import imageviewer.view.ImageLoader;

public class MockImageLoader implements ImageLoader {

    @Override
    public List<Image> load() {
        ArrayList<Image> list = new ArrayList<>();
        list.add(new Image("hola"));
        list.add(new Image("mundo"));
        list.add(new Image("bienvenido"));
        return list;
    }
    
}
