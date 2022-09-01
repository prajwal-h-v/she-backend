package com.lti.she.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.lti.she.dao.NgoAdminDAO;
import com.lti.she.model.NgoAdmin;

@Service
public class NgoadminServiceImpl implements NgoAdminService{
	
	 @Autowired
	    NgoAdminDAO dao;
	 
	 @Override
		public List<NgoAdmin> getNgoList() {
			// TODO Auto-generated method stub
			return dao.getAll();
		}

}
