package lti.she.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Family {
	
	@Id
	@SequenceGenerator(name = "family_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "family_seq", strategy = GenerationType.SEQUENCE)
	int familyId;

	String firstName;
	String middleName;
	String lastName;
	Gender gender;
	LocalDate dob;
	Relation relation;
	String aadhaarNo;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

//	@OneToOne(mappedBy = "family")
//	FamilyDocument familydoc;

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public FamilyDocument getFamilydoc() {
//		return familydoc;
//	}
//
//	public void setFamilydoc(FamilyDocument familydoc) {
//		this.familydoc = familydoc;
//	}

}

