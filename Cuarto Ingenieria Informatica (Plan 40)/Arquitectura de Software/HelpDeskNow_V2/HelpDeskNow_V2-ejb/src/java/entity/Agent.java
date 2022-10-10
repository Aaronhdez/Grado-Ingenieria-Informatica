/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.embedded.AgentData;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "AGENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a")
    , @NamedQuery(name = "Agent.findByAgentId", query = "SELECT a FROM Agent a WHERE a.agentId = :agentId")
    , @NamedQuery(name = "Agent.findByName", query = "SELECT a FROM Agent a WHERE a.name = :name")
    , @NamedQuery(name = "Agent.findByPassword", query = "SELECT a FROM Agent a WHERE a.password = :password")})
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AGENT_ID")
    private Integer agentId;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "agentName", column = @Column(name = "NAME")),
        @AttributeOverride( name = "agentPassword", column = @Column(name = "PASSWORD"))
    })
    private AgentData agentData;
    
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "OFFICE", referencedColumnName = "OFFICE_ID")
    @ManyToOne(optional = false)
    private Office office;
    @JoinColumn(name = "TEAM", referencedColumnName = "TEAM_ID")
    @ManyToOne(optional = false)
    private Team team;
    @OneToMany(mappedBy = "agent")
    private Collection<Ticket> ticketCollection;
    @OneToMany(mappedBy = "agent")
    private Collection<Comment> commentCollection;

    public Agent() {
    }

    public Agent(Integer agentId) {
        this.agentId = agentId;
    }

    public AgentData getAgentData() {
        return agentData;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Agent[ agentId=" + agentId + " ]";
    }
    
}
