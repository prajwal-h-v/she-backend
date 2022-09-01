package lti.she.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.dao.CourseDao;
import lti.she.dao.NgoDao;
import lti.she.dao.UserDao;
import lti.she.dto.CourseAddDTO;
import lti.she.dto.UserProfileDto;
import lti.she.entity.Course;
import lti.she.entity.Enrollment;
import lti.she.entity.Ngo;
import lti.she.entity.User;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public Course createCourse(CourseAddDTO courseAddDTO) {
		// TODO Auto-generated method stub
		if(courseAddDTO.getCourseID()!=0) {
			courseAddDTO.setCourseID(0);
		}
		Course course = courseAddDTO.toCourse();
		System.out.println(courseAddDTO.getNgoId()+" ngo");
		Ngo ngo = ngoDao.getNgoById(courseAddDTO.getNgoId());
		System.out.println(ngo.getName());
		try {
			course.setNgo(ngo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not set NGO");
		}
		return courseDao.createCourse(course);
	}

	@Override
	public List<Course> listCourseByNgo(int ngoId) {
		// TODO Auto-generated method stub
		return courseDao.listCourseByNgo(ngoId);
	}
	
	@Override
	public List<UserProfileDto> listUserEnrolledForCourse(int courseId) {
		List<Enrollment> en =  courseDao.listUserEnrolledForCourse(courseId);
		List<UserProfileDto> userProfileDtos = new ArrayList<UserProfileDto>();
		for(Enrollment e:en) {
			User user = e.getUser();
			user.setAccommodationStatus(null);
			user.setEnroll(null);
			
			userProfileDtos.add(new UserProfileDto(user));
		}
		return userProfileDtos;
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = courseDao.listAllCourses();
		List<Course> approvedCourses = new ArrayList<Course>();
		for(Course course : courses) {
			if(course.isVerified()) {
				approvedCourses.add(course);
			}
		}
		
		return approvedCourses;

	}

	@Override
	public Enrollment enrollForCourse(int courseId, int userId) {
		// TODO Auto-generated method stub
		Enrollment enrollment=new Enrollment();
		System.out.println(courseId);
		Course course=courseDao.getCourseById(courseId);
		System.out.println(course);
		User user=userDao.getUserById(userId);
		enrollment.setUser(user);
		enrollment.setCourse(course);
		enrollment.setRegistrationDate(LocalDate.now());
		
//		course.setVacancy(course.getVacancy()-1);
		
		return courseDao.enrollForCourse(course, enrollment);
	}
}
