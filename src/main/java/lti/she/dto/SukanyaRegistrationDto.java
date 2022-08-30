package lti.she.dto;

import java.time.LocalDate;
import java.util.Date;

import lti.she.entity.SukanyaAccount;

public class SukanyaRegistrationDto {

	String firstName;
	String lastName;
	LocalDate dateOfBirth;
	String aadharNumber;
	int userId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public SukanyaAccount toSukanyaAccount() {
		SukanyaAccount sukanyaAccount =new SukanyaAccount();
		sukanyaAccount.setAdharNo(aadharNumber);
		sukanyaAccount.setBeneficiaryName(firstName+" "+lastName);
		sukanyaAccount.setDob(dateOfBirth);
		sukanyaAccount.setRegistrationDate(new java.sql.Date(new Date().getTime()).toLocalDate());
		return sukanyaAccount;
	}
	
}


//STEP ADDED CLASS