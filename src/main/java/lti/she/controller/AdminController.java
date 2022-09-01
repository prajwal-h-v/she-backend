package lti.she.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lti.she.dto.AdminDto;
import lti.she.dto.UserProfileDto;
import lti.she.entity.Accommodation;
import lti.she.entity.Admin;
import lti.she.entity.Course;
import lti.she.entity.Ngo;
import lti.she.service.AdminService;
import lti.she.service.NgoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	NgoService ngoService;

	@RequestMapping("/login")
	public Admin login(@RequestBody AdminDto adminDto) {
		System.out.println(adminDto);
		return adminService.loginService(adminDto.toAdmin(adminDto));
	}

//	Pending NGOS
	@RequestMapping("/get-ngo-pending")
	public List<Ngo> getPendingNgo() {
		return ngoService.getNgoPendingList();
	}

	@RequestMapping(value = "/accept-ngo", method = RequestMethod.PUT)
	public Ngo acceptNgo(@RequestBody int ngoId) {
		return adminService.acceptNgo(ngoId);
	}

	@RequestMapping(value = "/delete-ngo", method = RequestMethod.POST)
	public Ngo deleteNgo(@RequestBody int ngoId) {

		return adminService.deleteNgo(ngoId);
	}

//	Pending Hostels

	@RequestMapping("/get-pending-hostels")
	public List<Accommodation> getPendingHostels() {
		return adminService.getPendingAccommodations();
	}
//
	@RequestMapping(value = "/accept-hostel", method = RequestMethod.PUT)
	public Accommodation acceptHostel(@RequestBody int accommodationId) {
		return adminService.acceptAccommodation(accommodationId);
	}
//
	@RequestMapping(value = "/delete-hostel", method = RequestMethod.POST)
	public Accommodation deleteHostel(@RequestBody int hostelId) {

		return adminService.removeAccommodation(hostelId);
	}
//	
//	Pending Courses

	@RequestMapping("/get-pending-courses")
	public List<Course> getPendingCourses() {
		return adminService.getPendingCourses();
	}

	@RequestMapping(value = "/accept-course", method = RequestMethod.PUT)
	public Course acceptCourse(@RequestBody int courseId) {
		return adminService.acceptCourse(courseId);
	}

//
	@RequestMapping(value = "/delete-course", method = RequestMethod.POST)
	public Course deleteCourse(@RequestBody int courseId) {
		return adminService.deleteCourse(courseId);
	}

//	Pending Users
	@RequestMapping("/get-pending-users")
	public List<UserProfileDto> getPendinUsers() {
		return adminService.getPendingUsers();
	}

	@RequestMapping(value = "/accept-user", method = RequestMethod.PUT)
	public boolean acceptUser(@RequestBody int userId) {
		return adminService.acceptUser(userId);
	}

//
	@RequestMapping(value = "/delete-user", method = RequestMethod.POST)
	public boolean deleteUser(@RequestBody int userId) {
		return adminService.deleteUser(userId);
	}
	
}
