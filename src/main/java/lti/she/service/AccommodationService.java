package lti.she.service;

import java.util.List;

import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;

public interface AccommodationService {
	
	Accommodation createAccommodation(AccommodationRegisterDTO registerDTO);
	List<Accommodation> listAccommodationsBtNgo(int ngoId);

}
