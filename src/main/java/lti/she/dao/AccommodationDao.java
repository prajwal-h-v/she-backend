package lti.she.dao;

import java.util.List;

import lti.she.entity.Accommodation;
import lti.she.entity.AccommodationStatus;
import lti.she.entity.User;

public interface AccommodationDao {
	Accommodation createAccommodation(Accommodation accommodation);
	List<Accommodation> listAccommodationByNgoId(int ngoId);
	List<Accommodation> listAllAccommodations();

	Accommodation getAccommodationById(int accommodationId);
	Accommodation removeAccommodation(int accommodationId);
	
//	step added
	List<AccommodationStatus>listResidentsByAccommodationId(int accomodationId);
	
	AccommodationStatus registerForAccommodation(AccommodationStatus accomodation, Accommodation accomodation2);
	
	public User getNgoById(int ngoId);
	
//	stepdashboard code
	public List<Accommodation> listAccomodationForUser(int userId);
}
