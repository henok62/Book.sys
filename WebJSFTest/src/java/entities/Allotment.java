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
@Table(name = "allotment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Allotment.findAll", query = "SELECT a FROM Allotment a"),
    @NamedQuery(name = "Allotment.findByAllotmentId", query = "SELECT a FROM Allotment a WHERE a.allotmentId = :allotmentId"),
    @NamedQuery(name = "Allotment.findByDescription", query = "SELECT a FROM Allotment a WHERE a.description = :description")})
public class Allotment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "allotment_id")
    private Integer allotmentId;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public Allotment() {
    }

    public Allotment(Integer allotmentId) {
        this.allotmentId = allotmentId;
    }

    public Integer getAllotmentId() {
        return allotmentId;
    }

    public void setAllotmentId(Integer allotmentId) {
        this.allotmentId = allotmentId;
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
        hash += (allotmentId != null ? allotmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Allotment)) {
            return false;
        }
        Allotment other = (Allotment) object;
        if ((this.allotmentId == null && other.allotmentId != null) || (this.allotmentId != null && !this.allotmentId.equals(other.allotmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Allotment[ allotmentId=" + allotmentId + " ]";
    }
}
