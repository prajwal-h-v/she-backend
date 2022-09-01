package lti.she.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.CourseAddDTO;
import lti.she.dto.UserProfileDto;
import lti.she.entity.Course;
import lti.she.entity.Enrollment;
import lti.she.service.CourseService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Course add(@RequestBody CourseAddDTO courseDTO) {
		System.out.println(courseDTO);
		return courseService.createCourse(courseDTO);
	}
	
	@GetMapping("/list-course-by-ngo/{ngoID}/{flag}")
	public List<Course> listCourse(@PathVariable int ngoID, @PathVariable boolean flag){
		List<Course> courses = courseService.listCourseByNgo(ngoID);
		List<Course> vCourses=new ArrayList<Course>();
		for(Course course : courses) {
			if(course.isVerified() == flag) {
				vCourses.add(course);
			}
			
		}
		
			
		return vCourses;
	}
//	STEP ADDED
	@GetMapping("/list-enrollments-for-course/{courseId}")
	public List<UserProfileDto> listEnrollmentsForCourse(@PathVariable int courseId){
		return courseService.listUserEnrolledForCourse(courseId);
		
	}
	@GetMapping("/list-course")
	public List<Course> listAllCourses(){
		return courseService.listAllCourses();
	}
	@GetMapping("/{courseId}/enroll/{userId}")
	public Enrollment enroll(@PathVariable int courseId,@PathVariable int userId) {
		return courseService.enrollForCourse(courseId,userId);
	}

}
