package lti.she.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.FamilyDetailsDto;
import lti.she.dto.NgoLogin;
//import lti.she.dto.UpdateDocumentDto;
import lti.she.dto.UpdateUserDto;
import lti.she.dto.UserIdDto;
import lti.she.dto.UserLoginDto;
import lti.she.dto.UserPasswordChangeDto;
import lti.she.dto.UserProfileDto;
import lti.she.dto.UserRegisterDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Course;
//import lti.she.entity.Document;
import lti.she.entity.Family;
import lti.she.entity.Ngo;
//import lti.she.service.DocumentService;
import lti.she.service.UserService;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
//	@Autowired
//	DocumentService docService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public boolean signup(@RequestBody UserRegisterDto user) {
		return userService.signup(user);
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public UserProfileDto updateProfile(@RequestBody UpdateUserDto user) {
		return userService.updateProfile(user);
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public boolean login(@RequestBody UserLoginDto userLoginDto) {
		return userService.userLogin(userLoginDto.getUserId(), userLoginDto.getPassword());
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.POST)
	public UserProfileDto getProfileDetails(@RequestBody UserIdDto userId) {
		UserProfileDto userProfileDto = userService.getProfileDetails(userId.getUserId());
		userProfileDto.setAccomodationStatus(null);
		userProfileDto.setSukanyaAccount(null);
		userProfileDto.setEnroll(null);
//		userProfileDto.getDocument().setUser(null);
//		userProfileDto.set(null);
		return userProfileDto;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public boolean changePassword(@RequestBody UserPasswordChangeDto dto) {
		return userService.changePassword(dto.getUserId(), dto.getPassword(), dto.getNewPassword());
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public boolean resetPassword(@RequestBody UserIdDto userId) {
		return userService.resetPassword(userId.getUserId());
	}
	
	@RequestMapping(value = "/addFamilyMember", method = RequestMethod.POST)
	public Family addFamilyMember(@RequestBody FamilyDetailsDto familyMember) {
		return userService.addOrUpdateFamily(familyMember);
	}
	
	@RequestMapping(value = "/getFamilyDetails", method = RequestMethod.POST)
	public List<Family> getFamilyDetails(@RequestBody UserIdDto userId) {
		return userService.getFamilyDetails(userId.getUserId());
	}
	
	
	
//	Step dashboard code
//	@RequestMapping(value = "/list-course-by-user/{userId}/courses", method = RequestMethod.GET)
//    public List<Course> listCoursesForUser(@RequestBody UserIdDto userId) {
//		return userService.listCourseForUser(userId);
//	}
	
	@RequestMapping(value = "/list-course-by-user/{userId}", method = RequestMethod.GET)
	 public List<Course> listCourseForUser(@PathVariable int userId) {
		return userService.listCourseForUser(userId);
	}
	
	@RequestMapping(value = "/list-accommodation-by-user/{userId}", method = RequestMethod.GET)
	 public List<Accommodation> listAccomodationForUser(@PathVariable int userId) {
		return userService.listAccomodationForUser(userId);
	}
	
	
	
//	@RequestMapping(value = "/updateAadhaar", method = RequestMethod.POST)
//	public Document updateAadhaar(@RequestBody UpdateDocumentDto documentDto) {
//		return userService.updateAadhaar(documentDto.getDocumentId(), documentDto.getLink());
//	}
//	
//	@RequestMapping(value = "/updatePan", method = RequestMethod.POST)
//	public Document updatePan(@RequestBody UpdateDocumentDto documentDto) {
//		return userService.updatePan(documentDto.getDocumentId(), documentDto.getLink());
//	}
//	
//	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
//	public String loadFile(@RequestBody String fileName, HttpServletRequest request) {
//		return docService.loadFile(fileName, request);
//	}
	
}


//STEP ADDED CLASS
