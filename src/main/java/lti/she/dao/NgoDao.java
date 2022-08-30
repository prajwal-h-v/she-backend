package lti.she.dao;

import java.util.List;

import lti.she.dto.NgoLogin;
import lti.she.entity.Ngo;


public interface NgoDao {

    Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);
	
	Ngo getNgoById(int ngoId);

	List<Ngo> getAll();
    
}
