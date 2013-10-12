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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByActivityId", query = "SELECT a FROM Activity a WHERE a.activityId = :activityId"),
    @NamedQuery(name = "Activity.findByActivityName", query = "SELECT a FROM Activity a WHERE a.activityName = :activityName"),
    @NamedQuery(name = "Activity.findByActivityInformation", query = "SELECT a FROM Activity a WHERE a.activityInformation = :activityInformation"),
    @NamedQuery(name = "Activity.findByActivityResources", query = "SELECT a FROM Activity a WHERE a.activityResources = :activityResources"),
    @NamedQuery(name = "Activity.findByActivityTransports", query = "SELECT a FROM Activity a WHERE a.activityTransports = :activityTransports"),
    @NamedQuery(name = "Activity.findByActivityPricing", query = "SELECT a FROM Activity a WHERE a.activityPricing = :activityPricing"),
    @NamedQuery(name = "Activity.findByActivityDescription", query = "SELECT a FROM Activity a WHERE a.activityDescription = :activityDescription")})
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_id")
    private Integer activityId;
    @Size(max = 100)
    @Column(name = "activity_name")
    private String activityName;
    @Size(max = 500)
    @Column(name = "activity_information")
    private String activityInformation;
    @Size(max = 300)
    @Column(name = "activity_resources")
    private String activityResources;
    @Size(max = 500)
    @Column(name = "activity_transports")
    private String activityTransports;
    @Size(max = 30)
    @Column(name = "activity_pricing")
    private String activityPricing;
    @Size(max = 500)
    @Column(name = "activity_description")
    private String activityDescription;
    @OneToMany(mappedBy = "activityId")
    private Collection<ScheduledActivity> scheduledActivityCollection;
    @JoinColumn(name = "activity_type_id", referencedColumnName = "activity_type_id")
    @ManyToOne
    private ActivityType activityTypeId;
    @JoinColumn(name = "business_id", referencedColumnName = "business_id")
    @ManyToOne
    private Business businessId;

    public Activity() {
    }

    public Activity(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityInformation() {
        return activityInformation;
    }

    public void setActivityInformation(String activityInformation) {
        this.activityInformation = activityInformation;
    }

    public String getActivityResources() {
        return activityResources;
    }

    public void setActivityResources(String activityResources) {
        this.activityResources = activityResources;
    }

    public String getActivityTransports() {
        return activityTransports;
    }

    public void setActivityTransports(String activityTransports) {
        this.activityTransports = activityTransports;
    }

    public String getActivityPricing() {
        return activityPricing;
    }

    public void setActivityPricing(String activityPricing) {
        this.activityPricing = activityPricing;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @XmlTransient
    public Collection<ScheduledActivity> getScheduledActivityCollection() {
        return scheduledActivityCollection;
    }

    public void setScheduledActivityCollection(Collection<ScheduledActivity> scheduledActivityCollection) {
        this.scheduledActivityCollection = scheduledActivityCollection;
    }

    public ActivityType getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(ActivityType activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Business getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Business businessId) {
        this.businessId = businessId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Activity[ activityId=" + activityId + " ]";
    }
}
