package lti.she.service;

import java.util.List;

import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.entity.AccommodationStatus;

public interface AccommodationService {

	Accommodation createAccommodation(AccommodationRegisterDTO registerDTO);

	List<Accommodation> listAccommodationsBtNgo(int ngoId);

//	STEP ADDED
	List<AccommodationStatus> listResidentsByAccomodationId(int accomodationId);

	List<Accommodation> listAllAccomodations();

	AccommodationStatus registerForAccomodation(int accomodationId, int userId);

}
