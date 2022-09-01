package com.lti.she.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.she.dao.UserAdminDAO;
import com.lti.she.model.UserAdmin;

@Service
public class UserAdminServiceImpl implements UserAdminService {
	
	@Autowired
    UserAdminDAO dao;
 
 @Override
	public List<UserAdmin> getUserList() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

}
