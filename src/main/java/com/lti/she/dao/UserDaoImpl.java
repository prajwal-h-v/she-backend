package com.lti.she.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.she.model.UserAdmin;

@Repository
public class UserDaoImpl implements UserAdminDAO {
	@PersistenceContext
    EntityManager eManager;

	@Override
	public List<UserAdmin> getAllUser() {
		// TODO Auto-generated method stub
		String jpql = "select user from UserAdmin user";
		TypedQuery<UserAdmin> query = eManager.createQuery(jpql, UserAdmin.class);
		return query.getResultList();
	}

}
