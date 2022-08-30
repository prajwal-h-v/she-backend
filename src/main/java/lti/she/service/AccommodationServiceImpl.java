package lti.she.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lti.she.entity.AccomodationStatus;
import lti.she.entity.User;

import lti.she.dao.AccommodationDao;
import lti.she.dao.NgoDao;
import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.entity.Ngo;
import lti.she.dao.UserDao;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	AccommodationDao accommodationDao;
	
//	STEP ADDED
//	@Autowired
//	UserDao userDao;
//	
	@Autowired
	UserDao userDao;
	
	@Override
	public Accommodation createAccommodation(AccommodationRegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		Accommodation accommodation = registerDTO.toAccommodation();
		System.out.println(registerDTO.getNgoId()+ " ngo");
		Ngo ngo= ngoDao.getNgoById(registerDTO.getNgoId());
		try {
			accommodation.setNgo(ngo);
		}
		catch(Exception exception) {
			System.out.println("Cant set NGO");
		}
		return accommodationDao.createAccommodation(accommodation);
	}

	@Override
	public List<Accommodation> listAccommodationsBtNgo(int ngoId) {
		// TODO Auto-generated method stub
		
		return accommodationDao.listAccommodationByNgoId(ngoId);
	}
	
	
	
//	STEP ADDED
	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		List<AccomodationStatus> accomodationStatii = accommodationDao.listResidentsByAccomodationId(accomodationId);
		for(AccomodationStatus status: accomodationStatii) {
			status.setAccomodation(null);
		}
		return accommodationDao.listResidentsByAccomodationId(accomodationId);
	}

	@Override
	public List<Accommodation> listAllAccomodations() {
		List<Accommodation> accomodations =accommodationDao.listAllAccomodations();
		for(Accommodation accomodation: accomodations) {
			accomodation.setAccomodation(null);
			accomodation.setNgo(null);
		}
		return accomodations;
	}

	@Override
	public AccomodationStatus registerForAccomodation(int accomodationId, int userId) {
		// TODO Auto-generated method stub
		AccomodationStatus accomodationStatus=new AccomodationStatus();
		Accommodation accomodation=accommodationDao.getAccomodationById(accomodationId);
		User user=userDao.getUserById(userId);
		accomodationStatus.setUser(user);
		accomodationStatus.setAccomodation(accomodation);
		accomodationStatus.setFromDate(LocalDate.now());
		
		accomodation.setRoomAvailable(accomodation.getRoomAvailable()-1);
		AccomodationStatus accomStatus = accommodationDao.registerForAccomodation(accomodationStatus, accomodation);
		accomStatus.setAccomodation(null);
		return accomStatus;
	}
	
	
	

}
