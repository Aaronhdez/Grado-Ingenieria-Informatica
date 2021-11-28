/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.UsersData;

/**
 *
 * @author Usuario
 */
public class NextCommand implements Command {

    private UsersData usersData;
    
    public NextCommand(UsersData usersData) {
        this.usersData = usersData;
    }

    @Override
    public void execute() {
        this.usersData.next();
    }
    
}
