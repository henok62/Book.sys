/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "scheduled_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledActivity.findAll", query = "SELECT s FROM ScheduledActivity s"),
    @NamedQuery(name = "ScheduledActivity.findByScheduledActivityId", query = "SELECT s FROM ScheduledActivity s WHERE s.scheduledActivityId = :scheduledActivityId"),
    @NamedQuery(name = "ScheduledActivity.findByDateStart", query = "SELECT s FROM ScheduledActivity s WHERE s.dateStart = :dateStart"),
    @NamedQuery(name = "ScheduledActivity.findByDateEnd", query = "SELECT s FROM ScheduledActivity s WHERE s.dateEnd = :dateEnd")})
public class ScheduledActivity implements Serializable {
    @OneToMany(mappedBy = "scheduledActivityId")
    private Collection<ResourceBooking> resourceBookingCollection;
    @OneToMany(mappedBy = "scheduledActivityId")
    private Collection<Pricing> pricingCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduled_activity_id")
    private Integer scheduledActivityId;
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @JoinColumn(name = "scheduled_tour_id", referencedColumnName = "scheduled_tour_id")
    @ManyToOne
    private ScheduledTour scheduledTourId;
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    @ManyToOne
    private Activity activityId;
    @OneToMany(mappedBy = "scheduledActivityId")
    private Collection<BookingRow> bookingRowCollection;

    public ScheduledActivity() {
    }

    public ScheduledActivity(Integer scheduledActivityId) {
        this.scheduledActivityId = scheduledActivityId;
    }

    public Integer getScheduledActivityId() {
        return scheduledActivityId;
    }

    public void setScheduledActivityId(Integer scheduledActivityId) {
        this.scheduledActivityId = scheduledActivityId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ScheduledTour getScheduledTourId() {
        return scheduledTourId;
    }

    public void setScheduledTourId(ScheduledTour scheduledTourId) {
        this.scheduledTourId = scheduledTourId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
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
        hash += (scheduledActivityId != null ? scheduledActivityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduledActivity)) {
            return false;
        }
        ScheduledActivity other = (ScheduledActivity) object;
        if ((this.scheduledActivityId == null && other.scheduledActivityId != null) || (this.scheduledActivityId != null && !this.scheduledActivityId.equals(other.scheduledActivityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ScheduledActivity[ scheduledActivityId=" + scheduledActivityId + " ]";
    }

    @XmlTransient
    public Collection<ResourceBooking> getResourceBookingCollection() {
        return resourceBookingCollection;
    }

    public void setResourceBookingCollection(Collection<ResourceBooking> resourceBookingCollection) {
        this.resourceBookingCollection = resourceBookingCollection;
    }

    @XmlTransient
    public Collection<Pricing> getPricingCollection() {
        return pricingCollection;
    }

    public void setPricingCollection(Collection<Pricing> pricingCollection) {
        this.pricingCollection = pricingCollection;
    }
    
}
