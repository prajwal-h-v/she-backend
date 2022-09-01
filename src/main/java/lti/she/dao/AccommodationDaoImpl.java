package lti.she.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lti.she.entity.Accommodation;
import lti.she.entity.AccommodationStatus;
import lti.she.entity.Ngo;
import lti.she.entity.User;

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

	@Override
	public List<Accommodation> listAllAccommodations() {
		// TODO Auto-generated method stub
		String jpql = "select accommodation from Accommodation accommodation";
		TypedQuery<Accommodation> query = eManager.createQuery(jpql, Accommodation.class);

		return query.getResultList();
	}

	@Override
	public Accommodation getAccommodationById(int accommodationId) {
		// TODO Auto-generated method stub
		return eManager.find(Accommodation.class, accommodationId);
	}

	@Transactional
	@Override
	public Accommodation removeAccommodation(int accommodationId) {
		// TODO Auto-generated method stub
		Accommodation a = eManager.find(Accommodation.class, accommodationId);
		try {

			eManager.remove(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	@Override
	public List<AccommodationStatus> listResidentsByAccommodationId(int accommodationId) {
		Accommodation accomodation = eManager.find(Accommodation.class, accommodationId);
		if (accomodation == null)
			return null;

		return accomodation.getAccomodationStatuses();
	}

	@Override
	@Transactional
	public AccommodationStatus registerForAccommodation(AccommodationStatus accomodationStatus,
			Accommodation accomodation) {
		eManager.merge(accomodation);
		System.out.println(accomodationStatus.toString());
		AccommodationStatus accStatus = eManager.merge(accomodationStatus);
		User user = accStatus.getUser();
		System.out.println(user.toString());
		eManager.merge(user);
		return accStatus;
	}

	@Override
	public User getNgoById(int ngoId) {
		return eManager.find(User.class, ngoId);
	}

//	stepdashboard code

	public List<Accommodation> listAccomodationForUser(int userId) {
	
		List<AccommodationStatus> listAccomodationStatus = eManager.find(User.class, userId).getAccommodationStatus();
		System.out.println(listAccomodationStatus.size());
		List<Accommodation> accomodations = new ArrayList<>();
		for (AccommodationStatus e : listAccomodationStatus) {
			e.getAccomodation().setNgo(null);
			e.getAccomodation().setAccomodationStatuses(null);
			accomodations.add(e.getAccomodation());
			System.out.println("User is in "+e);
			break;
		}

		return accomodations;

	}

}
