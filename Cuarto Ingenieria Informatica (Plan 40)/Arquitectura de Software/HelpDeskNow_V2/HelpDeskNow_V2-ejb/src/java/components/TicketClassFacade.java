/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entity.TicketClass;
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
public class TicketClassFacade extends AbstractFacade<TicketClass> {

    @PersistenceContext(unitName = "HelpDeskNow_V2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketClassFacade() {
        super(TicketClass.class);
    }

    public TicketClass getTicketClassFrom(String name) {
        Query queryToDB = em.createQuery("SELECT tc FROM TicketClass tc WHERE tc.name = :name")
                    .setParameter("name", name);
        return (TicketClass) queryToDB.getSingleResult();
    }
    
}
