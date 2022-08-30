package lti.she.dao;

import java.util.List;

import lti.she.entity.Course;

public interface CourseDao {
	Course createCourse(Course course);

	List<Course> listCourseByNgo(int ngoId);
}
