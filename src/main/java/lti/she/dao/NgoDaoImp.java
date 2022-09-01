package lti.she.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lti.she.dto.NgoLogin;
import lti.she.entity.Ngo;

@Repository
public class NgoDaoImp implements NgoDao {

	@PersistenceContext
	EntityManager eManager;

	@Override
	@Transactional
	public Ngo register(Ngo ngo) {

		Ngo registeredNgo = eManager.merge(ngo);
		return registeredNgo;
	}

	@Override
	public Ngo login(NgoLogin ngoLogin) {
		// TODO Auto-generated method stub
		String jpql = "select ngo from Ngo ngo where ngo.id=:id and ngo.password=:pwd";
		TypedQuery<Ngo> query = eManager.createQuery(jpql, Ngo.class);
		query.setParameter("id", ngoLogin.getId());
		query.setParameter("pwd", ngoLogin.getPassword());
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Ngo getNgoById(int ngoId) {
		// TODO Auto-generated method stub
		return eManager.find(Ngo.class, ngoId);
	}

	@Override
	public List<Ngo> getAll() {
		// TODO Auto-generated method stub
		String jpql = "select ngo from Ngo ngo";
		TypedQuery<Ngo> query = eManager.createQuery(jpql, Ngo.class);
		return query.getResultList();

	}

	@Transactional
	@Override
	public void updateNgo(Ngo ngo) {
		// TODO Auto-generated method stub
		eManager.merge(ngo);
	}

	@Transactional
	@Override
	public Ngo deleteNgo(Ngo ngo) {
		// TODO Auto-generated method stub
		if (ngo != null)
			eManager.remove(ngo);
		return ngo;
	}
//	STEP ADDED
	
	@Transactional
	public boolean verifyNgo(int ngoId) {
		Ngo ngo = eManager.find(Ngo.class, ngoId);
		ngo.setVerified(!ngo.isVerified());
		try {
			ngo = eManager.merge(ngo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public long getCoursesCount(int ngoId) {
		String jpql= "select count(c) from Course c where c.ngo=:ngoId" ;
		TypedQuery<Long> query = eManager.createQuery(jpql, Long.class);
		query.setParameter("ngoId", ngoId);
		return query.getSingleResult();
	}

	@Override
	public int getEnrollmentsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAccomodationsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResidentsCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDayCareCenterCount(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnrolledDayCareCenters(int ngoId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
