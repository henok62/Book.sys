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

@Entity
@Table(name = "destination_list_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DestinationListItem.findAll", query = "SELECT d FROM DestinationListItem d"),
    @NamedQuery(name = "DestinationListItem.findByDestinationListItemId", query = "SELECT d FROM DestinationListItem d WHERE d.destinationListItemId = :destinationListItemId"),
    @NamedQuery(name = "DestinationListItem.findByDescription", query = "SELECT d FROM DestinationListItem d WHERE d.description = :description")})
public class DestinationListItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destination_list_item_id")
    private Integer destinationListItemId;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public DestinationListItem() {
    }

    public DestinationListItem(Integer destinationListItemId) {
        this.destinationListItemId = destinationListItemId;
    }

    public Integer getDestinationListItemId() {
        return destinationListItemId;
    }

    public void setDestinationListItemId(Integer destinationListItemId) {
        this.destinationListItemId = destinationListItemId;
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
        hash += (destinationListItemId != null ? destinationListItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinationListItem)) {
            return false;
        }
        DestinationListItem other = (DestinationListItem) object;
        if ((this.destinationListItemId == null && other.destinationListItemId != null) || (this.destinationListItemId != null && !this.destinationListItemId.equals(other.destinationListItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DestinationListItem[ destinationListItemId=" + destinationListItemId + " ]";
    }
}
