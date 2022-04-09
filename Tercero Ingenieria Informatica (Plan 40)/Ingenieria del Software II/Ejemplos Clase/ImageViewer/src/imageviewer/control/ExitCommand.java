/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.control;

/**
 *
 * @author Usuario
 */
public class ExitCommand implements Command {

    public ExitCommand() {
    }

    @Override
    public void execute() {
        System.exit(0);
    }
    
}
