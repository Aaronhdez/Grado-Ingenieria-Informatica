/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "OFFICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")
    , @NamedQuery(name = "Office.findByOfficeId", query = "SELECT o FROM Office o WHERE o.officeId = :officeId")
    , @NamedQuery(name = "Office.findByName", query = "SELECT o FROM Office o WHERE o.name = :name")})
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFFICE_ID")
    private Integer officeId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private Collection<Agent> agentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Collection<Office> officeCollection;
    @JoinColumn(name = "ADDRESS", referencedColumnName = "OFFICE_ID")
    @ManyToOne(optional = false)
    private Office address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private Collection<Client> clientCollection;

    public Office() {
    }

    public Office(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Agent> getAgentCollection() {
        return agentCollection;
    }

    public void setAgentCollection(Collection<Agent> agentCollection) {
        this.agentCollection = agentCollection;
    }

    @XmlTransient
    public Collection<Office> getOfficeCollection() {
        return officeCollection;
    }

    public void setOfficeCollection(Collection<Office> officeCollection) {
        this.officeCollection = officeCollection;
    }

    public Office getAddress() {
        return address;
    }

    public void setAddress(Office address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (officeId != null ? officeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.officeId == null && other.officeId != null) || (this.officeId != null && !this.officeId.equals(other.officeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Office[ officeId=" + officeId + " ]";
    }
    
}
