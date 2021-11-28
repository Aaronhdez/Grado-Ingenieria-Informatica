/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositee1.main;

import compositee1.model.Directory;
import compositee1.model.RegularFile;
import compositee1.view.File;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        File mainDirectory = new Directory("C:\\","Documents");
        mainDirectory.add(new Directory(mainDirectory.getCompletePath()+"\\","Bills"));
        mainDirectory.getFile(0).add(new Directory(mainDirectory.getFile(0).getCompletePath()+"\\","2017-18"));
        mainDirectory.getFile(0).getFile(0).add(new RegularFile(mainDirectory.getFile(0).getCompletePath()+"\\"+"house",".cvs",7402));
        mainDirectory.getFile(0).add(new Directory(mainDirectory.getFile(0).getCompletePath()+"\\","2018-19"));
        mainDirectory.getFile(0).getFile(1).add(new RegularFile(mainDirectory.getFile(0).getCompletePath()+"\\"+"house",".cvs",5402));
        mainDirectory.getFile(0).add(new Directory(mainDirectory.getFile(0).getCompletePath()+"\\","2019-20"));
        mainDirectory.getFile(0).getFile(2).add(new RegularFile(mainDirectory.getFile(0).getCompletePath()+"\\"+"house",".cvs",10402));
        mainDirectory.getFile(0).getFile(2).add(new RegularFile(mainDirectory.getFile(0).getCompletePath()+"\\"+"company",".cvs",3202));
        mainDirectory.add(new Directory(mainDirectory.getCompletePath()+"\\","Memories"));
        mainDirectory.getFile(1).add(new Directory(mainDirectory.getFile(1).getCompletePath()+"\\","2019"));
        mainDirectory.getFile(1).getFile(0).add(new RegularFile(mainDirectory.getFile(1).getCompletePath()+"\\"+"photo",".jpg",1320402));
        mainDirectory.add(new Directory(mainDirectory.getCompletePath()+"\\","Others"));
        mainDirectory.getFile(2).add(new RegularFile(mainDirectory.getFile(2).getCompletePath()+"\\"+"things",".txt",1504));
        mainDirectory.operation();
    }
}
