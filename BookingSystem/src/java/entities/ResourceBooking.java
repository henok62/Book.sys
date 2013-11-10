/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "resource_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourceBooking.findAll", query = "SELECT r FROM ResourceBooking r"),
    @NamedQuery(name = "ResourceBooking.findByResourceBookingId", query = "SELECT r FROM ResourceBooking r WHERE r.resourceBookingId = :resourceBookingId"),
    @NamedQuery(name = "ResourceBooking.findByTimestamp", query = "SELECT r FROM ResourceBooking r WHERE r.timestamp = :timestamp"),
    @NamedQuery(name = "ResourceBooking.findByStartTime", query = "SELECT r FROM ResourceBooking r WHERE r.startTime = :startTime"),
    @NamedQuery(name = "ResourceBooking.findByEndTime", query = "SELECT r FROM ResourceBooking r WHERE r.endTime = :endTime")})
public class ResourceBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resource_booking_id")
    private Integer resourceBookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id")
    @ManyToOne
    private Resource resourceId;
    @JoinColumn(name = "scheduled_activity_id", referencedColumnName = "scheduled_activity_id")
    @ManyToOne
    private ScheduledActivity scheduledActivityId;

    public ResourceBooking() {
    }

    public ResourceBooking(Integer resourceBookingId) {
        this.resourceBookingId = resourceBookingId;
    }

    public ResourceBooking(Integer resourceBookingId, Date timestamp) {
        this.resourceBookingId = resourceBookingId;
        this.timestamp = timestamp;
    }

    public Integer getResourceBookingId() {
        return resourceBookingId;
    }

    public void setResourceBookingId(Integer resourceBookingId) {
        this.resourceBookingId = resourceBookingId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Resource getResourceId() {
        return resourceId;
    }

    public void setResourceId(Resource resourceId) {
        this.resourceId = resourceId;
    }

    public ScheduledActivity getScheduledActivityId() {
        return scheduledActivityId;
    }

    public void setScheduledActivityId(ScheduledActivity scheduledActivityId) {
        this.scheduledActivityId = scheduledActivityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceBookingId != null ? resourceBookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceBooking)) {
            return false;
        }
        ResourceBooking other = (ResourceBooking) object;
        if ((this.resourceBookingId == null && other.resourceBookingId != null) || (this.resourceBookingId != null && !this.resourceBookingId.equals(other.resourceBookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ResourceBooking[ resourceBookingId=" + resourceBookingId + " ]";
    }
    
}
