/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.ticket;

import command.FrontCommand;
import command.user.LoginCommand;
import components.TicketFacade;
import components.TicketStatusFacade;
import entity.Agent;
import entity.Client;
import entity.Ticket;
import entity.TicketStatus;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class CloseTicketCommand extends FrontCommand {

    TicketFacade ticketFacade = lookupTicketFacadeBean();
    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();

    @Override
    public void execute() {
        HttpSession session = request.getSession(); 
        Object currentUser = session.getAttribute("user");
        closeTicket(session);
        forwardToMainPage(currentUser);
    }

    private void closeTicket(HttpSession session) {
        Ticket ticketToUpdate = (Ticket) session.getAttribute("currentTicket");
        TicketStatus newTicketStatus = (TicketStatus) ticketStatusFacade.getTicketStatusFrom("CLOSED");
        ticketToUpdate.setTicketStatus(newTicketStatus);
        ticketFacade.edit(ticketToUpdate);
    }

    private void forwardToMainPage(Object currentUser) {
        try {
            HttpSession session = request.getSession(true);
            if (currentUser instanceof Agent){
                List<Ticket> ticketsAssignedToAgent = ticketFacade.findTicketsAssignedTo(((Agent) currentUser));
                session.setAttribute("ticketsAssignedToAgent", ticketsAssignedToAgent);
                forward("/view/agent.jsp");
            } else {
                List<Ticket> ticketsCreatedByClient = ticketFacade.ticketsCreatedBy(((Client) currentUser));
                session.setAttribute("ticketsCreatedByClient", ticketsCreatedByClient);
                forward("/view/client.jsp");
            } 
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TicketStatusFacade lookupTicketStatusFacadeBean() {
        try {
            Context c = new InitialContext();
            return (TicketStatusFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/TicketStatusFacade!components.TicketStatusFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TicketFacade lookupTicketFacadeBean() {
        try {
            Context c = new InitialContext();
            return (TicketFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/TicketFacade!components.TicketFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
