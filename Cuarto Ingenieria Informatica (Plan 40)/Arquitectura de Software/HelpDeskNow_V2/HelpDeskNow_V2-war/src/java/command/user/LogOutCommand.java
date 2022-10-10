/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.user;

import command.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author Usuario
 */
public class LogOutCommand extends FrontCommand {

    @Override
    public void execute() {
        request.getSession().invalidate();
        try {
            request.setAttribute("headerMsg", "Log Out succesfully");
            forward("/view/info.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogOutCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
