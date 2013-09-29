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
@Table(name = "allotment_list_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllotmentListItem.findAll", query = "SELECT a FROM AllotmentListItem a"),
    @NamedQuery(name = "AllotmentListItem.findByAllotmentListItemId", query = "SELECT a FROM AllotmentListItem a WHERE a.allotmentListItemId = :allotmentListItemId"),
    @NamedQuery(name = "AllotmentListItem.findByDescription", query = "SELECT a FROM AllotmentListItem a WHERE a.description = :description")})
public class AllotmentListItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "allotment_list_item_id")
    private Integer allotmentListItemId;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public AllotmentListItem() {
    }

    public AllotmentListItem(Integer allotmentListItemId) {
        this.allotmentListItemId = allotmentListItemId;
    }

    public Integer getAllotmentListItemId() {
        return allotmentListItemId;
    }

    public void setAllotmentListItemId(Integer allotmentListItemId) {
        this.allotmentListItemId = allotmentListItemId;
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
        hash += (allotmentListItemId != null ? allotmentListItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllotmentListItem)) {
            return false;
        }
        AllotmentListItem other = (AllotmentListItem) object;
        if ((this.allotmentListItemId == null && other.allotmentListItemId != null) || (this.allotmentListItemId != null && !this.allotmentListItemId.equals(other.allotmentListItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AllotmentListItem[ allotmentListItemId=" + allotmentListItemId + " ]";
    }
}
