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
public class SaveCommand implements Command{

    private final UsersData usersData;
    private final String name;
    private final String surname;
    private final String nid;
    private final String birthDate;

    public SaveCommand(UsersData usersData, String name, String surname, String nid, String birthDate) {
        this.usersData = usersData;
        this.name = name;
        this.surname = surname;
        this.nid = nid;
        this.birthDate = birthDate;
    }

    @Override
    public void execute() {
    }
    
    
}
