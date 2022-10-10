/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByTicketId", query = "SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
    , @NamedQuery(name = "Ticket.findByTitle", query = "SELECT t FROM Ticket t WHERE t.title = :title")
    , @NamedQuery(name = "Ticket.findByDescription", query = "SELECT t FROM Ticket t WHERE t.description = :description")
    , @NamedQuery(name = "Ticket.findByDate", query = "SELECT t FROM Ticket t WHERE t.date = :date")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TICKET_ID")
    private Integer ticketId;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "DATE")
    private String date;
    @JoinColumn(name = "AGENT", referencedColumnName = "AGENT_ID")
    @ManyToOne
    private Agent agent;
    @JoinColumn(name = "CLIENT", referencedColumnName = "CLIENT_ID")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "TICKET_CLASS", referencedColumnName = "CLASS_ID")
    @ManyToOne(optional = false)
    private TicketClass ticketClass;
    @JoinColumn(name = "TICKET_STATUS", referencedColumnName = "STATUS_ID")
    @ManyToOne(optional = false)
    private TicketStatus ticketStatus;

    public Ticket() {
    }

    public Ticket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(String title, String message, String date, Agent agent, Client client, TicketClass tClass, TicketStatus tStatus) {
        this.title = title;
        this.description = message;
        this.date = date;
        this.agent = agent;
        this.client= client;
        this.ticketClass = tClass;
        this.ticketStatus = tStatus;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ticket[ ticketId=" + ticketId + " ]";
    }
    
}
