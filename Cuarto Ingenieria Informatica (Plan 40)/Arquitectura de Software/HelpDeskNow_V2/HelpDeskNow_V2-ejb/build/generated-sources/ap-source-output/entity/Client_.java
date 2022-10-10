package entity;

import entity.Comment;
import entity.Office;
import entity.Ticket;
import entity.embedded.ClientData;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, Integer> clientId;
    public static volatile CollectionAttribute<Client, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Client, Comment> commentCollection;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, ClientData> clientData;
    public static volatile SingularAttribute<Client, Office> office;

}