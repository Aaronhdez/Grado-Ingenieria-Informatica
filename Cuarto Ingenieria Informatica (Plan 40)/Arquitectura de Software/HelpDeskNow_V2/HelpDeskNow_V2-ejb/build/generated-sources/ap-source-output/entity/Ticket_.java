package entity;

import entity.Agent;
import entity.Client;
import entity.TicketClass;
import entity.TicketStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, String> date;
    public static volatile SingularAttribute<Ticket, Agent> agent;
    public static volatile SingularAttribute<Ticket, TicketClass> ticketClass;
    public static volatile SingularAttribute<Ticket, TicketStatus> ticketStatus;
    public static volatile SingularAttribute<Ticket, String> description;
    public static volatile SingularAttribute<Ticket, Client> client;
    public static volatile SingularAttribute<Ticket, String> title;
    public static volatile SingularAttribute<Ticket, Integer> ticketId;

}