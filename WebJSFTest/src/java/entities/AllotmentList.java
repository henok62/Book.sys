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
@Table(name = "allotment_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllotmentList.findAll", query = "SELECT a FROM AllotmentList a"),
    @NamedQuery(name = "AllotmentList.findByAllotmentListId", query = "SELECT a FROM AllotmentList a WHERE a.allotmentListId = :allotmentListId"),
    @NamedQuery(name = "AllotmentList.findByDescription", query = "SELECT a FROM AllotmentList a WHERE a.description = :description")})
public class AllotmentList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "allotment_list_id")
    private Integer allotmentListId;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public AllotmentList() {
    }

    public AllotmentList(Integer allotmentListId) {
        this.allotmentListId = allotmentListId;
    }

    public Integer getAllotmentListId() {
        return allotmentListId;
    }

    public void setAllotmentListId(Integer allotmentListId) {
        this.allotmentListId = allotmentListId;
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
        hash += (allotmentListId != null ? allotmentListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllotmentList)) {
            return false;
        }
        AllotmentList other = (AllotmentList) object;
        if ((this.allotmentListId == null && other.allotmentListId != null) || (this.allotmentListId != null && !this.allotmentListId.equals(other.allotmentListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AllotmentList[ allotmentListId=" + allotmentListId + " ]";
    }
}
