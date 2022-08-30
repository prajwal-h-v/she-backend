package lti.she.dao;

import java.util.List;

import lti.she.entity.Accommodation;
import lti.she.entity.AccomodationStatus;
import lti.she.entity.User;

//import lti.she.entity.Accommodation;

public interface AccommodationDao {
	Accommodation createAccommodation(Accommodation accommodation);
	List<Accommodation> listAccommodationByNgoId(int ngoId);

	
//	step added
	List<AccomodationStatus>listResidentsByAccomodationId(int accomodationId);
	List<Accommodation> listAllAccomodations();
	AccomodationStatus registerForAccomodation(AccomodationStatus accomodation, Accommodation accomodation2);
	public Accommodation getAccomodationById(int accomodationId);
	public User getNgoById(int ngoId);
	
}
