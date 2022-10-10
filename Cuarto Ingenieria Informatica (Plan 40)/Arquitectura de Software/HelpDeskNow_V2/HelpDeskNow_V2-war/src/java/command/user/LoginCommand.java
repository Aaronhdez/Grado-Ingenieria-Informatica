/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.user;

import command.FrontCommand;
import components.AgentFacade;
import components.ClientFacade;
import components.TicketClassFacade;
import components.TicketFacade;
import components.TicketStatusFacade;
import entity.Agent;
import entity.Client;
import entity.Ticket;
import entity.embedded.AgentData;
import entity.embedded.ClientData;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand extends FrontCommand {

    TicketStatusFacade ticketStatusFacade = lookupTicketStatusFacadeBean();
    TicketClassFacade ticketClassFacade = lookupTicketClassFacadeBean();
    ClientFacade clientFacade = lookupClientFacadeBean1();
    TicketFacade ticketFacade = lookupTicketFacadeBean();
    AgentFacade agentFacade = lookupAgentFacadeBean();
    
    @Override
    public void execute(){
        Object userToLogIn = createUserToLogin(request);
        userToLogIn = verifyUserExistence(userToLogIn);
        forwardToProperPage(userToLogIn);
    }

    private Object createUserToLogin(HttpServletRequest request) {
        String type = request.getParameter("userType");
        String name = request.getParameter("user");
        String password = request.getParameter("password");
        return type.equals("Agent") ? 
                new AgentData(name, password) :
                new ClientData(name, password);
    }

    private Object verifyUserExistence(Object userToLogin) {
        if(userToLogin instanceof AgentData){
            return VerifyAgentInDB((AgentData) userToLogin);
        }
        if(userToLogin instanceof ClientData){
            return VerifyClientInDB((ClientData) userToLogin);
        }
        return null;
    }

    private Agent VerifyAgentInDB(AgentData agentData) {
        Agent agentFromDB = agentFacade.findByName(agentData.getName());
        if(agentFromDB.getAgentData().equals(agentData)){
            return agentFromDB;
        }
        return null;
    }

    private Client VerifyClientInDB(ClientData clientData) {
        Client clientFromDB = (Client) clientFacade.findByName(clientData.getName());
        if(clientFromDB.getClientData().equals(clientData)){
            return clientFromDB;
        }
        return null;
    }
    
    private void forwardToProperPage(Object userToLogin) {
        if(userToLogin == null){ 
            sendToUserUnknownPage();
        } else {
            sentToProfilePage(userToLogin);
        }
    }

    private void sendToUserUnknownPage() {
        try {
            request.setAttribute("headerMsg", "Wrong username or password");
            forward("/view/info.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sentToProfilePage(Object userToLogin) {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", userToLogin);
            session.setAttribute("ticketStatusList", ticketStatusFacade.findAll());
            session.setAttribute("ticketClassList", ticketClassFacade.findAll());
            if (userToLogin instanceof Agent){
                List<Ticket> ticketsAssignedToAgent = ticketFacade.findTicketsAssignedTo(((Agent) userToLogin));
                session.setAttribute("ticketsAssignedToAgent", ticketsAssignedToAgent);
                forward("/view/agent.jsp");
            } else {
                List<Ticket> ticketsCreatedByClient = ticketFacade.ticketsCreatedBy(((Client) userToLogin));
                session.setAttribute("ticketsCreatedByClient", ticketsCreatedByClient);
                forward("/view/client.jsp");
            } 
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private AgentFacade lookupAgentFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AgentFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/AgentFacade!components.AgentFacade");
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

    private ClientFacade lookupClientFacadeBean1() {
        try {
            Context c = new InitialContext();
            return (ClientFacade) c.lookup("java:global/HelpDeskNow_V2/HelpDeskNow_V2-ejb/ClientFacade!components.ClientFacade");
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


}
