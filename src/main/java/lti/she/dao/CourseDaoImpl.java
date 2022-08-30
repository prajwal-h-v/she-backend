package lti.she.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lti.she.entity.Course;
import lti.she.entity.Ngo;

@Repository
public class CourseDaoImpl implements CourseDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return em.merge(course);
	}

	@Override
	public List<Course> listCourseByNgo(int ngoId) {
		// TODO Auto-generated method stub
		return em.find(Ngo.class, ngoId).getCourses();
	}

}
