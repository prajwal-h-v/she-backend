package lti.she.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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

}
