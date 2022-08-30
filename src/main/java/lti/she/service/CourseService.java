package lti.she.service;


import java.util.List;

import lti.she.dto.CourseAddDTO;
import lti.she.entity.Course;

public interface CourseService {
	Course createCourse(CourseAddDTO courseAddDTO);

	List<Course> listCourseByNgo(int ngoId);
	

}
