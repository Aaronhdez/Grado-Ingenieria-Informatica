/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.comment;

import command.FrontCommand;
import components.CommentFacade;
import entity.Agent;
import entity.Client;
import entity.Comment;
import entity.Ticket;
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

public class AddCommentCommand extends FrontCommand {

    CommentFacade commentFacade = lookupCommentFacadeBean();
    
    @Override
    public void execute() {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Ticket ticket = (Ticket) session.getAttribute("currentTicket");
        Comment newComment = null;
        if(user instanceof Agent){
            newComment = createCommentForAgent(user, ticket);
        } else {
            newComment = createCommentForClient(user, ticket);
        }
        commentFacade.create(newComment);
        try {
            List<Comment> commentsAssociated = commentFacade.getCommandsAssociatedTo(ticket);
            session.setAttribute("commentsAssociated", commentsAssociated);
            forward("/view/ticket.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddCommentCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
{
        }
    }

    private Comment createCommentForAgent(Object user, Ticket ticket) {
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        String dateOfPost = DataHelper.generateDate();
        return new Comment((Agent) user, title, message, dateOfPost, ticket);
    }

    private Comment createCommentForClient(Object user, Ticket ticket) {
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        String dateOfPost = DataHelper.generateDate();
        return new Comment((Client)user, title, message, dateOfPost, ticket);
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
