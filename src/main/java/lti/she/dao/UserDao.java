package lti.she.dao;

import java.util.List;

import lti.she.dto.UpdateUserDto;
import lti.she.dto.UserProfileDto;
import lti.she.dto.UserRegisterDto;
//import lti.she.entity.Document;
import lti.she.entity.Family;
import lti.she.entity.User;

public interface UserDao {

	UserProfileDto addUser(UserRegisterDto user);

	UserProfileDto updateUser(UpdateUserDto user);

	Family addFamilyOrUpdate(Family familyMember);

	UserProfileDto searchUserById(int userId);

	boolean login(int userId, String password);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);
	boolean verifyUser(int userId);

	List<Family> getFamilyDetails(int userId);

	User getUserById(int userId);
	
//	Document updateAadhaar(int documentId, String link);
//	
//	Document updatePan(int documentId, String link);
}



//STEP ADDED INTERFACE
