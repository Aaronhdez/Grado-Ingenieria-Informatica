/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.ticket;

import command.FrontCommand;
import components.CommentFacade;
import components.TicketFacade;
import entity.Comment;
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

public class ViewTicketCommand extends FrontCommand {

    CommentFacade commentFacade = lookupCommentFacadeBean();
    TicketFacade ticketFacade = lookupTicketFacadeBean();

    @Override
    public void execute() {
        HttpSession session = request.getSession();
        String ticketId = request.getParameter("ticketId");
        Ticket ticketToDisplay = (Ticket) ticketFacade.getTicketFrom(Integer.parseInt(ticketId));
        try {
            List<Comment> commentsAssociated = commentFacade.getCommandsAssociatedTo(ticketToDisplay);
            session.setAttribute("commentsAssociated", commentsAssociated);
            session.setAttribute("currentTicket", ticketToDisplay);
            forward("/view/ticket.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(ViewTicketCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewTicketCommand.class.getName()).log(Level.SEVERE, null, ex);
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

    private CommentFacade lookupCommentFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CommentFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/CommentFacade!components.CommentFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
