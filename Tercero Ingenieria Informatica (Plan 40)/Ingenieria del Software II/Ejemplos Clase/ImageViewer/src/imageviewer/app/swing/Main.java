/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.app.swing;

import imageviewer.control.Command;
import imageviewer.control.ImagePresenter;
import imageviewer.control.NextCommand;
import imageviewer.control.PrevCommand;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Main extends JFrame {
    private Map<String,Command> commands;
    private List<Image> images;
    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;
    
    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        this.setTitle("Image Viewer");
        this.setSize(800,650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(imagePanel());
        this.add(toolbar(), BorderLayout.SOUTH);
    }
    
    private void execute(){
        this.images = new FileImageLoader(new File("./fotos")).load();
        this.imageDisplay.show(images.get(0));
        this.imagePresenter = new ImagePresenter(images, imageDisplay);
        this.createCommands();
        this.setVisible(true);
    }
    
    private JPanel imagePanel(){
        ImagePanel imagePanel;
        try {
            imagePanel = new ImagePanel();
        } catch (IOException ex) {
            imagePanel = null;
        }
        this.imageDisplay = imagePanel;
        return imagePanel;
    }

    private void createCommands(){
        this.commands = new HashMap<>();
        this.commands.put("<", new NextCommand(this.images, this.imageDisplay));
        this.commands.put(">", new PrevCommand(this.images, this.imageDisplay));
    }
    
    private Component toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(button("<"));
        toolbar.add(button(">"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton btn = new JButton(name);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evn){
                commands.get(name).execute();
            }
        });
        return btn;
    }

}
