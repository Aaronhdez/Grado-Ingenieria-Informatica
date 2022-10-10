/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.ticket;

import command.FrontCommand;
import components.TicketFacade;
import components.TicketStatusFacade;
import entity.Agent;
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

/**
 *
 * @author Usuario
 */
public class ChangeStatusCommand extends FrontCommand {

    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();
    TicketFacade ticketFacade = lookupTicketFacadeBean();
    
    @Override
    public void execute() {
        HttpSession session = request.getSession();
        String ticketId = request.getParameter("ticketId");
        String newStatus = request.getParameter("statuses");
        Ticket ticketToUpdate = (Ticket) ticketFacade.getTicketFrom(Integer.parseInt(ticketId));
        TicketStatus newTicketStatus = (TicketStatus) ticketStatusFacade.getTicketStatusFrom(newStatus);
        ticketToUpdate.setTicketStatus(newTicketStatus);
        try {
            ticketFacade.edit(ticketToUpdate);
            Agent userToLogin = (Agent) session.getAttribute("user");
            List<Ticket> ticketsAssignedToAgent = ticketFacade.findTicketsAssignedTo(((Agent) userToLogin));
            session.setAttribute("ticketsAssignedToAgent", ticketsAssignedToAgent);
            forward("/view/agent.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ChangeStatusCommand.class.getName()).log(Level.SEVERE, null, ex);
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

    private TicketStatusFacade lookupTicketStatusFacadeBean() {
        try {
            Context c = new InitialContext();
            return (TicketStatusFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/TicketStatusFacade!components.TicketStatusFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
