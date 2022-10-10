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
public class AssignToTechnicianCommand extends FrontCommand  {

    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();
    TicketFacade ticketFacade = lookupTicketFacadeBean();

    @Override
    public void execute() {
        HttpSession session = request.getSession();
        Agent currentAgent = (Agent) session.getAttribute("user");
        String ticketId = request.getParameter("ticketId");
        updateTicket(ticketId, currentAgent);
        try {
            List<Ticket> ticketsAssignedToAgent = ticketFacade.findTicketsAssignedTo(((Agent) currentAgent));
            session.setAttribute("ticketsAssignedToAgent", ticketsAssignedToAgent);
            forward("/view/agent.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AssignToTechnicianCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void updateTicket(String ticketId, Agent currentAgent) {
        Ticket ticket = ticketFacade.getTicketFrom((Integer) Integer.parseInt(ticketId));
        ticket.setAgent(currentAgent);
        ticket.setTicketStatus(ticketStatusFacade.getTicketStatusFrom("ASSIGNED"));
        ticketFacade.edit(ticket);
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
