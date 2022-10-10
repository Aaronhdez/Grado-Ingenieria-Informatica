package entity;

import entity.Agent;
import entity.Client;
import entity.Office;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-17T12:44:55")
@StaticMetamodel(Office.class)
public class Office_ { 

    public static volatile SingularAttribute<Office, Office> address;
    public static volatile SingularAttribute<Office, Integer> officeId;
    public static volatile CollectionAttribute<Office, Office> officeCollection;
    public static volatile SingularAttribute<Office, String> name;
    public static volatile CollectionAttribute<Office, Client> clientCollection;
    public static volatile CollectionAttribute<Office, Agent> agentCollection;

}