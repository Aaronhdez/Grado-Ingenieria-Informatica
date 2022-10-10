package entity;

import entity.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(TicketClass.class)
public class TicketClass_ { 

    public static volatile SingularAttribute<TicketClass, Integer> classId;
    public static volatile CollectionAttribute<TicketClass, Ticket> ticketCollection;
    public static volatile SingularAttribute<TicketClass, String> name;

}