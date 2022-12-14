package lti.she.dto;

import java.time.LocalDate;

import lti.she.entity.Disability;
import lti.she.entity.Gender;
import lti.she.entity.JobStatus;
import lti.she.entity.MaritalStatus;
import lti.she.entity.ResidenceArea;

public class UserRegisterDto {
	String firstName;
	String middleName;
	String lastName;
	String email;
	String password;
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

//	String aadhaarLink;
//	String panLink;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
