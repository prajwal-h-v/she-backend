package lti.she.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lti.she.entity.Enrollment;
import lti.she.entity.User;

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
	
	
//	STEP ADDED
	
	@Override
	public List<Enrollment> listUserEnrolledForCourse(int courseId) {
		
		return em.find(Course.class, courseId).getEnrollments();
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		String jpql="select c from Course c where startDate>:today";
		TypedQuery<Course> query=em.createQuery(jpql, Course.class);
		query.setParameter("today", LocalDate.now());
		return query.getResultList();
	}

	@Override
	@Transactional
	public Enrollment enrollForCourse(Course course, Enrollment enrollment) {
		em.merge(course);
		// TODO Auto-generated method stub
		return em.merge(enrollment);
	}
	
	
//	temprory remove once user dao is ready
	public User getNgoById(int ngoId) {
		return em.find(User.class, ngoId);
	}
	public Course getCourseById(int courseId) {
		return em.find(Course.class, courseId);
	}
	

}
