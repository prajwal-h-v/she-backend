package lti.she.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lti.she.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	EntityManager eManager;
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		Admin findAdmin = eManager.find(Admin.class, admin.getAdminId());
		if(findAdmin == null) return null;
		if(findAdmin.getPassword().equals( admin.getPassword()))return findAdmin;
		return null;
	}

}
