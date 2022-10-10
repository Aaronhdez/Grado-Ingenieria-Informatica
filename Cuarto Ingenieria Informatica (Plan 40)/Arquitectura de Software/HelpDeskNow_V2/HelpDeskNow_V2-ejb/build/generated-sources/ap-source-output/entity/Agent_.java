package entity;

import entity.Comment;
import entity.Office;
import entity.Team;
import entity.Ticket;
import entity.embedded.AgentData;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Agent.class)
public class Agent_ { 

    public static volatile SingularAttribute<Agent, Integer> agentId;
    public static volatile SingularAttribute<Agent, String> password;
    public static volatile CollectionAttribute<Agent, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Agent, Comment> commentCollection;
    public static volatile SingularAttribute<Agent, String> name;
    public static volatile SingularAttribute<Agent, AgentData> agentData;
    public static volatile SingularAttribute<Agent, Office> office;
    public static volatile SingularAttribute<Agent, Team> team;

}