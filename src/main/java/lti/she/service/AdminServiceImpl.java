package lti.she.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.AccommodationDao;
import lti.she.dao.AdminDao;
import lti.she.dao.CourseDao;
import lti.she.dao.NgoDao;
import lti.she.dao.UserDao;
import lti.she.dto.StaticsticDTO;
import lti.she.dto.UserProfileDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Admin;
import lti.she.entity.Course;
import lti.she.entity.Ngo;
import lti.she.entity.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	NgoDao ngoDao;

	@Autowired
	CourseDao courseDao;

	@Autowired
	AccommodationDao accDao;

	@Autowired
	UserDao userDao;

	@Override
	public Admin loginService(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}

	@Override
	public Ngo acceptNgo(int ngoId) {
		// TODO Auto-generated method stub
		Ngo ngo = ngoDao.getNgoById(ngoId);
		ngo.setVerified(true);
		ngoDao.updateNgo(ngo);
		return ngo;
	}

	@Override
	public Ngo deleteNgo(int ngoId) {
		// TODO Auto-generated method stub

		return ngoDao.deleteNgo(ngoDao.getNgoById(ngoId));
	}

	@Override
	public List<Course> getPendingCourses() {
		// TODO Auto-generated method stub
		List<Course> pCourses = new ArrayList<Course>();
		for (Course c : courseDao.listAllCourses()) {
			if (!c.isVerified()) {
				pCourses.add(c);
			}
		}
		return pCourses;
	}

	@Override
	public Course acceptCourse(int courseId) {
		// TODO Auto-generated method stub
		Course course = courseDao.getCourseById(courseId);
		course.setVerified(true);
		courseDao.createCourse(course);
		return course;

	}

	@Override
	public Course deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		return courseDao.removeCourse(courseId);
	}

	@Override
	public List<Accommodation> getPendingAccommodations() {
		// TODO Auto-generated method stub
		List<Accommodation> pAccommodations = new ArrayList<Accommodation>();
		for (Accommodation a : accDao.listAllAccommodations()) {
			if (!a.isVerified()) {
				pAccommodations.add(a);
			}
		}
		return pAccommodations;
	}

	@Override
	public Accommodation acceptAccommodation(int accommodationId) {
		// TODO Auto-generated method stub
		Accommodation accommodation = accDao.getAccommodationById(accommodationId);
		accommodation.setVerified(true);
		accDao.createAccommodation(accommodation);
		return accommodation;
	}

	@Override
	public Accommodation removeAccommodation(int accommodationId) {
		// TODO Auto-generated method stub
		return accDao.removeAccommodation(accommodationId);
	}

	@Override
	public List<UserProfileDto> getPendingUsers() {
		// TODO Auto-generated method stub
		List<User> users = userDao.getAllUsers();
		List<UserProfileDto> profileDtos = new ArrayList<UserProfileDto>();
		for (User user : users) {
			if (!user.isVerified()) {
				user.setEnroll(null);
				user.setAccommodationStatus(null);
				UserProfileDto dto = new UserProfileDto(user);
				profileDtos.add(dto);
			}
		}
		return profileDtos;
	}

	@Override
	public boolean acceptUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.verifyUser(userId);
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		try {
		userDao.deleteUser(userId);
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@Autowired
	CourseService cs;
	@Autowired 
	AccommodationService as;
	@Autowired
	UserService us;
	@Autowired
	NgoService ns;
	
	@Override
	public StaticsticDTO getStatistics() {
		StaticsticDTO dto = new StaticsticDTO();
		dto.setNgoCount(ns.getNgoList().size());
		dto.setCoursesCount(cs.listAllCourses().size());
		dto.setHostelCount(as.listAllAccomodations().size());
		dto.setUserCount(us.listAllUsers().size());
		System.out.println(dto);
		return dto;
		
	}

}
