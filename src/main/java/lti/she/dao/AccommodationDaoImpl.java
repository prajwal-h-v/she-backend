package lti.she.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import lti.she.entity.AccomodationStatus;
import lti.she.entity.User;

import lti.she.entity.Accommodation;
import lti.she.entity.Ngo;

@Repository
public class AccommodationDaoImpl implements AccommodationDao {

	@PersistenceContext
	EntityManager eManager;
	
	@Override
	@Transactional
	public Accommodation createAccommodation(Accommodation accommodation) {
		// TODO Auto-generated method stub
		
		return eManager.merge(accommodation);
	}

	@Override
	public List<Accommodation> listAccommodationByNgoId(int ngoId) {
		// TODO Auto-generated method stub
		return eManager.find(Ngo.class, ngoId).getAccommodations();
	}
	
	
//	STEP ADDED -------------
	
	@Override
	public List<AccomodationStatus> listResidentsByAccomodationId(int accomodationId) {
		Accommodation accomodation = eManager.find(Accommodation.class, accomodationId);
		if (accomodation == null)
			return null;
		
		return accomodation.getAccomodation();
	}

	@Override
	public List<Accommodation> listAllAccomodations() {
		String jpql = "select a from Accommodation a where a.roomAvailable>0";
		TypedQuery<Accommodation> query = eManager.createQuery(jpql, Accommodation.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public AccomodationStatus registerForAccomodation(AccomodationStatus accomodationStatus, Accommodation accomodation) {
		eManager.merge(accomodation);
		AccomodationStatus accStatus = eManager.merge(accomodationStatus);
		return accStatus;
	}

	@Override
	public Accommodation getAccomodationById(int accomodationId) {
		return eManager.find(Accommodation.class, accomodationId);
	}

	@Override
	public User getNgoById(int ngoId) {
		return eManager.find(User.class, ngoId);
	}
	

}
