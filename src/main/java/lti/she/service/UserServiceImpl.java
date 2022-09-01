package lti.she.service;

import java.util.ArrayList;
import java.util.List;

import lti.she.dto.FamilyDetailsDto;
import lti.she.dto.UpdateUserDto;
import lti.she.dto.UserProfileDto;
import lti.she.dto.UserRegisterDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Course;
import lti.she.entity.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.UserDao;
import lti.she.dao.AccommodationDao;
import lti.she.dao.CourseDao;
import lti.she.entity.User;
import lti.she.exception.UserIdMissingException;
import lti.she.exception.UserNotFoundException;
//import lti.she.service.EmailService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	CourseDao courseDao;

//	@Autowired
//	EmailService emailService;

	@Autowired
	AccommodationDao accommodationDao;

	public int signup(UserRegisterDto user) {
		try {
			user.getDob().plusDays(1);
			UserProfileDto user2 = userDao.addUser(user);
//			try {
//				emailService
//						.sendEmailForSignup(user.getEmail(),
//								"Sign up to Portal successfull\nYour User Id is: " + user2.getUserId()
//										+ "\nUse with your registered password to login",
//								"Welcome - Signup Successfull");
//			} catch (Exception e) {
//				System.out.println(e);
//			}
			return user2.getUserId();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public UserProfileDto updateProfile(UpdateUserDto user) {
		try {
			user.getDob().plusDays(1);
			if (user.getUserId() == 0) {
				throw new UserIdMissingException("Please mention your user id");
			} else if (userDao.searchUserById(user.getUserId()) == null) {
				throw new UserNotFoundException("User not found");
			} else {
				return userDao.updateUser(user);
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public UserProfileDto userLogin(int userId, String password) {
		return userDao.login(userId, password);
	}

	public UserProfileDto getProfileDetails(int userId) {
		return userDao.searchUserById(userId);
	}

	public boolean changePassword(int userId, String password, String newPassword) {
		return userDao.changePassword(userId, password, newPassword);
	}

	public boolean resetPassword(int userId) {
		return userDao.resetPassword(userId);
	}

	public boolean verifyUser(int userId) {

		return userDao.verifyUser(userId);
	}

	public Family addOrUpdateFamily(FamilyDetailsDto family) {
		family.getDob().plusDays(1);
		Family familyMember = family.toFamily();
		User user = userDao.getUserById(family.getUserId());

		try {
			familyMember.setUser(user);
		} catch (Exception e) {
			System.out.println("Cant set user");
		}
		return userDao.addFamilyOrUpdate(familyMember);
	}

	public List<Family> getFamilyDetails(int userId) {
		return userDao.getFamilyDetails(userId);
	}

//	step dashboard code
	public List<Course> listCourseForUser(int userId) {
		return courseDao.listCourseForUser(userId);
	}

	public Accommodation listAccomodationForUser(int userId) {
		List<Accommodation> acc = accommodationDao.listAccomodationForUser(userId);
		if (acc.size() == 1) {
			Accommodation ac = acc.get(0);
			return ac;
		}
		return null;
	}

	@Override
	public List<UserProfileDto> listAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userDao.getAllUsers();
		List<UserProfileDto> vUsers = new ArrayList<UserProfileDto>();
		for(User user :users) {
			if(user.isVerified()) {
				UserProfileDto dto = new UserProfileDto(user);
				vUsers.add(dto);
			}
		}
		return vUsers;
	}
	
	
//	public Document updateAadhaar(int documentId, String link) {
//		return userDao.updateAadhaar(documentId, link);
//	}
//
//	public Document updatePan(int documentId, String link) {
//		return userDao.updatePan(documentId, link);
//	}
}
