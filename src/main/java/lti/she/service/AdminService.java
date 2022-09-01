package lti.she.service;

import java.util.List;

import lti.she.dto.UserProfileDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Admin;
import lti.she.entity.Course;
import lti.she.entity.Ngo;


public interface AdminService {

	public Admin loginService(Admin admin);
	Ngo acceptNgo(int ngoId);
	Ngo deleteNgo(int ngoId);
	
	List<Course> getPendingCourses();
	Course acceptCourse(int courseId);
	Course deleteCourse(int courseId);
	
	List<Accommodation> getPendingAccommodations();
	Accommodation acceptAccommodation(int accommodationId);
	Accommodation removeAccommodation(int accommodationId);
	public List<UserProfileDto> getPendingUsers();
	public boolean acceptUser(int userId);
	public boolean deleteUser(int userId);
}
