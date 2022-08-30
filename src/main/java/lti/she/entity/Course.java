package lti.she.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Course {

	@Id
	@SequenceGenerator(name="course_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "course_seq", strategy = GenerationType.SEQUENCE)

	int courseID;
	
	String title;
	String description;
	LocalDate startDate;
	int durationMonth;
	String location;
	boolean jobOffered;
	
	@ManyToOne
	@JoinColumn(name="ndo_id")
	Ngo ngo;
	
	
//	step added
	@OneToMany(mappedBy = "course")
	@JsonBackReference
	List<Enrollment> enrollments;

	

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

	public Ngo getNgo() {
		return ngo;
	}

	public void setNgo(Ngo ngo) {
		this.ngo = ngo;
	}
	
//	STEP ADDED
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
}
