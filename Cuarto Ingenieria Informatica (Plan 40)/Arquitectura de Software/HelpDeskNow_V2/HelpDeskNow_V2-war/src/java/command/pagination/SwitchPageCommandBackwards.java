/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.pagination;

import command.FrontCommand;
import command.context.RedirectCommand;
import components.TicketFacade;
import components.TicketStatusFacade;
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
public class SwitchPageCommandBackwards extends FrontCommand{

    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();
    TicketFacade ticketFacade = lookupTicketFacadeBean();
    
    @Override
    public void execute() {
        HttpSession session = request.getSession();
        Integer pages = (Integer) session.getAttribute("pages");
        Integer currentPage = (Integer) session.getAttribute("currentPage");
        Integer lastResult = Integer.parseInt(request.getParameter("lastResult"));
        List<Ticket> pagedTickets = (List<Ticket>) session.getAttribute("pagedTicketList");
        lastResult = pagedTickets.get(0).getTicketId();
        
        if(currentPage > 0){
            currentPage -= 1;
            session.setAttribute("currentPage", currentPage);
            TicketStatus closedStatus = ticketStatusFacade.getTicketStatusFrom("CLOSED");
            pagedTickets = (List<Ticket>) ticketFacade.findPreviousOpenedTicketsFrom(lastResult, closedStatus);
            lastResult = pagedTickets.get(pagedTickets.size()-1).getTicketId();
            session.setAttribute("lastResult", lastResult);
            session.setAttribute("pagedTicketList", pagedTickets);
        }
        try {
            forward("/view/openedTickets.jsp");
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
