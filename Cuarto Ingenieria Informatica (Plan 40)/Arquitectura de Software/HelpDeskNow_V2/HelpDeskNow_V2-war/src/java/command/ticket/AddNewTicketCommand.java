/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.ticket;

import command.FrontCommand;
import components.ClientFacade;
import components.CommentFacade;
import components.TicketClassFacade;
import components.TicketFacade;
import components.TicketStatusFacade;
import entity.Agent;
import entity.Client;
import entity.Ticket;
import entity.TicketClass;
import entity.TicketStatus;
import helpers.DataHelper;
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
public class AddNewTicketCommand extends FrontCommand {

    ClientFacade clientFacade = lookupClientFacadeBean();
    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();
    TicketClassFacade ticketClassFacade = lookupTicketClassFacadeBean();
    CommentFacade commentFacade = lookupCommentFacadeBean();
    TicketFacade ticketFacade = lookupTicketFacadeBean();

    @Override
    public void execute() {
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Object currentUser = session.getAttribute("user");
        String ticketClass = request.getParameter("ticketClass");
        
        if(ticketCanBeCreated(currentUser, session)){
            createTicket(currentUser, message, title, ticketClass, session);
            try {
                if(userIsAnAgent(currentUser)){
                    forward("/view/agent.jsp");
                } else {
                    forward("/view/client.jsp");
                }
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AddNewTicketCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("headerMsg", "An Issue has Ocurred");
                forward("/view/client.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AddNewTicketCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private static boolean ticketCanBeCreated(Object currentUser, HttpSession session) {
        return currentUser != null && session != null;
    }

    private void createTicket(Object currentUser, String message, String title, String ticketClass, HttpSession session) {
        String date = DataHelper.generateDate();
        TicketClass tClass = ticketClassFacade.getTicketClassFrom(ticketClass);
        TicketStatus tStatus = ticketStatusFacade.getTicketStatusFrom("UNASSIGNED");
        Ticket newTicket = null;
        addTicketToDB(currentUser, title, message, date, tClass, tStatus, session);
    }

    private void addTicketToDB(Object currentUser, String title, String message, String date, TicketClass tClass, TicketStatus tStatus, HttpSession session) {
        Ticket newTicket;
        if(currentUser instanceof Agent){
            Client client = clientFacade.getAgentClientUser();
            newTicket = new Ticket(title, message, date, ((Agent) currentUser), client, tClass, tStatus);
            ticketFacade.create(newTicket);
            List<Ticket> ticketsAssignedToAgent = ticketFacade.findTicketsAssignedTo(((Agent) currentUser));
            session.setAttribute("ticketsAssignedToAgent", ticketsAssignedToAgent);
        } else {
            newTicket = new Ticket(title, message, date, null, ((Client) currentUser), tClass, tStatus);
            ticketFacade.create(newTicket);
            List<Ticket> ticketsCreatedByClient = ticketFacade.ticketsCreatedBy(((Client) currentUser));
            session.setAttribute("ticketsCreatedByClient", ticketsCreatedByClient);
        }
    }

    private static boolean userIsAnAgent(Object currentUser) {
        return currentUser instanceof Agent;
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

    private TicketClassFacade lookupTicketClassFacadeBean() {
        try {
            Context c = new InitialContext();
            return (TicketClassFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/TicketClassFacade!components.TicketClassFacade");
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

    private ClientFacade lookupClientFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ClientFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/ClientFacade!components.ClientFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
