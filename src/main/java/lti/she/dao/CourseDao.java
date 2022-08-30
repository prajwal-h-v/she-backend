package lti.she.dao;

import java.util.List;

import lti.she.entity.Enrollment;
import lti.she.entity.User;

import lti.she.entity.Course;

public interface CourseDao {
	Course createCourse(Course course);

	List<Course> listCourseByNgo(int ngoId);
	
	
	
//	STEP ADDED
	
	List<Enrollment> listUserEnrolledForCourse(int courseId);
	List<Course> listAllCourses();
	Enrollment enrollForCourse(Course course, Enrollment enrollment);
	public Course getCourseById(int courseId);
	public User getNgoById(int ngoId);
	
	
}
