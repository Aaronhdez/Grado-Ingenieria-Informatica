package imageviewer.app;

import imageviewer.control.Command;
import imageviewer.control.ExitCommand;
import imageviewer.control.InitCommand;
import imageviewer.control.NextCommand;
import imageviewer.control.NullCommand;
import imageviewer.control.PrevCommand;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainFrame {
    /**public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Command> commands = initCommands(new ArrayList(), new MockImageDisplay(), new MockImageLoader());
        while (true) {
            commands.getOrDefault(scanner.next(), NullCommand.Instance).execute();
        }
    }*/
    
        private static Map<String,Command> initCommands(List<Image> images, ImageDisplay imageDisplay, ImageLoader imageLoader){
        HashMap<String,Command> commands = new HashMap<>();
        commands.put("q", new ExitCommand());
        commands.put("i", new InitCommand(imageLoader,images,imageDisplay));
        commands.put("n", new NextCommand(images, imageDisplay));
        commands.put("p", new PrevCommand(images, imageDisplay));
        commands.put("Q", commands.get("q"));
        commands.put("P", commands.get("p"));
        commands.put("N", commands.get("n"));
        return commands;
    }
    
    private static ImageDisplay createImageDisplay(List<Image> images){
        ImageDisplay imageDisplay = new MockImageDisplay();
        imageDisplay.show(images.get(0));
        return imageDisplay;
    }
    
    private static List<Image> loadImages() {
        return new MockImageLoader().load();
    }
}
