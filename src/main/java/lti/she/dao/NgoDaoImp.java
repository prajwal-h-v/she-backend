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
public class NgoDaoImp implements NgoDao{

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
		TypedQuery<Ngo> query = eManager.createQuery(jpql,Ngo.class);
		query.setParameter("id", ngoLogin.getId());
		query.setParameter("pwd", ngoLogin.getPassword());
		try {
		return query.getSingleResult();
		}
		catch (NoResultException e) {
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
    
}
