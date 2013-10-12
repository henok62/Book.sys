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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "scheduled_tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledTour.findAll", query = "SELECT s FROM ScheduledTour s"),
    @NamedQuery(name = "ScheduledTour.findByScheduledTourId", query = "SELECT s FROM ScheduledTour s WHERE s.scheduledTourId = :scheduledTourId")})
public class ScheduledTour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduled_tour_id")
    private Integer scheduledTourId;
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    @ManyToOne
    private Tour tourId;
    @OneToMany(mappedBy = "scheduledTourId")
    private Collection<ScheduledActivity> scheduledActivityCollection;
    @OneToMany(mappedBy = "scheduledTourId")
    private Collection<BookingRow> bookingRowCollection;

    public ScheduledTour() {
    }

    public ScheduledTour(Integer scheduledTourId) {
        this.scheduledTourId = scheduledTourId;
    }

    public Integer getScheduledTourId() {
        return scheduledTourId;
    }

    public void setScheduledTourId(Integer scheduledTourId) {
        this.scheduledTourId = scheduledTourId;
    }

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    @XmlTransient
    public Collection<ScheduledActivity> getScheduledActivityCollection() {
        return scheduledActivityCollection;
    }

    public void setScheduledActivityCollection(Collection<ScheduledActivity> scheduledActivityCollection) {
        this.scheduledActivityCollection = scheduledActivityCollection;
    }

    @XmlTransient
    public Collection<BookingRow> getBookingRowCollection() {
        return bookingRowCollection;
    }

    public void setBookingRowCollection(Collection<BookingRow> bookingRowCollection) {
        this.bookingRowCollection = bookingRowCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduledTourId != null ? scheduledTourId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduledTour)) {
            return false;
        }
        ScheduledTour other = (ScheduledTour) object;
        if ((this.scheduledTourId == null && other.scheduledTourId != null) || (this.scheduledTourId != null && !this.scheduledTourId.equals(other.scheduledTourId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ScheduledTour[ scheduledTourId=" + scheduledTourId + " ]";
    }
    
}
