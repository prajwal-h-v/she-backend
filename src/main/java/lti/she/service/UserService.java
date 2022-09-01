package lti.she.service;

import java.util.List;

import lti.she.dto.FamilyDetailsDto;
import lti.she.dto.UpdateUserDto;
import lti.she.dto.UserProfileDto;
import lti.she.dto.UserRegisterDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Course;
import lti.she.entity.Family;

public interface UserService {
	int signup(UserRegisterDto user);

	UserProfileDto updateProfile(UpdateUserDto user);

	UserProfileDto userLogin(int userId, String password);

	UserProfileDto getProfileDetails(int userId);

	boolean changePassword(int userId, String password, String newPassword);

	boolean resetPassword(int userId);

	boolean verifyUser(int userId);
	List<Family> getFamilyDetails(int userId);

	Family addOrUpdateFamily(FamilyDetailsDto family);
	
	
//	step dash board code
	
	List<Course> listCourseForUser(int userId);
	List<Accommodation> listAccomodationForUser(int userId);
}
