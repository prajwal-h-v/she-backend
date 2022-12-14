package lti.she.dto;

import lti.she.entity.Ngo;

public class NgoRegisterDto {
    String ngoname;
    String email;
    String password;
    String address;
    String description;
    String contact;
    boolean isVerified;
    
    public String getNgoname() {
		return ngoname;
	}
	public void setNgoname(String ngoname) {
		this.ngoname = ngoname;
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
    public Ngo toNgo(){

        Ngo ngo = new Ngo();
        ngo.setName(ngoname);
        ngo.setAddress(address);
        ngo.setContact(contact);
        ngo.setDescription(description);
        ngo.setEmail(email);
        ngo.setPassword(password);
        ngo.setVerified(isVerified);
        return ngo;
    }
}
