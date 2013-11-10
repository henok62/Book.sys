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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "business")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
    @NamedQuery(name = "Business.findByBusinessId", query = "SELECT b FROM Business b WHERE b.businessId = :businessId"),
    @NamedQuery(name = "Business.findByBusinessName", query = "SELECT b FROM Business b WHERE b.businessName = :businessName"),
    @NamedQuery(name = "Business.findByOrgNumber", query = "SELECT b FROM Business b WHERE b.orgNumber = :orgNumber"),
    @NamedQuery(name = "Business.findByMobilePhoneNumber", query = "SELECT b FROM Business b WHERE b.mobilePhoneNumber = :mobilePhoneNumber"),
    @NamedQuery(name = "Business.findByLandlinePhoneNumber", query = "SELECT b FROM Business b WHERE b.landlinePhoneNumber = :landlinePhoneNumber"),
    @NamedQuery(name = "Business.findByFaxNo", query = "SELECT b FROM Business b WHERE b.faxNo = :faxNo"),
    @NamedQuery(name = "Business.findByEmail", query = "SELECT b FROM Business b WHERE b.email = :email"),
    @NamedQuery(name = "Business.findByBusinessDescription", query = "SELECT b FROM Business b WHERE b.businessDescription = :businessDescription")})
public class Business implements Serializable {
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "business_id")
    private Integer businessId;
    @Size(max = 50)
    @Column(name = "business_name")
    private String businessName;
    @Size(max = 100)
    @Column(name = "org_number")
    private String orgNumber;
    @Size(max = 30)
    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;
    @Size(max = 30)
    @Column(name = "landline_phone_number")
    private String landlinePhoneNumber;
    @Size(max = 30)
    @Column(name = "fax_no")
    private String faxNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 300)
    @Column(name = "business_description")
    private String businessDescription;
    @JoinColumn(name = "business_type_id", referencedColumnName = "business_type_id")
    @ManyToOne
    private BusinessType businessTypeId;
    @JoinColumn(name = "destination_id", referencedColumnName = "destination_id")
    @ManyToOne
    private Destination destinationId;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne
    private Address addressId;
    @OneToMany(mappedBy = "businessId")
    private Collection<TourType> tourTypeCollection;
    @OneToMany(mappedBy = "businessId")
    private Collection<UserInstance> userInstanceCollection;
    @OneToMany(mappedBy = "businessId")
    private Collection<Activity> activityCollection;

    public Business() {
    }

    public Business(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public void setLandlinePhoneNumber(String landlinePhoneNumber) {
        this.landlinePhoneNumber = landlinePhoneNumber;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public BusinessType getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(BusinessType businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public Destination getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Destination destinationId) {
        this.destinationId = destinationId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<TourType> getTourTypeCollection() {
        return tourTypeCollection;
    }

    public void setTourTypeCollection(Collection<TourType> tourTypeCollection) {
        this.tourTypeCollection = tourTypeCollection;
    }

    @XmlTransient
    public Collection<UserInstance> getUserInstanceCollection() {
        return userInstanceCollection;
    }

    public void setUserInstanceCollection(Collection<UserInstance> userInstanceCollection) {
        this.userInstanceCollection = userInstanceCollection;
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
        hash += (businessId != null ? businessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.businessId == null && other.businessId != null) || (this.businessId != null && !this.businessId.equals(other.businessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Business[ businessId=" + businessId + " ]";
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
}
