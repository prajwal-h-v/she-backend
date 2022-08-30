package lti.she.dao;

import java.util.List;

import lti.she.entity.Accommodation;

public interface AccommodationDao {
	Accommodation createAccommodation(Accommodation accommodation);
	List<Accommodation> listAccommodationByNgoId(int ngoId);

}
