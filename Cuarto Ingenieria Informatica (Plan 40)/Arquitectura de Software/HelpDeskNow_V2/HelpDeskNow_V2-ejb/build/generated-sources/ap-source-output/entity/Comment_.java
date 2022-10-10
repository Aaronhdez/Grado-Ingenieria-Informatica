package entity;

import entity.Agent;
import entity.Client;
import entity.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> date;
    public static volatile SingularAttribute<Comment, Agent> agent;
    public static volatile SingularAttribute<Comment, Ticket> ticket;
    public static volatile SingularAttribute<Comment, Integer> commentId;
    public static volatile SingularAttribute<Comment, String> description;
    public static volatile SingularAttribute<Comment, Client> client;
    public static volatile SingularAttribute<Comment, String> title;

}