package lti.she.dto;

import java.time.LocalDate;
import java.util.List;

import lti.she.entity.AccommodationStatus;
import lti.she.entity.Disability;
import lti.she.entity.Enrollment;
import lti.she.entity.Gender;
import lti.she.entity.JobStatus;
import lti.she.entity.MaritalStatus;
import lti.she.entity.ResidenceArea;
import lti.she.entity.SukanyaAccount;
import lti.she.entity.User;

public class UserProfileDto {
	int userId;

	String firstName;
	String middleName;
	String lastName;

	String email;
	String contactNo;
	String aadhaarNo;
	String panNo;
	LocalDate dob;
	Gender gender;
	JobStatus jobStatus;
	String jobTitle;
	double salary;
	ResidenceArea residenceArea;
	MaritalStatus maritalStatus;
	Disability disabled;
	boolean isVerified;

//	Document document;

	List<SukanyaAccount> sukanyaAccount;

	List<Enrollment> enroll;

	List<AccommodationStatus> accomodationStatus;

	public UserProfileDto(User user) {
		this.userId = user.getUserId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.middleName = user.getMiddleName();
		this.email = user.getEmail();
		this.contactNo = user.getContactNo();
		this.aadhaarNo = user.getAadhaarNo();
		this.panNo = user.getPanNo();
		this.dob = user.getDob();
		this.gender = user.getGender();
		this.jobStatus = user.getJobStatus();
		this.jobTitle = user.getJobTitle();
		this.salary = user.getSalary();
		this.residenceArea = user.getResidenceArea();
		this.maritalStatus = user.getMaritalStatus();
		this.isVerified = user.isVerified();
//		this.document = user.getDocument();
		this.sukanyaAccount = user.getSukanyaAccount();
		this.enroll = user.getEnroll();
		this.accomodationStatus = user.getAccommodationStatus();
		this.disabled = user.getDisabled();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ResidenceArea getResidenceArea() {
		return residenceArea;
	}

	public void setResidenceArea(ResidenceArea residenceArea) {
		this.residenceArea = residenceArea;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Disability getDisabled() {
		return disabled;
	}

	public void setDisabled(Disability disabled) {
		this.disabled = disabled;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

//	public Document getDocument() {
//		return document;
//	}
//
//	public void setDocument(Document document) {
//		this.document = document;
//	}

	public List<SukanyaAccount> getSukanyaAccount() {
		return sukanyaAccount;
	}

	public void setSukanyaAccount(List<SukanyaAccount> sukanyaAccount) {
		this.sukanyaAccount = sukanyaAccount;
	}

	public List<Enrollment> getEnroll() {
		return enroll;
	}

	public void setEnroll(List<Enrollment> enroll) {
		this.enroll = enroll;
	}

	public List<AccommodationStatus> getAccomodationStatus() {
		return accomodationStatus;
	}

	public void setAccomodationStatus(List<AccommodationStatus> accomodationStatus) {
		this.accomodationStatus = accomodationStatus;
	}

	
}
