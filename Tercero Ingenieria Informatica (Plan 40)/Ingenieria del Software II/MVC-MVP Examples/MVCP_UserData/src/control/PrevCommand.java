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
public class PrevCommand implements Command {

    private final UsersData usersData;

    public PrevCommand(UsersData usersData) {
        this.usersData = usersData;
    }

    @Override
    public void execute() {
        this.usersData.prev();
    }
    
}
