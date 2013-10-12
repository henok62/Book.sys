/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "destination_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DestinationList.findAll", query = "SELECT d FROM DestinationList d"),
    @NamedQuery(name = "DestinationList.findByDestinationListId", query = "SELECT d FROM DestinationList d WHERE d.destinationListId = :destinationListId"),
    @NamedQuery(name = "DestinationList.findByDestinationListName", query = "SELECT d FROM DestinationList d WHERE d.destinationListName = :destinationListName"),
    @NamedQuery(name = "DestinationList.findByDescription", query = "SELECT d FROM DestinationList d WHERE d.description = :description")})
public class DestinationList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destination_list_id")
    private Integer destinationListId;
    @Size(max = 300)
    @Column(name = "destination_list_name")
    private String destinationListName;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public DestinationList() {
    }

    public DestinationList(Integer destinationListId) {
        this.destinationListId = destinationListId;
    }

    public Integer getDestinationListId() {
        return destinationListId;
    }

    public void setDestinationListId(Integer destinationListId) {
        this.destinationListId = destinationListId;
    }

    public String getDestinationListName() {
        return destinationListName;
    }

    public void setDestinationListName(String destinationListName) {
        this.destinationListName = destinationListName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (destinationListId != null ? destinationListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinationList)) {
            return false;
        }
        DestinationList other = (DestinationList) object;
        if ((this.destinationListId == null && other.destinationListId != null) || (this.destinationListId != null && !this.destinationListId.equals(other.destinationListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DestinationList[ destinationListId=" + destinationListId + " ]";
    }
    
}
