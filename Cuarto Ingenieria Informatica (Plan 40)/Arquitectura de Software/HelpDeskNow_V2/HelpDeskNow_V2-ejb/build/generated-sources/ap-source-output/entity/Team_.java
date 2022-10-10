package entity;

import entity.Agent;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, Integer> teamId;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile CollectionAttribute<Team, Agent> agentCollection;

}