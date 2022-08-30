package lti.she.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
