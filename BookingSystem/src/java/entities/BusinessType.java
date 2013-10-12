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
@Table(name = "business_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusinessType.findAll", query = "SELECT b FROM BusinessType b"),
    @NamedQuery(name = "BusinessType.findByBusinessTypeId", query = "SELECT b FROM BusinessType b WHERE b.businessTypeId = :businessTypeId"),
    @NamedQuery(name = "BusinessType.findByBusinessTypeName", query = "SELECT b FROM BusinessType b WHERE b.businessTypeName = :businessTypeName")})
public class BusinessType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "business_type_id")
    private Integer businessTypeId;
    @Size(max = 100)
    @Column(name = "business_type_name")
    private String businessTypeName;
    @OneToMany(mappedBy = "businessTypeId")
    private Collection<Business> businessCollection;

    public BusinessType() {
    }

    public BusinessType(Integer businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public Integer getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Integer businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    @XmlTransient
    public Collection<Business> getBusinessCollection() {
        return businessCollection;
    }

    public void setBusinessCollection(Collection<Business> businessCollection) {
        this.businessCollection = businessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessTypeId != null ? businessTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessType)) {
            return false;
        }
        BusinessType other = (BusinessType) object;
        if ((this.businessTypeId == null && other.businessTypeId != null) || (this.businessTypeId != null && !this.businessTypeId.equals(other.businessTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BusinessType[ businessTypeId=" + businessTypeId + " ]";
    }
    
}
