/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entity.Agent;
import entity.Client;
import entity.Ticket;
import entity.TicketStatus;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class TicketFacade extends AbstractFacade<Ticket> {

    @PersistenceContext(unitName = "HelpDeskNow_V2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketFacade() {
        super(Ticket.class);
    }

    public List<Ticket> findTicketsAssignedTo(Agent agent){
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t WHERE t.agent = :agent")
                    .setParameter("agent", agent);
        List<Ticket> TicketsList = queryToDB.getResultList();
        return TicketsList;
    }

    public List<Ticket> ticketsCreatedBy(Client client) {
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t WHERE t.client = :client")
                    .setParameter("client", client);
        List<Ticket> TicketsList = queryToDB.getResultList();
        return TicketsList;
    }    
    
    public List<Ticket> ticketsThatAreNotClosed(TicketStatus ticketStatus) {
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t WHERE t.ticketStatus != :ticketStatus")
                    .setParameter("ticketStatus", ticketStatus);
        List<Ticket> TicketsList = queryToDB.getResultList();
        return TicketsList;
    } 
    
    public List<Ticket> findNextOpenedTicketsFrom(Integer firstResult, TicketStatus ticketStatus) {
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t "
                + "WHERE t.ticketId > :firstResult AND t.ticketStatus != :ticketStatus")
                    .setParameter("firstResult", firstResult)
                    .setParameter("ticketStatus", ticketStatus)
                    .setMaxResults(10);
        
        List<Ticket> TicketsList = queryToDB.getResultList();
        return TicketsList;
    } 
    
        
    public List<Ticket> findPreviousOpenedTicketsFrom(Integer firstResult, TicketStatus ticketStatus) {
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t "
                + "WHERE t.ticketId < :firstResult AND t.ticketStatus != :ticketStatus ORDER BY t.ticketId DESC")
                    .setParameter("firstResult", firstResult)
                    .setParameter("ticketStatus", ticketStatus)
                    .setMaxResults(10);
        
        List<Ticket> TicketsList = queryToDB.getResultList();
        Collections.reverse(TicketsList);
        return TicketsList;
    } 
    
    public Ticket getTicketFrom(Integer ticketId){
        Query queryToDB = em.createQuery("SELECT t FROM Ticket t WHERE t.ticketId = :ticket_id")
                    .setParameter("ticket_id", ticketId);
        Ticket ticket = (Ticket) queryToDB.getSingleResult();
        return ticket;
    }
}
