/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Usuario
 */
public class NullCommand implements Command {

    public static final Command Instance = new NullCommand();
    
    @Override
    public void execute() {
    }
    
}
