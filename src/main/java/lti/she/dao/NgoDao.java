package lti.she.dao;

import java.util.List;

//import lti.she.entity.NgoDocuments;

import lti.she.dto.NgoLogin;
import lti.she.entity.Ngo;


public interface NgoDao {

    Ngo register(Ngo ngo);

	Ngo login(NgoLogin ngoLogin);
	
	Ngo getNgoById(int ngoId);

	List<Ngo> getAll();
	
	
	
//	STEP ADDED
	boolean verifyNgo(int ngoId);
	long getCoursesCount(int ngoId);
	int getEnrollmentsCount(int ngoId);
	int getAccomodationsCount(int ngoId);
	int getResidentsCount(int ngoId);
	int getDayCareCenterCount(int ngoId);
	int getEnrolledDayCareCenters(int ngoId);

//	NgoDocuments registerDoc(NgoDocuments ngoDocuments);
    
}
