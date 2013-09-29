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
@Table(name = "partner_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerList.findAll", query = "SELECT p FROM PartnerList p"),
    @NamedQuery(name = "PartnerList.findByPartnerListId", query = "SELECT p FROM PartnerList p WHERE p.partnerListId = :partnerListId"),
    @NamedQuery(name = "PartnerList.findByDescription", query = "SELECT p FROM PartnerList p WHERE p.description = :description")})
public class PartnerList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "partner_list_id")
    private Integer partnerListId;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public PartnerList() {
    }

    public PartnerList(Integer partnerListId) {
        this.partnerListId = partnerListId;
    }

    public Integer getPartnerListId() {
        return partnerListId;
    }

    public void setPartnerListId(Integer partnerListId) {
        this.partnerListId = partnerListId;
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
        hash += (partnerListId != null ? partnerListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartnerList)) {
            return false;
        }
        PartnerList other = (PartnerList) object;
        if ((this.partnerListId == null && other.partnerListId != null) || (this.partnerListId != null && !this.partnerListId.equals(other.partnerListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PartnerList[ partnerListId=" + partnerListId + " ]";
    }
}
