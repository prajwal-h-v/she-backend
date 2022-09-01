package lti.she.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Enrollment {
	@Id
	@SequenceGenerator(name = "enroll_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "enroll_seq", strategy = GenerationType.SEQUENCE)
	int enrollmentId;

	LocalDate registrationDate;

	@ManyToOne
	@JoinColumn(name = "courseId")
	Course course;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", registrationDate=" + registrationDate + ", course="
				+ course + ", user=" + user + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}
}
