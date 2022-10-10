/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entity.Comment;
import entity.Ticket;
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
public class CommentFacade extends AbstractFacade<Comment> {

    @PersistenceContext(unitName = "HelpDeskNow_V2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }

    public List<Comment> getCommandsAssociatedTo(Ticket ticketToDisplay) {
        Query queryToDB = em.createQuery("SELECT c FROM Comment c WHERE c.ticket = :ticketToDisplay")
                    .setParameter("ticketToDisplay", ticketToDisplay);
        List<Comment> CommentsList = queryToDB.getResultList();
        return CommentsList;
    }
    
}
