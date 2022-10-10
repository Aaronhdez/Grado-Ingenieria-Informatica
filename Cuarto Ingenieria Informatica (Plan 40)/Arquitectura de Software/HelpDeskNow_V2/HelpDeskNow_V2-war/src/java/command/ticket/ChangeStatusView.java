/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.ticket;

import command.FrontCommand;
import components.TicketFacade;
import entity.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.transform.TransformerException;
import twoStepTransform.XsltTransformer;

/**
 *
 * @author Usuario
 */
public class ChangeStatusView extends FrontCommand {

    TicketFacade ticketFacade = lookupTicketFacadeBean();

    
    @Override
    public void execute() {
        String ticketId = request.getParameter("ticketId");
        Ticket ticket = ticketFacade.getTicketFrom(Integer.parseInt(ticketId));
        
        String htmlToTransform = getHtmlToTransform(ticket);
        String firstStepFile = "TicketFirstXSL.xsl";
        String secondStepFile = "TicketSecondXSL.xsl";
        XsltTransformer xstlTransformer = new XsltTransformer(firstStepFile, secondStepFile, htmlToTransform);

        try (PrintWriter out = response.getWriter()) {
            String transformedHTML = xstlTransformer.twoStepTransform(request, response);
            out.println(transformedHTML);
        } catch (IOException | URISyntaxException | TransformerException ex) {
            Logger.getLogger(ChangeStatusView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String getHtmlToTransform(Ticket ticket) {
        String htmlToTransform = 
                "<schema>"
                + "<tid>"+ticket.getTicketId()+"</tid>"
                + "<tstatus>"+ticket.getTicketStatus().getName()+"</tstatus>"
                + "</schema>";
        return htmlToTransform;
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
