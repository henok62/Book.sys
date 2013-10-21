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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mikael
 */
@Entity
@Table(name = "activity_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityType.findAll", query = "SELECT a FROM ActivityType a"),
    @NamedQuery(name = "ActivityType.findByActivityTypeId", query = "SELECT a FROM ActivityType a WHERE a.activityTypeId = :activityTypeId"),
    @NamedQuery(name = "ActivityType.findByActivityTypeName", query = "SELECT a FROM ActivityType a WHERE a.activityTypeName = :activityTypeName"),
    @NamedQuery(name = "ActivityType.findByDescription", query = "SELECT a FROM ActivityType a WHERE a.description = :description")})
public class ActivityType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_type_id")
    private Integer activityTypeId;
    @Size(max = 100)
    @Column(name = "activity_type_name")
    private String activityTypeName;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "activityTypeId")
    private Collection<Activity> activityCollection;

    public ActivityType() {
    }

    public ActivityType(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityTypeId != null ? activityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityType)) {
            return false;
        }
        ActivityType other = (ActivityType) object;
        if ((this.activityTypeId == null && other.activityTypeId != null) || (this.activityTypeId != null && !this.activityTypeId.equals(other.activityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ActivityType[ activityTypeId=" + activityTypeId + " ]";
    }
    
}
