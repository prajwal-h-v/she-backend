package lti.she.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.AccommodationDao;
import lti.she.dao.NgoDao;
import lti.she.dto.AccommodationRegisterDTO;
import lti.she.entity.Accommodation;
import lti.she.entity.Ngo;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	AccommodationDao accommodationDao;
	
	
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

}
