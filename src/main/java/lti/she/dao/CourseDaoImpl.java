package lti.she.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lti.she.entity.Course;
import lti.she.entity.Enrollment;
import lti.she.entity.Ngo;
import lti.she.entity.User;

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

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		String jpql  = "select course from Course course";
		TypedQuery<Course> query = em.createQuery(jpql,Course.class);
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		
		return em.find(Course.class, courseId);
	}

	@Transactional
	@Override
	public Course removeCourse(int courseId) {
		// TODO Auto-generated method stub
		Course course = em.find(Course.class, courseId);
		try {
			em.remove(course);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return course;
	}
	
	@Override
	public List<Course> listCourseForUser(int userId){
		 List<Enrollment> listEnrollment = em.find(User.class,userId).getEnroll();
		 List<Course> courses = new ArrayList<>();
		 for(Enrollment e:listEnrollment) {
			 e.getCourse().setNgo(null);
	 		 courses.add(e.getCourse());
		 }

		 return courses;
	}

	@Override
	public List<Enrollment> listUserEnrolledForCourse(int courseId) {
		
		return em.find(Course.class, courseId).getEnrollments();
	}


	@Override
	@Transactional
	public Enrollment enrollForCourse(Course course, Enrollment enrollment) {
		em.merge(course);
		// TODO Auto-generated method stub
		return em.merge(enrollment);
	}

	@Override
	public User getNgoById(int ngoId) {
		return em.find(User.class, ngoId);
	}

}
