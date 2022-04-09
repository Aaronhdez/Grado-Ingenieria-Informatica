package app;

import control.Command;
import control.DownCommand;
import control.LeftCommand;
import control.RightCommand;
import control.UpCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import model.Block;
import view.BlockDisplay;


public class Main extends JFrame{
    private Block block;
    private BlockDisplay blockDisplay;
    private Map<String,Command> commands;
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main(){
        this.setTitle("Block Shifter");
        this.setSize(700,750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
    }
    
    private void execute() {
        this.block = new Block();
        this.blockDisplay.display(block);
        this.block.register(blockDisplay);
        this.commands = createCommands();
        this.setVisible(true);
    }
    
    private BlockPanel blockPanel(){
        BlockDisplay blockPanel =  new BlockPanel();
        this.blockDisplay = blockPanel;
        return (BlockPanel) blockPanel;
    }

    private HashMap<String,Command> createCommands(){
        HashMap<String,Command> comms = new HashMap<String,Command>();
        comms.put("U", new UpCommand(this.block));
        comms.put("D", new DownCommand(this.block));
        comms.put("L", new LeftCommand(this.block));
        comms.put("R", new RightCommand(this.block));
        return comms;
    }    
    
    private Component toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(button("L"));
        toolbar.add(button("R"));
        toolbar.add(button("U"));
        toolbar.add(button("D"));
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
