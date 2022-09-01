package lti.she.service;

import java.util.List;

import lti.she.dto.CourseAddDTO;
import lti.she.dto.UserProfileDto;
import lti.she.entity.Course;
import lti.she.entity.Enrollment;

public interface CourseService {
	Course createCourse(CourseAddDTO courseAddDTO);

	List<Course> listCourseByNgo(int ngoId);

//	STEP ADDED
	List<UserProfileDto> listUserEnrolledForCourse(int courseId);

	List<Course> listAllCourses();

	Enrollment enrollForCourse(int courseId, int userId);
}
