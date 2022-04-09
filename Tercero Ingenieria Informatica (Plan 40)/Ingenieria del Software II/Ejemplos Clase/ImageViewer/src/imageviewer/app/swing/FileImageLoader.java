/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.app.swing;

import imageviewer.model.Image;
import imageviewer.view.ImageLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FileImageLoader implements ImageLoader {

    private final File root;

    public FileImageLoader(File root) {
        this.root = root;
    }
    
    @Override
    public List<Image> load() {
        List<Image> result = new ArrayList<>();
        for (File file : root.listFiles(filter())) {
            result.add(new Image(file.getAbsolutePath()));
        }
        return result;
    }

    private static final String[] ImageExtensions = new String[] {"jpg","png","bmp"};
    private FilenameFilter filter() {
        return new FilenameFilter(){
            @Override
            public boolean accept(File file, String name) {
                for (String ImageExtension : ImageExtensions) {
                    if(name.endsWith(ImageExtension)) return true;
                }
                return false;
            }
        };
    }
    
}
