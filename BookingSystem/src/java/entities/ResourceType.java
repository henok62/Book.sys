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
@Table(name = "resource_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourceType.findAll", query = "SELECT r FROM ResourceType r"),
    @NamedQuery(name = "ResourceType.findByResourceTypeId", query = "SELECT r FROM ResourceType r WHERE r.resourceTypeId = :resourceTypeId"),
    @NamedQuery(name = "ResourceType.findByResourceTypeName", query = "SELECT r FROM ResourceType r WHERE r.resourceTypeName = :resourceTypeName"),
    @NamedQuery(name = "ResourceType.findByResourceTypeDescription", query = "SELECT r FROM ResourceType r WHERE r.resourceTypeDescription = :resourceTypeDescription")})
public class ResourceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resource_type_id")
    private Integer resourceTypeId;
    @Size(max = 200)
    @Column(name = "resource_type_name")
    private String resourceTypeName;
    @Size(max = 400)
    @Column(name = "resource_type_description")
    private String resourceTypeDescription;
    @OneToMany(mappedBy = "resourceTypeId")
    private Collection<Resource> resourceCollection;

    public ResourceType() {
    }

    public ResourceType(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public String getResourceTypeDescription() {
        return resourceTypeDescription;
    }

    public void setResourceTypeDescription(String resourceTypeDescription) {
        this.resourceTypeDescription = resourceTypeDescription;
    }

    @XmlTransient
    public Collection<Resource> getResourceCollection() {
        return resourceCollection;
    }

    public void setResourceCollection(Collection<Resource> resourceCollection) {
        this.resourceCollection = resourceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceTypeId != null ? resourceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceType)) {
            return false;
        }
        ResourceType other = (ResourceType) object;
        if ((this.resourceTypeId == null && other.resourceTypeId != null) || (this.resourceTypeId != null && !this.resourceTypeId.equals(other.resourceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ResourceType[ resourceTypeId=" + resourceTypeId + " ]";
    }
    
}
