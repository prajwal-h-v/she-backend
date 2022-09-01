package lti.she.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.AccommodationDao;
import lti.she.dao.NgoDao;
import lti.she.dao.UserDao;
import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.entity.AccommodationStatus;
import lti.she.entity.Ngo;
import lti.she.entity.User;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	NgoDao ngoDao;

	@Autowired
	AccommodationDao accommodationDao;

//	STEP ADDED
	@Autowired
	UserDao userDao;

	@Override
	public Accommodation createAccommodation(AccommodationRegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		Accommodation accommodation = registerDTO.toAccommodation();
		System.out.println(registerDTO.getNgoId() + " ngo");
		Ngo ngo = ngoDao.getNgoById(registerDTO.getNgoId());
		try {
			accommodation.setNgo(ngo);
		} catch (Exception exception) {
			System.out.println("Cant set NGO");
		}
		return accommodationDao.createAccommodation(accommodation);
	}

	@Override
	public List<Accommodation> listAccommodationsBtNgo(int ngoId) {
		// TODO Auto-generated method stub

		return accommodationDao.listAccommodationByNgoId(ngoId);
	}

	@Override
	public List<AccommodationStatus> listResidentsByAccomodationId(int accomodationId) {
		List<AccommodationStatus> accomodationStatii = accommodationDao.listResidentsByAccommodationId(accomodationId);
		for (AccommodationStatus status : accomodationStatii) {
			status.setAccomodation(null);
		}
		return accommodationDao.listResidentsByAccommodationId(accomodationId);
	}

	@Override
	public List<Accommodation> listAllAccomodations() {
		List<Accommodation> accomodations = accommodationDao.listAllAccommodations();
		for (Accommodation accomodation : accomodations) {
			accomodation.setAccomodationStatuses(null);
			accomodation.setNgo(null);
		}
		return accomodations;
	}

	@Override
	public AccommodationStatus registerForAccomodation(int accomodationId, int userId) {
		// TODO Auto-generated method stub
		AccommodationStatus accomodationStatus = new AccommodationStatus();
		Accommodation accomodation = accommodationDao.getAccommodationById(accomodationId);
		User user = userDao.getUserById(userId);
		accomodationStatus.setUser(user);
		accomodationStatus.setAccomodation(accomodation);
		accomodationStatus.setFromDate(LocalDate.now());

		accomodation.setRoomAvailable(accomodation.getRoomAvailable() - 1);
		AccommodationStatus accomStatus = accommodationDao.registerForAccommodation(accomodationStatus, accomodation);
		accomStatus.setAccomodation(null);
		return accomStatus;
	}

}
