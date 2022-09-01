package lti.she.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.SequenceGenerator;

@Entity
public class AccommodationStatus {
	@Id
	@SequenceGenerator(name = "accomodationStatusId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "accomodationStatusId_seq", strategy = GenerationType.SEQUENCE)
	int accomodationStatusId;


	LocalDate fromDate;
	LocalDate toDate;
	boolean dayCareAvailed;

	@ManyToOne
	@JoinColumn(name = "accomodationId")
	Accommodation accomodation;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	public int getAccomodationStatusId() {
		return accomodationStatusId;
	}

	public void setAccomodationStatusId(int accomodationStatusId) {
		this.accomodationStatusId = accomodationStatusId;
	}

	public Accommodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public boolean isDayCareAvailed() {
		return dayCareAvailed;
	}

	public void setDayCareAvailed(boolean dayCareAvailed) {
		this.dayCareAvailed = dayCareAvailed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
