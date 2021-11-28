/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Account;

/**
 *
 * @author Usuario
 */
public interface AccountDisplay extends Account.Observer {
    void display(Account account);
}
