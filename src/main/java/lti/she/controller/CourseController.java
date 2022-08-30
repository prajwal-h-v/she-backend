package lti.she.controller;

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
import lti.she.entity.Course;
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
	
	@GetMapping("/list-course-by-ngo/{ngoID}")
	public List<Course> listCourse(@PathVariable int ngoID){
		return courseService.listCourseByNgo(ngoID);
	}

}
