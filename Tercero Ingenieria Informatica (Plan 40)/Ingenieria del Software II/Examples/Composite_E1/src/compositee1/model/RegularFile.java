/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositee1.model;

import compositee1.view.File;
import java.text.DecimalFormat;

/**
 *
 * @author Usuario
 */
public class RegularFile implements File {
    private final String name;
    private final String extension;
    private int size;
    private int level;
    
    public RegularFile(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.level = 0;
        this.size = size;
    }

    @Override
    public String getCompletePath() {
        return this.name+"";
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public int getSize() {
        return size;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public String getNormalizaedSize(){
        float aux = (float) this.size;
        DecimalFormat df = new DecimalFormat("#.00");
        if(this.size >= 1024 && this.size < (1024*1024)){
            return df.format(aux / 1024.F)+ " k";
        } else if(this.size >= (1024*1024)){
            return df.format(aux / (1024*1024.F)) + " M";
        } else {
            return df.format(aux)+"";
        }
    }
    
    @Override
    public void setIndent() {
        for (int i = 0; i < this.level-2; i++) System.out.print(" ");
        System.out.print("|_");
    }
    
    @Override
    public void operation() {
        this.setIndent();
        System.out.println("-" + this.getName()+this.getExtension()+ ": " + this.getNormalizaedSize() + "B");
    }
    
}
