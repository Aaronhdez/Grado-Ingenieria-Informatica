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
@Table(name = "COMMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId")
    , @NamedQuery(name = "Comment.findByTitle", query = "SELECT c FROM Comment c WHERE c.title = :title")
    , @NamedQuery(name = "Comment.findByDate", query = "SELECT c FROM Comment c WHERE c.date = :date")
    , @NamedQuery(name = "Comment.findByDescription", query = "SELECT c FROM Comment c WHERE c.description = :description")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMENT_ID")
    private Integer commentId;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "DATE")
    private String date;
    @Size(max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "AGENT", referencedColumnName = "AGENT_ID")
    @ManyToOne
    private Agent agent;
    @JoinColumn(name = "CLIENT", referencedColumnName = "CLIENT_ID")
    @ManyToOne
    private Client client;
    @JoinColumn(name = "TICKET", referencedColumnName = "TICKET_ID")
    @ManyToOne(optional = false)
    private Ticket ticket;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Comment(Agent agent, String title, String message, String dateOfPost, Ticket ticket) {
        this.agent = agent;
        this.title = title;
        this.description = message;
        this.date = dateOfPost;
        this.ticket = ticket;
    }

    public Comment(Client client, String title, String message, String dateOfPost, Ticket ticket) {
        this.client = client;
        this.title = title;
        this.description = message;
        this.date = dateOfPost;
        this.ticket = ticket;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comment[ commentId=" + commentId + " ]";
    }
    
}
