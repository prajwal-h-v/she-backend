package lti.she.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="ngo")
public class Ngo {
    
    @Id
	@SequenceGenerator(name = "ngo_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "ngo_seq", strategy = GenerationType.SEQUENCE)
    int ngoId;

    String name;
    String email;
    String password;
    String address;
    String description;
    String contact;
    boolean isVerified;
    
    @OneToMany(mappedBy = "ngo")
    @JsonBackReference
    List<Course> courses;
    
    @OneToMany(mappedBy = "ngo")
    @JsonBackReference
    List<Accommodation> accommodations;
    
    
    
    
    public List<Accommodation> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	public int getNgoId() {
        return ngoId;
    }
    public void setNgoId(int ngoId) {
        this.ngoId = ngoId;
    }
    public String getName() {
        return name;
    }
    public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public boolean isVerified() {
        return isVerified;
    }
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    

}
