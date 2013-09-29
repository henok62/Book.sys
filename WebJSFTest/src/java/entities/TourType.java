package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tour_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourType.findAll", query = "SELECT t FROM TourType t"),
    @NamedQuery(name = "TourType.findByTourTypeId", query = "SELECT t FROM TourType t WHERE t.tourTypeId = :tourTypeId")})
public class TourType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tour_type_id")
    private Integer tourTypeId;
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
    @ManyToOne
    private Business businessId;
    @OneToMany(mappedBy = "tourTypeId")
    private Collection<Tour> tourCollection;

    public TourType() {
    }

    public TourType(Integer tourTypeId) {
        this.tourTypeId = tourTypeId;
    }

    public Integer getTourTypeId() {
        return tourTypeId;
    }

    public void setTourTypeId(Integer tourTypeId) {
        this.tourTypeId = tourTypeId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    @XmlTransient
    public Collection<Tour> getTourCollection() {
        return tourCollection;
    }

    public void setTourCollection(Collection<Tour> tourCollection) {
        this.tourCollection = tourCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourTypeId != null ? tourTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourType)) {
            return false;
        }
        TourType other = (TourType) object;
        if ((this.tourTypeId == null && other.tourTypeId != null) || (this.tourTypeId != null && !this.tourTypeId.equals(other.tourTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TourType[ tourTypeId=" + tourTypeId + " ]";
    }
}
