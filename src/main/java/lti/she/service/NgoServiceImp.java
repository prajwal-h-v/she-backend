package lti.she.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lti.she.dao.NgoDao;
import lti.she.dto.NgoLogin;
import lti.she.entity.Ngo;

@Service
public class NgoServiceImp implements NgoService{

    @Autowired
    NgoDao dao;

    @Override
    public Ngo register(Ngo ngo) {
        
        System.out.println("registering..." + dao);
        return dao.register(ngo);
    }

	public Ngo login(NgoLogin ngoLogin) {
		// TODO Auto-generated method stub
		return dao.login(ngoLogin);
	}

	@Override
	public List<Ngo> getNgoList() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

    
    
}
