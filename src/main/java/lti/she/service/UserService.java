package lti.she.service;

import java.util.List;

import lti.she.dto.FamilyDetailsDto;
import lti.she.dto.UpdateUserDto;
import lti.she.dto.UserProfileDto;
import lti.she.dto.UserRegisterDto;
//import lti.she.entity.Document;
import lti.she.entity.Family;

public interface UserService {

	boolean signup(UserRegisterDto user);

	UserProfileDto updateProfile(UpdateUserDto user);

	boolean userLogin(int userId, String password);

	UserProfileDto getProfileDetails(int userId);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);

	boolean verifyUser(int userId);
	List<Family> getFamilyDetails(int userId);

	Family addOrUpdateFamily(FamilyDetailsDto family);
	
//	Document updateAadhaar(int documentId, String link);
	
//	Document updatePan(int documentId, String link);
}


//STEP ADDED INTERFACE