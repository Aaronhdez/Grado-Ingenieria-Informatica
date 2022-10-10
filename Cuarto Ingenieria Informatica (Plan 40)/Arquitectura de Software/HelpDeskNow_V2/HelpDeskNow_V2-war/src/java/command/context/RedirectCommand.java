/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.context;

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

public class RedirectCommand extends FrontCommand {

    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();

    
    TicketFacade ticketFacade = lookupTicketFacadeBean();
    
    @Override
    public void execute() {
        String destination = request.getParameter("destination");
        HttpSession session = request.getSession();
        loadParameterAccordingTo(request.getParameter("destination"), session);
        try {
            forward(destination);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RedirectCommand.class.getName()).log(Level.SEVERE, null, ex);
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

    private void loadParameterAccordingTo(String destination,HttpSession session) {
        switch(destination){
            case "/view/openedTickets.jsp":
                TicketStatus closedStatus = ticketStatusFacade.getTicketStatusFrom("CLOSED");
                List<Ticket> openedTickets = (List<Ticket>) ticketFacade.ticketsThatAreNotClosed(closedStatus); 
                List<Ticket> pagedTickets = (List<Ticket>) ticketFacade.findNextOpenedTicketsFrom(0, closedStatus);
                Integer lastResult = pagedTickets.get(pagedTickets.size()-1).getTicketId();
                session.setAttribute("pages", (openedTickets.size()/10));
                session.setAttribute("currentPage", 0);
                session.setAttribute("pagedTicketList", pagedTickets);
                session.setAttribute("lastResult", lastResult);
                break;
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
