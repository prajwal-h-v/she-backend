package lti.she.dao;

import java.util.List;

import lti.she.entity.Course;
import lti.she.entity.Enrollment;
import lti.she.entity.User;

public interface CourseDao {
	Course createCourse(Course course);

	List<Course> listCourseByNgo(int ngoId);
	
	List<Course> listAllCourses();
	
	Course getCourseById(int courseId);
	Course removeCourse(int courseId);
	
//	STEP ADDED
	
	List<Enrollment> listUserEnrolledForCourse(int courseId);
	
	Enrollment enrollForCourse(Course course, Enrollment enrollment);
	
	public User getNgoById(int ngoId);
	
//	step dashboard code
	public List<Course> listCourseForUser(int userId);
}
