/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositee1.model;

import compositee1.view.File;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Directory implements File{
    private ArrayList<File> files;
    private final String name;
    private final String path;
    private int level;

    public Directory(String path, String name) {
        this.files = new ArrayList();
        this.name = name;
        this.path = path;
        this.level = 0;
    }

    @Override
    public String getCompletePath() {
        return this.path+this.name+"";
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public void add(File f) {
        f.setLevel(this.level+2);
        this.files.add(f); 
    }

    @Override
    public void remove(File f) {
        this.files.remove(f); 
    }

    @Override
    public File getFile(int file) {
        return this.files.get(file); 
    }

    @Override
    public void setIndent() {
        for (int i = 0; i < this.level-2; i++) System.out.print(" ");
        System.out.print("|_");
    }
    
    @Override
    public void operation() {
        if(level != 0) setIndent();
        System.out.println("+" + this.getCompletePath());
        for (File file : files) {
            file.operation();
        }
    }
    
}
