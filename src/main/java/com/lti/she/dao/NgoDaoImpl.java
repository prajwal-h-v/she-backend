package com.lti.she.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.lti.she.model.NgoAdmin;

@Repository
public class NgoDaoImpl implements NgoAdminDAO{
	
	@PersistenceContext
    EntityManager eManager;

	@Override
	public List<NgoAdmin> getAll() {
		// TODO Auto-generated method stub
		String jpql = "select ngo from NgoAdmin ngo";
		TypedQuery<NgoAdmin> query = eManager.createQuery(jpql, NgoAdmin.class);
		return query.getResultList();
	}

}

