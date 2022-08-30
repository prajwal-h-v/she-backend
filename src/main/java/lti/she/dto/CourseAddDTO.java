package lti.she.dto;

import java.time.LocalDate;

import lti.she.entity.Course;

public class CourseAddDTO {
@Override
	public String toString() {
		return "CourseAddDTO [courseID=" + courseID + ", title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", durationMonth=" + durationMonth + ", location=" + location
				+ ", jobOffered=" + jobOffered + ", ngoId=" + ngoId + "]";
	}

int courseID;
	
	String title;
	String description;
	LocalDate startDate;
	int durationMonth;
	String location;
	boolean jobOffered;
	
	int ngoId;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getDurationMonth() {
		return durationMonth;
	}

	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isJobOffered() {
		return jobOffered;
	}

	public void setJobOffered(boolean jobOffered) {
		this.jobOffered = jobOffered;
	}

	
	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	public Course toCourse() {
		Course course = new Course();
		course.setCourseID(courseID);
		course.setTitle(title);
		course.setDescription(description);
		course.setDurationMonth(durationMonth);
		course.setJobOffered(jobOffered);
		course.setLocation(location);
		course.setStartDate(startDate.plusDays(1));
		
		return course;
	}

}
