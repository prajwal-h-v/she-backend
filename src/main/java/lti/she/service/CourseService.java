package lti.she.service;


import java.util.List;

import lti.she.entity.Enrollment;

import lti.she.dto.CourseAddDTO;
import lti.she.entity.Course;

public interface CourseService {
	Course createCourse(CourseAddDTO courseAddDTO);

	List<Course> listCourseByNgo(int ngoId);
	

//	STEP ADDED
	List<Enrollment> listUserEnrolledForCourse(int courseId);
	List<Course> listAllCourses();
	Enrollment enrollForCourse(int courseId,int userId);
	
}
