package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "scheduled_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduledActivity.findAll", query = "SELECT s FROM ScheduledActivity s"),
    @NamedQuery(name = "ScheduledActivity.findByScheduledActivityId", query = "SELECT s FROM ScheduledActivity s WHERE s.scheduledActivityId = :scheduledActivityId"),
    @NamedQuery(name = "ScheduledActivity.findByDateStart", query = "SELECT s FROM ScheduledActivity s WHERE s.dateStart = :dateStart"),
    @NamedQuery(name = "ScheduledActivity.findByDateEnd", query = "SELECT s FROM ScheduledActivity s WHERE s.dateEnd = :dateEnd")})
public class ScheduledActivity implements Serializable {
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
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    @ManyToOne
    private Tour tourId;
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    @ManyToOne
    private Booking bookingId;
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    @ManyToOne
    private Activity activityId;

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

    public Tour getTourId() {
        return tourId;
    }

    public void setTourId(Tour tourId) {
        this.tourId = tourId;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
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
}
