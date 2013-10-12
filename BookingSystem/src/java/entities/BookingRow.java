/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "booking_row")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingRow.findAll", query = "SELECT b FROM BookingRow b"),
    @NamedQuery(name = "BookingRow.findByBookingRowId", query = "SELECT b FROM BookingRow b WHERE b.bookingRowId = :bookingRowId")})
public class BookingRow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_row_id")
    private Integer bookingRowId;
    @JoinColumn(name = "scheduled_activity_id", referencedColumnName = "scheduled_activity_id")
    @ManyToOne
    private ScheduledActivity scheduledActivityId;
    @JoinColumn(name = "scheduled_tour_id", referencedColumnName = "scheduled_tour_id")
    @ManyToOne
    private ScheduledTour scheduledTourId;
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    @ManyToOne
    private Booking bookingId;

    public BookingRow() {
    }

    public BookingRow(Integer bookingRowId) {
        this.bookingRowId = bookingRowId;
    }

    public Integer getBookingRowId() {
        return bookingRowId;
    }

    public void setBookingRowId(Integer bookingRowId) {
        this.bookingRowId = bookingRowId;
    }

    public ScheduledActivity getScheduledActivityId() {
        return scheduledActivityId;
    }

    public void setScheduledActivityId(ScheduledActivity scheduledActivityId) {
        this.scheduledActivityId = scheduledActivityId;
    }

    public ScheduledTour getScheduledTourId() {
        return scheduledTourId;
    }

    public void setScheduledTourId(ScheduledTour scheduledTourId) {
        this.scheduledTourId = scheduledTourId;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingRowId != null ? bookingRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingRow)) {
            return false;
        }
        BookingRow other = (BookingRow) object;
        if ((this.bookingRowId == null && other.bookingRowId != null) || (this.bookingRowId != null && !this.bookingRowId.equals(other.bookingRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookingRow[ bookingRowId=" + bookingRowId + " ]";
    }
    
}
