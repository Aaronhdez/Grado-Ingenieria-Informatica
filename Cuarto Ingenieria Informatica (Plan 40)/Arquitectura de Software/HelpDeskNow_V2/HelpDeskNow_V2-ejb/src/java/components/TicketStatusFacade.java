/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entity.TicketStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class TicketStatusFacade extends AbstractFacade<TicketStatus> {

    @PersistenceContext(unitName = "HelpDeskNow_V2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketStatusFacade() {
        super(TicketStatus.class);
    }

    public TicketStatus getTicketStatusFrom(String name) {
        Query queryToDB = em.createQuery("SELECT s FROM TicketStatus s WHERE s.name = :name")
                    .setParameter("name", name);
        return (TicketStatus) queryToDB.getSingleResult();
    }
    
}
