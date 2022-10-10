/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entity.Client;
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
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "HelpDeskNow_V2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
   
    public Client findByName(String name){
        Query queryToDB = em.createQuery("SELECT c FROM Client c WHERE c.name = :name")
                    .setParameter("name", name);
        Client client = (Client) queryToDB.getSingleResult();
        return client;
    }

    public Client getAgentClientUser() {
        Query queryToDB = em.createQuery("SELECT c FROM Client c WHERE c.name = 'Agent_Assignee'");
        return (Client) queryToDB.getSingleResult();
    }
}
