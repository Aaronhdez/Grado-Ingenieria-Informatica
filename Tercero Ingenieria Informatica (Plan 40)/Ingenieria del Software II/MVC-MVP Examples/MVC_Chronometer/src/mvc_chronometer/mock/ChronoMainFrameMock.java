/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_chronometer.mock;

import control.Command;
import control.NullCommand;
import control.ResetCommand;
import control.StartCommand;
import control.StopCommand;
import java.util.HashMap;
import java.util.Scanner;
import model.Measure;
import view.ChronoDisplay;

/**
 *
 * @author Usuario
 */
public class ChronoMainFrameMock {
    
    private ChronoDisplay timerDisplay;
    private HashMap<String,Command> commands;
    private Measure measure;

    public ChronoMainFrameMock() {
        this.execute();
    }

    private void execute() {
        this.timerDisplay = new ChronoPanelDisplayMock();
        this.measure = new Measure();
        this.measure.registerObservers(timerDisplay);
        this.timerDisplay.display(measure);
        this.createCommands();
        Scanner scanner = new Scanner(System.in);
        while(true){
            commands.getOrDefault(scanner.next(), NullCommand.Instance).execute();
        }
        //this.commands.get("Start").execute();
    }

    private void createCommands(){
        this.commands = new HashMap<>();
        this.commands.put("c", new StartCommand(this.measure));
        this.commands.put("s", new StopCommand(this.measure));
        this.commands.put("r", new ResetCommand(this.measure));
    }
    

    
    
}
