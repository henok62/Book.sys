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
@Table(name = "pricing_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PricingCategory.findAll", query = "SELECT p FROM PricingCategory p"),
    @NamedQuery(name = "PricingCategory.findByPricingCategoryId", query = "SELECT p FROM PricingCategory p WHERE p.pricingCategoryId = :pricingCategoryId"),
    @NamedQuery(name = "PricingCategory.findByPricingCategoryDescription", query = "SELECT p FROM PricingCategory p WHERE p.pricingCategoryDescription = :pricingCategoryDescription")})
public class PricingCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pricing_category_id")
    private Integer pricingCategoryId;
    @Size(max = 200)
    @Column(name = "pricing_category_description")
    private String pricingCategoryDescription;
    @OneToMany(mappedBy = "pricingCategoryId")
    private Collection<Pricing> pricingCollection;

    public PricingCategory() {
    }

    public PricingCategory(Integer pricingCategoryId) {
        this.pricingCategoryId = pricingCategoryId;
    }

    public Integer getPricingCategoryId() {
        return pricingCategoryId;
    }

    public void setPricingCategoryId(Integer pricingCategoryId) {
        this.pricingCategoryId = pricingCategoryId;
    }

    public String getPricingCategoryDescription() {
        return pricingCategoryDescription;
    }

    public void setPricingCategoryDescription(String pricingCategoryDescription) {
        this.pricingCategoryDescription = pricingCategoryDescription;
    }

    @XmlTransient
    public Collection<Pricing> getPricingCollection() {
        return pricingCollection;
    }

    public void setPricingCollection(Collection<Pricing> pricingCollection) {
        this.pricingCollection = pricingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingCategoryId != null ? pricingCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingCategory)) {
            return false;
        }
        PricingCategory other = (PricingCategory) object;
        if ((this.pricingCategoryId == null && other.pricingCategoryId != null) || (this.pricingCategoryId != null && !this.pricingCategoryId.equals(other.pricingCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PricingCategory[ pricingCategoryId=" + pricingCategoryId + " ]";
    }
    
}
