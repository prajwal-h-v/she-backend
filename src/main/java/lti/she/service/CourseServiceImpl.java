package lti.she.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.she.entity.Enrollment;
import lti.she.entity.User;
import lti.she.dao.UserDao;

import lti.she.dao.CourseDao;
import lti.she.dao.NgoDao;
import lti.she.dto.CourseAddDTO;
import lti.she.entity.Course;
import lti.she.entity.Ngo;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	NgoDao ngoDao;
	
	@Autowired
	CourseDao courseDao;
	
//	STEP ADDED
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
	
	
//	STEP ADDED
	@Override
	public List<Enrollment> listUserEnrolledForCourse(int courseId) {
		return courseDao.listUserEnrolledForCourse(courseId);
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.listAllCourses();

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
