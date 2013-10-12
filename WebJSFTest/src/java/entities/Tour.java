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
@Table(name = "tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t"),
    @NamedQuery(name = "Tour.findByTourId", query = "SELECT t FROM Tour t WHERE t.tourId = :tourId")})
public class Tour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tour_id")
    private Integer tourId;
    @OneToMany(mappedBy = "tourId")
    private Collection<ScheduledActivity> scheduledActivityCollection;
    @JoinColumn(name = "tour_type_id", referencedColumnName = "tour_type_id")
    @ManyToOne
    private TourType tourTypeId;

    public Tour() {
    }

    public Tour(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @XmlTransient
    public Collection<ScheduledActivity> getScheduledActivityCollection() {
        return scheduledActivityCollection;
    }

    public void setScheduledActivityCollection(Collection<ScheduledActivity> scheduledActivityCollection) {
        this.scheduledActivityCollection = scheduledActivityCollection;
    }

    public TourType getTourTypeId() {
        return tourTypeId;
    }

    public void setTourTypeId(TourType tourTypeId) {
        this.tourTypeId = tourTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourId != null ? tourId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.tourId == null && other.tourId != null) || (this.tourId != null && !this.tourId.equals(other.tourId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tour[ tourId=" + tourId + " ]";
    }
}
