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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "pricing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pricing.findAll", query = "SELECT p FROM Pricing p"),
    @NamedQuery(name = "Pricing.findByPricingId", query = "SELECT p FROM Pricing p WHERE p.pricingId = :pricingId"),
    @NamedQuery(name = "Pricing.findByStartTime", query = "SELECT p FROM Pricing p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Pricing.findByEndTime", query = "SELECT p FROM Pricing p WHERE p.endTime = :endTime"),
    @NamedQuery(name = "Pricing.findByDiscount", query = "SELECT p FROM Pricing p WHERE p.discount = :discount")})
public class Pricing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pricing_id")
    private Integer pricingId;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "discount")
    private Integer discount;
    @JoinColumn(name = "scheduled_activity_id", referencedColumnName = "scheduled_activity_id")
    @ManyToOne
    private ScheduledActivity scheduledActivityId;
    @JoinColumn(name = "pricing_category_id", referencedColumnName = "pricing_category_id")
    @ManyToOne
    private PricingCategory pricingCategoryId;

    public Pricing() {
    }

    public Pricing(Integer pricingId) {
        this.pricingId = pricingId;
    }

    public Integer getPricingId() {
        return pricingId;
    }

    public void setPricingId(Integer pricingId) {
        this.pricingId = pricingId;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public ScheduledActivity getScheduledActivityId() {
        return scheduledActivityId;
    }

    public void setScheduledActivityId(ScheduledActivity scheduledActivityId) {
        this.scheduledActivityId = scheduledActivityId;
    }

    public PricingCategory getPricingCategoryId() {
        return pricingCategoryId;
    }

    public void setPricingCategoryId(PricingCategory pricingCategoryId) {
        this.pricingCategoryId = pricingCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingId != null ? pricingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pricing)) {
            return false;
        }
        Pricing other = (Pricing) object;
        if ((this.pricingId == null && other.pricingId != null) || (this.pricingId != null && !this.pricingId.equals(other.pricingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pricing[ pricingId=" + pricingId + " ]";
    }
    
}
