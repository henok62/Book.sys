/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "destination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destination.findAll", query = "SELECT d FROM Destination d"),
    @NamedQuery(name = "Destination.findByDestinationId", query = "SELECT d FROM Destination d WHERE d.destinationId = :destinationId"),
    @NamedQuery(name = "Destination.findByDestinationName", query = "SELECT d FROM Destination d WHERE d.destinationName = :destinationName"),
    @NamedQuery(name = "Destination.findByDestinationDescription", query = "SELECT d FROM Destination d WHERE d.destinationDescription = :destinationDescription")})
public class Destination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destination_id")
    private Integer destinationId;
    @Size(max = 100)
    @Column(name = "destination_name")
    private String destinationName;
    @Size(max = 300)
    @Column(name = "destination_description")
    private String destinationDescription;
    @OneToMany(mappedBy = "destinationId")
    private Collection<Business> businessCollection;

    public Destination() {
    }

    public Destination(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationDescription() {
        return destinationDescription;
    }

    public void setDestinationDescription(String destinationDescription) {
        this.destinationDescription = destinationDescription;
    }

    @XmlTransient
    public Collection<Business> getBusinessCollection() {
        return businessCollection;
    }

    public void setBusinessCollection(Collection<Business> businessCollection) {
        this.businessCollection = businessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (destinationId != null ? destinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) object;
        if ((this.destinationId == null && other.destinationId != null) || (this.destinationId != null && !this.destinationId.equals(other.destinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Destination[ destinationId=" + destinationId + " ]";
    }
    
}
